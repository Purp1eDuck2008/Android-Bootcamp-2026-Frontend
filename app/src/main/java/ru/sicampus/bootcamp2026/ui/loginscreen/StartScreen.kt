package ru.sicampus.bootcamp2026.ui.loginscreen


import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.R
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    OnRegisterClick: () -> Unit,
    OnLoginClick: () -> Unit
) {
    Box(modifier = modifier
        .fillMaxSize()
        .background(
            brush = Brush.linearGradient(
                colors = listOf( //Заменить на значения из колор хмл
                    Color(color = 0xFF5B22BF),
                    Color(color = 0xFF7624AA)
                )
            )
        ),
    ) {
        Column(modifier = Modifier
            .align(Alignment.BottomCenter)
            .clip(RoundedCornerShape(
                topEnd = 32.dp,
                topStart = 32.dp
                )
            )
            .fillMaxWidth()
            .height(500.dp)
            .background(color = MaterialTheme.colorScheme.primary),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                modifier = Modifier.padding(top = 24.dp),
                painter = painterResource(R.drawable.logo_with_appname),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.9f),
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                    )
                    .width(320.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = "Введите ваш email",
                        color = MaterialTheme.colorScheme.secondary
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.secondary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                    focusedLabelColor = MaterialTheme.colorScheme.secondary,
                    unfocusedLabelColor = MaterialTheme.colorScheme.secondary
                ),
                singleLine = true
            )
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
                    containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                )
            ) {
                Text(
                    text = "Продолжить",
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
                    text = "или",
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
                        text = "Войти через Google",
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
                        text = "Войти через Apple",
                    )
                }
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "Проблемы со входом?",
                modifier = Modifier.padding(horizontal = 12.dp),
                style = MaterialTheme.typography.bodyMedium,
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
            OnLoginClick = {},
            OnRegisterClick = {}

        )
    }
}