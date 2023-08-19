plugins {
    id("java-library")
    `maven-publish`
    id("io.freefair.lombok") version "8.2.2" apply false
}

group = "ru.melonhell.survival"
version = "0.0.3"

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")
    apply(plugin = "io.freefair.lombok")

    version = rootProject.version

    repositories {
        mavenCentral()
        maven("https://jitpack.io/")
        maven("https://papermc.io/repo/repository/maven-public/") // Paper API
    }

    dependencies {
        compileOnly("org.jetbrains:annotations:24.0.1")
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        withSourcesJar()
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = rootProject.group.toString()
                from(components["java"])
            }
        }

        repositories {
            mavenLocal()
            maven("https://maven.melonhell.ru/public/") { melonhellCredentials() }
        }
    }
}

fun AuthenticationSupported.melonhellCredentials() = credentials {
    credentials {
        username = extensions.extraProperties["melonhell.username"]?.toString()
        password = extensions.extraProperties["melonhell.password"]?.toString()
    }
}
