package Options

import BL.transactionManager
import checkDate

fun viewBalance(){
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim() // .trim() odstraní náhodné mezery
    var date=checkDate(input)
    println("Váš balance:${transactionManager.getBalance(date)}")
}