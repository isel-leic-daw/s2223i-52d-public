package pt.isel.daw.tictactow.repositories

import pt.isel.daw.tictactow.domain.Game
import java.util.*

interface GamesRepository {
    fun getById(id : UUID) : Game?
    fun update(game: Game)
    fun insert(game: Game)
}