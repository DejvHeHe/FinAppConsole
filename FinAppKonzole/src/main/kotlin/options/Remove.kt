package options

import bl.TransactionManager
import helpFunctions.checkId


fun remove()
{
    val id= checkId()
    try{
        TransactionManager.remove(id)

    }
    catch(e: IllegalArgumentException)
    {
        println("Chyba:${e.message}")
    }












}