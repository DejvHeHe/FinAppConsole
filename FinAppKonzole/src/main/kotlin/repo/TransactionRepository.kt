package repo

import models.Transaction
import models.TransactionCategory
import models.TransactionType
import java.time.LocalDate
import java.time.YearMonth
import java.util.UUID


object TransactionRepository {
    private val transactions = mutableListOf<Transaction>()

    fun create(transaction: Transaction): Boolean
    {
        return transactions.add(transaction)
    }
    fun remove(id: UUID):Boolean
    {
        return (transactions.removeIf { it.id == id })

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
    fun sumAllCategories(date: YearMonth): Map<TransactionCategory, Int>
    {
        val sumByCategories = mutableMapOf<TransactionCategory, Int>()
        for(category in TransactionCategory.entries)
        {
            sumByCategories[TransactionCategory.valueOf(category.name)]=sumByCategory(category, date)
        }
        return sumByCategories


    }

    fun getById(id: UUID): Transaction?
    {
        return transactions.find { it.id == id }
    }
    fun update(id: UUID, changes: Map<String, Any?>): Boolean {
        val index = transactions.indexOfFirst { it.id == id }
        if (index == -1) return false

        val old = transactions[index]

        val updated = old.copy(
            name = changes["name"] as? String ?: old.name,
            type = changes["type"] as? TransactionType ?: old.type,
            category = changes["category"] as? TransactionCategory ?: old.category,
            amount = changes["amount"] as? Int ?: old.amount,
            date = changes["date"] as? LocalDate ?: old.date,
            description = changes["description"] as? String ?: old.description
        )

        transactions[index] = updated
        return(old!=updated)
    }

}