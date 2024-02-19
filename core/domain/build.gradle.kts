@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
    alias(libs.plugins.supergene.jvm.kotlin)
}

dependencies {
    implementations(
        libs.javax.inject,
        libs.kotlinx.coroutines.core,
        libs.androidx.paging.common
    )
}
