package net.dankito.webextractor.serialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import net.dankito.webextractor.model.WebContentExtractor

class WebContentExtractorDeserializer : StdDeserializer<WebContentExtractor>(WebContentExtractor::class.java) {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): WebContentExtractor? =
        parser.valueAsString?.let { lowercase -> WebContentExtractor.valueOf(lowercase.uppercase().replace('-', '_')) }

}