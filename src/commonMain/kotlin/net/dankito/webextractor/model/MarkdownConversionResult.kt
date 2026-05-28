package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class MarkdownConversionResult(
    val converter: MarkdownConverter? = null,
    val content: String? = null,
    val failures: Map<MarkdownConverter, String>? = null,
)
