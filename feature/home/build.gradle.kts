@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.supergene.android.feature)
}

android {
    namespace = "com.leejihun.supergene.assignment.feature.home"
}

dependencies {
    implementations(
        libs.androidx.core,
        libs.androidx.activity.compose,
        libs.timber,
        libs.system.ui.controller,
    )
}
