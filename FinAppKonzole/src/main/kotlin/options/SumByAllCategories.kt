package options

import bl.TransactionManager
import helpFunctions.checkDate

fun sumByAllCategories(){
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim()
    val date=checkDate(input)
    println("Sumy podle kategorii:${TransactionManager.sumAllCategories(date)}")
}