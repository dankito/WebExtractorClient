package net.dankito.webextractor.serialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import net.dankito.webextractor.model.WebFetcher

class WebFetcherDeserializer : StdDeserializer<WebFetcher>(WebFetcher::class.java) {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): WebFetcher? =
        parser.valueAsString?.let { lowercase -> WebFetcher.valueOf(lowercase.uppercase()) }

}