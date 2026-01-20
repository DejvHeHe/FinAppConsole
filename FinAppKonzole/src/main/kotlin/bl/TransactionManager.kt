package bl

import models.Transaction
import models.TransactionCategory
import models.TransactionType
import repo.TransactionRepository
import java.time.YearMonth
import  interfaces.TransactionService
import java.time.LocalDate
import java.util.UUID

object TransactionManager:TransactionService {


    override fun create(transaction: Transaction):Boolean
    {
        if(transaction.amount <= 0)
        {
            throw IllegalArgumentException("Částka musí být kladná.")
        }
        if(transaction.name.isEmpty())
        {
            throw IllegalArgumentException("Název transakce nesmí být prázdný.")
        }



        return(TransactionRepository.create(transaction))


    }

    override fun remove(id: UUID): Boolean {
        return(TransactionRepository.remove(id))
    }
    override fun getAll(date: YearMonth): List<Transaction>
    {
        return TransactionRepository.getAll(date)
    }
    override fun getBalance(date: YearMonth): Int
    {
        return TransactionRepository.getBalance(date)
    }

    override fun sumByType(type: TransactionType, date: YearMonth): Int
    {
        return TransactionRepository.sumByType(type, date)
    }
    override fun sumAllCategories(date: YearMonth): Map<TransactionCategory, Int>
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

            return(TransactionRepository.update(id,changes))

        }




    }


    override fun getById(id: UUID): Transaction? {
        return (TransactionRepository.getById(id))
    }




}