plugins {
    java
    id("com.github.johnrengelman.shadow") version ("7.1.2")
}

group = "team.devblook"
version = property("projectVersion") as String
description = "A modern Minecraft server hub core solution. Based on DeluxeHub by ItsLewizz."

val libsPackage = property("libsPackage") as String

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    maven("https://repo.codemc.org/repository/maven-public")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://jitpack.io")
    maven("https://repo.papermc.io/repository/maven-public/")
    mavenCentral()
}

dependencies {
    implementation("javax.inject:javax.inject:1")

    implementation("org.bstats:bstats-bukkit-lite:1.8")
    implementation("com.github.cryptomorin:XSeries:9.0.0")

    implementation("com.github.MegavexNetwork.scoreboard-library:implementation:-SNAPSHOT")
    runtimeOnly("com.github.MegavexNetwork.scoreboard-library:v1_19_R1:-SNAPSHOT")

    compileOnly("net.kyori:adventure-text-minimessage:4.11.0")
    compileOnly("net.kyori:adventure-api:4.11.0")

    compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")

    compileOnly("com.mojang:authlib:1.5.25")
    compileOnly("me.clip:placeholderapi:2.11.2")
    compileOnly("com.arcaniax:HeadDatabase-API:1.3.1")
}

configurations.implementation {
    exclude("org.bukkit", "bukkit")
}

tasks {
    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version)
        }
    }

    shadowJar {
        archiveClassifier.set("")
        archiveFileName.set("Akropolis-${project.version}.jar")

        minimize {
            exclude(dependency("com.github.MegavexNetwork.scoreboard-library:.*:.*"))
        }

        relocate("org.bstats", "${libsPackage}.metrics")
        relocate("com.cryptomorin.xseries", "${libsPackage}.xseries")
        relocate("net.megavex.scoreboardlibrary", "${libsPackage}.scoreboardlibrary")
    }

    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}
