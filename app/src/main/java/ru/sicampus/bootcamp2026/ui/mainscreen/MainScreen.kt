package ru.sicampus.bootcamp2026.ui.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import ru.sicampus.bootcamp2026.R
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun mainScreen(){
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painterResource(id = R.drawable.logo_with_appname),
                contentDescription = "Logo",
                tint = MaterialTheme.colorScheme.primary.copy(0.8f)
            )
        }
        Text(
            modifier = Modifier
            .padding(start = 16.dp, top = 16.dp),
            text = "Активные встречи:",
            textAlign = TextAlign.Start,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
        )
        //Димон, я даже наколхозить не могу, уменьши растояние между ними, чтобы снизу не появилось белой темы

        //основной бокс с информацией
        Box(modifier = Modifier
            
            .zIndex(0f)
            .fillMaxWidth()
            .weight(1f)
            .offset(y = 30.dp)
            .clip(shape = RoundedCornerShape(
                topEnd = 30.dp,
                topStart = 30.dp
            ))
            .background(MaterialTheme.colorScheme.secondaryContainer)
        ){
            //заготовка под отображение, надо еще скрол сделать
            Row(){
                Column(modifier = Modifier.padding(start = 24.dp)) {
                    Text(
                        modifier = Modifier
                            .padding(top = 16.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        text = "Название встречи (время)",
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 12.dp),
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        text = "Описание встречи"

                    )
                }
                //Тут должен быть тумблек
            }
        }

        //Spacer(modifier = Modifier.weight(1f))

        //Нижняя менюшка
        Row(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    topStart = 30.dp
                ))
                .background(color = MaterialTheme.colorScheme.surfaceVariant),
            verticalAlignment = Alignment.CenterVertically

        ){
            Icon( // кнопка для настроек профиля
                painterResource(id = R.drawable.ic_profile_circle),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground,

                modifier = Modifier
                    .padding(start = 24.dp)
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Button( //кнопка для добавления новой активности
                onClick = {},
                modifier = Modifier
                    .width(80.dp)
                    .height(40.dp)
            ) {
                Text (
                    text = "+",
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Icon( // кнопка для настроек
                painterResource(id = R.drawable.ic_settings_circle),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .padding(end = 24.dp)
                    .size(30.dp)
            )
        }
    }
}






@Preview(showBackground = true)
@Composable
fun previewMainScreen(){
    AndroidBootcamp2026FrontendTheme() {
        mainScreen()
    }
}