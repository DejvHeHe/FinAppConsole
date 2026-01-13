package Options

import BL.TransactionManager
import checkDate

fun ViewAll()
{
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim() // .trim() odstraní náhodné mezery
    var date=checkDate(input)
    println("Vaše transakce ${TransactionManager.getAll(date)}")
}