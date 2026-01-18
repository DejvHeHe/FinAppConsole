package Options

import BL.transactionManager
import Models.transactionCategory
import checkDate

fun sumByCategory() {
    print("Zadejte název categorie:")
    var category=readln().uppercase()
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim()
    var date=checkDate(input)
    println("Suma dané kategorie je:${transactionManager.sumByCategory(transactionCategory.valueOf(category),date)}")

}