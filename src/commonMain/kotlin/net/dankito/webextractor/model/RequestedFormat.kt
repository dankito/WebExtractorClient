package net.dankito.webextractor.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RequestedFormat {
    @SerialName("raw_html") RAW_HTML,
    @SerialName("content_html") CONTENT_HTML,
    @SerialName("raw_markdown") RAW_MARKDOWN,
    @SerialName("content_markdown") CONTENT_MARKDOWN,
    @SerialName("raw_text") RAW_TEXT,
    @SerialName("content_text") CONTENT_TEXT,
}