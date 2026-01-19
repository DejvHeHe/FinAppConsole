package options

import bl.transactionManager
import models.transaction
import models.transactionCategory
import models.transactionType
import java.time.LocalDate
import java.util.UUID

fun create() {
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

    var date: LocalDate? = null
    while (date == null) {
        print("Zadejte datum ve formátu (YYYY-MM-DD) nebo Enter pro dnešek: ")
        val input = readln().trim()

        if (input.isEmpty()) {
            date = LocalDate.now()
        } else {
            try {
                date = LocalDate.parse(input)
            } catch (e: Exception) {
                println("Chyba: Špatný formát data. Zkuste to znovu.")
            }
        }
    }

    print("Zadejte popis:")
    val description = readln()

    val id = UUID.randomUUID()

    val newRecord = transaction(
        id = id,
        name = name,
        amount = amount,
        type = type,
        category = category,
        date = date,
        description = description
    )

    try{
        transactionManager.create(newRecord)

    }
    catch(e: IllegalArgumentException)
    {
        println("Chyba:${e.message}")
    }

    println("Transakce '$name' byla úspěšně vytvořena.")
}