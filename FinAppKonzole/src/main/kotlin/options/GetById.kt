package options

import bl.transactionManager
import java.util.UUID

fun getById()
{
    var id: UUID? = null

    while(id == null)
    {
        print("Zadejte id transakce:")
        val input=readln()
        if (input.isEmpty())
        {
            println("Id nesmí být prazdné")
        }
        else{
            try {
                id = UUID.fromString(input)
                println("Transakce:${transactionManager.getById(id)}")

            }
            catch (e: Exception)
            {
                println("Došlo k chybě ${e.message}")
            }
        }
    }

}