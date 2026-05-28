package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class ExtractedMetadata(
    val title: String? = null,
    val author: String? = null,
    val date: String? = null,
    val description: String? = null,
    val siteName: String? = null,
    val language: String? = null,
)