package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class ExtractFromHtmlResult(
    val format: OutputFormat,
    val content: String? = null,
    val metadata: ExtractedMetadata? = null,
    val extractionResult: WebContentExtractionResult? = null,
    val conversionResult: MarkdownConversionResult? = null,
)