package ru.sicampus.bootcamp2026

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun StartScreen(
    people_for_startscreen: List<Int> = listOf(R.drawable.people_start_1,
                                               R.drawable.people_start_2,
                                               R.drawable.people_start_3,
                                               R.drawable.people_start_4,
                                               R.drawable.people_start_5
    )
) {
    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
           horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(64.dp))
        Icon (
            painter = painterResource(R.drawable.logo_with_appname),
            contentDescription = "Logo",
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row (verticalAlignment = Alignment.CenterVertically){
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
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Нам доверяют команды по всему миру",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )




        
        //нижние кнопки
        Box(modifier = Modifier.fillMaxSize().size(200.dp)) {

            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier
                    .width(412.dp)
                    .height(412.dp)
                    .align (Alignment.BottomStart),
                tint = MaterialTheme.colorScheme.primaryContainer
                )

            Button(
                onClick = {},
                modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 92.dp)
                        .width(360.dp)
                        .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
            ) {
                Text(
                    text = "Зарегистрироваться"
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 32.dp)
                    .width(360.dp)
                    .height(52.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    contentColor = MaterialTheme.colorScheme.onPrimary
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
        StartScreen()
    }
}