package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class WebFetcherResult(
    val fetcher: WebFetcher? = null,
    val error: String? = null,
    val html: String? = null,
    val statusCode: Int? = null,
    val finalUrl: String? = null,
    val headers: Map<String, String>? = null,
    val cookies: Map<String, String>? = null,
    val httpVersion: String? = null,
    val elapsedMicroseconds: Int? = null,
)