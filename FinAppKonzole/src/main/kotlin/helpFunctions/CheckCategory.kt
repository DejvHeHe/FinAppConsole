package helpFunctions

import models.TransactionCategory

fun checkCategory(): TransactionCategory
{
    var category: TransactionCategory? = null
    while (category == null) {
        print("Zadejte kategorii transakce: ")
        val input = readln().uppercase().trim()
        try {
            category = TransactionCategory.valueOf(input)
        } catch (e: Exception) {
            println("Chyba: Kategorie '$input' neexistuje. Zkuste to znovu.")
        }
    }
    return category
}