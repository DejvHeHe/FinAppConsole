package options

import bl.transactionManager
import helpFunctions.checkDate

fun sumByAllCategories(){
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim()
    val date=checkDate(input)
    println("Sumy podle kategorii:${transactionManager.sumAllCategories(date)}")
}