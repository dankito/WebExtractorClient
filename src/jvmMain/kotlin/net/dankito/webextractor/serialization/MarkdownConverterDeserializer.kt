package net.dankito.webextractor.serialization

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import net.dankito.webextractor.model.MarkdownConverter

class MarkdownConverterDeserializer : StdDeserializer<MarkdownConverter>(MarkdownConverter::class.java) {

    override fun deserialize(parser: JsonParser, context: DeserializationContext): MarkdownConverter? =
        parser.valueAsString?.let { lowercase -> MarkdownConverter.valueOf(lowercase.uppercase()) }

}