import Options.SumByAllCategories
import Options.SumByCategory
import Options.SumByTypes
import Options.TransactionCreate
import Options.ViewAll
import Options.ViewBalance

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
        "1"->{
            TransactionCreate()
        }
        "2"->{
            print("Zadejte id:")
            var id=readln()


        }
        "3"->{
            ViewAll()

        }
        "4"->{
            ViewBalance()
        }
        "5"->
        {
            SumByCategory()

        }
        "6"->
        {
            SumByAllCategories()

        }
        "7"->{
            SumByTypes()

        }

    }
    


}


