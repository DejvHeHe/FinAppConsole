package options

import bl.transactionManager
import helpFunctions.checkDate

fun viewAll()
{
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim() // .trim() odstraní náhodné mezery
    val date=checkDate(input)
    println("Vaše transakce ${transactionManager.getAll(date)}")
}