import com.kenshi.favoritefeed.Plugins
import com.kenshi.favoritefeed.applyPlugins
import com.kenshi.favoritefeed.implementation
import com.kenshi.favoritefeed.libs
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
