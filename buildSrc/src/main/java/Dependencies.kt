/**
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val detekt by lazy { "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.detekt}" }
}

/**
 * To define dependencies
 */
object Deps {
    // Kotlin
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }

    // Android
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val materialDesign by lazy { "com.google.android.material:material:${Versions.material}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activity}" }
    val lifecycleRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}" }
    val composeUI by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
    val composeUITooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
    val composeUIToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
    val composeFoundation by lazy { "androidx.compose.foundation:foundation:${Versions.compose}" }
    val composeMaterial by lazy { "androidx.compose.material:material:${Versions.compose}" }
    val composeMaterialIcons by lazy { "androidx.compose.material:material-icons-extended:${Versions.compose}" }
    val viewModelCompose by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}" }


    // Others
    val detektFormatting by lazy { "io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.detekt}" }
}
