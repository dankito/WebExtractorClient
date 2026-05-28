package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class ExtractFromHtmlRequest(
    val html: String,
    val format: OutputFormat = OutputFormat.HTML,
    val includeMetadata: Boolean = false,
    val extractorOptions: WebContentExtractorOptions? = null,
    val converterOptions: MarkdownConverterOptions? = null,
)
