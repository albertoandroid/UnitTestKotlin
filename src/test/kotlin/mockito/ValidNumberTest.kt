package mockito

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ValidNumberTest{
    private var validNumber: ValidNumber? = null

    @BeforeEach
    fun setUp(){
        validNumber = ValidNumber()
    }

    @AfterEach
    fun tearDown(){
        validNumber = null
    }

    @Test
    fun checkTest(){
        assertEquals(true, validNumber!!.check(5))
    }

    @Test
    fun checkNegativeTest(){
        assertEquals(false, validNumber!!.check(-5))
    }

    @Test
    fun checkStringTest(){
        assertEquals(false, validNumber!!.check("5"))
    }

    @Test
    fun checkDoubleTest(){
        assertEquals(false, validNumber!!.check(5.5))
    }

    @Test
    fun check0Test(){
        assertEquals(true, validNumber!!.check(0))
    }

    @Test
    fun checkZeroTest(){
        assertEquals(true, validNumber!!.checkZero(-57))
    }

    @Test
    fun checkZeroStringTest(){
        assertEquals(false, validNumber!!.checkZero("5"))
    }

    @Test
    fun checkZero0Test(){
        assertThrows(ArithmeticException::class.java){ validNumber!!.checkZero(0)}
    }

    @Test
    fun doubleToIntTest(){
        assertEquals(9, validNumber!!.doubleToIn(9.9999))
    }

    @Test
    fun doubleToIntErrorTest(){
        assertEquals(0, validNumber!!.doubleToIn("9.9999"))
    }

}