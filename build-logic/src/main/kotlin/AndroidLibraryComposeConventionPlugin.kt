import com.android.build.gradle.LibraryExtension
import com.kenshi.favoritefeed.Plugins
import com.kenshi.favoritefeed.applyPlugins
import com.kenshi.favoritefeed.configureCompose
import org.gradle.kotlin.dsl.configure

internal class AndroidLibraryComposeConventionPlugin : BuildLogicConventionPlugin(
    {
        applyPlugins(Plugins.AndroidLibrary)

        extensions.configure<LibraryExtension> {
            configureCompose(this)
        }
    },
)


