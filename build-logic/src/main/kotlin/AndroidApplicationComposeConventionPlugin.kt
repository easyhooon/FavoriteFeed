import com.android.build.api.dsl.ApplicationExtension
import com.kenshi.favoritefeed.Plugins
import com.kenshi.favoritefeed.applyPlugins
import com.kenshi.favoritefeed.configureCompose
import org.gradle.kotlin.dsl.configure

internal class AndroidApplicationComposeConventionPlugin : BuildLogicConventionPlugin(
    {
        applyPlugins(Plugins.AndroidApplication)

        extensions.configure<ApplicationExtension> {
            configureCompose(this)
        }
    },
)
