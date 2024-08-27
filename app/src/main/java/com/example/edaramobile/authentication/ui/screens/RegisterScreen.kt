package com.example.edaramobile.authentication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.edaramobile.authentication.ui.components.PasswordEntryTextField
import com.example.edaramobile.authentication.ui.components.TextEntryTextField
import com.example.edaramobile.authentication.ui.states.RegisterScreenUiState
import com.example.edaramobile.authentication.utils.extensions.Constants

@Composable
fun RegisterScreen(
    state: RegisterScreenUiState,
    modifier: Modifier = Modifier,
    onBackArrowClicked: () -> Unit = {},
    onFirstNameChanged: (String) -> Unit = {},
    onLastNameChanged: (String) -> Unit = {},
    onUsernameChanged: (String) -> Unit = {},
    onPasswordChanged: (String) -> Unit = {},
    onConfirmPasswordChanged: (String) -> Unit = {},
    onSignInLinkClicked: () -> Unit = {},
    onCreateAccountButtonClicked: () -> Unit = {}
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // logo
        Icon(
            imageVector = Icons.Outlined.Timer,
            contentDescription = "",
            modifier = Modifier.size(40.dp)
        )

        // title and back button
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // back icon
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = "",
                modifier = Modifier.clickable { onBackArrowClicked() }
            )

            // title
            Text(
                text = "Create Account",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            )
        }

        // first name and last name
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            // firstname
            TextEntryTextField(
                value = state.firstName,
                onValueChanged = { onFirstNameChanged(it) },
                labelString = "First Name",
                modifier = Modifier
                    .weight(1f)

            )
            Spacer(modifier = Modifier.width(16.dp))
            // lastname
            TextEntryTextField(
                value = state.lastName,
                onValueChanged = { onLastNameChanged(it) },
                labelString = "Last Name",
                modifier = Modifier
                    .weight(1f)
            )
        }

        // username
        TextEntryTextField(
            value = state.username,
            onValueChanged = { onUsernameChanged(it) },
            labelString = "Username",
            leadingIcon = { Icon(imageVector = Icons.Outlined.Person, contentDescription = "") },
            suffixText = Constants.SUFFIX_USERNAME
        )

        // password
        PasswordEntryTextField(
            value = state.password,
            onValueChanged = { onPasswordChanged(it) },
            labelText = "Password"
        )
        //  password error
        Text(text = state.passwordErrorMessage, color = MaterialTheme.colorScheme.error)


        // confirm password
        PasswordEntryTextField(
            value = state.confirmedPassword,
            onValueChanged = { onConfirmPasswordChanged(it) },
            labelText = "Confirm Password"
        )
        //  password error
        Text(text = state.confirmedPasswordErrorMessage, color = MaterialTheme.colorScheme.error)

        // sign in link
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("already have account? ")
            Text(
                "Sign in",
                textDecoration = TextDecoration.Underline,
                color = Color.Blue,
                modifier = Modifier.clickable { onSignInLinkClicked() }
            )
        }

        // create account button
        Button(
            onClick = { onCreateAccountButtonClicked() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create Account")
        }

        // general error
        Text(text = state.generalErrorMessage, color = MaterialTheme.colorScheme.error)
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(
        RegisterScreenUiState(
            passwordErrorMessage = "invalid password"
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
}