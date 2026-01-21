package options

import bl.TransactionManager

import helpFunctions.checkDate
import helpFunctions.readEnum
import models.TransactionType

fun sumByTypes() {

    val type = readEnum<TransactionType>("Zadejte typ(EXPENSE/INCOME):")
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim()
    val date=checkDate(input)
    println("Suma podle typu:${TransactionManager.sumByType(type,date)}")
}