package pt.isel.daw.tictactoe.controllers

import org.springframework.web.bind.annotation.*
import pt.isel.daw.tictactoe.controllers.models.UserInputModel
import pt.isel.daw.tictactoe.controllers.models.UserOutputModel
import pt.isel.daw.tictactoe.services.UsersService

@RestController
class UsersController(private val usersService : UsersService) {

    @GetMapping(PathTemplate.USER_BY_ID)
    fun getById(@PathVariable id : Int) : UserOutputModel {
        val user = usersService.getById(id)
        return UserOutputModel(user.id,user.username)
    }

    @PostMapping(PathTemplate.CREATE_USER)
    fun insert(@RequestBody user : UserInputModel) {
        TODO("Not yet implemented")
    }

}