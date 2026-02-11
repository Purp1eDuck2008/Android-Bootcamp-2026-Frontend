package ru.sicampus.bootcamp2026.ui.mainscreen.components.subscreens.profilescreen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BorderColor
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.sicampus.bootcamp2026.R
import ru.sicampus.bootcamp2026.ui.mainscreen.components.subscreens.profilescreen.components.EditableTextField
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun ProfileScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Профиль",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    color = MaterialTheme.colorScheme.outlineVariant,
                    thickness = 1.dp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(128.dp)
                    //.background(Color.Gray, RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(24.dp))
            ) {
                Icon(
                    painter = painterResource(R.drawable.profile_scrap),
                    contentDescription = "",
                    tint = Color.Unspecified,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Box(
                modifier = Modifier
                    .offset(
                        y = -40.dp,
                        x = 48.dp
                    )
                    .clip(RoundedCornerShape(64.dp))
                    .background(MaterialTheme.colorScheme.onSecondaryContainer)
                    .size(48.dp),
                contentAlignment = Alignment.Center

            ) {
                Icon(
                    painterResource(R.drawable.ic_camera),
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier
                        .size(36.dp),
                )
            }
            EditableTextField(
                singleLine = true,
                onValueChange = {},
                value = "Казак Дмитрий Владимирович",
                label = "ФИО"
            ) { }
            EditableTextField(
                singleLine = false,
                onValueChange = {},
                value = "Фиолетовый шёпот треугольного сапога в разрезе синхрофазотрона",
                label = "Описание"
            ) { }
            EditableTextField(
                singleLine = true,
                onValueChange = {},
                value = "test@email.com",
                label = "Email"
            ) { }
            EditableTextField(
                singleLine = true,
                onValueChange = {},
                value = "+7 902 614 3620",
                label = "Номер телефона"
            ) { }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .weight(1f)
                            .height(52.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.6f),
                            contentColor = MaterialTheme.colorScheme.error
                        )
                    ) {
                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(
                                imageVector = Icons.Default.ExitToApp,
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(end = 6.dp)
                                    .offset(y = -2.dp)
                                    .rotate(180f)
                            )
                            Text(text = "Выйти")
                        }
                    }
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .weight(1f)
                            .height(52.dp),
                        shape = RoundedCornerShape(16.dp),
                        enabled = false,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            contentColor = MaterialTheme.colorScheme.primary,
                            disabledContainerColor = MaterialTheme.colorScheme.onSecondaryContainer,
                            disabledContentColor = MaterialTheme.colorScheme.onSecondary
                        )
                    ) {
                        Text(text = "Сохранить")
                    }
                }
            }

        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
    )
@Composable
fun ProfileScreenPreview() {
    AndroidBootcamp2026FrontendTheme() {
        ProfileScreen()
    }

}