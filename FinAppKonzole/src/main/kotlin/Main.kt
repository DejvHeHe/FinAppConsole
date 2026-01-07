import Models.Transaction
import Models.TransactionCategory
import Models.TransactionType

fun main()
{
    print("Zadejte název transakce:")
    val transactionName=readln()
    print("Zadejte typ transakce (INCOME/EXPENSE):")
    val transactionType=readln().uppercase()
    print("Zadejte kategori transakce:")
    val transactionCategory=readln().uppercase()
    print("Zadejte částku transakce:")
    val transactionAmount=readln().toIntOrNull()?:0

    val newRecord=Transaction(name=transactionName, amount=transactionAmount,   type= TransactionType.valueOf(transactionType), category = TransactionCategory.valueOf(transactionCategory))
    TransactionManager.create(newRecord)
}