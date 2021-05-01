# SkGame:template

This module implements template configuration for easily writing new modules. You can copy this module, rename it, and change its configuration until you're happy with it.

## Default Configuration

By default, template will inherit configuration specified in the root `build.gradle.kts` file, as this removes common dependencies and repositories from build files. By default, SkGame libraries build to target Java 14, as this is the running version on DDD servers.

## Plugins

By default, template includes the following plugins:
```kotlin
plugins {
    // kotlin jvm
    kotlin("jvm") version "1.4.32"
    // spotless formatter
    id("com.diffplug.spotless") version "5.8.2"
    // kotlin javadoc plugin
    id("org.jetbrains.dokka") version "1.4.20"
}
```

## Repositories

By default, template includes the following repository block

```kotlin
repositories { 
    mavenCentral()
    jCenter()
    // paper repository
    maven {
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }
}
```

## Dependencies

By default, template includes the following dependency block:

```kotlin
dependencies {
    // papermc
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    // kotlin standard library
    implementation(kotlin("stdlib"))
    // lucko helper library
    implementation("me.lucko:helper:5.6.5")
    implementation("org.jetbrains:annotations:20.1.0")
    // testing dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}
```
