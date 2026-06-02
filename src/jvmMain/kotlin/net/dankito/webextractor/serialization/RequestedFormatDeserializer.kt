package net.dankito.webextractor.serialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import net.dankito.webextractor.model.RequestedFormat

class RequestedFormatDeserializer : StdDeserializer<RequestedFormat>(RequestedFormat::class.java) {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): RequestedFormat? =
        parser.valueAsString?.let { lowercase -> RequestedFormat.valueOf(lowercase.uppercase()) }

}