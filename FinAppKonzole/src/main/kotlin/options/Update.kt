package options

import bl.transactionManager
import models.transactionCategory
import models.transactionType
import java.time.LocalDate
import java.util.UUID

fun update() {
    var name: String? = null
    var date: LocalDate? = null
    var category: transactionCategory? = null
    var type: transactionType? = null
    var amount: Int? = null
    var description: String? = null
    var id: UUID? = null

    while (id == null) {
        try {
            print("Zadejte id: ")
            var input = readln().trim()
            if (input.isEmpty()) {
                println("ID nesmí být prázdné!")
                continue
            }
            id = UUID.fromString(input)

            print("Zadejte nové jméno: ")
            name = readln().trim().ifEmpty { null }

            print("Zadejte nový typ (INCOME/EXPENSE): ")
            input = readln().uppercase().trim()
            if (input.isNotEmpty()) {
                try {
                    type = transactionType.valueOf(input)
                } catch (e: Exception) {
                    println("Neplatný typ, hodnota nebude změněna.")
                }
            }

            print("Zadejte novou kategorii: ")
            input = readln().uppercase().trim()
            if (input.isNotEmpty()) {
                try {
                    category = transactionCategory.valueOf(input)
                } catch (e: Exception) {
                    println("Neplatná kategorie, hodnota nebude změněna.")
                }
            }

            print("Zadejte novou hodnotu: ")
            amount = readln().toIntOrNull()

            print("Zadejte nové datum (YYYY-MM-DD): ")
            input = readln().trim()
            if (input.isNotEmpty()) {
                try {
                    date = LocalDate.parse(input)
                } catch (e: Exception) {
                    println("Neplatný formát data, hodnota nebude změněna.")
                }
            }

            print("Zadejte nový popisek: ")
            description = readln().trim().ifEmpty { null }

            try{
                val result = transactionManager.update(
                    id = id,
                    name = name,
                    type = type,
                    category = category,
                    amount = amount,
                    date = date,
                    description = description
                )

                println("Proběhnul update: $result")

            }
            catch(e: IllegalArgumentException)
            {
                println("Chyba:${e.message}")
            }


        } catch (e: Exception) {
            println("Nastala chyba: ${e.message}")
            id = null
        }
    }
}