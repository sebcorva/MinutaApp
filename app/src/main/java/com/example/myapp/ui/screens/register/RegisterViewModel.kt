package com.example.myapp.ui.screens.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myapp.data.model.Usuario

class RegisterViewModel : ViewModel() {
    var nombre by mutableStateOf("")
        private set
    
    var email by mutableStateOf("")
        private set
    
    var password by mutableStateOf("")
        private set
    
    var mensajeError by mutableStateOf("")
        private set

    // En una app real, usaríamos un Repositorio o Base de Datos.
    // Por ahora, usaremos una lista estática para simular persistencia.
    companion object {
        val usuariosRegistrados = mutableListOf<Usuario>()
    }

    fun onNombreChange(nuevoNombre: String) {
        nombre = nuevoNombre
        mensajeError = ""
    }

    fun onEmailChange(nuevoEmail: String) {
        email = nuevoEmail
        mensajeError = ""
    }

    fun onPasswordChange(nuevoPassword: String) {
        password = nuevoPassword
        mensajeError = ""
    }

    fun registrarUsuario(onExito: () -> Unit) {
        if (nombre.isNotBlank() && email.isNotBlank() && password.isNotBlank()) {
            if (usuariosRegistrados.any { it.email == email }) {
                mensajeError = "El correo ya está registrado"
            } else {
                val nuevoUsuario = Usuario(nombre, email, password)
                usuariosRegistrados.add(nuevoUsuario)
                onExito()
            }
        } else {
            mensajeError = "Por favor, completa todos los campos"
        }
    }
}
