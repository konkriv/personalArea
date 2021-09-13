package ru.personalarea

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PersonalAreaApplication

fun main(args: Array<String>) {
    runApplication<PersonalAreaApplication>(*args)
}
