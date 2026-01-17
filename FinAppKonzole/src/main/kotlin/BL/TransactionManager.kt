package BL

import Models.Transaction
import Models.TransactionCategory
import Models.TransactionType
import Repo.TransactionRepository
import java.time.YearMonth
import  TransactionInterface
import java.time.LocalDate
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

    override fun update(
        id: UUID,
        name: String?,
        type: TransactionType?,
        category: TransactionCategory?,
        amount: Int?,
        date: LocalDate?,
        description: String?
    ):Boolean
    {
        val transactionFound=getById(id)
        if(transactionFound==null)
        {
            println("Transakce neexistuje")
            return false

        }
        else{
            val changes = mutableMapOf<String, Any?>()


            if (name != null) changes["name"] = name
            if (type != null) changes["type"] = type
            if (category != null) changes["category"] = category
            if (amount != null) changes["amount"] = amount
            if (date != null) changes["date"] = date
            if (description != null) changes["description"] = description

            TransactionRepository.update(id,changes)

        }
        return true



    }


    override fun getById(id: UUID): Transaction? {
        return (TransactionRepository.getById(id))
    }

    override fun setAsReacuring(id: UUID, date: LocalDate): Boolean {
        val transactionOrigin=getById(id)
        if(transactionOrigin==null)
        {
            return false
        }
        val originTransactiovAtributes=transactionOrigin.
    }


}