package day05

class Mapper(maps : String, mapperKind: String) {
    private val kind : String
    private val destinationRangeStart : Long
    private val sourceRangeStart : Long
    val range : LongRange

    init {
        kind = mapperKind
        val (destination, source, offset) = maps
            .split(" ")
            .map{ it.toLong() }
        destinationRangeStart = destination
        sourceRangeStart = source
        range = sourceRangeStart..<(sourceRangeStart + offset)
    }

    fun appliesTo(value : Long) : Boolean {
        return range.contains(value)
    }

    fun map(value : Long) : Long {
        return if (appliesTo(value)) {
            value - sourceRangeStart + destinationRangeStart
        } else {
            value
        }
    }
}
