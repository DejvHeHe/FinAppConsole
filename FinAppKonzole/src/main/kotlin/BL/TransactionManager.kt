package BL

import Models.Transaction
import Repo.TransactionRepository

object TransactionManager {


    fun create(transaction: Transaction)
    {
        if(transaction.amount <= 0)
        {
            println("Musí být kladné")
        }
        if(transaction.name.length <= 0)
        {
            println("Musí mít jmeno")
        }


        println("Byla transakce vytvořena? ${TransactionRepository.create(transaction)}")


    }



}