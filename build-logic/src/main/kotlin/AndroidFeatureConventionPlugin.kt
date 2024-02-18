import com.leejihun.supergene.assignment.applyPlugins
import com.leejihun.supergene.assignment.implementation
import com.leejihun.supergene.assignment.libs
import com.leejihun.supergene.assignment.project
import org.gradle.kotlin.dsl.dependencies

internal class AndroidFeatureConventionPlugin : BuildLogicConventionPlugin(
    {
        applyPlugins(
            "supergene.android.library",
            "supergene.android.library.compose",
            "supergene.android.hilt",
        )

        dependencies {
            implementation(project(path = ":core:domain"))

            implementation(libs.androidx.hilt.navigation.compose)
            implementation(libs.bundles.androidx.lifecycle)
        }
    },
)
