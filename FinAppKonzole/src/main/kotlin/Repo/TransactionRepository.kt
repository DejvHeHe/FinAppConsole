package Repo

import Models.Transaction
import Models.TransactionCategory
import Models.TransactionType
import java.time.LocalDate
import java.time.YearMonth
import java.util.UUID


object TransactionRepository {
    private val transactions = mutableListOf<Transaction>()

    fun create(transaction: Transaction): Boolean
    {
       transactions.add(transaction)
        return true
    }
    fun remove(id: UUID)
    {
        transactions.removeIf { it.id == id }
        println("Removed $id")
    }

    fun getAll(date: YearMonth): List<Transaction>
    {

        val transactionsMoth= transactions.filter { YearMonth.from(it.date) == date }
        return transactionsMoth
    }
    fun getBalance(date: YearMonth): Int
    {
        var balance = 0
        var sumExpenses=0
        var sumIncomes=0
        val transactionsMoth=getAll(date)
        for (transaction in transactionsMoth)
        {
            if(transaction.type == TransactionType.EXPENSE)
            {
                sumExpenses+=transaction.amount
            }
            if (transaction.type == TransactionType.INCOME)
            {
                sumIncomes+=transaction.amount
            }

        }
        balance+=sumIncomes-sumExpenses
        return balance
    }
    fun sumByCategory(category: TransactionCategory, date: YearMonth): Int
    {
        val transactionsMoth=getAll(date)
        val transactionsCategory=transactionsMoth.filter { it.category == category }
        var sum=0
        for (transaction in transactionsCategory)
        {
            sum+=transaction.amount

        }
        return sum
    }
    fun sumByType(type: TransactionType, date: YearMonth): Int
    {
        val transactionsMoth=getAll(date)
        val transactionsType=transactionsMoth.filter { it.type == type }
        var sum=0
        for (transaction in transactionsType)
        {
            sum+=transaction.amount
        }
        return sum

    }
    fun sumAllCategories(date: YearMonth): Map<String, Int>
    {
        val sumByCatgories = mutableMapOf<String, Int>()
        for(category in TransactionCategory.values())
        {
            sumByCatgories[category.name]=sumByCategory(category, date)
        }
        return sumByCatgories


    }

    fun getById(id: UUID): Transaction?
    {
        return transactions.find { it.id == id }
    }
    fun update(id: UUID,
               name: String,
               type: TransactionType,
               category: TransactionCategory,
               amount: Int,
               date: LocalDate,
               description: String):Boolean
    {
        for(transaction in transactions)
        {
            if (transaction.id == id)
            {


            }
        }
        return true
    }

}