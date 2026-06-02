package net.dankito.webextractor.serialization

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.std.StdSerializer
import net.dankito.webextractor.model.OutputFormat

class OutputFormatSerializer : StdSerializer<OutputFormat>(OutputFormat::class.java) {

    override fun serialize(value: OutputFormat, generator: JsonGenerator, provider: SerializerProvider) {
        generator.writeString(value.name.lowercase())
    }

}