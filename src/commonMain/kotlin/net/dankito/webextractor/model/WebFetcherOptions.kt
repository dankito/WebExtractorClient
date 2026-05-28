package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class WebFetcherOptions(
    val fetchers: List<WebFetcher>? = null,
    val timeout: Double? = null,
    val userAgent: String? = null,
    val followRedirects: Boolean = true,
)