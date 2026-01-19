package interfaces

import models.transaction
import models.transactionCategory
import models.transactionType
import java.time.LocalDate
import java.time.YearMonth
import java.util.UUID

interface Transaction {
    fun create(transaction: transaction): Boolean
    fun remove(id: UUID): Boolean

    fun getAll(date: YearMonth): List<transaction>

    fun getBalance(date: YearMonth): Int

    fun sumByType(type: transactionType, date: YearMonth): Int

    fun sumAllCategories(date: YearMonth): Map<transactionCategory, Int>

    fun update(id: UUID,name: String?=null,type: transactionType?=null,category: transactionCategory?=null,amount: Int?=null,
               date: LocalDate?=null,
               description: String?=null):Boolean

    fun getById(id: UUID): transaction?

}