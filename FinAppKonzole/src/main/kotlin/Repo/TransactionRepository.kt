package Repo

import Models.Transaction

object TransactionRepository {
    private val transactions = mutableListOf<Transaction>()

    fun create(transaction: Transaction): Boolean
    {
       transactions.add(transaction)
        return true
    }
}