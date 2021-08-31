plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.21"
    id("org.jetbrains.kotlin.kapt") version "1.5.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("io.micronaut.application") version "2.0.3"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.5.21"
}

version = "0.1"
group = "io.github.julioamorim"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("io.github.julioamorim.*")
    }
}

dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    kapt("io.micronaut.data:micronaut-data-processor")

    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("io.micronaut.sql:micronaut-hibernate-jpa")
    runtimeOnly("com.h2database:h2")

}


application {
    mainClass.set("io.github.julioamorim.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("14")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "14"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "14"
        }
    }


}
