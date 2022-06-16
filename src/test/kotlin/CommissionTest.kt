import org.junit.Test

import org.junit.Assert.*

class CommissionTest {

    @Test
    fun VK_PAY_commission() {
        assertEquals(30, commission(1000_00))
        assertEquals(0, commission(50_00, 1000_00, accountType = "Another"))
        assertEquals(0, commission(10_000_00, 1000_00))
    }

    @Test
    fun MASTERCARD_commission() {
        assertEquals(0, commission(8000_00, accountType = MASTERCARD))
        assertEquals(6800, commission(8000_00, 78000_00, MAESTRO))
    }

    @Test
    fun VISA_commission() {
        assertEquals(3500, commission(1_000_00, accountType =  VISA))
        assertEquals(37500, commission(50_000_00, accountType =  VISA))
        assertEquals(63750, commission(85_000_00, accountType =  MIR))
        assertEquals(63750, commission(85_000_00, accountType =  VISA))
    }
}