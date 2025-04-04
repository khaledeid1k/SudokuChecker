package main

fun checkSudokuValidation(sudokuNumbers: List<List<String>>): Boolean {

    return checkSudokuRules(sudokuNumbers)
}



fun checkSudokuRules(grid: List<List<String>>): Boolean {
    val validChars = listOf("-","1", "2", "3")
    if (grid.any { row -> row.any { it !in validChars } }) return false
    for (row in grid) {
        if (!isValidUnit(row)) return false
    }
    for (col in 0..2) {
        val column = listOf(grid[0][col], grid[1][col], grid[2][col])
        if (!isValidUnit(column)) return false
    }

    return true
}

fun isValidUnit(unit: List<String>): Boolean {
    val seen = mutableSetOf<String>()
    return unit.all { it !in seen && seen.add(it) }
}

