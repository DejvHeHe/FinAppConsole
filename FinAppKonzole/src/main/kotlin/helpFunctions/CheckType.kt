package helpFunctions

import models.TransactionType

fun checkType(): TransactionType
{
    var type: TransactionType? = null
    while (type == null) {
        print("Zadejte typ transakce (INCOME/EXPENSE): ")
        val input = readln().uppercase().trim()
        try {
            type = TransactionType.valueOf(input)

        } catch (e: Exception) {
            println("Chyba: Typ '$input' neexistuje. Zkuste to znovu.")
        }
    }
    return type


}