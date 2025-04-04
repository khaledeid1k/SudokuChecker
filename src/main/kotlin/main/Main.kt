package main

import test.checkResult

fun main() {
    checkResult(
        caseName = "when no repeated number at row and at column should return true",
        actualResult = checkSudokuValidation(
            listOf(
                listOf("1", "2", "3"),
                listOf("3", "1", "2"),
                listOf("2", "3", "1")
            )
        ),
        expectedResult = true
    )
    checkResult(
        caseName = "when no repeated number at row and at column 4*4 should return true",
        actualResult = checkSudokuValidation(
            listOf(
                listOf("1", "2", "3","4"),
                listOf("3", "1", "4","2"),
                listOf("4", "3", "2","1"),
                listOf("2", "4", "1","3"),
            )
        ),
        expectedResult = true
    )
    checkResult(
        caseName = "when no repeated number at row and at column 5x5 should return true",
        actualResult = checkSudokuValidation(
            listOf(
                listOf("1", "2", "3", "4", "5"),
                listOf("2", "3", "4", "5", "1"),
                listOf("3", "4", "5", "1", "2"),
                listOf("4", "5", "1", "2", "3"),
                listOf("5", "1", "2", "3", "4")
            )
        ),
        expectedResult = true
    )

    checkResult(
        caseName = "when no repeated number at row and at column 9x9 should return true",
        actualResult = checkSudokuValidation(
            listOf(
                listOf("1", "2", "3", "4", "5", "6", "7", "8", "9"),
                listOf("2", "3", "4", "5", "6", "7", "8", "9", "1"),
                listOf("3", "4", "5", "6", "7", "8", "9", "1", "2"),
                listOf("4", "5", "6", "7", "8", "9", "1", "2", "3"),
                listOf("5", "6", "7", "8", "9", "1", "2", "3", "4"),
                listOf("6", "7", "8", "9", "1", "2", "3", "4", "5"),
                listOf("7", "8", "9", "1", "2", "3", "4", "5", "6"),
                listOf("8", "9", "1", "2", "3", "4", "5", "6", "7"),
                listOf("9", "1", "2", "3", "4", "5", "6", "7", "8")
            )
        ),
        expectedResult = true
    )




    checkResult(
        caseName = "when repeated number at row or at column should return false",
        actualResult = checkSudokuValidation(
            listOf(
                listOf("1", "1", "3"),
                listOf("3", "2", "1"),
                listOf("2", "3", "1")
            )
        ),
        expectedResult = false
    )

    checkResult(
        caseName = "When any symbol except '-' is passed should return false.",
        actualResult = checkSudokuValidation(
            listOf(
                listOf("5", "/", "-"),
                listOf("3", "1", "2"),
                listOf("2", "3", "1")
            )
        ),
        expectedResult = false
    )
    checkResult(
        caseName = "when pass alphabetical char should return false",
        actualResult = checkSudokuValidation(
            listOf(
                listOf("5", "e", "-"),
                listOf("3", "1", "2"),
                listOf("2", "3", "1")
            )
        ),
        expectedResult = false
    )
    checkResult(
        caseName = "when pass space should return false",
        actualResult = checkSudokuValidation(
            listOf(
                listOf("5", " ", "-"),
                listOf("3", "1", "2"),
                listOf("2", "3", "1")
            )
        ),
        expectedResult = false
    )
    checkResult(
        caseName = "when grid contains numbers outside the range should return false", // write range at use case
        actualResult = checkSudokuValidation(
            listOf(
                listOf("1", "1", "4"),
                listOf("3", "2", "1"),
                listOf("2", "3", "1")
            )
        ),
        expectedResult = false
    )
    checkResult(
        caseName = "when board is empty list should return false",
        actualResult = checkSudokuValidation(
            listOf(
                listOf("-", "-", "-"),
                listOf("-", "-", "-"),
                listOf("-", "-", "-"),
            )
        ),
        expectedResult = false
    )
    checkResult(
        caseName = "when grid contains negative numbers should return false",
        actualResult = checkSudokuValidation(
            listOf(
                listOf("1", "-1", "4"),
                listOf("3", "2", "1"),
                listOf("2", "3", "1")
            )
        ),
        expectedResult = false
    )



}