package main

fun checkSudokuValidation(sudokuNumbers: List<List<String>>): Boolean {
    val validChars = generateValidChars(sudokuNumbers.size)

    if (!containsOnlyValidChars(sudokuNumbers, validChars)) return false
    if (!rowsAreValid(sudokuNumbers)) return false
    if (!columnsAreValid(sudokuNumbers)) return false
    if (!subGridsAreValid(sudokuNumbers)) return false

    return true
}

fun generateValidChars(size: Int): List<String> {
    val validChars = mutableListOf("-")
    for (i in 1..size) {
        validChars.add(i.toString())
    }
    return validChars
}

fun containsOnlyValidChars(sudoku: List<List<String>>, validChars: List<String>): Boolean {
    return sudoku.all { row -> row.all { it in validChars } }
}

fun rowsAreValid(sudoku: List<List<String>>): Boolean {
    return sudoku.all { isValidUnit(it) }
}

fun columnsAreValid(sudoku: List<List<String>>): Boolean {
    for (col in sudoku.indices) {
        val column = mutableListOf<String>()
        for (row in sudoku) {
            column.add(row[col])
        }
        if (!isValidUnit(column)) return false
    }
    return true
}

fun subGridsAreValid(sudoku: List<List<String>>): Boolean {
    for (rowStart in sudoku.indices step 3) {
        for (colStart in sudoku.indices step 3) {
            val subGrid = mutableListOf<String>()
            for (r in 0 until 3) {
                for (c in 0 until 3) {
                    subGrid.add(sudoku[rowStart + r][colStart + c])
                }
            }
            if (!isValidUnit(subGrid)) return false
        }
    }
    return true
}

fun isValidUnit(unit: List<String>): Boolean {
    val seen = mutableSetOf<String>()
    return unit.all { it !in seen && seen.add(it) }
}

