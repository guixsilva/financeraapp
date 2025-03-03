import java.util.Date

data class Transaction(
    val idtransaction: Int,
    val transactionamount: Int,
    val transactiontitle: String,
    val transactiondescription: String,
    val transactiondate: Date,
    val idexpense: Int,
    val idincome: Int,
    val idreserve: Int
)