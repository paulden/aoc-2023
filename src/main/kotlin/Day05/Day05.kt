package Day05

fun part1(input: List<String>): Long {
    var seeds = input
        .first()
        .split(": ")
        .last()
        .split(" ")
        .map { it.toLong() }
    var currentKind = ""
    val mappersByKind = mutableMapOf<String, List<Mapper>>()
        .withDefault { mutableListOf() }

    for (line in input.subList(2, input.size)) {
        if (line.isEmpty()) {
            continue
        } else if (line.first().isDigit()) {
            mappersByKind[currentKind] = mappersByKind.getValue(currentKind) + Mapper(line, currentKind)
        } else if (line.contains("map")) {
            currentKind = line.split(" ").first()
        }
    }

    return seeds
        .asSequence()
        .map { seed ->
            mappersByKind.getValue("seed-to-soil").filter { it.appliesTo(seed) }.map { it.map(seed) }
                .getOrElse(0) { seed }
        }
        .map { seed ->
            mappersByKind.getValue("soil-to-fertilizer").filter { it.appliesTo(seed) }.map { it.map(seed) }
                .getOrElse(0) { seed }
        }
        .map { seed ->
            mappersByKind.getValue("fertilizer-to-water").filter { it.appliesTo(seed) }.map { it.map(seed) }
                .getOrElse(0) { seed }
        }
        .map { seed ->
            mappersByKind.getValue("water-to-light").filter { it.appliesTo(seed) }.map { it.map(seed) }
                .getOrElse(0) { seed }
        }
        .map { seed ->
            mappersByKind.getValue("light-to-temperature").filter { it.appliesTo(seed) }.map { it.map(seed) }
                .getOrElse(0) { seed }
        }
        .map { seed ->
            mappersByKind.getValue("temperature-to-humidity").filter { it.appliesTo(seed) }.map { it.map(seed) }
                .getOrElse(0) { seed }
        }
        .map { seed ->
            mappersByKind.getValue("humidity-to-location").filter { it.appliesTo(seed) }.map { it.map(seed) }
                .getOrElse(0) { seed }
        }
        .toList()
        .min()
}

fun part2(input: List<String>): Long {
    var seeds = input
        .first()
        .split(": ")
        .last()
        .split(" ")
        .map { it.toLong() }
        .chunked(2)
        .map { it[0]..(it[0] + it[1]) }

    var currentKind = ""
    val mappersByKind = mutableMapOf<String, List<Mapper>>()
        .withDefault { mutableListOf() }

    for (line in input.subList(2, input.size)) {
        if (line.isEmpty()) {
            continue
        } else if (line.first().isDigit()) {
            mappersByKind[currentKind] = mappersByKind.getValue(currentKind) + Mapper(line, currentKind)
            mappersByKind[currentKind] = mappersByKind[currentKind]!!.sortedBy { it.range.first }
        } else if (line.contains("map")) {
            currentKind = line.split(" ").first()
        }
    }

    return seeds
        .asSequence()
        .map { mapRange(it, mappersByKind.getValue("seed-to-soil")) }
        .flatten()
        .map { mapRange(it, mappersByKind.getValue("soil-to-fertilizer")) }
        .flatten()
        .map { mapRange(it, mappersByKind.getValue("fertilizer-to-water")) }
        .flatten()
        .map { mapRange(it, mappersByKind.getValue("water-to-light")) }
        .flatten()
        .map { mapRange(it, mappersByKind.getValue("light-to-temperature")) }
        .flatten()
        .map { mapRange(it, mappersByKind.getValue("temperature-to-humidity")) }
        .flatten()
        .map { mapRange(it, mappersByKind.getValue("humidity-to-location")) }
        .flatten()
        .map { it.first }
        .toList()
        .min()
}

fun mapRange(range: LongRange, mappers: List<Mapper>): List<LongRange> {
    val nextRanges = mutableListOf<LongRange>()
    var startRange = range.first
    val endRange = range.last

    for (mapper in mappers) {
        if (mapper.range.last < startRange) {
            continue
        } else if (mapper.range.first > endRange) {
            break
        } else if (startRange < mapper.range.first && endRange <= mapper.range.last) {
            nextRanges.addLast(startRange..<mapper.range.first)
            nextRanges.addLast(mapper.map(mapper.range.first)..mapper.map(endRange))
            startRange = endRange
            break
        } else if (startRange >= mapper.range.first && endRange <= mapper.range.last) {
            nextRanges.addLast(mapper.map(startRange)..mapper.map(endRange))
            startRange = endRange
            break
        } else if (startRange >= mapper.range.first && endRange > mapper.range.last) {
            nextRanges.addLast(mapper.map(startRange)..mapper.map(mapper.range.last))
            startRange = mapper.range.last + 1
        }
    }
    if (startRange < endRange) {
        nextRanges.addLast(startRange..endRange)
    }
    return nextRanges
}
