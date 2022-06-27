package com.liquidforte

plugins {
    id("com.liquidforte.library")
    id("distribution")
}

val runtimeClasspath by configurations
distributions {
    main {
        distributionBaseName.set("${rootProject.name}.${project.name}")
        contents {
            from(runtimeClasspath) {
                into("lib")
            }
        }
    }
}

val dist by configurations.creating
val distZip by tasks
artifacts {
    add("dist", distZip)
}