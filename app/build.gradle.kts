@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.supergene.android.application)
    alias(libs.plugins.supergene.android.application.compose)
    alias(libs.plugins.supergene.android.hilt)
}

android {
    namespace = "com.leejihun.supergene.assignment"

    buildFeatures {
        buildConfig = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementations(
        projects.core.data,
        projects.core.database,
        projects.core.designsystem,
        projects.core.domain,
        projects.core.network,

        projects.feature.favorites,
        projects.feature.home,
        projects.feature.main,

        libs.androidx.activity.compose,
        libs.androidx.core,
        libs.androidx.splash,
        libs.androidx.startup,
        libs.timber,
    )
}
