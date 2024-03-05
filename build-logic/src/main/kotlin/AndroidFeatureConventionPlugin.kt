import com.kenshi.favoritefeed.implementation
import com.kenshi.favoritefeed.libs
import com.kenshi.favoritefeed.applyPlugins
import com.kenshi.favoritefeed.project
import org.gradle.kotlin.dsl.dependencies

internal class AndroidFeatureConventionPlugin : BuildLogicConventionPlugin(
    {
        applyPlugins(
            "favoritefeed.android.library",
            "favoritefeed.android.library.compose",
            "favoritefeed.android.hilt",
        )

        dependencies {
            implementation(project(path = ":core:domain"))
            implementation(project(path = ":core:designsystem"))

            implementation(libs.androidx.hilt.navigation.compose)
            implementation(libs.bundles.androidx.lifecycle)
        }
    },
)
