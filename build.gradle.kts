plugins {
    kotlin("jvm") version "2.2.0"
    id("maven-publish")
    id("java-library")
}

group = "com.dharamstudios"
version = "0.2.4"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}

java {
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = "com.dharamstudios"
            artifactId = "validation-core"
            version = "0.2.4"
        }
    }
}