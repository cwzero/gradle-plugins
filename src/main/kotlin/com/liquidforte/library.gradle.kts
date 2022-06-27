package com.liquidforte

import gradle.kotlin.dsl.accessors._ac15ab036490e2c022365f23398906a9.base

plugins {
    id("com.liquidforte.java")
    id("java-library")
}

val junitVersion: String by rootProject.extra
val mockitoVersion: String by rootProject.extra
val assertjVersion: String by rootProject.extra

dependencies {
    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")

    testImplementation("org.assertj:assertj-core:$assertjVersion")
}

tasks.withType<JavaExec> {
    standardInput = System.`in`
    workingDir = rootProject.file("run")
}

tasks.withType<Test> {
    useJUnitPlatform()
    systemProperties["junit.jupiter.execution.parallel.enabled"] = true
    systemProperties["junit.jupiter.execution.parallel.mode.default"] = "concurrent"
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
}

base.archivesName.set("${rootProject.name}.${project.name}")