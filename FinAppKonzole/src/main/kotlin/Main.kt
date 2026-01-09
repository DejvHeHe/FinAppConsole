import Models.Transaction
import Models.TransactionCategory
import Models.TransactionType
import java.time.LocalDate

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
    println("3.View all transaction")
    println("4.View sumarization")
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

        }
        "3"->{
           println(TransactionManager.getAll())
        }
        "4"->{
            println("Vaš status je:${TransactionManager.sumarize()}")

        }
        "5"->
        {
            print("Zadejte název categorie:")
            var category=readln().uppercase()
            println("Sumarizace podle kategorie:${TransactionManager.sumarizeByCategory(category)}")

        }
        "6"->
        {


        }
        "7"->{

        }

    }


}

