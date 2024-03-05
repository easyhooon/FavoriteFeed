@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.favoritefeed.android.feature)
}

android {
    namespace = "com.kenshi.favoritefeed.feature.main"
}

dependencies {
    implementations(
        projects.feature.favorites,
        projects.feature.home,

        libs.kotlinx.collections.immutable,
        libs.androidx.core,
        libs.androidx.activity.compose,
        libs.timber,
        libs.system.ui.controller,
    )
}
