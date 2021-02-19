package com.example.parqueadero.controller

import com.example.parqueadero.`interface`.ParkingCommuication
import com.example.parqueadero.toDate
import java.util.*

class ParkingController(
        private val comunicaion: ParkingCommuication
) {

    private val carros = mutableMapOf<String, Long>()
    private var totalacumulado = 0L

    private fun fecha(): Long {
        return Date().time
    }


    fun registro(placa: String) {
        val fecha_entrada = fecha()
        if (placa.isNotEmpty()) {
            if (carros.containsKey(placa).not()) {
                if (carros.size < 5) {
                    carros[placa] = fecha_entrada
                    comunicaion.registroExitoso("Registro exitoso " + placa.toString() + " " + fecha_entrada.toDate())
                } else {
                    comunicaion.cupoLleno()
                }
            }
        } else {
            comunicaion.placaVacia()
        }
    }

    fun salida(placa: String) {
        val feSalida = fecha()
        if (placa.isNotEmpty()) {
            if (carros.containsKey(placa)) {
                val valor = (feSalida - carros[placa]!!) / 1000
                val valTotal = valor * 2000
                totalacumulado += valTotal
                carros.remove(placa)
                comunicaion.valTotal(valTotal.toString())
                comunicaion.totalAcomulado(totalacumulado.toString())
            } else {
                comunicaion.placaNoExiste()
            }
        } else {
            comunicaion.placaVacia()
        }
    }
}