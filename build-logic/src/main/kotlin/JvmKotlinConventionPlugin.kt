import com.kenshi.favoritefeed.ApplicationConfig
import com.kenshi.favoritefeed.applyPlugins
import com.kenshi.favoritefeed.detektPlugins
import com.kenshi.favoritefeed.libs
import com.kenshi.favoritefeed.Plugins
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

internal class JvmKotlinConventionPlugin : BuildLogicConventionPlugin({
    applyPlugins(Plugins.JavaLibrary, Plugins.KotlinJvm)

    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = ApplicationConfig.JavaVersion
        targetCompatibility = ApplicationConfig.JavaVersion
    }

    extensions.configure<KotlinProjectExtension> {
        jvmToolchain(ApplicationConfig.JavaVersionAsInt)
    }

    dependencies {
        detektPlugins(libs.detekt.formatting)
    }
})
