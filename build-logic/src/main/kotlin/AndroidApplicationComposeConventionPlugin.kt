import com.android.build.api.dsl.ApplicationExtension
import com.leejihun.supergene.assignment.Plugins
import com.leejihun.supergene.assignment.applyPlugins
import com.leejihun.supergene.assignment.configureCompose
import org.gradle.kotlin.dsl.configure

internal class AndroidApplicationComposeConventionPlugin : BuildLogicConventionPlugin(
    {
        applyPlugins(Plugins.AndroidApplication)

        extensions.configure<ApplicationExtension> {
            configureCompose(this)
        }
    },
)
