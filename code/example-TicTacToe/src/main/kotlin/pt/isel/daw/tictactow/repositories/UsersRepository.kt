package pt.isel.daw.tictactow.repositories

import pt.isel.daw.tictactow.domain.User

interface UsersRepository {
    fun getById(id : Int) : User?
    fun insert(name : String)
}