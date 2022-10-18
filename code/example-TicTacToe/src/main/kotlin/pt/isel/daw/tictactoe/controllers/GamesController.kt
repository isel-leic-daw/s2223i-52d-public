package pt.isel.daw.tictactoe.controllers

import ProblemJsonModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pt.isel.daw.tictactoe.controllers.models.BoardOutputModel
import pt.isel.daw.tictactoe.controllers.models.GameOutputModel
import pt.isel.daw.tictactoe.controllers.models.GamePlayInputModel
import pt.isel.daw.tictactoe.controllers.models.GameStartInputModel
import pt.isel.daw.tictactoe.services.GamesService
import pt.isel.daw.tictactoe.services.exceptions.NotFoundException
import java.util.UUID

//TODO Errors and Refactor Code

@RestController
class GamesController (private val gameService : GamesService) {

   @ExceptionHandler (value = [NotFoundException::class] )
    fun exceptionHandler() = ResponseEntity
        .status(404)
        .contentType(ProblemJsonModel.MEDIA_TYPE)
        .body(ProblemJsonModel("https://example.org/problems/not-found", "GameNotFound"))

    @GetMapping(PathTemplate.GAME_BY_ID)
    fun getGame(@PathVariable id : UUID) :GameOutputModel{
        val game = gameService.getById(id)
        return GameOutputModel(game.id, BoardOutputModel(game.board.toString()), game.playerX, game.playerO)
    }

    @PostMapping(PathTemplate.PLAY)
    fun play(@PathVariable id : UUID, @RequestBody p : GamePlayInputModel) : GameOutputModel {
        val game = gameService.play(id, p.userId, p.l, p.c)
        return GameOutputModel(game.id, BoardOutputModel(game.board.toString()), game.playerX, game.playerO)
    }

    @PostMapping(PathTemplate.START)
    fun startGame(@RequestBody s : GameStartInputModel){
        val game = gameService.start(s.userIdX,s.userIdO)
        val gameOutModel = GameOutputModel(game.id, BoardOutputModel(game.board.toString()), game.playerX, game.playerO)
        ResponseEntity.status(201).body(gameOutModel)
    }


}