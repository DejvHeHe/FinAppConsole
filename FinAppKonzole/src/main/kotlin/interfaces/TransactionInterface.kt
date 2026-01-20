package interfaces

import models.Transaction
import models.TransactionCategory
import models.TransactionType
import java.time.LocalDate
import java.time.YearMonth
import java.util.UUID

interface TransactionService {
    fun create(transaction: Transaction): Boolean
    fun remove(id: UUID): Boolean

    fun getAll(date: YearMonth): List<Transaction>

    fun getBalance(date: YearMonth): Int

    fun sumByType(type: TransactionType, date: YearMonth): Int

    fun sumAllCategories(date: YearMonth): Map<TransactionCategory, Int>

    fun update(id: UUID,name: String?=null,type: TransactionType?=null,category: TransactionCategory?=null,amount: Int?=null,
               date: LocalDate?=null,
               description: String?=null):Boolean

    fun getById(id: UUID): Transaction?

}