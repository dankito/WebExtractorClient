package net.dankito.webextractor.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class WebFetcher {
    @SerialName("python_httpx") PYTHON_HTTPX,
    @SerialName("curl_cffi") CURL_CFFI,
    @SerialName("camoufox") CAMOUFOX,
    @SerialName("zendriver") ZENDRIVER,
}