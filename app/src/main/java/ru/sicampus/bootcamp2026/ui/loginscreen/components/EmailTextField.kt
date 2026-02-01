package ru.sicampus.bootcamp2026.ui.loginscreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.R

@Composable
fun EmailTextField(
    loginValue: String,
    OnLoginValueChange: (String) -> Unit,

    label: String,

    imeAction: ImeAction,
    OnImeClicked: () -> Unit
){
    OutlinedTextField(
        value = loginValue,
        onValueChange = {OnLoginValueChange(it)},
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
            keyboardType = KeyboardType.Email,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onAny = { OnImeClicked() }
        )


    )
}