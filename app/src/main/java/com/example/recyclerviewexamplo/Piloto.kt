package com.example.recyclerviewexamplo

//permite crear un modelo de datos sencillo, es necesario pasarle minimo un atributo
//ella se encarga de hacer los gets y los sets... y las funciones basicas de las clases

data class Piloto(
    val nombre:String,
    val dorsal:Int,
    val escuderia:String,
    val imagen:String
)
