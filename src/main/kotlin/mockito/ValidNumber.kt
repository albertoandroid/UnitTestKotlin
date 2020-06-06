package mockito

import java.lang.ArithmeticException

class ValidNumber {
    fun check(o: Any?): Boolean{
        return if(o is Int){
            o in 0..9
        }else{
            false
        }
    }

    fun checkZero(o: Any?): Boolean{
        return if(o is Int){
            if(o == 0){
                throw ArithmeticException("No podemos aceptar cero")
            } else {
                true
            }
        } else{
            false
        }
    }

    fun doubleToIn(o: Any?): Int{
        return if(o is Double){
            o.toInt()
        } else {
            0
        }
    }
}