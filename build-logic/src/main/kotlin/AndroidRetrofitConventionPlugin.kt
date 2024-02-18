import com.leejihun.supergene.assignment.Plugins
import com.leejihun.supergene.assignment.applyPlugins
import com.leejihun.supergene.assignment.implementation
import com.leejihun.supergene.assignment.libs
import org.gradle.kotlin.dsl.dependencies

internal class AndroidRetrofitConventionPlugin : BuildLogicConventionPlugin(
    {
        applyPlugins(Plugins.KotlinxSerialization)

        dependencies {
            implementation(libs.retrofit)
            implementation(libs.retrofit.kotlinx.serialization.converter)
            implementation(libs.okhttp.logging.interceptor)
            implementation(libs.kotlinx.serialization.json)
        }
    },
)
