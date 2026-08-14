package com.example.myapp.ui.screens.minuta

import androidx.lifecycle.ViewModel
import com.example.myapp.data.model.Receta

class MinutaViewModel : ViewModel() {
    val recetas: List<Receta> = listOf(
        Receta(
            diaSemana = "Lunes",
            categoria = "Almuerzo",
            titulo = "Ensalada César con Pollo",
            ingredientes = listOf("Pechuga de pollo", "Lechuga romana", "Crutones", "Queso parmesano", "Aderezo César"),
            instrucciones = "Cocina el pollo a la plancha, corta la lechuga y mezcla todo con el aderezo y el queso.",
            consejoNutricional = "Usa yogur griego para el aderezo para reducir calorías y aumentar la proteína."
        ),
        Receta(
            diaSemana = "Martes",
            categoria = "Cena",
            titulo = "Salmón al Horno con Espárragos",
            ingredientes = listOf("Filete de salmón", "Espárragos", "Limón", "Aceite de oliva", "Ajo"),
            instrucciones = "Hornea el salmón y los espárragos a 200°C por 15-20 minutos con limón y ajo.",
            consejoNutricional = "El salmón es una excelente fuente de omega-3, esencial para la salud del corazón."
        ),
        Receta(
            diaSemana = "Miércoles",
            categoria = "Almuerzo",
            titulo = "Bowl de Quinoa y Vegetales",
            ingredientes = listOf("Quinoa cocida", "Garbanzos", "Espinacas", "Palta", "Tahini"),
            instrucciones = "Mezcla la quinoa con los vegetales y añade los garbanzos y el aderezo de tahini.",
            consejoNutricional = "La quinoa es una proteína completa que contiene los nueve aminoácidos esenciales."
        ),
        Receta(
            diaSemana = "Jueves",
            categoria = "Almuerzo",
            titulo = "Tacos de Pavo con Mango",
            ingredientes = listOf("Carne molida de pavo", "Tortillas de maíz", "Mango", "Cebolla morada", "Cilantro"),
            instrucciones = "Cocina el pavo con especias. Prepara una salsa picando el mango, la cebolla y el cilantro. Sirve en tortillas.",
            consejoNutricional = "El pavo es una carne magra muy alta en proteínas y baja en grasas saturadas."
        ),
        Receta(
            diaSemana = "Viernes",
            categoria = "Almuerzo",
            titulo = "Pasta Integral con Pesto de Albahaca",
            ingredientes = listOf("Pasta integral", "Albahaca fresca", "Nueces", "Aceite de oliva", "Ajo"),
            instrucciones = "Cocina la pasta. Tritura la albahaca con nueces, ajo y aceite para el pesto. Mezcla y sirve.",
            consejoNutricional = "La pasta integral aporta más fibra, lo que ayuda a mantener la saciedad por más tiempo."
        )
    )
}
