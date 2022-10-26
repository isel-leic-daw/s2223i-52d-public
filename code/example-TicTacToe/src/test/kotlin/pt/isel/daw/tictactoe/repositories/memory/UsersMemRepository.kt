package pt.isel.daw.tictactoe.repositories.memory

import pt.isel.daw.tictactoe.domain.User
import pt.isel.daw.tictactoe.repositories.UsersRepository

//Todo memory implementation

class UsersMemRepository : UsersRepository {

    override fun getById(id : Int) : User? = User(1,"filipe")
    override fun insert(name: String) {
        TODO("Not yet implemented")
    }

}
