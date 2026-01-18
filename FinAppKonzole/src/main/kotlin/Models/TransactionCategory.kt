package Models

enum class transactionCategory(val type: transactionType) {
    //INCOME
    SALARY(transactionType.INCOME),
    PRESENT(transactionType.INCOME),
    ALLOWANCE(transactionType.INCOME),

    //EXPENSE
    SAVINGS(transactionType.EXPENSE),
    FUN(transactionType.EXPENSE),
    INVESTMENT(transactionType.EXPENSE),
    FOOD(transactionType.EXPENSE),
    RENT(transactionType.EXPENSE)
}