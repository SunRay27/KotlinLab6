import java.io.File

class FileSaver {

    fun save(obj: String, filePath: String) {
        File(filePath).writeText(obj)
    }

    fun readFile(filePath: String): String {
        return File(filePath).readText()
    }

}