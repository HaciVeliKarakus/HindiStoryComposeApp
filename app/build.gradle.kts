plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.hvk.hindistory"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.hvk.hindistory"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/*"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // https://voyager.adriel.cafe/setup
    implementation("cafe.adriel.voyager:voyager-navigator:1.0.0-rc06")
    implementation("cafe.adriel.voyager:voyager-androidx:1.0.0-rc06")
    implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:1.0.0-rc06")
    implementation("cafe.adriel.voyager:voyager-tab-navigator:1.0.0-rc06")
    implementation("cafe.adriel.voyager:voyager-transitions:1.0.0-rc06")

    // https://insert-koin.io/docs/quickstart/android-compose
    implementation("io.insert-koin:koin-androidx-compose:3.4.5")

    // https://docs.skrape.it/docs/overview/setup
    implementation("it.skrape:skrapeit:1.1.5")

    // https://coil-kt.github.io/coil/compose/
    implementation("io.coil-kt:coil-compose:2.4.0")

    // http://airbnb.io/lottie/#/android-compose
    implementation("com.airbnb.android:lottie-compose:6.0.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
