import androidx.room.gradle.RoomExtension
import com.kenshi.favoritefeed.Plugins
import com.kenshi.favoritefeed.applyPlugins
import com.kenshi.favoritefeed.implementation
import com.kenshi.favoritefeed.ksp
import com.kenshi.favoritefeed.libs
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : BuildLogicConventionPlugin(
    {
        applyPlugins(Plugins.AndroidxRoom, Plugins.KotlinxSerialization, Plugins.Ksp)

        extensions.configure<RoomExtension> {
            // The schemas directory contains a schema file for each version of the Room database.
            // This is required to enable Room auto migrations.
            // See https://developer.android.com/reference/kotlin/androidx/room/AutoMigration.
            schemaDirectory("$projectDir/schemas")
        }

        dependencies {
            implementation(libs.androidx.room.runtime)
            implementation(libs.androidx.room.ktx)
            ksp(libs.androidx.room.compiler)
            implementation(libs.kotlinx.serialization.json)
        }
    },
)
