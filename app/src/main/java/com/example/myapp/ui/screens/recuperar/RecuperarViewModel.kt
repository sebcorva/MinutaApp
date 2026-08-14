package com.example.myapp.ui.screens.recuperar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.myapp.ui.screens.register.RegisterViewModel

class RecuperarViewModel : ViewModel() {
    var email by mutableStateOf("")
        private set
    
    var nuevaPassword by mutableStateOf("")
        private set
    
    var pasoVerificacion by mutableStateOf(false)
        private set
    
    var mensaje by mutableStateOf("")
        private set

    fun onEmailChange(nuevoEmail: String) {
        email = nuevoEmail
        mensaje = ""
    }

    fun onPasswordChange(nueva: String) {
        nuevaPassword = nueva
        mensaje = ""
    }

    fun verificarCorreo() {
        val usuarioEncontrado = RegisterViewModel.usuariosRegistrados.find { it.email == email }
        if (usuarioEncontrado != null) {
            pasoVerificacion = true
            mensaje = "Correo verificado. Ingresa tu nueva contraseña."
        } else {
            mensaje = "El correo electrónico no está registrado."
        }
    }

    fun guardarNuevaPassword(onExito: () -> Unit) {
        if (nuevaPassword.isNotBlank()) {
            val indice = RegisterViewModel.usuariosRegistrados.indexOfFirst { it.email == email }
            if (indice != -1) {
                val usuarioActual = RegisterViewModel.usuariosRegistrados[indice]
                RegisterViewModel.usuariosRegistrados[indice] = usuarioActual.copy(password = nuevaPassword)
                onExito()
            } else {
                mensaje = "Error al actualizar. Intenta de nuevo."
            }
        } else {
            mensaje = "La contraseña no puede estar vacía."
        }
    }
}
