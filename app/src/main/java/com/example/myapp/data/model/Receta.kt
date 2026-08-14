package com.example.myapp.data.model

data class Receta(
    val diaSemana: String,
    val categoria: String,
    val titulo: String,
    val ingredientes: List<String>,
    val instrucciones: String,
    val consejoNutricional: String,
)
