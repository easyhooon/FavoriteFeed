@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.favoritefeed.android.feature)
}

android {
    namespace = "com.kenshi.favoritefeed.feature.favorites"
}

dependencies {
    implementations(
        projects.core.domain,

        libs.kotlinx.collections.immutable,
        libs.androidx.core,
        libs.androidx.activity.compose,
        libs.androidx.paging.compose,
        libs.timber,
        libs.system.ui.controller,
        libs.coil.compose,
    )
}
