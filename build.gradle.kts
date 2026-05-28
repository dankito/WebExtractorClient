plugins {
    val kotlinVersion = "2.3.20"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion
}


group = "net.dankito.webextractor"
version = "1.0.0-SNAPSHOT"

ext["customArtifactId"] = "web-extractor-client"

ext["sourceCodeRepositoryBaseUrl"] = "github.com/dankito/WebExtractorClient"

ext["projectDescription"] = "Kotlin Multiplatform Client for WebExtractor (https://github.com/dankito/WebExtractorClient)"


kotlin {
    jvmToolchain(21)
}


repositories {
    mavenCentral()
}


val kotlinCoroutinesVersion: String by project
val kotlinxSerializationVersion: String by project
val webClientVersion: String by project
val kmpDateTimeVersion: String by project

val assertKVersion: String by project
val logbackVersion: String by project

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlinxSerializationVersion")

    api("net.dankito.web:web-client-api:$webClientVersion")
    implementation("net.dankito.web:ktor-web-client:$webClientVersion")


    testImplementation(kotlin("test"))
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinCoroutinesVersion")

    testImplementation("com.willowtreeapps.assertk:assertk:$assertKVersion")
    testImplementation("ch.qos.logback:logback-classic:$logbackVersion")
}

tasks.test {
    useJUnitPlatform()
}


if (file("./gradle/scripts/publish-dankito.gradle.kts").exists()) {
    apply(from = "./gradle/scripts/publish-dankito.gradle.kts")
}