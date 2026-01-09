import Models.Transaction
import Models.TransactionCategory
import Models.TransactionType

object TransactionManager {
    private val transactions = mutableListOf<Transaction>()

    fun create(transaction: Transaction)
    {
        if(transaction.amount <= 0)
        {
            println("Musí být kladné")
        }

        transactions.add(transaction)
        println(transactions)


    }
    fun getAll(): List<Transaction> = transactions
    fun sumarize():Int
    {
        var sum= 0
        var sumExpenses = 0
        var sumIncomes = 0
        for(transaction in transactions)
        {
            if(transaction.type== TransactionType.EXPENSE)
            {
                sumExpenses = transaction.amount
            }
            if(transaction.type== TransactionType.INCOME)
            {
                sumIncomes = transaction.amount
            }


        }
        sum=sumIncomes - sumExpenses
        return sum

    }
    fun sumarizeByCategory(category: String):Int
    {
        var sum= 0
        val categoryS=TransactionCategory.valueOf(category)

        for(transaction in transactions)
        {
            if(transaction.category==categoryS )
            {
                sum += transaction.amount
            }
        }
        return sum
    }

}