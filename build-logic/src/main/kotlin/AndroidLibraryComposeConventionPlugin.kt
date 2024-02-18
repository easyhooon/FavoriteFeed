import com.android.build.gradle.LibraryExtension
import com.leejihun.supergene.assignment.Plugins
import com.leejihun.supergene.assignment.applyPlugins
import com.leejihun.supergene.assignment.configureCompose
import org.gradle.kotlin.dsl.configure

internal class AndroidLibraryComposeConventionPlugin : BuildLogicConventionPlugin(
    {
        applyPlugins(Plugins.AndroidLibrary)

        extensions.configure<LibraryExtension> {
            configureCompose(this)
        }
    },
)


