package pt.isel.daw.tictactow.controllers

import org.springframework.web.bind.annotation.*
import pt.isel.daw.tictactow.controllers.models.UserInputModel
import pt.isel.daw.tictactow.controllers.models.UserOutputModel
import pt.isel.daw.tictactow.services.UsersService

@RestController
class UsersController(private val usersService : UsersService) {

    @GetMapping(PathTemplate.userById)
    fun getById(@PathVariable id : Int) : UserOutputModel {
        val user = usersService.getById(id)
        return UserOutputModel(user.id,user.username)
    }

    @PostMapping(PathTemplate.createUser)
    fun insert(@RequestBody user : UserInputModel) {
        TODO("Not yet implemented")
    }

}