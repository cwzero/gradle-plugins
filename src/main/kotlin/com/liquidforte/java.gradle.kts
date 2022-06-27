package com.liquidforte

plugins {
    id("com.liquidforte.base")
    id("java-base")
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}