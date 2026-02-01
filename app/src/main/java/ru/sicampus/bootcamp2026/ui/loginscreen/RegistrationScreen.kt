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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sicampus.bootcamp2026.R
import ru.sicampus.bootcamp2026.ui.loginscreen.components.EmailTextField
import ru.sicampus.bootcamp2026.ui.loginscreen.components.PasswordTextField
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme


@Composable
fun RegistrationScreen(
    OnBackButtonClick: () -> Unit,

    nameValue: String,
    OnNameValueChange: (String) -> Unit,

    loginValue: String,
    OnLoginValueChange: (String) -> Unit,

    firstPasswordValue: String,
    OnFirstPasswordChange: (String) -> Unit,

    secondPasswordValue: String,
    OnSecondPasswordChange: (String) -> Unit,

    showPassword: Boolean,
    ShowPasswordToggle: () -> Unit,

    validateEmail: Boolean,

    FocusDown: () -> Unit
){
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
                    text = stringResource(R.string.registration),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        Column(
            modifier = Modifier
                .imePadding()
                .verticalScroll(rememberScrollState())
        ) {
            OutlinedTextField(
                value = nameValue,
                onValueChange = { OnNameValueChange(it) },
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                    )
                    .width(320.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = stringResource(R.string.displayed_name),
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
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onAny = { FocusDown() }
                ),
            )

            EmailTextField(
                loginValue = loginValue,
                OnLoginValueChange = OnLoginValueChange,
                label = stringResource(R.string.enter_mail),
                imeAction = ImeAction.Next,
                OnImeClicked = { FocusDown() }
            )

            PasswordTextField(
                modifier = Modifier,
                passwordValue = firstPasswordValue,
                showPassword = showPassword,
                OnPasswordValueChange = { OnFirstPasswordChange(it) },
                ShowPasswordToggle = { ShowPasswordToggle() },
                label = stringResource(R.string.come_pu_with_password),
                imeAction = ImeAction.Next,
                OnImeNextClicked = { FocusDown() }
            )

            PasswordTextField(
                modifier = Modifier,
                passwordValue = secondPasswordValue,
                showPassword = showPassword,
                OnPasswordValueChange = { OnSecondPasswordChange(it) },
                ShowPasswordToggle = { ShowPasswordToggle() },
                label = stringResource(R.string.repeat_password),
                imeAction = ImeAction.Done,
                OnImeNextClicked = { FocusDown() }
            )

            Button(
                onClick = { },
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                        bottom = 32.dp
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
                enabled = firstPasswordValue.length >= 8 && secondPasswordValue.length >= 8 && (firstPasswordValue == secondPasswordValue) && validateEmail
            ) {
                Text(
                    text = stringResource(R.string.proceed),
                )
            }

        }
    }


}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun RegistartionScreenPreview() {
    AndroidBootcamp2026FrontendTheme {
        RegistrationScreen(
            firstPasswordValue = "",
            showPassword = false,
            OnFirstPasswordChange = { },
            ShowPasswordToggle = { },
            nameValue = "",
            OnNameValueChange = { },
            secondPasswordValue = "",
            OnSecondPasswordChange = { },
            loginValue = "",
            OnLoginValueChange = { },
            OnBackButtonClick = { },
            validateEmail = false,
            FocusDown = {}
        )
    }
}