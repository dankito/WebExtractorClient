package net.dankito.webextractor.model

import kotlinx.serialization.Serializable

@Serializable
data class ExtractionMetrics(
    val name: String,

    val linkDensity: Float? = null,
    val boilerplatePhraseRatio: Float? = null,
    val compressionRatio: Float? = null,
    val avgSentenceLength: Float? = null,
    val navTagLeakage: Float? = null,
    val readabilityScore: Float? = null,
    val repetitionRatio: Float? = null,

    val extractedWordsCount: Int? = null,
    val pageWordsCount: Int? = null,

    val score: Float? = null,
)
