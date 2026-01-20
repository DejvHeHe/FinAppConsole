package helpFunctions


import java.util.UUID

fun checkId(): UUID {
    var id: UUID? = null
    while (id == null) {
        println("Zadejte id:")
        try {
            id = UUID.fromString(readln())
            if (id == null) {
                print("id nesmí být prazdné")
            }


        } catch (e: Exception) {
            print("Nastala chyba:${e.message}")
        }
    }
    return id
}