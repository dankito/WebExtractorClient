package net.dankito.webextractor

import assertk.assertThat
import assertk.assertions.isGreaterThan
import assertk.assertions.isNotNull
import assertk.assertions.isNull
import assertk.assertions.isTrue
import kotlinx.coroutines.test.runTest
import net.dankito.web.client.WebClientResult
import net.dankito.webextractor.model.ExtractFromHtmlRequest
import net.dankito.webextractor.model.ExtractionRequest
import net.dankito.webextractor.model.MarkdownConverterOptions
import net.dankito.webextractor.model.MultiFormatExtractionRequest
import net.dankito.webextractor.model.OutputFormat
import net.dankito.webextractor.model.RequestedFormat
import net.dankito.webextractor.test.TestConfig
import net.dankito.webextractor.test.TestData
import kotlin.test.Test

class WebExtractorClientTest {

    private val client = WebExtractorClient(TestConfig.WebExtractorBaseUrl)


    @Test
    fun extract() = runTest {
        val response = client.extract(ExtractionRequest(TestData.Url, OutputFormat.MARKDOWN, true))


        val result = assertSuccess(response)

        assertThat(result.extractionResult).isNotNull()
        assertThat(result.conversionResult).isNotNull()
        assertThat(result.metadata).isNotNull()
        assertThat(result.content).isNotNull()
        assertThat(result.content!!.length).isGreaterThan(4_000)
    }

    @Test
    fun extractFromHtml() = runTest {
        val response = client.extractFromHtml(ExtractFromHtmlRequest(TestData.Html, OutputFormat.MARKDOWN, true))


        val result = assertSuccess(response)

        assertThat(result.extractionResult).isNotNull()
        assertThat(result.conversionResult).isNotNull()
        assertThat(result.metadata).isNotNull()

        assertThat(result.content).isNotNull()
        assertThat(result.content!!.length).isGreaterThan(4_400)
    }

    @Test
    fun extractMultipleResponseFormats() = runTest {
        val formats = listOf(RequestedFormat.RAW_HTML, RequestedFormat.CONTENT_HTML, RequestedFormat.CONTENT_MARKDOWN, RequestedFormat.CONTENT_TEXT)

        val response = client.extractMultipleResponseFormats(MultiFormatExtractionRequest(TestData.Url, formats, true))


        val result = assertSuccess(response)

        assertThat(result.extractionResult).isNotNull()
        assertThat(result.metadata).isNotNull()

        assertThat(result.fetchResult).isNotNull()
        assertThat(result.fetchResult.html).isNotNull()
        assertThat(result.fetchResult.html!!.length).isGreaterThan(50_000)

        assertThat(result.extractionResult).isNotNull()
        assertThat(result.extractionResult!!.content).isNotNull()
        assertThat(result.extractionResult.content!!.length).isGreaterThan(4_000)

        assertThat(result.contentMarkdown).isNotNull()
        assertThat(result.contentMarkdown!!.content).isNotNull()
        assertThat(result.contentMarkdown.content!!.length).isGreaterThan(4_000)

        assertThat(result.contentText).isNotNull()
        assertThat(result.contentText!!.content).isNotNull()
        assertThat(result.contentText.content!!.length).isGreaterThan(4_000)
    }


    @Test
    fun convertHtmlToMarkdown() = runTest {
        val response = client.convertHtmlToMarkdown(TestData.Html, MarkdownConverterOptions())

        val result = assertSuccess(response)

        assertThat(result.content).isNotNull()
        assertThat(result.content!!.length).isGreaterThan(4_000)
    }



    private fun <T> assertSuccess(response: WebClientResult<T>): T {
        assertThat(response.successfulAndBodySet).isTrue()
        assertThat(response.body).isNotNull()
        assertThat(response.error).isNull()

        return response.body!!
    }

}