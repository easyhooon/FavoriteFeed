import com.android.build.gradle.LibraryExtension
import com.kenshi.favoritefeed.ApplicationConfig
import com.kenshi.favoritefeed.applyPlugins
import com.kenshi.favoritefeed.configureAndroid
import com.kenshi.favoritefeed.Plugins
import org.gradle.kotlin.dsl.configure

internal class AndroidLibraryConventionPlugin : BuildLogicConventionPlugin({
    applyPlugins(Plugins.AndroidLibrary, Plugins.KotlinAndroid)

    extensions.configure<LibraryExtension> {
        configureAndroid(this)

        defaultConfig.apply {
            targetSdk = ApplicationConfig.TargetSdk
        }
    }
})
