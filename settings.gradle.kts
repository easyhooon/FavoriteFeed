rootProject.name = "supergene-assignment"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("STABLE_CONFIGURATION_CACHE")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
include(":app")

include(":core:data")
include(":core:database")
include(":core:designsystem")
include(":core:domain")
include(":core:network")

include(":feature:favorites")
include(":feature:home")
include(":feature:main")
