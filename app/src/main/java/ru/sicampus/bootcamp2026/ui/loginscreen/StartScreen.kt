package ru.sicampus.bootcamp2026.ui.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sicampus.bootcamp2026.R
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    people_for_startscreen: List<Int> = listOf(
        R.drawable.people_start_1,
        R.drawable.people_start_2,
        R.drawable.people_start_3,
        R.drawable.people_start_4,
        R.drawable.people_start_5
    ),
    OnRegisterClick: () -> Unit,
    OnLoginClick: () -> Unit
) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Icon (
            painter = painterResource(R.drawable.logo_with_appname),
            contentDescription = "Logo",
            tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f)
        )
        Spacer(modifier = Modifier.height(40.dp))
        Row (verticalAlignment = Alignment.CenterVertically,
             horizontalArrangement = Arrangement.Center
        ){
            people_for_startscreen.forEachIndexed{ index, i ->
                Box(
                    modifier = Modifier.size(64.dp).clip(CircleShape)
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = i),
                        contentDescription = "people photo",
                        contentScale = ContentScale.Crop
                    )
                }
                if (index != people_for_startscreen.size - 1) {
                    Spacer(modifier = Modifier.width(12.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "Нам доверяют команды по всему миру",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )

        /* это надо каким то образом выделить по центру между иконкой и фотками
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text = "C нами встречи становятся легче!",
            modifier = Modifier.width(360.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        */

        //Нижние кнопки
        Box(modifier = Modifier.fillMaxSize().size(200.dp))
        {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier
                    .width(360.dp)
                    .height(360.dp)
                    .align (Alignment.BottomCenter)
                    .padding(bottom = 26.dp),
                tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)
            )

            Button(
                onClick = OnRegisterClick,
                modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 92.dp)
                        .width(360.dp)
                        .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            ) {
                Text(
                    text = "Зарегистрироваться"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(                                                // я бы сделал OutlinedButton или поменял цвет на
                onClick = OnLoginClick,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 32.dp)
                    .width(360.dp)
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,  // тут можно surfaceVariant
                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant            // а тут onSurfaceVariant
                )
            ) {
                Text(
                    text = "Войти"
                )
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    AndroidBootcamp2026FrontendTheme {
        StartScreen(
            OnLoginClick = {},
            OnRegisterClick = {}
        )
    }
}