package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class WebContentExtractionResult(
    val extractor: WebContentExtractor? = null,
    val content: String? = null,
    val failures: Map<WebContentExtractor, String>? = null,

    val metrics: ExtractionMetrics? = null,
    val allMetrics: Map<WebContentExtractor, ExtractionMetrics>? = null,
)