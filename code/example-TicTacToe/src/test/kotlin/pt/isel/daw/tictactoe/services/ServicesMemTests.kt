package pt.isel.daw.tictactoe.services

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import pt.isel.daw.tictactoe.repositories.memory.UsersMemRepository
import kotlin.test.assertEquals

@SpringBootTest
class ServicesMemTests {

    @Autowired
    lateinit var usersService: UsersService

    @TestConfiguration
    class Config {
        @Bean
        @Primary
        fun usersRepository() = UsersMemRepository()
    }

    @Test
    fun exampleTest() {

        val user = usersService.getById(1)
        assertEquals("filipe",user.username)
    }

}