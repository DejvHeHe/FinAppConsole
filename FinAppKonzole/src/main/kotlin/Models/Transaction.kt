package Models

data class Transaction (
    val name: String,
    val amount: Int,
    val category: TransactionCategory,
    val type: TransactionType,
)