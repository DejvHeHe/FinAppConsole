import Models.Transaction
import Models.TransactionType

object TransactionManager {
    private val transactions = mutableListOf<Transaction>()

    fun create(transaction: Transaction)
    {
        if(transaction.amount <= 0)
        {
            println("Musí být kladné")
        }
        if(transaction.type== TransactionType.EXPENSE)
        {
            transaction.amount*-1
        }
        transactions.add(transaction)
        println(transactions)


    }
    fun getAll(): List<Transaction> = transactions
    fun sumarize():Int
    {
        var sum= 0
        for(transaction in transactions)
        {
            sum += transaction.amount

        }
        return sum

    }
}