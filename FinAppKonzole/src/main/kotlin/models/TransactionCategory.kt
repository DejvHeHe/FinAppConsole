package models

enum class TransactionCategory(val type: TransactionType) {
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
//Pokud zadám type expense a category salary tak to funguje