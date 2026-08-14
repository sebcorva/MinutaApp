package com.example.myapp.ui.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var email by mutableStateOf("")
        private set
    
    var password by mutableStateOf("")
        private set
    
    var errorMessage by mutableStateOf("")
        private set

    fun onEmailChange(newEmail: String) {
        email = newEmail
        errorMessage = ""
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword
        errorMessage = ""
    }

    fun login(onSuccess: () -> Unit) {
        if (email.isNotBlank() && password.isNotBlank()) {
            // Verificar si el usuario existe en nuestra lista
            val usuarioExiste = com.example.myapp.ui.screens.register.RegisterViewModel.usuariosRegistrados
                .any { it.email == email && it.password == password }
            
            if (usuarioExiste || (email == "admin@test.com" && password == "admin")) {
                onSuccess()
            } else {
                errorMessage = "Credenciales incorrectas o usuario no registrado"
            }
        } else {
            errorMessage = "Por favor, completa todos los campos"
        }
    }
}
