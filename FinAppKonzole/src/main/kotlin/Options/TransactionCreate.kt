package Options

import BL.TransactionManager
import Models.Transaction
import Models.TransactionCategory
import Models.TransactionType
import java.time.LocalDate
import java.util.UUID

fun TransactionCreate() {
    print("Zadejte název transakce: ")
    val transactionName = readln()


    var transactionType: TransactionType? = null
    while (transactionType == null) {
        print("Zadejte typ transakce (INCOME/EXPENSE): ")
        val input = readln().uppercase().trim()
        try {
            transactionType = TransactionType.valueOf(input)
        } catch (e: Exception) {
            println("Chyba: Typ '$input' neexistuje. Zkuste to znovu.")
        }
    }

    // BEZPEČNÝ VÝBĚR KATEGORIE
    var transactionCategory: TransactionCategory? = null
    while (transactionCategory == null) {
        print("Zadejte kategorii transakce: ")
        val input = readln().uppercase().trim()
        try {
            transactionCategory = TransactionCategory.valueOf(input)
        } catch (e: Exception) {
            println("Chyba: Kategorie '$input' neexistuje. Zkuste to znovu.")
        }
    }


    print("Zadejte částku transakce: ")
    val transactionAmount = readln().toIntOrNull() ?: 0


    var transactionDate: LocalDate? = null
    while (transactionDate == null) {
        print("Zadejte datum ve formátu (YYYY-MM-DD) nebo Enter pro dnešek: ")
        val input = readln().trim()

        if (input.isEmpty()) {
            transactionDate = LocalDate.now()
        } else {
            try {
                transactionDate = LocalDate.parse(input)
            } catch (e: Exception) {
                println("Chyba: Špatný formát data. Zkuste to znovu.")
            }
        }
    }
    print("Zadejte popis:")
    var transactionDescription=readln()
    val transactionId = UUID.randomUUID()

    val newRecord = Transaction(
        id=transactionId,
        name = transactionName,
        amount = transactionAmount,
        type = transactionType!!,
        category = transactionCategory!!,
        date = transactionDate!!,
        description = transactionDescription
    )

    TransactionManager.create(newRecord)
    println("Transakce '$transactionName' byla úspěšně vytvořena.")
}