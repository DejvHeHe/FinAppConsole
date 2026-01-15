package Options

import BL.TransactionManager
import Models.TransactionCategory
import Models.TransactionType
import java.time.LocalDate
import java.util.UUID

fun transactionUpdate(){
    var transactionName:String? = null
    var transactionDate: LocalDate? = null
    var transactionCategory: TransactionCategory? = null
    var transactionType: TransactionType? = null
    var transactionAmount: Int? = null
    var transactionDescription:String? = null
    var id:UUID?=null
    while(id==null)
    {
        try {
            print("Zadejte id:")
            id= UUID.fromString(readln())
            if(id==null)
            {
                print("id nesmí být prazdné")
            }
            print("Zadejte nové jmeno:")
            transactionName = readln()
            print("Zadejte nový type")
            var input= readln()
            if (input.isNotEmpty()) {
                try {
                    transactionType = TransactionType.valueOf(input.uppercase())
                } catch (e: Exception) {
                    println("Neplatný typ, hodnota nebude změněna.")
                }
            }
            print("Zadejte novou kategori:")
            input=readln()
            if (input.isNotEmpty()) {
                try {
                    transactionCategory = TransactionCategory.valueOf(input.uppercase())
                } catch (e: Exception) {
                    println("Neplatný typ, hodnota nebude změněna.")
                }
            }
            print("Zadejte novou hodnotu:")
            transactionAmount = readln().toIntOrNull()
            print("Zadejte nové datum:")
            input=readln()
            if (input.isNotEmpty()) {
                try {
                    transactionDate = LocalDate.parse(input)
                } catch (e: Exception) {
                    println("Neplatný typ, hodnota nebude změněna.")
                }
            }

            print("Zadejte nový popisek:")
            transactionDescription = readln()


        }
        catch(e:Exception) {
            println("Nastala chyba:${e.message}")
        }
    }


}