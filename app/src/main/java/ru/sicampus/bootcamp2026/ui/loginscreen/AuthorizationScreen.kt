package ru.sicampus.bootcamp2026.ui.loginscreen

import androidx.compose.material3.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.R
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme


@Composable
fun AuthorizationScreen(
    loginValue: String,
    passwordValue: String,
    OnLoginChange: (String) -> Unit,
    OnPasswordChange: (String) -> Unit,
    OnRegisterClick: () -> Unit
){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Spacer(modifier = Modifier.height(32.dp))
        Icon (
            painter = painterResource(R.drawable.logo_with_appname),
            contentDescription = "Logo",
            tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)
        )
        Spacer(modifier = Modifier.height(163.dp))
        Column (modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .height(300.dp)
                .width(320.dp)
                .background(MaterialTheme.colorScheme.onSecondary) //лучше использовать SurfaceContainer цвет
                //.clip(RoundedCornerShape(20.dp))
                .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(16.dp)) //Добавь RoundedCornerShape к background модификатору
            //.clip(RoundedCornerShape(20.dp))
        ){
            Text(
                modifier = Modifier.padding(start = 24.dp, top = 24.dp ),
                text = "Логин"
            )

            OutlinedTextField(modifier = Modifier //нужно чтобы оба поля ввода были выше клавиатуры при ее открытии
                .width(292.dp)
                .padding(start = 24.dp),
                value = loginValue,
                onValueChange = {
                    OnLoginChange(it)
                },
                label = { Text(text = "Введите логин")} //сделай чтобы пароль был скрыт точками
            )
            Text(
                modifier = Modifier.padding(start = 24.dp, top = 16.dp ),
                text = "Пороль"
            )
            OutlinedTextField(modifier = Modifier
                .width(292.dp)
                .padding(start = 24.dp),
                value = passwordValue,
                onValueChange = {
                    OnPasswordChange(it)
                },
                label = { Text(text = "Введите пороль") }
            )
            Button(onClick = {},
                modifier = Modifier
                    .padding(top = 24.dp, start = 24.dp)
                    .width(272.dp)
                    .height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ){
                Text(
                    text = "Войти"
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row() {
            Text(
                text = "Нет аккаунта?"
            )
            Spacer(Modifier.width(4.dp))
            Text(
                modifier = Modifier.clickable(
                    enabled = true,
                    onClickLabel = "Войти",
                    onClick = {
                        OnRegisterClick()
                    }
                ),
                text = "Зарегистрироваться",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun previewAuthorization(){
    AndroidBootcamp2026FrontendTheme() {
        AuthorizationScreen(
            loginValue = "",
            passwordValue = "",
            OnLoginChange = { },
            OnPasswordChange = { },
            OnRegisterClick = {}
        )
    }
}