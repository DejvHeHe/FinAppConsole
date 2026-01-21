package options

import bl.TransactionManager
import helpFunctions.checkLocalDate
import helpFunctions.readEnum
import models.TransactionCategory
import java.time.LocalDate
import java.util.UUID

fun update() {

    var id: UUID? = null

    while (id == null) {
        try {
            print("Zadejte id: ")
            val input = readln().trim()
            if (input.isEmpty()) {
                println("ID nesmí být prázdné!")
                continue
            }
            id = UUID.fromString(input)

            print("Zadejte nové jméno: ")
           val name = readln().trim().ifEmpty { null }


            val category = readEnum<TransactionCategory>("Zadejte kategorii:",true)!!
            val type = category.type

            print("Zadejte novou hodnotu: ")
           val amount = readln().toIntOrNull()

            val date= checkLocalDate("Zadejte datum ve formatu YYYY-MM-DD . nebo Enter pro dnešek:", LocalDate.now())

            print("Zadejte nový popisek: ")
            val description = readln().trim().ifEmpty { null }

            try{
                val result = TransactionManager.update(
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