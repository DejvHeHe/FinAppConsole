import Models.transaction
import Models.transactionCategory
import Models.transactionType
import java.time.LocalDate
import java.time.YearMonth
import java.util.UUID

interface transactionInterface {
    fun create(transaction: transaction)
    fun remove(id: UUID)

    fun getAll(date: YearMonth): List<transaction>

    fun getBalance(date: YearMonth): Int

    fun sumByCategory(category: transactionCategory, date: YearMonth): Int

    fun sumByType(type: transactionType, date: YearMonth): Int

    fun sumAllCategories(date: YearMonth): Map<String, Int>

    fun update(id: UUID,name: String?=null,type: transactionType?=null,category: transactionCategory?=null,amount: Int?=null,
               date: LocalDate?=null,
               description: String?=null):Boolean

    fun getById(id: UUID): transaction?

}