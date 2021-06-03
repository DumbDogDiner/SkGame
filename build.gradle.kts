plugins {
    kotlin("jvm") version "1.4.10"
    id("maven-publish")
    id("com.diffplug.spotless") version "5.8.2"
    id("org.jetbrains.dokka") version "1.4.20"
    id("io.freefair.lombok") version "5.3.3.3"
}

allprojects {
    version = "1.0.0"
    group = "com.dumbdogdiner"

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
    apply(plugin = "maven-publish")
    apply(plugin = "io.freefair.lombok")

    // Spotless configuration
    apply(plugin =  "com.diffplug.spotless")
    spotless {
        ratchetFrom = "origin/master"
        kotlin {
            target(fileTree(".") {
                include("**/*.kt")
                exclude("**/.gradle/**")
            })
            // see https://github.com/shyiko/ktlint#standard-rules
            ktlint().userData(mapOf("max_line_length" to "120", "insert_final_newline" to "true"))
            licenseHeaderFile("${rootDir}/LICENSE_HEADER")
        }
    }

    apply(plugin = "org.jetbrains.dokka")

    // declare global dependencies
    dependencies {
        implementation("org.projectlombok:lombok:1.18.18")
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

        create<Jar>("sources") {
            archiveClassifier.set("sources")
            from("sourceSets.main.allSource")
        }
    }

    val sourcesJar by tasks.creating(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets.getByName("main").allSource)
    }

    val dokkaJavadocJar by tasks.creating(Jar::class) {
        dependsOn(tasks.dokkaJavadoc)
        from(tasks.dokkaJavadoc.get().outputDirectory.get())
        archiveClassifier.set("javadoc")
    }

    // define the publishing block
    publishing {
        repositories {
            // github packages repository
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/DumbDogDiner/SkGame")
                credentials {
                    username = extra.properties.getOrDefault("gpr.user", System.getenv("GITHUB_ACTOR")).toString()
                    password =  extra.properties.getOrDefault("gpr.password", System.getenv("GITHUB_TOKEN")).toString()
                }
            }
        }
        // define the publication for github packages
        publications {
            register<MavenPublication>("gpr") {
                artifactId = "${rootProject.name}-${project.name}"

                from(components["java"])
                // include the sources, and javadoc in the publication
                artifact(sourcesJar)
                artifact(dokkaJavadocJar)

                // configure pom for the output
                pom {
                    scm {
                        connection.set("scm:git:https://github.com/DumbDogDiner/SkGame.git")
                        developerConnection.set("scm:git:https://github.com/DumbDogDiner/SkGame.git")
                        url.set("https://github.com/DumbDogDiner/SkGame")
                    }
                    issueManagement {
                        system.set("GitHub Issues")
                        url.set("https://github.com/DumbDogDiner/SkGame/issues")
                    }
                    ciManagement {
                        system.set("GitHub Actions")
                        url.set("https://github.com/DumbDogDiner/SkGame/actions")
                    }
                }
            }
        }
    }
}
