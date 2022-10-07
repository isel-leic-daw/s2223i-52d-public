package com.example.demo

import com.example.demo.pipeline.ExampleFilter
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.core.kotlin.mapTo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.servlet.http.HttpServletRequest

data class Student(
    val name : String,
    val number : Int
)

@RestController
@RequestMapping("/demo")
class DemoController {

    @GetMapping("0")
    fun handle0()="Handle One"

    @GetMapping("1/{id}")
    fun handle1(@PathVariable id : Int) = "id = ${id}"

    @GetMapping("2")
    fun handle2(@RequestParam id : Int?) = "id = ${id}"

    @GetMapping("3")
    fun handle3(@RequestParam parms : MultiValueMap<String,String>) =
        parms.map{"key = ${it.key} - value = ${it.value} "}.joinToString()

    @GetMapping("4")
    fun handle4() = Student("Filipe", 1234)

    @PostMapping("5")
    fun handle5(@RequestBody std : Student ) = std
        //"name : ${std.name} - number : ${std.number}"

    @GetMapping("6")
    fun handler6(
        clientIp: ClientIp,
    ) = "Hello ${clientIp.ipAddress}"


    @PostMapping("7")
    fun handler7(
        request: HttpServletRequest,
        @RequestBody input: Student,
    ) = "Accept: ${request.getHeader("Accept")}, Body: $input }"

    @PostMapping("8")
    fun handler8(@RequestBody std : Student) = ResponseEntity
        .status(201)
        .body(std)

    @GetMapping("9")
    fun handler9() = URI("https://www.example.com")


    companion object {
        private val log: Logger = LoggerFactory.getLogger(ExampleFilter::class.java)
    }
}