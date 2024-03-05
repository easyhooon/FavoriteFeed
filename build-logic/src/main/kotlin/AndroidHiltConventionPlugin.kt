import com.kenshi.favoritefeed.Plugins
import com.kenshi.favoritefeed.applyPlugins
import com.kenshi.favoritefeed.implementation
import com.kenshi.favoritefeed.ksp
import com.kenshi.favoritefeed.libs
import org.gradle.kotlin.dsl.dependencies

internal class AndroidHiltConventionPlugin : BuildLogicConventionPlugin(
    {
        applyPlugins(Plugins.hilt, Plugins.Ksp)

        dependencies {
            implementation(libs.hilt.android)
            ksp(libs.hilt.android.compiler)
        }
    },
)
