package BL

import Models.Transaction
import Models.TransactionCategory
import Models.TransactionType
import Repo.TransactionRepository
import java.time.YearMonth
import  TransactionInterface
import java.util.UUID

object TransactionManager:TransactionInterface {


    override fun create(transaction: Transaction)
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

    override fun remove(id: UUID) {
        TransactionRepository.remove(id)
    }
    override fun getAll(date: YearMonth): List<Transaction>
    {
        return TransactionRepository.getAll(date)
    }
    override fun getBalance(date: YearMonth): Int
    {
        return TransactionRepository.getBalance(date)
    }
    override fun sumByCategory(category: TransactionCategory,date: YearMonth): Int
    {
        return TransactionRepository.sumByCategory(category, date)
    }
    override fun sumByType(type: TransactionType, date: YearMonth): Int
    {
        return TransactionRepository.sumByType(type, date)
    }
    override fun sumAllCategories(date: YearMonth): Map<String, Int>
    {
        return TransactionRepository.sumAllCategories(date)

    }


}