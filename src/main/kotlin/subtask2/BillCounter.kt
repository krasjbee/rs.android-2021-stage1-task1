package subtask2

class BillCounter {


    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        //amount to pay calculated by filtering unnecessary element
        val amountToPay = bill.filterIndexed { index, _ ->
            index != k
        }.sum() / 2
        val refundValue = b - amountToPay
        //if value to be refunded is zero , return "Bon Appetit" else returns this value
        return if (refundValue == 0) "Bon Appetit" else refundValue.toString()
    }
}
