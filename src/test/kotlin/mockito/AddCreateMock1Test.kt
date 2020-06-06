package mockito

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class AddCreateMock1Test{
    private var add: Add? = null
    private var validNumber: ValidNumber? = null
    private var print: Print? = null

    @BeforeEach
    fun setUp(){
        validNumber = Mockito.mock(ValidNumber::class.java)
        print = Mockito.mock(Print::class.java)
        add = Add(validNumber!!, print!!)
    }

    @Test
    fun addTest(){
        add?.add(3,2)
        Mockito.verify(validNumber)?.check(3)
        //Mockito.verify(validNumber)?.check(2)
    }
}