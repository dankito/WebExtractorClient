package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class MultiFormatExtractionResult(
    val url: String,
    val fetchResult: WebFetcherResult,
    val extractionResult: WebContentExtractionResult? = null,
    val metadata: ExtractedMetadata? = null,
    val rawMarkdown: MarkdownConversionResult? = null,
    val contentMarkdown: MarkdownConversionResult? = null,
    val rawText: MarkdownConversionResult? = null,
    val contentText: MarkdownConversionResult? = null,
)