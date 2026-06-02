package net.dankito.webextractor.serialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import net.dankito.webextractor.model.OutputFormat

class OutputFormatDeserializer : StdDeserializer<OutputFormat>(OutputFormat::class.java) {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): OutputFormat? =
        parser.valueAsString?.let { lowercase -> OutputFormat.valueOf(lowercase.uppercase()) }

}