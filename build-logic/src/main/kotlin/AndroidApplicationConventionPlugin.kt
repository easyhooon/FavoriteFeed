import com.android.build.api.dsl.ApplicationExtension
import com.leejihun.supergene.assignment.ApplicationConfig
import com.leejihun.supergene.assignment.Plugins
import com.leejihun.supergene.assignment.applyPlugins
import com.leejihun.supergene.assignment.configureAndroid
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
