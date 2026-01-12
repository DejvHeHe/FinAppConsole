package BL

import Models.Transaction
import Models.TransactionCategory
import Models.TransactionType
import Repo.TransactionRepository
import java.time.YearMonth

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
    fun getAll(date: YearMonth): List<Transaction>
    {
        return TransactionRepository.getAll(date)
    }
    fun getBalance(date: YearMonth): Int
    {
        return TransactionRepository.getBalance(date)
    }
    fun sumByCategory(category: TransactionCategory,date: YearMonth): Int
    {
        return TransactionRepository.sumByCategory(category, date)
    }
    fun sumByType(type: TransactionType, date: YearMonth): Int
    {
        return TransactionRepository.sumByType(type, date)
    }
    fun sumAllCategories(date: YearMonth): Map<String, Int>
    {
        return TransactionRepository.sumAllCategories(date)

    }


}