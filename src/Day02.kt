import kotlin.math.absoluteValue

fun main() {

    fun isSafe(report: List<Int>): Boolean {
        var isIncreasing = false
        var isDecreasing = false

        for (i in 0..<report.lastIndex) {
            val diff = report[i] - report[i + 1]
            if (diff.absoluteValue > 3 || diff == 0) return false
            if (diff < 0) isDecreasing = true
            else
                isIncreasing = true
        }
        return isIncreasing xor isDecreasing
    }


    /*fun isSafe(report: List<Int>): Boolean {
        val differences = report.zipWithNext { a: Int, b: Int -> a - b }
        return differences.all {
            it in -3..3 &&
                    (differences.all { it > 0 } || differences.all { it < 0 })
        }
    }*/


    fun part1(input: List<String>): Int {
        var result = 0
        input.forEach { line ->
            val report = line.split(" ").map { it.toInt() }
            result += if (isSafe(report)) 1 else 0
        }
        return result
    }


    fun isSafePart2(report: List<Int>): Int {
        if (isSafe(report)) return 1
        for (i in 0..report.lastIndex) {
            val modifiedReport = report.toMutableList()
            val mole = modifiedReport.removeAt(i)
            if (isSafe(modifiedReport)) return 1
            modifiedReport.add(i, mole)
        }
        return 0
    }

    fun part2(input: List<String>): Int {
        var result = 0
        input.forEach { line ->
            val report = line.split(" ").map { it.toInt() }
            result += isSafePart2(report)
        }
        return result
    }


    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}