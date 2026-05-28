package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class ExtractionResult(
    val url: String,
    val format: OutputFormat,
    val content: String? = null,
    val metadata: ExtractedMetadata? = null,
    val extractionResult: WebContentExtractionResult? = null,
    val conversionResult: MarkdownConversionResult? = null,
    val fetchResult: WebFetcherResult,
)