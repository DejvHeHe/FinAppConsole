import Models.Transaction
import Models.TransactionCategory
import Models.TransactionType
import java.time.LocalDate
import java.time.YearMonth
import java.util.UUID

interface TransactionInterface {
    fun create(transaction: Transaction)
    fun remove(id: UUID)

    fun getAll(date: YearMonth): List<Transaction>

    fun getBalance(date: YearMonth): Int

    fun sumByCategory(category: TransactionCategory, date: YearMonth): Int

    fun sumByType(type: TransactionType, date: YearMonth): Int

    fun sumAllCategories(date: YearMonth): Map<String, Int>

    fun update(id: UUID,name: String?=null,type: TransactionType?=null,category: TransactionCategory?=null,amount: Int?=null,
               date: LocalDate?=null,
               description: String?=null):Boolean

    fun getById(id: UUID): Transaction?
    fun setAsReacuring(id: UUID, date: LocalDate): Boolean
}