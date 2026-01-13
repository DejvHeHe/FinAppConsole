package Options

import BL.TransactionManager
import Models.TransactionType
import checkDate

fun SumByTypes() {
    print("Zadejte název typu:")
    var type=readln().uppercase()
    print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
    val input = readln().trim() // .trim() odstraní náhodné mezery
    var date=checkDate(input)
    println("Suma podle typu:${TransactionManager.sumByType(TransactionType.valueOf(type),date)}")
}