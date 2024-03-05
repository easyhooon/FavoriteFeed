import com.android.build.api.dsl.ApplicationExtension
import com.kenshi.favoritefeed.ApplicationConfig
import com.kenshi.favoritefeed.applyPlugins
import com.kenshi.favoritefeed.configureAndroid
import com.kenshi.favoritefeed.Plugins
import org.gradle.kotlin.dsl.configure

internal class AndroidApplicationConventionPlugin : BuildLogicConventionPlugin(
    {
        applyPlugins(Plugins.AndroidApplication, Plugins.KotlinAndroid)

        extensions.configure<ApplicationExtension> {
            configureAndroid(this)

            defaultConfig {
                targetSdk = ApplicationConfig.TargetSdk
                versionCode = ApplicationConfig.VersionCode
                versionName = ApplicationConfig.VersionName
            }
        }
    },
)
