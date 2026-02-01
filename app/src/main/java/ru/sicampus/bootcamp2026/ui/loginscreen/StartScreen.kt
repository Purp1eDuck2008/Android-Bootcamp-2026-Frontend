package ru.sicampus.bootcamp2026.ui.loginscreen


import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.R
import ru.sicampus.bootcamp2026.ui.loginscreen.components.EmailTextField
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    OnLoginValueChange: (String) -> Unit,
    OnProceedClick: () -> Unit,
    loginValue: String,
    validateEmail: Boolean,
    OnRegisterClick: () -> Unit
) {

        Column(modifier = Modifier

            .clip(
                RoundedCornerShape(
                    topEnd = 32.dp,
                    topStart = 32.dp
                )
            )
            .fillMaxWidth()
            .height(480.dp)
            .background(color = MaterialTheme.colorScheme.primary),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                modifier = Modifier.padding(top = 24.dp),
                painter = painterResource(R.drawable.logo_with_appname),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.9f),
            )

            EmailTextField(
                loginValue = loginValue,
                OnLoginValueChange = OnLoginValueChange,
                label = stringResource(R.string.enter_mail),
                imeAction = ImeAction.Next,
                OnImeClicked = { OnProceedClick() }
            )

            Button(
                onClick = { OnProceedClick() },
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                    )
                    .height(52.dp)
                    .width(320.dp),
                shape = RoundedCornerShape(16.dp),
                enabled = validateEmail,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    contentColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    disabledContentColor = MaterialTheme.colorScheme.onSecondary
                )
            ) {
                Text(
                    text = stringResource(R.string.proceed),
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(320.dp)
                    .padding(top = 12.dp)
            ) {
                Divider(
                    modifier = Modifier.weight(1f),
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = stringResource(R.string.or),
                    modifier = Modifier.padding(horizontal = 12.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                Divider(
                    modifier = Modifier.weight(1f),
                    color = MaterialTheme.colorScheme.secondary
                )
            }

            Button(
                onClick = {  },
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                    )
                    .height(52.dp)
                    .width(320.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(R.drawable.ic_google),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = stringResource(R.string.login_with_google),
                    )
                }
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                    )
                    .height(52.dp)
                    .width(320.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painterResource(R.drawable.ic_apple),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp),
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = stringResource(R.string.login_with_apple),
                    )
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))

            Row(
                Modifier.padding(horizontal = 12.dp)
            ){
                Text(
                    text = stringResource(R.string.no_account),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                )

                Spacer(Modifier.width(8.dp))

                Text(
                    text = stringResource(R.string.go_register),
                    modifier = Modifier.clickable(
                        enabled = true,
                        onClickLabel = null,
                        onClick = {
                            OnRegisterClick()
                        }
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    textDecoration = TextDecoration.Underline,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                )
            }

        }

}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun StartScreenPreview2() {
    AndroidBootcamp2026FrontendTheme {
        StartScreen(
            modifier = Modifier,
            OnLoginValueChange = { },
            loginValue = "",
            validateEmail = false,
            OnProceedClick = { },
            OnRegisterClick = { }
        )
    }
}