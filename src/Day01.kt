import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (left, right) = input.map { line ->
            val first = line.substringBefore(" ").toInt()
            val second = line.substringAfterLast(" ").toInt()
            first to second
        }.unzip()

        val result = left.sorted().zip(right.sorted()).sumOf { (a, b) ->
            abs(a - b)
        }
        return result
    }

    fun part2(input: List<String>): Long {
        val (left, right) = input.map { line ->
            val first = line.substringBefore(" ").toLong()
            val second = line.substringAfterLast(" ").toLong()
            first to second
        }.unzip()

        val frequencies: Map<Long, Int> = right.groupingBy { it }.eachCount()

        val result = left.sumOf { num ->
            frequencies.getOrDefault(num, 0) * num
        }

        return result
    }


    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
