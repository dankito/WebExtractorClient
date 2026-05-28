package net.dankito.webextractor.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WebContentExtractor {
    @SerialName("trafilatura") TRAFILATURA,
    @SerialName("readability-lxml") READABILITY_LXML,
}