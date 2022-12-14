# Lecture notes on the Spring Framework

## Creating an (almost) empty JVM project with Spring Boot

- [Spring Initializr](https://start.spring.io)
        - [Example](https://start.spring.io/#!type=gradle-project&language=kotlin&platformVersion=2.7.3&packaging=jar&jvmVersion=17&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo&dependencies=web)
- Select `Generate`. This will produce a `.zip` archive.

- Uncompress `.zip` file into a folder.
- Inspect the folder, noticing:
  - The presence of a `gradlew` file indicates that this is a gradle based project.
  - Instead of a `build.gradle` there is a `build.gradle.kts`.
    - Initially, Gradle build files described the build process using the [Apache Groovy language](https://groovy-lang.org/), which a language that also targets the JVM.
    - More recently, Gradle also started supporting the definition of the build process using the Kotlin lnaguage, which is what we will be using in this project.
- This `build.gradle.kts` looks like a rather simple build file:
  - There are additional plugins being installed, namely the `kotlin` one (since we are using Kotlin) and others that are specific to Spring (these will add new build tasks).
  - There are dependencies for:
    - The Spring Boot library - `org.springframework.boot:spring-boot-starter-web`.
    - Kotlin - `org.jetbrains.kotlin:kotlin-stdlib-jdk8` and `org.jetbrains.kotlin:kotlin-reflect`.
    - The [Jackson library](https://github.com/FasterXML/jackson), which will handle JSON serialization and deserialization.
    - The Spring Boot library for tests - `org.springframework.boot:spring-boot-starter-test`.

- Start Intellij, open the `build.gradle.kts` file as a project, and browse around.
  - The there is a single file under the `main` folder - `SpringDemoApplication.kt`
    - It has an empty class `SpringDemoApplication`, annotated with `@SpringBootApplication`
    - It also has a main function that simply calls `runApplication<runApplication<SpringDemoApplication>(*args)>`, using the above class as the generic argument.

- Notice how the project defines a rather simple console application with a `main` entry point.

## Building and running the application

- Run `./gradlew build`
  - This is will a JAR inside `build/libs`
  - This is a JAR, also called a "uber JAR" or a "fat JAR", containing all the classes required to run the application. No other dependency will be needed for that.

- Run the application by doing `java -jar build/libs/<library-name.jar`.
- Notice the following in the output - `Tomcat started on port(s): 8080 (http) with context path ''`
  - Tomcat is a servlet server, similar to Jetty (which we used in LS). 
  - The server will use port 8080. 
  - The `context path` is `''` meaning that all application paths will start from the root.
- To stop the application, do a `Control-C`
  - Notice how there is a shutdown process, visible in the `Shutting down ExecutorService 'applicationTaskExecutor'` message.

## Adding HTTP request handlers

- The project that we configured uses a library called `Spring MVC` to handle HTTP requests.
  - `MVC` comes from Model-View-Controller.
- A way to define HTTP request handlers is by defining methods inside a _controller_ class.
  - A controller is a class that contains request handing methods.
- Create an `ExampleController` class
  - Annotate it with `@RestController`
    - This is _mark_  this class as being a controller to the Spring framework.
    - Notice that there isn't a required base class.
    - The meaning of `Rest` in `RestController` is be discussed later on.

- Inside this class, create a method that returns the `Hello Web` string and annotate it with `@GetMapping("/examples/1")`.
  - This annotation defines the mapping between the HTTP method and target URI path and a method.

```
@GetMapping("/examples/1")
fun get() = "Hello Web"
```
  
- `Spring MVC` uses Java reflection to 
  - Locate all classes that are controllers via the presence of the `@RestController` annotation.
  - Locate all methods that are handlers, via the presence of `@<Method>Mapping` annotations.
    - Associate each class method to an HTTP method and request URI path.

- Start the application and do a request to `http://locahost:8080/examples/1`
  - Notice that the response contains the `Hello Web` string in the body.
  - Do the request using curl (e.g. `curl -i http://localhost:8080/examples/1`) and notice that the `Content-Type` is `text/plain;charset=UTF-8`.
  - Do the request from a browser and notice that the `Content-Type` is `text/html; charset=UTF-8` (can you tell why?).

- Create a another method returning the `Hello Web` string, but this time add extra information to the annotation.

```
@GetMapping("/examples/2", produces = ["text/plain"])
fun get2() = "Hello Web"
```

- Do a request to `http://locahost:8080/examples/1` from a browser notice that the response contains the `Hello Web` string in the body and the `Content-Type` is now `text/html;charset=UTF-8`.

