import com.leejihun.supergene.assignment.Plugins
import com.leejihun.supergene.assignment.applyPlugins
import com.leejihun.supergene.assignment.implementation
import com.leejihun.supergene.assignment.ksp
import com.leejihun.supergene.assignment.libs
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
