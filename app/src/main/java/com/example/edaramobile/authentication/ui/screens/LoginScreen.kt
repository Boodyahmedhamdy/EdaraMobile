package com.example.edaramobile.authentication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DoorFront
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.edaramobile.R
import com.example.edaramobile.authentication.ui.components.PasswordEntryTextField
import com.example.edaramobile.authentication.ui.components.TextEntryTextField
import com.example.edaramobile.authentication.ui.states.LoginScreenUiState
import com.example.edaramobile.authentication.utils.extensions.Constants

@Composable
fun LoginScreen(
    state: LoginScreenUiState,
    modifier: Modifier = Modifier,
    onUserNameChanged: (newUsername: String) -> Unit = {},
    onPasswordChanged: (newPassword: String) -> Unit = {},
    onForgetPasswordClicked: () -> Unit = {},
    onKeepMeLoggedInClicked: (isLoggedIn: Boolean) -> Unit = {},
    onSignUpLinkClicked: () -> Unit = {},
    onLoginButtonClicked: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        // icon
        Icon(
            imageVector = Icons.Outlined.DoorFront,
            contentDescription = "logo",
            modifier = Modifier.size(40.dp)
        )

        // welcome message
        Text(
            text = stringResource(R.string.welcome_back_we_wish_you_a_day_of_happiness_and_luck)
        )

        // username field
        TextEntryTextField(
            modifier = Modifier.fillMaxWidth(),
            labelString = "Username",
            value = state.username,
            onValueChanged = {
                onUserNameChanged(it)
            },
            leadingIcon = { Icon(Icons.Outlined.Person, contentDescription = "") },
            suffixText = Constants.SUFFIX_USERNAME
        )
        // username error
        Text(
            state.usernameErrorMessage,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        // password field
        PasswordEntryTextField(
            modifier = Modifier.fillMaxWidth(),
            labelText = "Password",
            value = state.password,
            onValueChanged = {
                onPasswordChanged(it)
            }
        )
        // password error
        Text(
            state.passwordErrorMessage,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        // forget password
        Text(
            text = "forget Password",
            textDecoration = TextDecoration.Underline,
            color = Color.Blue,
            textAlign = TextAlign.Start,
            fontSize = 18.sp,
            modifier = Modifier
                .clickable { onForgetPasswordClicked() }
                .fillMaxWidth()
        )

        // keep logged in option ?
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = state.isKeepLoggedIn, onCheckedChange = {
                    onKeepMeLoggedInClicked(it)
                }
            )
            Text("Keep Me Logged in", style = MaterialTheme.typography.bodyMedium)
        }


        // register go to
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Don't have account ?")
            Text(text = "Sign up",
                color = Color.Blue,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable { onSignUpLinkClicked() }
            )
        }

        // Login button
        Button(
            onClick = { onLoginButtonClicked() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun LoginScreenPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        LoginScreen(
            state = LoginScreenUiState(
                username = "boody",
                usernameErrorMessage = "invalid username",
                passwordErrorMessage = "Invalid password"
            ),
            modifier = Modifier.fillMaxSize()
        )
    }
}
