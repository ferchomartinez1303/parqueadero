package com.example.parqueadero

import java.text.SimpleDateFormat
import java.util.*

const val FORMATO_FECHA="dd/MM/yyyy hh:mm:ss.SSS"

fun Long.toDate(): String {
    val sdf=SimpleDateFormat(FORMATO_FECHA,Locale.getDefault())
    return sdf.format(Date(this))
}