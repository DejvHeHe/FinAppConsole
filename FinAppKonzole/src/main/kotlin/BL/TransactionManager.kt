package BL

import Models.transaction
import Models.transactionCategory
import Models.transactionType
import Repo.transactionRepository
import java.time.YearMonth
import  transactionInterface
import java.time.LocalDate
import java.util.UUID

object transactionManager:transactionInterface {


    override fun create(transaction: transaction)
    {
        if(transaction.amount <= 0)
        {
            println("Musí být kladné")
        }
        if(transaction.name.length <= 0)
        {
            println("Musí mít jmeno")
        }


        println("Byla transakce vytvořena? ${transactionRepository.create(transaction)}")


    }

    override fun remove(id: UUID) {
        transactionRepository.remove(id)
    }
    override fun getAll(date: YearMonth): List<transaction>
    {
        return transactionRepository.getAll(date)
    }
    override fun getBalance(date: YearMonth): Int
    {
        return transactionRepository.getBalance(date)
    }
    override fun sumByCategory(category: transactionCategory,date: YearMonth): Int
    {
        return transactionRepository.sumByCategory(category, date)
    }
    override fun sumByType(type: transactionType, date: YearMonth): Int
    {
        return transactionRepository.sumByType(type, date)
    }
    override fun sumAllCategories(date: YearMonth): Map<String, Int>
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

            transactionRepository.update(id,changes)

        }
        return true



    }


    override fun getById(id: UUID): transaction? {
        return (transactionRepository.getById(id))
    }




}