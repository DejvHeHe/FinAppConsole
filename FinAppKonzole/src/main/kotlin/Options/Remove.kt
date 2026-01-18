package Options

import BL.transactionManager
import java.util.UUID

fun remove()
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
                transactionManager.remove(id)

            }


        }
        catch(e:Exception) {
            print("Nastala chyba:${e.message}")
        }

    }






}