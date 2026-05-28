package net.dankito.webextractor

import net.dankito.web.client.ClientConfig
import net.dankito.web.client.KtorWebClient
import net.dankito.web.client.WebClient

object Instances {

    val DefaultWebClient: WebClient by lazy {
        // we have to do it this complicated, otherwise Graal will register KtorWebClient at build time and therefore native build will fail
        createDefaultWebClient()
    }

    private fun createDefaultWebClient(): WebClient {
        return KtorWebClient(ClientConfig(requestTimeoutMillis = 15 * 60 * 1000))
    }

}