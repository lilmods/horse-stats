plugins {
    kotlin("jvm")
}

group = "$modGroup.common"
version = coreVersion

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:$googleGuava")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutines")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = jvmTarget
    }
}
