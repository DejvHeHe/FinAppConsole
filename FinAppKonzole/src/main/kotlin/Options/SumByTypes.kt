package Options

import BL.transactionManager
import Models.transactionType
import checkDate

fun sumByTypes() {
    print("Zadejte název typu:")
    var type=readln().uppercase()
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim() // .trim() odstraní náhodné mezery
    var date=checkDate(input)
    println("Suma podle typu:${transactionManager.sumByType(transactionType.valueOf(type),date)}")
}