package ru.sicampus.bootcamp2026.ui.loginscreen


import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sicampus.bootcamp2026.R
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun AuthorizationScreen(
    modifier: Modifier = Modifier,
    enteredEmail: String,
    OnBackButtonClick:() -> Unit,
    OnPasswordValueChange:(String) -> Unit,
    passwordValue: String,
    showPassword: Boolean,
    ShowPasswordToggle: () -> Unit
) {
    
        Column(
            modifier = Modifier

                .clip(
                    RoundedCornerShape(
                        topEnd = 32.dp,
                        topStart = 32.dp
                    )
                )
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.primary),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
               // modifier = Modifier.padding(top = 16.dp),
                painterResource(R.drawable.logo_with_hole),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .padding(
                        top = 28.dp,
                        bottom = 16.dp
                    )
                    .height(32.dp)
              )
            Row(
                //horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_backangel),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier
                            .clickable(
                                enabled = true,
                                onClickLabel = null,
                                onClick = { OnBackButtonClick() }
                            )
                            .align(Alignment.CenterStart)
                            .padding(start = 16.dp)
                            .size(32.dp)
                    )

                    Text(
                        fontSize = 24.sp,
                        text = stringResource(R.string.authorization),
                        color = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
            Text(
                text = enteredEmail,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier
                    .padding(top = 24.dp)
            )
            OutlinedTextField(
                value = passwordValue,
                onValueChange = {OnPasswordValueChange(it)},
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                    )
                    .width(320.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = stringResource(R.string.password),
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
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (showPassword)
                        Icons.Filled.Visibility
                    else
                        Icons.Filled.VisibilityOff

                    IconButton(onClick = { ShowPasswordToggle() }) {
                        Icon(imageVector = image, contentDescription = null)
                    }
                }
            )
            Button(
                onClick = { },
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                    )
                    .height(52.dp)
                    .width(320.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    contentColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    disabledContentColor = MaterialTheme.colorScheme.onSecondary
                ),
                enabled = passwordValue.length >= 8
            ) {
                Text(
                    text = stringResource(R.string.proceed),
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 32.dp)

            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = stringResource(R.string.restore_password),
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(bottom = 32.dp)
                )
            }

        }
    }

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun AuthorizationScreenPreview() {
    AndroidBootcamp2026FrontendTheme {
        AuthorizationScreen(
            enteredEmail = "test@mail.com",
            OnBackButtonClick = {},
            OnPasswordValueChange = {},
            passwordValue = "",
            ShowPasswordToggle = {},
            showPassword = true
        )
    }
}