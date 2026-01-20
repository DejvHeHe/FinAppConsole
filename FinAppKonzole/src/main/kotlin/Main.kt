//Main

import options.createWithRecurrence
import options.getById
import options.remove
import options.sumByAllCategories
import options.sumByTypes

import options.update
import options.viewAll
import options.viewBalance

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
    println("0. Zavřít")
    println("1. Vytvořit transakci")
    println("2. Smazat transakci")
    println("3. Zobrazit všechny transakce")
    println("4. Zobrazit zůstatek")
    println("5. Zobrazit přehled všech kategorií")
    println("6. Zobrazit přehled podle typu")
    println("7. Upravit transakci")
    println("8. Vyhledat podle ID")
    print("Vyberte možnost: ")
    option=readln()

    when(option)
    {
        "1"->{
            createWithRecurrence()
        }
        "2"->{
            remove()


        }
        "3"->{
            viewAll()

        }
        "4"->{
            viewBalance()
        }

        "5"->
        {
            sumByAllCategories()

        }
        "6"->{
            sumByTypes()

        }
        "7"->{
            update()
        }
        "8"->{
            getById()
        }

    }
    


}


