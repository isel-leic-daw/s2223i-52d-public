package pt.isel.daw.tictactoe.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.tictactoe.controllers.models.BoardOutputModel
import pt.isel.daw.tictactoe.controllers.models.GameOutputModel
import pt.isel.daw.tictactoe.controllers.models.GamePlayInputModel
import pt.isel.daw.tictactoe.controllers.models.GameStartInputModel
import pt.isel.daw.tictactoe.services.GamesService
import java.util.UUID

//TODO Errors and Refactor Code

@RestController
class GamesController (private val gameService : GamesService) {

    @GetMapping(PathTemplate.gameById)
    fun getGame(@PathVariable id : UUID) :GameOutputModel{
        val game = gameService.getById(id)
        return GameOutputModel(game.id, BoardOutputModel(game.board.toString()), game.playerX, game.playerO)
    }

    @PostMapping(PathTemplate.play)
    fun play(@PathVariable id : UUID, @RequestBody p : GamePlayInputModel) : GameOutputModel {
        val game = gameService.play(id, p.userId, p.l, p.c)
        return GameOutputModel(game.id, BoardOutputModel(game.board.toString()), game.playerX, game.playerO)
    }

    @PostMapping(PathTemplate.start)
    fun startGame(@RequestBody s : GameStartInputModel){
        val game = gameService.start(s.userIdX,s.userIdO)
        val gameOutModel = GameOutputModel(game.id, BoardOutputModel(game.board.toString()), game.playerX, game.playerO)
        ResponseEntity.status(201).body(gameOutModel)
    }


}