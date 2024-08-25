package com.example.edaramobile.authentication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.edaramobile.authentication.ui.screens.LoginScreen
import com.example.edaramobile.authentication.ui.screens.RegisterScreen
import com.example.edaramobile.authentication.ui.states.LoginScreenUiState
import com.example.edaramobile.authentication.ui.states.RegisterScreenUiState

@Composable
fun AuthenticationNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AuthenticationRoutes.LOGIN_SCREEN.name,
        modifier = modifier
    ) {

        composable(
            AuthenticationRoutes.LOGIN_SCREEN.name
        ) {
            LoginScreen(state = LoginScreenUiState())
        }


        composable(
            AuthenticationRoutes.REGISTER_SCREEN.name
        ) {
            RegisterScreen(state = RegisterScreenUiState())
        }


    }
}