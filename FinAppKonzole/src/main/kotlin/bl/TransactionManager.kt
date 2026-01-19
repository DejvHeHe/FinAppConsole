package bl

import models.transaction
import models.transactionCategory
import models.transactionType
import repo.transactionRepository
import java.time.YearMonth
import  interfaces.Transaction
import java.time.LocalDate
import java.util.UUID

object transactionManager:Transaction {


    override fun create(transaction: transaction):Boolean
    {
        if(transaction.amount <= 0)
        {
            throw IllegalArgumentException("Částka musí být kladná.")
        }
        if(transaction.name.isEmpty())
        {
            throw IllegalArgumentException("Název transakce nesmí být prázdný.")
        }



        return(transactionRepository.create(transaction))


    }

    override fun remove(id: UUID): Boolean {
        return(transactionRepository.remove(id))
    }
    override fun getAll(date: YearMonth): List<transaction>
    {
        return transactionRepository.getAll(date)
    }
    override fun getBalance(date: YearMonth): Int
    {
        return transactionRepository.getBalance(date)
    }

    override fun sumByType(type: transactionType, date: YearMonth): Int
    {
        return transactionRepository.sumByType(type, date)
    }
    override fun sumAllCategories(date: YearMonth): Map<transactionCategory, Int>
    {
        return transactionRepository.sumAllCategories(date)

    }

    override fun update(
        id: UUID,
        name: String?,
        type: transactionType?,
        category: transactionCategory?,
        amount: Int?,
        date: LocalDate?,
        description: String?
    ):Boolean
    {
        val transactionFound=getById(id)
        if(transactionFound==null)
        {
            throw IllegalArgumentException("Transakce neexistuje")

        }
        else{
            val changes = mutableMapOf<String, Any?>()


            if (name != null) changes["name"] = name
            if (type != null) changes["type"] = type
            if (category != null) changes["category"] = category
            if (amount != null) changes["amount"] = amount
            if (date != null) changes["date"] = date
            if (description != null) changes["description"] = description

            return(transactionRepository.update(id,changes))

        }




    }


    override fun getById(id: UUID): transaction? {
        return (transactionRepository.getById(id))
    }




}