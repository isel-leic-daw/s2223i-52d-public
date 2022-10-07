package pt.isel.daw.tictactow.services

import org.springframework.stereotype.Component
import pt.isel.daw.tictactow.domain.Board
import pt.isel.daw.tictactow.domain.Game
import pt.isel.daw.tictactow.domain.play
import pt.isel.daw.tictactow.repositories.GamesRepository
import pt.isel.daw.tictactow.services.exceptions.NotFoundException
import java.util.*

@Component
class GamesService(private val gameRepository: GamesRepository) {

    fun getById(id : UUID) = gameRepository.getById(id)?:throw NotFoundException()

    fun play(id : UUID, userId : Int, l : Int ,c : Int) :Game{
        val game = gameRepository.getById(id)?:throw NotFoundException()
        val updatedGame = play(game,userId, l, c)
        gameRepository.update(updatedGame)
        return updatedGame
    }

    fun start(userIdX : Int, userIdO : Int) :Game {
        val newGame = Game(
            UUID.randomUUID(),
            Board.create(),
            userIdX,
            userIdO
        )
        gameRepository.insert(newGame)
        return newGame
    }
}