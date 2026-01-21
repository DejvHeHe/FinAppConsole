package options

import bl.TransactionManager
import helpFunctions.checkLocalDate
import helpFunctions.readEnum
import models.Transaction
import models.TransactionCategory
import java.time.LocalDate
import java.util.UUID
import java.time.temporal.ChronoUnit

fun createWithRecurrence() {
    print("Zadejte název: ")
    val name = readln()
    val category = readEnum<TransactionCategory>("Zadejte kategorii:")!!
    val type = category.type
    print("Zadejte částku: ")
    val amount = readln().toIntOrNull() ?: 0
    print("Zadejte popisek:")
    val description = readln()

    val startDate = checkLocalDate("Zadejte datum (Enter pro dnešek): ", LocalDate.now())!!
    val lastDate = checkLocalDate("Zadejte datum konce opakování (Enter pro jednorázovou): ")

    val monthsToCreate = if (lastDate != null) {
        if (lastDate.isBefore(startDate)) {
            println("Chyba: Konec je před začátkem.")
            return
        }
        ChronoUnit.MONTHS.between(startDate.withDayOfMonth(1), lastDate.withDayOfMonth(1))
    } else 0L

    for (i in 0..monthsToCreate) {
        val date = startDate.plusMonths(i)
        try {
            TransactionManager.create(Transaction(
                id = UUID.randomUUID(),
                name = name,
                amount = amount,
                type = type,
                category = category,
                date = date,
                description = description
            ))
            println("Uloženo pro datum $date")
        } catch (e: IllegalArgumentException) {
            println("Chyba: ${e.message}")
            break
        }
    }
}