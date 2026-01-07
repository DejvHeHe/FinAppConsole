import Models.Transaction
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
}