fun main() {

    val mulRegex = "mul\\(\\d{1,3},\\d{1,3}\\)".toRegex()
    val mulAndConditionRegex = "d(o|on't)\\(\\)|mul\\(\\d{1,3},\\d{1,3}\\)".toRegex()
    fun part1(input: List<String>): Int {
        var result = 0
        input.forEach { line ->
            val validMuls: Sequence<String> = mulRegex.findAll(line).map { it.value }
            result += validMuls.sumOf {
                val (a, b) = it.removeSurrounding("mul(", ")").split(",")
                a.toInt() * b.toInt()
            }
        }
        return result
    }

    fun part2(input: List<String>): Long {
        val mulAndConditions: MutableList<String> = mutableListOf()
        var proceed = true
        var result = 0L
        input.forEach { line ->
            mulAndConditionRegex.findAll(line).forEach { mulAndConditions.add(it.value) }
        }
        mulAndConditions.forEach { operation ->
            when(operation){
                "do()" -> proceed = true
                "don't()" -> proceed = false
                else -> {
                    if(proceed){
                        val (a,b) = operation.removeSurrounding("mul(", ")").split(",")
                        result += a.toLong() * b.toLong()
                    }
                }
            }
        }
        return result
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}