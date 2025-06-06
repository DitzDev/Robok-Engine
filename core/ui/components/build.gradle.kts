plugins {
  alias(libs.plugins.agp.lib)
  alias(libs.plugins.kotlin)
  alias(libs.plugins.compose.compiler)
}

android {
  namespace = "org.robok.engine.ui.core.components"
  compileSdk = libs.versions.android.compileSdk.get().toInt()

  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildFeatures {
    viewBinding = true
    compose = true
  }

  compileOptions {
    sourceCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
    targetCompatibility = JavaVersion.toVersion(libs.versions.android.jvm.get().toInt())
  }

  kotlinOptions {
    jvmTarget = libs.versions.android.jvm.get()
  }
}

dependencies {
  implementation(libs.google.material)
  implementation(libs.androidx.appcompat)

  implementation(libs.bundles.compose)
  implementation(libs.compose.scrolleffect)

  implementation(projects.appStrings)
  implementation(projects.core.utils)
}