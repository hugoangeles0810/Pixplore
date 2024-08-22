package io.github.hugoangeles0810.pixplore.data.mappers

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class DateFormatterTest {

    private lateinit var dateFormatter: DateFormatter

    @Before
    fun setUp() {
        dateFormatter = DateFormatter()
    }

    @Test
    fun `singular years ago`() {
        val from = LocalDate.ofYearDay(2000, 1)
        val to = LocalDate.ofYearDay(2001, 1)

        val result = dateFormatter.relativeFormat(from, to)

        assertEquals("1 year ago", result)
    }

    @Test
    fun `plural years ago`() {
        val from = LocalDate.ofYearDay(2000, 1)
        val to = LocalDate.ofYearDay(2005, 1)

        val result = dateFormatter.relativeFormat(from, to)

        assertEquals("5 years ago", result)
    }

    @Test
    fun `singular months ago`() {
        val from = LocalDate.ofYearDay(2000, 1)
        val to = LocalDate.ofYearDay(2000, 32)

        val result = dateFormatter.relativeFormat(from, to)

        assertEquals("1 month ago", result)
    }

    @Test
    fun `plural months ago`() {
        val from = LocalDate.ofYearDay(2000, 1)
        val to = LocalDate.ofYearDay(2000, 61)

        val result = dateFormatter.relativeFormat(from, to)

        assertEquals("2 months ago", result)
    }

    @Test
    fun `singular days ago`() {
        val from = LocalDate.ofYearDay(2000, 1)
        val to = LocalDate.ofYearDay(2000, 2)

        val result = dateFormatter.relativeFormat(from, to)

        assertEquals("1 day ago", result)
    }

    @Test
    fun `plural days ago`() {
        val from = LocalDate.ofYearDay(2000, 1)
        val to = LocalDate.ofYearDay(2000, 5)

        val result = dateFormatter.relativeFormat(from, to)

        assertEquals("4 days ago", result)
    }
}