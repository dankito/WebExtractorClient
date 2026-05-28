package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class MarkdownConverterOptions(
    val converters: List<MarkdownConverter>? = null,
)