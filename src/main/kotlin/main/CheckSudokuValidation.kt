package main

fun checkSudokuValidation(sudokuNumbers: List<List<String>>): Boolean {
    val validChars = listOf("-","1", "2", "3")
    if (sudokuNumbers.any { row -> row.any { it !in validChars } }) return false
    for (row in sudokuNumbers) {
        if (!isValidUnit(row)) return false
    }
    for (col in 0..2) {
        val column = listOf(sudokuNumbers[0][col], sudokuNumbers[1][col], sudokuNumbers[2][col])
        if (!isValidUnit(column)) return false
    }
    return true
}

fun isValidUnit(unit: List<String>): Boolean {
    val seen = mutableSetOf<String>()
    return unit.all { it !in seen && seen.add(it) }
}

