@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.supergene.android.library)
    alias(libs.plugins.supergene.android.hilt)
    alias(libs.plugins.supergene.android.room)
    id("kotlinx-serialization")
}

android {
    namespace = "com.leejihun.supergene.assignment.core.database"
}

dependencies {
    implementations(
        // libs.androidx.room.paging,
        libs.timber,
    )
}
