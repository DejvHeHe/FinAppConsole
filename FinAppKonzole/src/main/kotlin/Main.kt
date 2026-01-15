import Options.SumByAllCategories
import Options.SumByCategory
import Options.SumByTypes
import Options.TransactionCreate
import Options.TransactionRemove
import Options.ViewAll
import Options.ViewBalance
import Options.getById
import Options.transactionUpdate

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
    println("8.Update transaction")
    println("9.GetById")
    println("10.Create reacuring transaction")
    print("Enter option: ")
    option=readln()

    when(option)
    {
        "1"->{
            TransactionCreate()
        }
        "2"->{
            TransactionRemove()


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
        "8"->{
            transactionUpdate()
        }
        "9"->{
            getById()
        }
        "10"->{
            //CreateReacuring
        }

    }
    


}


