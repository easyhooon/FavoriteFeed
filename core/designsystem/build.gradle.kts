@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.supergene.android.library)
    alias(libs.plugins.supergene.android.library.compose)
}

android {
    namespace = "com.leejihun.supergene.assignment.core.designsystem"
}

dependencies {
    implementations(
        libs.androidx.core,
        libs.coil.compose,
    )
}
