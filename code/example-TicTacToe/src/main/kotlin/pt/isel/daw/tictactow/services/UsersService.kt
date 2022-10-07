package pt.isel.daw.tictactow.services

import org.springframework.stereotype.Component
import pt.isel.daw.tictactow.repositories.UsersRepository
import pt.isel.daw.tictactow.services.exceptions.NotFoundException

@Component
class UsersService(private val userRepository: UsersRepository) {

    fun getById(id : Int) = userRepository.getById(id)?:throw NotFoundException()
    fun insert(name : String) {
        TODO("Not yet implemented")
    }


}
