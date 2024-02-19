@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.supergene.android.library)
    alias(libs.plugins.supergene.android.hilt)
    alias(libs.plugins.supergene.android.retrofit)
    id("kotlinx-serialization")
}

android {
    namespace = "com.leejihun.supergene.assignment.core.data"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementations(
        projects.core.domain,

        libs.timber,
    )
}
