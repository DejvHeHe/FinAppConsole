import BL.TransactionManager
import Models.Transaction
import Models.TransactionCategory
import Models.TransactionType
import Repo.TransactionRepository
import jdk.nashorn.internal.objects.NativeJava.type
import java.time.LocalDate
import java.time.YearMonth

var option:String="1"


fun main()
{

    while (option!="0")
    {

        pickOption()

    }

}
fun pickOption()
{
    println("0.Close")
    println("1.Create transaction")
    println("2.Remove transaction")
    println("3.View all transactions")
    println("4.View balance")
    println("5.View sumarization by category")
    println("6.View sumarization of all categories")
    println("7.View sumarization by types")
    print("Enter option: ")
    option=readln()

    when(option)
    {
        "1"->{print("Zadejte název transakce:")
            val transactionName=readln()
            print("Zadejte typ transakce (INCOME/EXPENSE):")
            val transactionType=readln().uppercase()
            print("Zadejte kategori transakce:")
            val transactionCategory=readln().uppercase()
            print("Zadejte částku transakce:")
            val transactionAmount=readln().toIntOrNull()?:0
            print("Zadejte datum ve formátu (YYYY-MM-DD):")
            val transactionDate=readln()

            val newRecord=Transaction(name=transactionName, amount=transactionAmount,   type= TransactionType.valueOf(transactionType), category = TransactionCategory.valueOf(transactionCategory) ,date= LocalDate.parse(transactionDate))
            TransactionManager.create(newRecord)
        }
        "2"->{
            print("Zadejte id:")
            var id=readln()


        }
        "3"->{
            print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
            val input = readln().trim() // .trim() odstraní náhodné mezery
            var date=checkDate(input)
            println("Vaše transakce ${TransactionManager.getAll(date)}")

        }
        "4"->{
            print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
            val input = readln().trim() // .trim() odstraní náhodné mezery
            var date=checkDate(input)
            println("Váš balance:${TransactionManager.getBalance(date)}")


        }
        "5"->
        {
            print("Zadejte název categorie:")
            var category=readln().uppercase()
            print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
            val input = readln().trim() 
            var date=checkDate(input)
            println("Suma dané kategorie je:${TransactionManager.sumByCategory(TransactionCategory.valueOf(category),date)}")


        }
        "6"->
        {
            print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
            val input = readln().trim() // .trim() odstraní náhodné mezery
            var date=checkDate(input)
            println("Sumy podle kategorii:${TransactionManager.sumAllCategories(date)}")


        }
        "7"->{
            print("Zadejte název typu:")
            var type=readln().uppercase()
            print("Zadej období (RRRR-MM) nebo potvrď Enterem pro aktuální měsíc: ")
            val input = readln().trim() // .trim() odstraní náhodné mezery
            var date=checkDate(input)
            println("Suma podle typu:${TransactionManager.sumByType(TransactionType.valueOf(type),date)}")

        }

    }
    


}
fun checkDate(input: String): YearMonth
{

    val date = if (input.isEmpty()) {
        YearMonth.now()
    } else {
        try {
            YearMonth.parse(input)
        } catch (e: Exception) {
            println("Chyba: Špatný formát, nastavuji aktuální měsíc.")
            YearMonth.now()
        }
    }

    return date
}

