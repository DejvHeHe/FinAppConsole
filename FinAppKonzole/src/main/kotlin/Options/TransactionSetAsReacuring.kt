package Options


import BL.TransactionManager
import checkDate
import java.time.LocalDate
import java.util.UUID

fun transactionSetAsReaccuring()
{

    var id:UUID?=null
    while(id==null)
    {
        try {
            println("Zadejte id:")
            id= UUID.fromString(readln())
            if(id==null)
            {
                print("id nesmí být prazdné")
            }
            else{
                println("Zadejte do jakeho datumu jí chcete vytvořit")
                val date = LocalDate.parse(readln().trim())



            }


        }
        catch(e:Exception) {
            print("Nastala chyba:${e.message}")
        }

    }


}