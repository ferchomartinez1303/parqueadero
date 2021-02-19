package com.example.parqueadero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.parqueadero.`interface`.ParkingCommuication
import com.example.parqueadero.controller.ParkingController
import com.example.parqueadero.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity(), ParkingCommuication {

    private lateinit var binding: ActivityMainBinding
    private val controller: ParkingController = ParkingController(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registro()
        salida()
    }

    private fun registro() {
        binding.btnIngreso.setOnClickListener {
            controller.registro(binding.inPlaca.text.toString())
        }
    }

    private fun salida() {
        binding.btnCobrar.setOnClickListener {
            controller.salida(binding.salPlaca.text.toString())
        }
    }

    override fun registroExitoso(valor: String) {
        binding.horaIngreso.text=valor
    }

    override fun cupoLleno() {
        Toast.makeText(this, "Cupo lleno", Toast.LENGTH_SHORT).show()
    }

    override fun placaVacia() {
        Toast.makeText(this, "La placa no puede estar vacia", Toast.LENGTH_SHORT).show()
    }

    override fun valTotal(valor: String) {
        binding.total1.text= valor
    }

    override fun totalAcomulado(valor: String) {
        binding.total2.text= valor
    }

    override fun placaNoExiste() {
        Toast.makeText(this, "La placa no existe", Toast.LENGTH_SHORT).show()
    }
}


