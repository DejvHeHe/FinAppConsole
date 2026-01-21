package helpFunctions

import java.time.LocalDate

fun checkLocalDate(prompt: String, default: LocalDate? = null): LocalDate? {
    while (true) {
        print(prompt)
        val input = readln().trim()

        if (input.isEmpty() && default != null) {
            return default
        }
        else if(input.isEmpty()&& default == null)
        {
            return null
        }

        try {
            return LocalDate.parse(input)
        } catch (_: Exception) {
            println("Chyba: Špatný formát data (použijte YYYY-MM-DD).")
        }
    }
}