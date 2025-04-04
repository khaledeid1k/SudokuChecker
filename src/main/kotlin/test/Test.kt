package test

fun checkResult(caseName: String, actualResult: Boolean, expectedResult: Boolean) {
    println(if (actualResult == expectedResult) "Successful -> $caseName" else "Failed -> $caseName" )
}