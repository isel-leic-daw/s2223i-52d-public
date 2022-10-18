package pt.isel.daw.tictactoe.controllers

import ProblemJsonModel
import org.springframework.beans.TypeMismatchException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import pt.isel.daw.tictactoe.services.exceptions.NotFoundException


@ControllerAdvice
class ResponseExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler (value = [NotFoundException::class] )
    fun exceptionHandler() = ResponseEntity
        .status(404)
        .contentType(ProblemJsonModel.MEDIA_TYPE)
        .body(ProblemJsonModel("https://example.org/problems/not-found", "NotFound"))


    override fun handleTypeMismatch(
        ex: TypeMismatchException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest,
    ) : ResponseEntity<Any> {

        logger.info("Handling MethodArgumentNotValidException")
        return ResponseEntity
            .status(404)
            .contentType(ProblemJsonModel.MEDIA_TYPE)
            .body(ProblemJsonModel("https://example.org/problems/not-found", "NotFound"))
    }


}