package ru.sicampus.bootcamp2026.ui.loginscreen

import androidx.compose.material3.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.R
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme


@Composable
fun RegistrationScreen(
    loginValue: String,
    passwordValue: String,
    OnLoginChange: (String) -> Unit,
    OnPasswordChange: (String) -> Unit,
    OnloginClick: () -> Unit
){


    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
           horizontalAlignment = Alignment.CenterHorizontally
            )
    {
        Spacer(modifier = Modifier.height(64.dp))
        Icon (
            painter = painterResource(R.drawable.logo_with_appname),
            contentDescription = "Logo",
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(163.dp))
        Column (
            modifier = Modifier
                .height(300.dp)
                .width(320.dp)
                .background(MaterialTheme.colorScheme.onSecondary)  //лучше использовать SurfaceContainer цвет
                //.clip(RoundedCornerShape(20.dp))
                .border(
                    1.dp,
                    MaterialTheme.colorScheme.outline,
                    RoundedCornerShape(8.dp)
                )
                //.clip(RoundedCornerShape(20.dp))
        ){
            Text(
                modifier = Modifier.padding(start = 24.dp, top = 24.dp ),
                text = "Логин"
            )

            OutlinedTextField(modifier = Modifier   //нужно чтобы оба поля ввода были выше клавиатуры при ее открытии
                .width(292.dp)
                .padding(start = 24.dp),
                value = loginValue,
                onValueChange = {
                    OnLoginChange(it)
                },
                label = { Text(text = "Введите логин")}
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
                label = { Text(text = "Введите пороль") } //сделай чтобы пароль был скрыт точками
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
                    text = "Зарегистрироваться"
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Уже есть аккаунт?"
            )
            Spacer(Modifier.width(8.dp))
            Text(
                modifier = Modifier.clickable(
                    enabled = true,
                    onClickLabel = "Войти",
                    onClick = {
                        OnloginClick()
                    }
                ),
                text = "Войти",
                color = MaterialTheme.colorScheme.primary
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun preiewRegistraition(){
    AndroidBootcamp2026FrontendTheme() {
        RegistrationScreen(
            loginValue = "",
            passwordValue = "",
            OnLoginChange = {},
            OnPasswordChange = {},
            OnloginClick = {}
        )
    }
}