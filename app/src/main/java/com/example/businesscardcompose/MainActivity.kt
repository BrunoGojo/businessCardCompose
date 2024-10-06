package com.example.businesscardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.businesscardcompose.ui.theme.BusinessCardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardComposeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    composable(route = "login") {
                        EntradaDados(navController = navController)
                    }
                    composable(
                        route = "BusinessCard?name={name}&title={title}&cellphone={cellphone}&instagram={instagram}&email={email}&imageUri={imageUri}"
                    ) { backStackEntry ->
                        val name = backStackEntry.arguments?.getString("name") ?: ""
                        val title = backStackEntry.arguments?.getString("title") ?: ""
                        val cellphone = backStackEntry.arguments?.getString("cellphone") ?: ""
                        val instagram = backStackEntry.arguments?.getString("instagram") ?: ""
                        val email = backStackEntry.arguments?.getString("email") ?: ""
                        val imageUri = backStackEntry.arguments?.getString("imageUri")


                        // Passa os dados para a tela BusinessCardScreen
                        BusinessCardScreen(
                            fullname = name,
                            title = title,
                            cellphone = cellphone,
                            instagram = instagram,
                            email = email,
                            imageUri = imageUri
                        )
                    }
                }
            }
        }
    }
}
