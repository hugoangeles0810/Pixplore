package io.github.hugoangeles0810.pixplore.data.mappers

import java.time.LocalDate
import java.time.Period

class DateFormatter(
    private val now: () -> LocalDate = { LocalDate.now() }
)  {

    fun relativeFormat(from: LocalDate, to: LocalDate = now()): String {
        val period = Period.between(from, to)
        val years = period.years
        val months = period.months
        val days = period.days

        return when {
            years > 0 -> {
                "$years year${"s".takeUnless { years == 1 }.orEmpty()} ago"
            }
            months > 0 -> {
                "$months month${"s".takeUnless { months == 1 }.orEmpty()} ago"
            }
            else -> {
                "$days day${"s".takeUnless { days == 1 }.orEmpty()} ago"
            }
        }
    }
}