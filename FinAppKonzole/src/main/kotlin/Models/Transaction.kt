package Models

import java.time.LocalDate


data class Transaction (
    //val id: String,
    val name: String,
    val amount: Int,
    val category: TransactionCategory,
    val type: TransactionType,
    val date: LocalDate,
)