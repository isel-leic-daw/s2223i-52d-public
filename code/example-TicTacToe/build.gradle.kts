import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.3"
	id("io.spring.dependency-management") version "1.0.13.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

val isArm = System.getProperty("os.arch") == "aarch64"
val isMac = System.getProperty("os.name").toLowerCase().contains("mac")

repositories {
	mavenCentral()
}

dependencies {

	implementation("org.jdbi:jdbi3-core:3.32.0")
	implementation("org.jdbi:jdbi3-kotlin:3.28.0")
	implementation("org.jdbi:jdbi3-postgres:3.32.0")
	implementation("org.postgresql:postgresql:42.5.0")


	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("net.glxn:qrgen:1.4")
	implementation("org.slf4j:slf4j-api:2.0.0")
	runtimeOnly("org.slf4j:slf4j-simple:2.0.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webflux")

	if(isMac && isArm) {
		runtimeOnly("io.netty:netty-resolver-dns-native-macos:4.1.82.Final:osx-aarch_64")
	}

	testImplementation(kotlin("test"))
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
