package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class MultiFormatExtractionRequest(
    val url: String,
    val formats: List<RequestedFormat> = listOf(RequestedFormat.CONTENT_HTML),
    val includeMetadata: Boolean = false,
    val webFetcherOptions: WebFetcherOptions? = null,
    val extractorOptions: WebContentExtractorOptions? = null,
    val converterOptions: MarkdownConverterOptions? = null,
)