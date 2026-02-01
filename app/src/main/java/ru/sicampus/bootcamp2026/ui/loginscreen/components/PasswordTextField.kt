package ru.sicampus.bootcamp2026.ui.loginscreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    passwordValue: String,
    showPassword: Boolean,
    OnPasswordValueChange: (String) -> Unit,
    ShowPasswordToggle: () -> Unit,

    label: String,

    imeAction: ImeAction,
    OnImeNextClicked: () -> Unit
){
    OutlinedTextField(
        value = passwordValue,
        onValueChange = {OnPasswordValueChange(it)},
        modifier = Modifier
            .padding(
                top = 16.dp,
            )
            .width(320.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        label = {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.secondary
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
            focusedLabelColor = MaterialTheme.colorScheme.secondary,
            unfocusedLabelColor = MaterialTheme.colorScheme.secondary
        ),
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onNext = { OnImeNextClicked() }
        ),
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (showPassword)
                Icons.Filled.Visibility
            else
                Icons.Filled.VisibilityOff

            IconButton(onClick = { ShowPasswordToggle() }) {
                Icon(imageVector = image,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
        }
    )
}