fun main() {
    var amount = 100_00
    println("Сумма перевода: ${ amount / 100 } руб.  Комиссия за перевод: ${ commission(amount) / 100 } руб.")
    amount = 500_00
    println("Сумма перевода: ${ amount / 100 } руб.  Комиссия за перевод: ${ commission(amount) / 100 } руб.")
    amount = 8000_00
    println("Сумма перевода: ${ amount / 100 } руб.  Комиссия за перевод: ${ commission(amount) / 100 } руб.")
    amount = 50000_00
    println("Сумма перевода: ${ amount / 100 } руб.  Комиссия за перевод: ${ commission(amount) / 100 } руб.")
}

fun commission(amount: Int): Int {
    val commission = amount * 75 / 10_000
    return if (commission < 35_00) 35_00 else commission
}