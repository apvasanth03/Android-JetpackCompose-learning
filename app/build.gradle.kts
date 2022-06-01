plugins {
    id("com.android.application")
    id("kotlin-android")
    id("io.gitlab.arturbosch.detekt") version Versions.detekt
}

android {
    compileSdk = ConfigData.compileSdkVersion
    buildToolsVersion = ConfigData.buildToolsVersion

    defaultConfig {
        applicationId = "com.vasanth.jetpackcomposelearning"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

// Detekt Configuration.
detekt {
    toolVersion = Versions.detekt
    source = files("src/main/java", "src/main/kotlin")
    config = files("${rootProject.projectDir}/config/detekt/detekt.yml")
    buildUponDefaultConfig = true
    autoCorrect = true
}

dependencies {
    // Kotlin
    implementation(Deps.kotlin)

    // Android
    implementation(Deps.coreKtx)
    implementation(Deps.appCompat)
    implementation(Deps.materialDesign)
    implementation(Deps.constraintLayout)
    implementation(Deps.navigationFragmentKtx)
    implementation(Deps.navigationUIKtx)
    implementation(Deps.composeUI)
    implementation(Deps.composeUITooling)
    implementation(Deps.composeFoundation)
    implementation(Deps.composeMaterial)

    // Others

    // Detekt
    detektPlugins(Deps.detektFormatting)
}