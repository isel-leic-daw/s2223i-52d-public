package pt.isel.daw.tictactoe

import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import pt.isel.daw.tictactoe.repositories.jdbi.mappers.BoardMapper

// TicTacToe simplified game implementation
// Services and Repositories are using code and follow some of the ideas from
// https://github.com/isel-leic-daw/s2223i-51d-51n-public/tree/main/code/tic-tac-tow-service

@SpringBootApplication
class TicTacToeApp {
	//TODO Use DataSource and URL in environment variable
	@Bean
	fun jdbi() = Jdbi.create("jdbc:postgresql://localhost/postgres?user=postgres&password=postgres")
		.installPlugin(KotlinPlugin())
		.registerColumnMapper(BoardMapper())
}

fun main(args: Array<String>) {
	runApplication<TicTacToeApp>(*args)
}
