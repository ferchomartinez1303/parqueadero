package com.example.parqueadero.`interface`

interface ParkingCommuication {

    fun registroExitoso(valor:String)
    fun cupoLleno()
    fun placaVacia()
    fun valTotal(valor:String)
    fun totalAcomulado(valor:String)
    fun placaNoExiste()

}