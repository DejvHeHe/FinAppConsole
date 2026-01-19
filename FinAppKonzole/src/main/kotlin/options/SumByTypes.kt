package options

import bl.transactionManager
import models.transactionType
import helpFunctions.checkDate

fun sumByTypes() {
    print("Zadejte název typu:")
    val type=readln().uppercase()
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim()
    val date=checkDate(input)
    println("Suma podle typu:${transactionManager.sumByType(transactionType.valueOf(type),date)}")
}