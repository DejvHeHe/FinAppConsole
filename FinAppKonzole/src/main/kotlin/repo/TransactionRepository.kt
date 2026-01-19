package repo

import models.transaction
import models.transactionCategory
import models.transactionType
import java.time.LocalDate
import java.time.YearMonth
import java.util.UUID


object transactionRepository {
    private val transactions = mutableListOf<transaction>()

    fun create(transaction: transaction): Boolean
    {
        return transactions.add(transaction)
    }
    fun remove(id: UUID):Boolean
    {
        return (transactions.removeIf { it.id == id })

    }

    fun getAll(date: YearMonth): List<transaction>
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
            if(transaction.type == transactionType.EXPENSE)
            {
                sumExpenses+=transaction.amount
            }
            if (transaction.type == transactionType.INCOME)
            {
                sumIncomes+=transaction.amount
            }

        }
        balance+=sumIncomes-sumExpenses
        return balance
    }
    fun sumByCategory(category: transactionCategory, date: YearMonth): Int
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
    fun sumByType(type: transactionType, date: YearMonth): Int
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
    fun sumAllCategories(date: YearMonth): Map<transactionCategory, Int>
    {
        val sumByCategories = mutableMapOf<transactionCategory, Int>()
        for(category in transactionCategory.values())
        {
            sumByCategories[transactionCategory.valueOf(category.name)]=sumByCategory(category, date)
        }
        return sumByCategories


    }

    fun getById(id: UUID): transaction?
    {
        return transactions.find { it.id == id }
    }
    fun update(id: UUID, changes: Map<String, Any?>): Boolean {
        val index = transactions.indexOfFirst { it.id == id }
        if (index == -1) return false

        val old = transactions[index]

        val updated = old.copy(
            name = changes["name"] as? String ?: old.name,
            type = changes["type"] as? transactionType ?: old.type,
            category = changes["category"] as? transactionCategory ?: old.category,
            amount = changes["amount"] as? Int ?: old.amount,
            date = changes["date"] as? LocalDate ?: old.date,
            description = changes["description"] as? String ?: old.description
        )

        transactions[index] = updated
        return(old!=updated)
    }

}