package net.dankito.webextractor.serialization

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import net.dankito.webextractor.model.RequestedFormat

class RequestedFormatSerializer : StdSerializer<RequestedFormat>(RequestedFormat::class.java) {

    override fun serialize(value: RequestedFormat, generator: JsonGenerator, provider: SerializerProvider) {
        generator.writeString(value.apiValue)
    }

}