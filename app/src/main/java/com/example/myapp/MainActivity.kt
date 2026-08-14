package com.example.myapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp.ui.screens.login.LoginScreen
import com.example.myapp.ui.screens.register.RegisterScreen
import com.example.myapp.ui.screens.recuperar.RecuperarScreen
import com.example.myapp.ui.screens.minuta.MinutaScreen
import com.example.myapp.ui.theme.MyAppTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyAppTheme {
                val navController = rememberNavController()
                
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") {
                        LoginScreen(
                            onLoginSuccess = {
                                navController.navigate("minuta") {
                                    popUpTo("login") { inclusive = true }
                                }
                            },
                            onNavigateToRegister = {
                                Log.d("NAVEGACION", "Yendo a registro")
                                navController.navigate("register")
                            },
                            onNavigateToForgotPassword = {
                                navController.navigate("recuperar")
                            }
                        )
                    }
                    composable("register") {
                        RegisterScreen(
                            onNavigateBack = {
                                navController.popBackStack()
                            },
                            onRegisterSuccess = {
                                navController.popBackStack() // Volver al login tras el registro
                            }
                        )
                    }
                    composable("recuperar") {
                        RecuperarScreen(
                            onNavigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                    composable("minuta") {
                        MinutaScreen(
                            onLogout = {
                                navController.navigate("login") {
                                    popUpTo("minuta") { inclusive = true }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    MyAppTheme {
        LoginScreen(
            onLoginSuccess = {},
            onNavigateToRegister = {},
            onNavigateToForgotPassword = {}
        )
    }
}