import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    val kotlinVersion = "2.3.20"
    kotlin("multiplatform") version kotlinVersion
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


kotlin {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
        // suppresses compiler warning: [EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING] 'expect'/'actual' classes (including interfaces, objects, annotations, enums, and 'actual' typealiases) are in Beta.
        freeCompilerArgs.add("-Xexpect-actual-classes")

        // avoid "variable has been optimised out" in debugging mode
        if (System.getProperty("idea.debugger.dispatch.addr") != null) {
            freeCompilerArgs.add("-Xdebug")
        }
    }


    jvmToolchain(11)

    jvm()


    js {
        binaries.executable()

        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    useFirefoxHeadless()
                }
            }
        }

        nodejs {
            testTask {
                useMocha {
                    timeout = "20s" // Mocha times out after 2 s, which is too short for some tests
                }
            }
        }
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            testTask {
                useKarma {
                    useChromeHeadless()
                    useFirefoxHeadless()
                }
            }
        }
    }


    linuxX64()
    mingwX64()

    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosArm64()
    watchosArm64()
    watchosSimulatorArm64()
    tvosArm64()
    tvosSimulatorArm64()

    applyDefaultHierarchyTemplate()


    sourceSets {
        val kotlinCoroutinesVersion: String by project
        val kotlinxSerializationVersion: String by project
        val webClientVersion: String by project

        val assertKVersion: String by project
        val logbackVersion: String by project

        commonMain.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${kotlinCoroutinesVersion}")
            implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${kotlinxSerializationVersion}")
            api("net.dankito.web:web-client-api:${webClientVersion}")
            implementation("net.dankito.web:ktor-web-client:${webClientVersion}")
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinCoroutinesVersion")

            implementation("com.willowtreeapps.assertk:assertk:$assertKVersion")
        }

        jvmTest.dependencies {
            implementation("ch.qos.logback:logback-classic:$logbackVersion")
        }
    }
}


if (file("./gradle/scripts/publish-dankito.gradle.kts").exists()) {
    apply(from = "./gradle/scripts/publish-dankito.gradle.kts")
}