@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.favoritefeed.android.library)
    alias(libs.plugins.favoritefeed.android.hilt)
    alias(libs.plugins.favoritefeed.android.room)
    id("kotlinx-serialization")
}

android {
    namespace = "com.kenshi.favoritefeed.core.database"
}

dependencies {
    implementations(
        libs.timber,
    )
}
