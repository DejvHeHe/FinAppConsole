package options

import bl.TransactionManager

import helpFunctions.checkDate
import helpFunctions.checkType

fun sumByTypes() {

    val type= checkType()
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim()
    val date=checkDate(input)
    println("Suma podle typu:${TransactionManager.sumByType(type,date)}")
}