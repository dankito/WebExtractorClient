package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class WebContentExtractorOptions(
    val extractors: List<WebContentExtractor>? = null,
)