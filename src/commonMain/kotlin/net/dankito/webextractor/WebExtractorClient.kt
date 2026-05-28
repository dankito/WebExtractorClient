package net.dankito.webextractor

import net.dankito.web.client.KtorWebClient
import net.dankito.web.client.RequestParameters
import net.dankito.web.client.WebClient
import net.dankito.web.client.WebClientResult
import net.dankito.web.client.post
import net.dankito.webextractor.model.ExtractFromHtmlRequest
import net.dankito.webextractor.model.ExtractFromHtmlResult
import net.dankito.webextractor.model.ExtractionRequest
import net.dankito.webextractor.model.ExtractionResult
import net.dankito.webextractor.model.MultiFormatExtractionRequest
import net.dankito.webextractor.model.MultiFormatExtractionResult

open class WebExtractorClient(
    private val baseUrl: String,
    private val webClient: WebClient = KtorWebClient()
) {

    open suspend fun extract(request: ExtractionRequest): WebClientResult<ExtractionResult> =
        webClient.post(url("/extract"), request)

    open suspend fun extractFromHtml(request: ExtractFromHtmlRequest): WebClientResult<ExtractFromHtmlResult> =
        webClient.post(RequestParameters(url("/extract/html"), ExtractFromHtmlResult::class,
            request.html, "text/html", "text/markdown", queryParameters = createQueryParameters(request)))

    open suspend fun extractMultipleResponseFormats(request: MultiFormatExtractionRequest): WebClientResult<MultiFormatExtractionResult> =
        webClient.post(url("/extract/multiple"), request)


    protected open fun url(path: String): String =
        "$baseUrl$path"

    protected open fun createQueryParameters(request: ExtractFromHtmlRequest): Map<String, Any> = buildMap {
        put("format", request.format.name.lowercase())

        if (request.includeMetadata) {
            put("include_metadata", request.includeMetadata)
        }
        if (request.extractorOptions?.extractors.isNullOrEmpty().not()) {
            put("extractor", request.extractorOptions.extractors[0].name.lowercase())
        }
        if (request.converterOptions?.converters.isNullOrEmpty().not()) {
            put("converter", request.converterOptions.converters[0].name.lowercase())
        }
    }

}