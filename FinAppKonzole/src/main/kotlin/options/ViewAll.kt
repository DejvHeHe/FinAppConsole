package options

import bl.TransactionManager
import helpFunctions.checkDate

fun viewAll()
{
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim()
    val date=checkDate(input)
    println("Vaše transakce ${TransactionManager.getAll(date)}")
}