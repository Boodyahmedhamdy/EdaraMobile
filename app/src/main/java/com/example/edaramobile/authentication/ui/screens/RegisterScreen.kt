package com.example.edaramobile.authentication.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.edaramobile.authentication.ui.states.RegisterScreenUiState

@Composable
fun RegisterScreen(
    state: RegisterScreenUiState,
    modifier: Modifier = Modifier
) {
    PlaceHolderScreen(title = "Register Screen", modifier = modifier)

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(
        RegisterScreenUiState(),
        modifier = Modifier.fillMaxSize()
    )
}