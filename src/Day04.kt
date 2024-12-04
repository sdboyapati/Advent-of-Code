fun main() {
    var n = false
    var s = false
    var e = false
    var w = false
    var ne = false
    var se = false
    var sw = false
    var nw = false


    fun setDirectionsPart1(pos: Pair<Int, Int>, matrix: Pair<Int, Int>) {
        if (pos.first - 3 >= 0) n = true
        if (pos.second + 3 <= matrix.second) e = true
        if (pos.second - 3 >= 0) w = true
        if (pos.first + 3 <= matrix.first) s = true
        if (n && e) ne = true
        if (n && w) nw = true
        if (s && e) se = true
        if (s && w) sw = true
    }

    fun resetDirections() {
        n = false
        s = false
        e = false
        w = false
        ne = false
        se = false
        sw = false
        nw = false
    }

    fun part1(input: List<String>): Int {
        val breadth = input.lastIndex
        val length = input.first().length - 1

        var result = 0
        for (b in 0..breadth) {
            for (l in 0..length) {
                resetDirections()
                val pos = Pair(b, l)
                setDirectionsPart1(pos, Pair(breadth, length))
                if (n) {
                    if (input[pos.first][pos.second] == 'X') {
                        if (input[pos.first - 1][pos.second] == 'M') {
                            if (input[pos.first - 2][pos.second] == 'A') {
                                if (input[pos.first - 3][pos.second] == 'S') {
                                    result += 1
                                }
                            }
                        }
                    }
                }

                if (s) {
                    if (input[pos.first][pos.second] == 'X') {
                        if (input[pos.first + 1][pos.second] == 'M') {
                            if (input[pos.first + 2][pos.second] == 'A') {
                                if (input[pos.first + 3][pos.second] == 'S') {
                                    result += 1
                                }
                            }
                        }
                    }
                }

                if (e) {
                    if (input[pos.first][pos.second] == 'X') {
                        if (input[pos.first][pos.second + 1] == 'M') {
                            if (input[pos.first][pos.second + 2] == 'A') {
                                if (input[pos.first][pos.second + 3] == 'S') {
                                    result += 1
                                }
                            }
                        }
                    }
                }

                if (w) {
                    if (input[pos.first][pos.second] == 'X') {
                        if (input[pos.first][pos.second - 1] == 'M') {
                            if (input[pos.first][pos.second - 2] == 'A') {
                                if (input[pos.first][pos.second - 3] == 'S') {
                                    result += 1
                                }
                            }
                        }
                    }
                }

                if (ne) {
                    if (input[pos.first][pos.second] == 'X') {
                        if (input[pos.first - 1][pos.second + 1] == 'M') {
                            if (input[pos.first - 2][pos.second + 2] == 'A') {
                                if (input[pos.first - 3][pos.second + 3] == 'S') {
                                    result += 1
                                }
                            }
                        }
                    }
                }

                if (nw) {
                    if (input[pos.first][pos.second] == 'X') {
                        if (input[pos.first - 1][pos.second - 1] == 'M') {
                            if (input[pos.first - 2][pos.second - 2] == 'A') {
                                if (input[pos.first - 3][pos.second - 3] == 'S') {
                                    result += 1
                                }
                            }
                        }
                    }
                }

                if (se) {
                    if (input[pos.first][pos.second] == 'X') {
                        if (input[pos.first + 1][pos.second + 1] == 'M') {
                            if (input[pos.first + 2][pos.second + 2] == 'A') {
                                if (input[pos.first + 3][pos.second + 3] == 'S') {
                                    result += 1
                                }
                            }
                        }
                    }
                }

                if (sw) {
                    if (input[pos.first][pos.second] == 'X') {
                        if (input[pos.first + 1][pos.second - 1] == 'M') {
                            if (input[pos.first + 2][pos.second - 2] == 'A') {
                                if (input[pos.first + 3][pos.second - 3] == 'S') {
                                    result += 1
                                }
                            }
                        }
                    }
                }
            }
        }
        return result
    }


    fun setDirectionsPart2(pos: Pair<Int, Int>, matrix: Pair<Int, Int>) {
        if (pos.first - 1 >= 0 && pos.second - 1 >= 0) nw = true
        if (pos.first - 1 >= 0 && pos.second + 1 <= matrix.second) ne = true
        if (pos.first + 1 <= matrix.first && pos.second + 1 <= matrix.second) se = true
        if (pos.first + 1 <= matrix.first && pos.second - 1 >= 0) sw = true
    }

    fun part2(input: List<String>): Int {
        var result = 0
        for (b in 0..input.lastIndex) {
            for (l in 0..<input.first().length) {
                resetDirections()
                val pos = Pair(b, l)
                setDirectionsPart2(pos, Pair(input.lastIndex, input.first().length-1))
                if (ne && nw && se && sw) {
                    val nwLetter = input[pos.first - 1][pos.second - 1]
                    val neLetter = input[pos.first - 1][pos.second + 1]
                    val swLetter = input[pos.first + 1][pos.second - 1]
                    val seLetter = input[pos.first + 1][pos.second + 1]
                    if (input[pos.first][pos.second] == 'A') {
                        if ((swLetter == 'M' && neLetter == 'S') || (swLetter == 'S' && neLetter == 'M')) {
                            if ((seLetter == 'M' && nwLetter == 'S') || (seLetter == 'S' && nwLetter == 'M')) {
                                result += 1
                            }
                        }
                    }
                }
            }
        }
        return result
    }

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}