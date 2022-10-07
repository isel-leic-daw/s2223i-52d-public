package com.example.demo

import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.core.kotlin.mapTo

fun main(){
    val jdbi = Jdbi.create("jdbc:postgresql://localhost/postgres?user=postgres&password=postgres");
    jdbi.installPlugin(KotlinPlugin())
    jdbi.useHandle<Exception> { handle ->
        val result = handle.createQuery("select name, number from students")
        val students = result.mapTo<Student>().list();
        println(students.joinToString("\n"))
    }
}

//: <https://api.github.com/organizations/10852760/repos?per_page=2&page=2>; rel="next", <https://api.github.com/organizations/10852760/repos?per_page=2&page=6>; rel="last"