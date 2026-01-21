package helpFunctions

//Potřeba upravit pro update

inline fun <reified T : Enum<T>> readEnum(prompt:String):T {
    while(true)
    {
        print(prompt)
        val input = readln().uppercase().trim()
        try {
            val output=enumValueOf<T>(input)
            return output
        } catch (e: Exception) {
            println("Chyba:${e.message} ")
        }
    }

}