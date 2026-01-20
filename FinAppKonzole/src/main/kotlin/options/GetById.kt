package options

import bl.TransactionManager
import helpFunctions.checkId


fun getById()
{
    val id= checkId()

    try {

        println("Transakce:${TransactionManager.getById(id)}")

    }
    catch (e: Exception)
    {
        println("Došlo k chybě ${e.message}")
    }



}