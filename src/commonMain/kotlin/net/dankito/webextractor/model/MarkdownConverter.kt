package net.dankito.webextractor.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MarkdownConverter {
    @SerialName("markdownify") MARKDOWNIFY,
    @SerialName("html2text") HTML2TEXT,
    @SerialName("kreuzberg") KREUZBERG,
}