package com.fazra.coetus.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object AppRoutes {
    const val HOME = "home"
    const val LOGIN = "login"
    const val REGISTER = "register"
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppRoutes.LOGIN
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(AppRoutes.LOGIN) {
            // LoginScreen(
            //     onLoginSuccess = {
            //         navController.navigate(AppRoutes.HOME) {
            //             popUpTo(AppRoutes.LOGIN) {
            //                 inclusive = true
            //             }
            //         }
            //     },
            //     onRegisterClick = {
            //         navController.navigate(AppRoutes.REGISTER)
            //     }
            // )
        }

        composable(AppRoutes.REGISTER) {
            // RegisterScreen()
        }

        composable(AppRoutes.HOME) {
            // HomeScreen()
        }
    }
}
