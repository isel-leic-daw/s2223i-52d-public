package pt.isel.daw.tictactoe.http

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.test.web.reactive.server.WebTestClient
import pt.isel.daw.tictactoe.repositories.memory.GamesMemRepository
import pt.isel.daw.tictactoe.repositories.memory.UsersMemRepository
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import kotlin.test.assertEquals

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpExampleMemRepo {
    @LocalServerPort
    var port: Int = 0

    @TestConfiguration
    class Config {
        @Bean
        @Primary
        fun usersRepository() = UsersMemRepository()

        @Bean
        @Primary
        fun gamesRepository() = GamesMemRepository()
    }

    @Test
    fun exampleTestUsingWebTestClient() {
        val client = WebTestClient.bindToServer().baseUrl("http://localhost:$port").build()
        client.get().uri("/users/1")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("username").isEqualTo("filipe")
    }

    @Test
    fun exampleUsingHttpClientOK() {
        val client = HttpClient.newHttpClient()
        val response = client.send(
            HttpRequest
                .newBuilder()
                .uri(URI("http://localhost:$port/users/1"))
                .GET()
                .build(),
            HttpResponse.BodyHandlers.ofString()
        )
        assertEquals(200, response.statusCode())
    }

    @Test
    fun exampleUsingHttpClientNotFound() {
        val client = HttpClient.newHttpClient()
        val response = client.send(
            HttpRequest
                .newBuilder()
                .uri(URI("http://localhost:$port/users/a"))
                .GET()
                .build(),
            HttpResponse.BodyHandlers.ofString()
        )
        assertEquals(404, response.statusCode())
    }
}