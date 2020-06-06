package junit5

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.time.Duration
import java.util.stream.Stream


class CalculatorTest{

    companion object{
        var calculator: Calculator? = null
        @JvmStatic
        @BeforeAll
        fun beforeAll(){
            calculator = Calculator()
            println("@BeforeAll -> beforeAll()")
        }

        @JvmStatic
        @AfterAll
        fun afterAll(){
            calculator = null
            println("@AfterAll -> afterAll()")
        }
    }

    @BeforeEach
    fun setUp(){
        //calculator = Calculator()
        println("@BeforeEah -> setUp()")
    }

    @AfterEach
    fun tearDown(){
        //calculator = null
        println("@AfterEach -> tearDown()")
    }

    @Test
    fun calculatorNotNullTest(){
        assertNotNull(calculator, "Calculator debe ser not null")
        println("@Test -> calculatorNotNullTest()")
    }

    @Test
    fun `necesitamos una instancia de calculator para que nuestra clase calculator funcione`(){
        assertNotNull(calculator, "Calculator debe ser not null")
        println("@Test -> necesitamos una instancia de calculator para()")
    }

    @Test
    fun addAssertTest(){
        //1.- SetUp
        val calculatorAssert = Calculator()
        val resultadoEsperado = 30
        val resultadoActual: Int
        //2.- Action
        resultadoActual = calculatorAssert.add(10,20)
        //3.- Assert
        assertEquals(resultadoEsperado, resultadoActual)
        println("@Test -> addAssertTest()")
    }

    @Test
    fun addTest(){
        assertEquals(30, calculator?.add(10, 20))
        println("@Test -> addTest()")
    }

    @Test
    fun assertTypesTest(){
        assertTrue(1 == 1)
        assertFalse(1 == 2)
        assertNull(null)
        assertNotNull(calculator)

        var calculator1 = Calculator()
        var calculator2 = Calculator()
        var calculator3 = calculator1

//        assertSame(calculator1, calculator2)
        assertSame(calculator1, calculator3)

        assertEquals("alberto", "alberto")
        //assertEquals("alberto", "Alberto", "Ha fallado nuestro médoto de conversión a minusculas de un String")
    }

    @Test
    fun divide_ValidInput_ValidExpected_Test(){
        assertEquals(2, calculator?.divide(4,2))
        println("@Test -> divide_ValidInput_ValidExpected_Test()")
    }

    @Test
    fun divide_NotValidInput_Zero_Test(){
        //fail<Int>("Fallo detectado manualmente - No se puede dividir por cero. Solucionar")
    }

    @Test
    fun divideByZero_InValidInput_ExpectedException_Test(){
        assertThrows(
            ArithmeticException::class.java,
            {calculator?.divideByZero(2,0)},
            "No se puede dividir por cero"
        )
    }

    @Disabled("Disabled util but 23 be resolved")
    @Test
    fun divideByZeroTest(){
        assertEquals(2, calculator?.divide(5,0))
    }

    @DisplayName("Metodo Dividir por Cero -> Funciona")
    @Test
    fun divideByZero_ValidInput_ExpectedException_Name_Test(){
        assertThrows(
            ArithmeticException::class.java,
            {calculator?.divideByZero(2,0)},
            "No se puede dividir por cero"
        )
    }

    @Test
    fun add_Assert_all_Test(){
        assertAll(
            {assertEquals(30, calculator?.add(10,20))},
            {assertEquals(30, calculator?.add(10,20))},
            {assertEquals(2, calculator?.add(1,1))}
        )
    }

    @Nested
    inner class AddTest{
        @Test
        fun add_Positive_Test(){
            assertEquals(30, calculator?.add(15,15))
        }
        @Test
        fun add_Negative_Test(){
            assertEquals(-30, calculator?.add(-15,-15))
        }
        @Test
        fun add_Zero_Test(){
            assertEquals(0, calculator?.add(0,0))
        }
    }

    @Test
    fun timeOut_Test(){
        assertTimeout(Duration.ofMillis(2000)){ calculator?.longTaskOperation()}
    }






}














/*
     //METODO////////////////////////////////////////ESPECIFICACIOM//////////////////////////////////////////////////////////////////////////////
    fun sumar(                  |Este método devuelve un int resultado de la suma de numero 1 y numero2
        numero1: Int,           |
        numero2: Int            |
        ): Int                  | -> Nos devuelve un Entero con el resultado
    ------------------------------------------------------------------------------------------------------------------------
    fun restar(                 |Este método devuelve un int resultado de la resta de numero 1 y numero2
        numero1: Int,           |
        numero2: Int            |
        ): Int                  |-> Nos devuelve un Entero con el resultado
    ------------------------------------------------------------------------------------------------------------------------

    Método a Probar                 |      Entrada      |       Salida Esperada
    sumar(int a, int b)             |a = 10, b=20       |30
    sumar(int a, int b)             |a = 7, b=4         |11
    restar(int a, int b)            |a = 7, b=4         |3
    restar(int a, int b)            |a = 10, b=20       |-10
     */