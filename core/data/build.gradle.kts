@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.supergene.android.library)
    alias(libs.plugins.supergene.android.hilt)
    alias(libs.plugins.supergene.android.retrofit)
    id("kotlinx-serialization")
}

android {
    namespace = "com.leejihun.supergene.assignment.core.data"
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
