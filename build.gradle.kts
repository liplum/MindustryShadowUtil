plugins {
    kotlin("jvm") version "1.6.10"
    java
    application
}
sourceSets {
    main {
        java.srcDir("src")
    }
    test {
        java.srcDir("test")
    }
}
group = "net.liplum"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    //implementation("org.eclipse.jgit:org.eclipse.jgit.pgm:6.1.0.202203080745-r")
    implementation("net.lingala.zip4j:zip4j:2.10.0")
}

application {
    mainClass.set("net.liplum.ShadowKt")
}
tasks.getByName<JavaExec>("run"){
    args = listOf(
        "https://github.com/Anuken/Mindustry/archive/refs/heads/erekir.zip"
    )
}
tasks.getByName<Test>("test") {
    useJUnitPlatform()
}