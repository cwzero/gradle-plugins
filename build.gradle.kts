import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    id("com.github.ben-manes.versions") version "0.42.0"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("com.github.ben-manes:gradle-versions-plugin:0.42.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}