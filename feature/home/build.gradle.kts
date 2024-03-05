@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.favoritefeed.android.feature)
}

android {
    namespace = "com.kenshi.favoritefeed.feature.home"
}

dependencies {
    implementations(
        libs.androidx.core,
        libs.androidx.activity.compose,
        libs.androidx.paging.compose,
        libs.timber,
        libs.system.ui.controller,
    )
}
