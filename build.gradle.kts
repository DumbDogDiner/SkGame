plugins {
    kotlin("jvm") version "1.4.10"
    id("com.diffplug.spotless") version "5.8.2"
    id("org.jetbrains.dokka") version "1.4.20"
}

allprojects {
    version = "1.0.0"

    // declare global repositories
    repositories {
        jcenter()
        mavenCentral()

        // papermc repository
        maven {
            url = uri("https://papermc.io/repo/repository/maven-public/")
        }
    }
}

subprojects {
    // apply plugins
    apply(plugin = "kotlin")
    apply(plugin = "org.jetbrains.dokka")

    // Spotless configuration
    apply(plugin =  "com.diffplug.spotless")
    spotless {
        ratchetFrom = "origin/master"
    }

    // declare global dependencies
    dependencies {
        compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    }

    tasks {
        compileJava {
            targetCompatibility = JavaVersion.VERSION_14.toString()
            sourceCompatibility = JavaVersion.VERSION_14.toString()
        }
        compileKotlin {
            kotlinOptions.jvmTarget = JavaVersion.VERSION_14.toString()
        }
    }
}
