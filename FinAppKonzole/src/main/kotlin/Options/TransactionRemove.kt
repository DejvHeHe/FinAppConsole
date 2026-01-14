package Options

import BL.TransactionManager
import java.util.UUID

fun TransactionRemove()
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
                TransactionManager.remove(id)

            }


        }
        catch(e:Exception) {
            print("Nastala chyba:${e.message}")
        }

    }






}