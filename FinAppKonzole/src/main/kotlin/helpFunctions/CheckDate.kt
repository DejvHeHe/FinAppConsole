package helpFunctions

import java.time.YearMonth

fun checkDate(input: String): YearMonth
{

    val date = if (input.isEmpty()) {
        YearMonth.now()
    } else {
        try {
            YearMonth.parse(input)
        } catch (_: Exception) {
            println("Chyba: Špatný formát, nastavuji aktuální měsíc.")
            YearMonth.now()
        }
    }

    return date
}