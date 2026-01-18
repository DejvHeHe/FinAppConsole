package Options

import BL.transactionManager
import Models.transaction
import Models.transactionCategory
import Models.transactionType
import java.time.LocalDate
import java.util.UUID
import java.time.temporal.ChronoUnit

fun createReacuring() {
    print("Zadejte název transakce: ")
    val name = readln()

    var type: transactionType? = null
    while (type == null) {
        print("Zadejte typ transakce (INCOME/EXPENSE): ")
        val input = readln().uppercase().trim()
        try {
            type = transactionType.valueOf(input)
        } catch (e: Exception) {
            println("Chyba: Typ '$input' neexistuje. Zkuste to znovu.")
        }
    }

    var category: transactionCategory? = null
    while (category == null) {
        print("Zadejte kategorii transakce: ")
        val input = readln().uppercase().trim()
        try {
            category = transactionCategory.valueOf(input)
        } catch (e: Exception) {
            println("Chyba: Kategorie '$input' neexistuje. Zkuste to znovu.")
        }
    }

    print("Zadejte částku transakce: ")
    val amount = readln().toIntOrNull() ?: 0

    val startDate = readDate("Zadejte startovní datum (YYYY-MM-DD) nebo Enter pro dnešek: ", LocalDate.now())

    val lastDate = readDate("Zadejte datum, do kdy se má opakovat (YYYY-MM-DD): ")
    if (lastDate.isBefore(startDate)) {
        println("Chyba: Koncové datum nemůže být dříve než startovní!")
        return
    }

    val monthsBetween = ChronoUnit.MONTHS.between(
        startDate.withDayOfMonth(1),
        lastDate.withDayOfMonth(1)
    )

    print("Zadejte popis:")
    val description = readln()

    for (i in 0..monthsBetween) {
        val id = UUID.randomUUID()
        val date = startDate.plusMonths(i.toLong())

        val newRecord = transaction(
            id = id,
            name = name,
            amount = amount,
            type = type,       // Opraveno na lokální proměnnou
            category = category, // Opraveno na lokální proměnnou
            date = date,
            description = description
        )

        transactionManager.create(newRecord)
        println("Transakce '$name' pro datum $date byla úspěšně vytvořena.")
    }
}

fun readDate(prompt: String, default: LocalDate? = null): LocalDate {
    while (true) {
        print(prompt)
        val input = readln().trim()

        if (input.isEmpty() && default != null) {
            return default
        }

        try {
            return LocalDate.parse(input)
        } catch (e: Exception) {
            println("Chyba: Špatný formát data (použijte YYYY-MM-DD).")
        }
    }
}