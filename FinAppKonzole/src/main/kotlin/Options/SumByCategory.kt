package Options

import BL.TransactionManager
import Models.TransactionCategory
import checkDate

fun SumByCategory() {
    print("Zadejte název categorie:")
    var category=readln().uppercase()
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim()
    var date=checkDate(input)
    println("Suma dané kategorie je:${TransactionManager.sumByCategory(TransactionCategory.valueOf(category),date)}")

}