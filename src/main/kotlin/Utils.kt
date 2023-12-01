fun readInput(name: String) = object {}.javaClass.getResourceAsStream("$name.txt")!!.bufferedReader().readLines()
