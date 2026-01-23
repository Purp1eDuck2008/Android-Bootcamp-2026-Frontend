package ru.sicampus.bootcamp2026

import androidx.compose.material3.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme


@Composable
fun Authorization(){


    Column(modifier = Modifier.fillMaxSize()
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
            modifier = Modifier.height(300.dp)
                .width(320.dp)
                .background(MaterialTheme.colorScheme.onSecondary)
                //.clip(RoundedCornerShape(20.dp))
                .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(8.dp))
            //.clip(RoundedCornerShape(20.dp))
        ){
            Text(
                modifier = Modifier.padding(start = 24.dp, top = 24.dp ),
                text = "Логин"
            )

            OutlinedTextField(modifier = Modifier
                .width(292.dp)
                .padding(start = 24.dp),
                value = "",
                onValueChange = {},
                label = { Text(text = "Введите логин")}
            )
            Text(
                modifier = Modifier.padding(start = 24.dp, top = 16.dp ),
                text = "Пороль"
            )
            OutlinedTextField(modifier = Modifier
                .width(292.dp)
                .padding(start = 24.dp),
                value = "",
                onValueChange = {},
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
        Row() {
            Text(
                text = "Нет аккаунта?"
            )
            Button(
                modifier = Modifier.width(200.dp).height(32.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = "Регистрация"
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun previewAuthorization(){
    AndroidBootcamp2026FrontendTheme() {
        Authorization()
    }
}