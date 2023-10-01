plugins {
	java
	id("org.springframework.boot") version "3.1.4"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "com.sinam"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	//swagger
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")

	//mapper
	implementation("org.mapstruct:mapstruct-jdk8:1.3.0.Final")
	annotationProcessor("org.mapstruct:mapstruct-jdk8:1.5.3.Final")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.3.0.Final")

	//postgresql
	runtimeOnly("org.postgresql:postgresql")

	//liquibase
	implementation("org.liquibase:liquibase-core")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
