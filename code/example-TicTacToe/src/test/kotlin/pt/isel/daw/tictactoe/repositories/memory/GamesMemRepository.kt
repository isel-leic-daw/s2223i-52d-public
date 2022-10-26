package pt.isel.daw.tictactoe.repositories.memory

import pt.isel.daw.tictactoe.domain.Game
import pt.isel.daw.tictactoe.repositories.GamesRepository
import java.util.UUID

//Todo memory implementation

class GamesMemRepository : GamesRepository {
    override fun getById(id: UUID): Game? {
        TODO("Not yet implemented")
    }

    override fun update(game: Game) {
        TODO("Not yet implemented")
    }

    override fun insert(game: Game) {
        TODO("Not yet implemented")
    }
}