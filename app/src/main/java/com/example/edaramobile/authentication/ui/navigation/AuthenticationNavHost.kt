package com.example.edaramobile.authentication.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.edaramobile.authentication.ui.screens.LoginScreen
import com.example.edaramobile.authentication.ui.screens.RegisterScreen
import com.example.edaramobile.authentication.ui.states.RegisterScreenUiState
import com.example.edaramobile.authentication.ui.viewmodels.AuthenticationViewModel

@Composable
fun AuthenticationNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {

    val viewModel: AuthenticationViewModel = viewModel()
    val loginScreenUiState = viewModel.loginScreenState.collectAsState()
    val registerScreenUiState = viewModel.registerScreenState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = AuthenticationRoutes.LOGIN_SCREEN.name,
        modifier = modifier
    ) {

        composable(
            AuthenticationRoutes.LOGIN_SCREEN.name
        ) {
            LoginScreen(
                state = loginScreenUiState.value,
                onUserNameChanged = { viewModel.updateUsernameInLoginScreen(it) },
                onPasswordChanged = { viewModel.updatePasswordInLoginScreen(it) },
                onKeepMeLoggedInClicked = { viewModel.updateIsKeepLoggedInInLoginScreen(it) },
                onForgetPasswordClicked = { /* navigate to forget password screens */ },
                onSignUpLinkClicked = { navController.navigate(AuthenticationRoutes.REGISTER_SCREEN.name) },
                onLoginButtonClicked = { viewModel.login() },
                modifier = Modifier.fillMaxSize().padding(24.dp)
            )
        }


        composable(
            AuthenticationRoutes.REGISTER_SCREEN.name
        ) {
            RegisterScreen(
                state = registerScreenUiState.value,
                onBackArrowClicked = { navController.navigateUp() },
                onFirstNameChanged = { viewModel.updateFirstNameInRegisterScreen(it) },
                onLastNameChanged = { viewModel.updateLastNameInRegisterScreen(it) },
                onUsernameChanged =  { viewModel.updateUsernameInRegisterScreen(it) },
                onPasswordChanged = { viewModel.updatePasswordInRegisterScreen(it) },
                onConfirmPasswordChanged = { viewModel.updateConfirmedPasswordInRegisterScreen(it) },
                onSignInLinkClicked = { navController.navigate(AuthenticationRoutes.LOGIN_SCREEN.name) },
                onCreateAccountButtonClicked = { viewModel.register() },
                modifier = Modifier.fillMaxSize().padding(24.dp)
            )
        }


    }
}