package utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun toLocalDateTime(dateTime: String) : LocalDateTime{
    val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
    return LocalDateTime.parse(formatter.toString())
}