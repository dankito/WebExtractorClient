package net.dankito.webextractor.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RequestedFormat(val apiValue: String) {
    @SerialName("raw_html")
    RAW_HTML("raw_html"),

    @SerialName("content_html")
    CONTENT_HTML("content_html"),

    @SerialName("raw_markdown")
    RAW_MARKDOWN("raw_markdown"),

    @SerialName("content_markdown")
    CONTENT_MARKDOWN("content_markdown"),

    @SerialName("raw_text")
    RAW_TEXT("raw_text"),

    @SerialName("content_text")
    CONTENT_TEXT("content_text"),
}