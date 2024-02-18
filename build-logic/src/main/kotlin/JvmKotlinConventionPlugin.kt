import com.leejihun.supergene.assignment.ApplicationConfig
import com.leejihun.supergene.assignment.Plugins
import com.leejihun.supergene.assignment.applyPlugins
import com.leejihun.supergene.assignment.detektPlugins
import com.leejihun.supergene.assignment.libs
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
