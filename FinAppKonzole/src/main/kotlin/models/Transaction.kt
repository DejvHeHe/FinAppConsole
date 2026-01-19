package models

import java.time.LocalDate
import java.util.UUID


data class transaction (
    val id: UUID,
    val name: String,
    val amount: Int,
    val category: transactionCategory,
    val type: transactionType,
    val date: LocalDate,
    val description: String
)