plugins {
    kotlin("jvm")
    id("org.jetbrains.dokka")
}

dependencies {
    // reflection
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.10")
    // test deps
    testImplementation(platform("org.junit:junit-bom:5.7.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
            this.showStandardStreams = true
        }
    }
}
