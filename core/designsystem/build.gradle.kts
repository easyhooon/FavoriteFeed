@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.favoritefeed.android.library)
    alias(libs.plugins.favoritefeed.android.library.compose)
}

android {
    namespace = "com.kenshi.favoritefeed.core.designsystem"
}

dependencies {
    implementations(
        libs.androidx.core,
        libs.coil.compose,
    )
}
