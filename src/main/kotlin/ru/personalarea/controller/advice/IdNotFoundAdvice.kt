package ru.personalarea.controller.advice

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import ru.personalarea.controller.exception.IdNotFoundException

@ControllerAdvice
class IdNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(IdNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun idNotFoundHandler(exception: IdNotFoundException) = exception.message
}