package main

fun checkSudokuValidation(sudokuNumbers: List<List<String>>): Boolean {
    val validChars = mutableListOf("-")
    for (i in 1..sudokuNumbers.size) {
        validChars.add(i.toString())
    }
    if (sudokuNumbers.any { row -> row.any { it !in validChars } }) return false
    for (row in sudokuNumbers) {
        if (!isValidUnit(row)) return false
    }
    for (col in sudokuNumbers.indices) {
        val column = mutableListOf<String>()
        for (element in sudokuNumbers) {
            column.add(element[col])
        }
        if (!isValidUnit(column)) return false
        column.clear()

    }

    for (rowStart in sudokuNumbers.indices step 3) {
        println(rowStart)
        for (colStart in sudokuNumbers.indices step 3) {
            val subGrid = mutableListOf<String>()
            for (r in 0 until 3) {
                for (c in 0 until 3) {
                    subGrid.add(sudokuNumbers[rowStart + r][colStart + c])
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

