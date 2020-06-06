package junit5

import java.lang.ArithmeticException
import java.lang.Exception

class Calculator {

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
     */

    fun add(n1: Int, n2: Int): Int{
        return n1 + n2
    }

    fun subtract(n1: Int, n2: Int): Int{
        return n1 - n2
    }

    fun divide(n1: Int, n2: Int): Int{
        return n1/n2
    }

    fun divideByZero(n1: Int, n2: Int): Int{
        if(n2 == 0){
            throw ArithmeticException("No se puede dividir por cero")
        }
        return n1/n2
    }

    fun longTaskOperation(){
        try{
            Thread.sleep(1000)
        } catch (e: Exception){

        }
    }
}