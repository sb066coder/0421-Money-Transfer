const val MASTERCARD = "Mastercard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"
const val MIR = "Мир"
const val VK_PAY = "VK Pay"

fun main() {
    pay(1000_00)
    pay(8000_00, 0, MASTERCARD)
    pay(8000_00, 100_000_00, MASTERCARD)
    pay(10_000_00, accountType = MIR)

    val array = arrayOf(1,2,3)
    for (i in 0..2)
        print(array[i] * 3)
}

fun commission(amount: Int, sentInCurrentMonth: Int = 0, accountType: String = VK_PAY): Int {
    return when (accountType) {
        MASTERCARD, MAESTRO -> {
            val more75 = sentInCurrentMonth > 75_000_00
            if (more75) amount * 6 / 1_000 + 20_00 else 0
        }
        VISA, MIR -> {
            val minCommission = 35_00
            val commission = amount * 75 / 10_000
            if (commission < minCommission) minCommission else commission
        }
        else -> 0
    }
}

fun pay(amount: Int, sentInCurrentMonth: Int = 0, accountType: String = VK_PAY) {
    println("Сумма платежа: ${amount / 100}")
    println("Оплата со счета: $accountType")
    if (accountType == MASTERCARD || accountType == MAESTRO)
        println("Сумма переводов в текущем месяце: ${ sentInCurrentMonth / 100 }")
    println("Комиссия: ${commission(amount, sentInCurrentMonth, accountType) / 100}")
    println()
}