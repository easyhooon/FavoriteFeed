@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.supergene.jvm.kotlin)
}

dependencies {
    compileOnly(
        libs.compose.stable.marker,
    )
    implementations(
        libs.javax.inject,
        libs.kotlinx.coroutines.core,
        libs.androidx.paging.common,
    )
}
