package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class ExtractionRequest(
    val url: String,
    val format: OutputFormat = OutputFormat.HTML,
    val includeMetadata: Boolean = false,
    val webFetcherOptions: WebFetcherOptions? = null,
    val extractorOptions: WebContentExtractorOptions? = null,
    val converterOptions: MarkdownConverterOptions? = null,
)