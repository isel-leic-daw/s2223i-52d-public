package pt.isel.daw.tictactoe

import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.postgresql.ds.PGSimpleDataSource
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import pt.isel.daw.tictactoe.repositories.jdbi.mappers.BoardMapper

// TicTacToe simplified game implementation
// Services and Repositories are using code and follow some of the ideas from
// https://github.com/isel-leic-daw/s2223i-51d-51n-public/tree/main/code/tic-tac-tow-service

//docker build -t tictac:1
//docker run -d -p 8080:8080 --env JDBC_DATABASE_URL="jdbc:postgresql://host.docker.internal/postgres?user=postgres&password=postgres" tictac:1
@SpringBootApplication
class TicTacToeApp {

	@Bean
	fun jdbi() : Jdbi {
		val jdbcDatabaseURL =
			System.getenv("JDBC_DATABASE_URL")
				?: "jdbc:postgresql://localhost/postgres?user=postgres&password=postgres"
		val dataSource = PGSimpleDataSource()
		dataSource.setURL(jdbcDatabaseURL)

		return Jdbi.create(dataSource)
			.installPlugin(KotlinPlugin())
			.registerColumnMapper(BoardMapper())
	}
}

fun main(args: Array<String>) {
	runApplication<TicTacToeApp>(*args)
}
