package options

import bl.transactionManager
import helpFunctions.checkDate

fun viewBalance(){
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim() // .trim() odstraní náhodné mezery
    val date=checkDate(input)
    println("Váš balance:${transactionManager.getBalance(date)}")
}