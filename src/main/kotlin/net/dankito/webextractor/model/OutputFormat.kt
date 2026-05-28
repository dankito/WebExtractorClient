package net.dankito.webextractor.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class OutputFormat {
    @SerialName("html") HTML,
    @SerialName("markdown") MARKDOWN,
    @SerialName("md") MD,
    @SerialName("text") TEXT,
}