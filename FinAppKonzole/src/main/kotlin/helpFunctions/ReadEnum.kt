package helpFunctions



inline fun <reified T : Enum<T>> readEnum(prompt:String,canBeNull: Boolean=false):T? {
    while(true)
    {
        print(prompt)
        val input = readln().uppercase().trim()
        if (input.isEmpty()) {
            if (canBeNull) return null
            else {
                println("Chyba: Toto pole je povinné.")
                continue
            }
        }
        try {

            return enumValueOf<T>(input)
        } catch (e: Exception) {
            println("Chyba:${e.message} ")
        }
    }

}