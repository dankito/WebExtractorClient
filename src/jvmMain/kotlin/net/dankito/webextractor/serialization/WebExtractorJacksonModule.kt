package net.dankito.webextractor.serialization

import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.databind.module.SimpleModule
import net.dankito.webextractor.model.MarkdownConverter
import net.dankito.webextractor.model.OutputFormat
import net.dankito.webextractor.model.RequestedFormat
import net.dankito.webextractor.model.WebContentExtractor
import net.dankito.webextractor.model.WebFetcher
import kotlin.jvm.java

class WebExtractorJacksonModule : SimpleModule("WebExtractor", Version(1, 0, 0, null, null, null)) {

    init {
        addSerializer(OutputFormat::class.java, OutputFormatSerializer())
        addDeserializer(OutputFormat::class.java, OutputFormatDeserializer())

        addSerializer(RequestedFormat::class.java, RequestedFormatSerializer())
        addDeserializer(RequestedFormat::class.java, RequestedFormatDeserializer())

        addDeserializer(WebFetcher::class.java, WebFetcherDeserializer())
        addDeserializer(WebContentExtractor::class.java, WebContentExtractorDeserializer())
        addDeserializer(MarkdownConverter::class.java, MarkdownConverterDeserializer())
    }

}