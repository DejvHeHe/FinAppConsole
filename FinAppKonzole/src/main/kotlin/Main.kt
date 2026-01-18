
import Options.create
import Options.createReacuring
import Options.getById
import Options.remove
import Options.sumByAllCategories
import Options.sumByCategory
import Options.sumByTypes

import Options.update
import Options.viewAll
import Options.viewBalance

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
    println("5. Zobrazit přehled podle kategorie")
    println("6. Zobrazit přehled všech kategorií")
    println("7. Zobrazit přehled podle typu")
    println("8. Upravit transakci")
    println("9. Vyhledat podle ID")
    println("10. Vytvořit opakovanou transakci")
    print("Vyberte možnost: ")
    option=readln()

    when(option)
    {
        "1"->{
            create()
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
            sumByCategory()

        }
        "6"->
        {
            sumByAllCategories()

        }
        "7"->{
            sumByTypes()

        }
        "8"->{
            update()
        }
        "9"->{
            getById()
        }
        "10"->{
            createReacuring()
        }

    }
    


}


