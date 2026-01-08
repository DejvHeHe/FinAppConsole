import Models.Transaction
import Models.TransactionCategory
import Models.TransactionType
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

            val newRecord=Transaction(name=transactionName, amount=transactionAmount,   type= TransactionType.valueOf(transactionType), category = TransactionCategory.valueOf(transactionCategory))
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

    }


}

