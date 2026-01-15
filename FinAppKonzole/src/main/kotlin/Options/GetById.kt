package Options

import BL.TransactionManager
import java.util.UUID

fun getById()
{
    var id: UUID? = null

    while(id == null)
    {
        print("Zadejte id transakce:")
        var input=readln()
        if (input.isEmpty())
        {
            println("Id nesmí být prazdné")
        }
        else{
            try {
                id = UUID.fromString(input)
                println("Transakce:${TransactionManager.getById(id)}")

            }
            catch (e: Exception)
            {
                println("Došlo k chybě ${e.message}")
            }
        }
    }

}