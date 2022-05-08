import org.gradle.api.JavaVersion.VERSION_17

plugins {
    id("java")
    id("maven")
}

group = "com.github.tarasmurzenkovv"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation ("io.kubernetes:client-java:15.0.1")
    implementation ("ch.qos.logback:logback-classic:1.2.11")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.13.2.2")
    compileOnly("org.projectlombok:lombok:1.18.24")
    annotationProcessor("org.projectlombok:lombok:1.18.24")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    testCompileOnly("org.projectlombok:lombok:1.18.24")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.24")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}