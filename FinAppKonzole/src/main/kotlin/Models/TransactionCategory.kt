package Models

enum class TransactionCategory(val Type: TransactionType) {
    //INCOME
    SALARY(TransactionType.INCOME),
    PRESENT(TransactionType.INCOME),
    ALLOWANCE(TransactionType.INCOME),

    //EXPENSE
    SAVINGS(TransactionType.EXPENSE),
    FUN(TransactionType.EXPENSE),
    INVESTMENT(TransactionType.EXPENSE),
    FOOD(TransactionType.EXPENSE),
    RENT(TransactionType.EXPENSE)
}