import shapes2d.*

fun main() {
    val white = Color(1f, 1f, 1f, 1f)
    val black = Color(0f, 0f, 0f, 1f)

    val disk1 = Disk(1337.0, white, black)
    val disk2 = Disk(2448.0, white, black)


    val serializer = JSONSerializer()
    val fileSaver = FileSaver()

    val deserializedCollector = serializer.deserialize<ShapeCollector>(fileSaver.readFile("collector.txt"))

    deserializedCollector.add(disk1)
    deserializedCollector.add(disk2)

    fileSaver.save(serializer.serialize(deserializedCollector), "collectorOut.txt")

}