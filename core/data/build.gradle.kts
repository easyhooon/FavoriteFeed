@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.favoritefeed.android.library)
    alias(libs.plugins.favoritefeed.android.hilt)
    alias(libs.plugins.favoritefeed.android.retrofit)
    id("kotlinx-serialization")
}

android {
    namespace = "com.kenshi.favoritefeed.core.data"
}

dependencies {
    implementations(
        projects.core.domain,
        projects.core.network,
        projects.core.database,

        libs.androidx.paging.runtime,
        libs.timber,
    )
}
