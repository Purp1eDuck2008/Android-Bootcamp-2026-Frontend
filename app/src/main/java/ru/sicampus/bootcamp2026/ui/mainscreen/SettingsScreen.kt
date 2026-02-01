package ru.sicampus.bootcamp2026.ui.mainscreen

import android.content.res.Configuration
import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import ru.sicampus.bootcamp2026.R
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun SettingsScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Приглашения",
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
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(20){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.profile_scrap),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(RoundedCornerShape(64.dp))
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Text(
                                    text = "Дмитрий приглашает в телемост",
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = FontWeight.SemiBold
                                )

                                Text(
                                    text = "ДАТА ВСТРЕЧИ · ОПИСАНИЕ ВСТРЕЧИ",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f)
                                )
                            }

                        }
                        Row(
                            modifier = Modifier.padding(top = 4.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .padding(
                                        top = 16.dp,
                                    )
                                    .height(32.dp)
                                    .width(160.dp),
                                shape = RoundedCornerShape(16.dp),
                                enabled = false,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.onPrimary,
                                    contentColor = MaterialTheme.colorScheme.primary,
                                    disabledContainerColor = MaterialTheme.colorScheme.onPrimary.copy(
                                        alpha = 0.7f
                                    ),
                                    disabledContentColor = MaterialTheme.colorScheme.primary
                                )
                            ) {
                                Text(
                                    text = "Отказать"
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .padding(
                                        top = 16.dp,
                                    )
                                    .height(32.dp)
                                    .width(160.dp),
                                shape = RoundedCornerShape(16.dp),
                                enabled = false,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.onPrimary,
                                    contentColor = MaterialTheme.colorScheme.primary,
                                    disabledContainerColor = MaterialTheme.colorScheme.onPrimary.copy(
                                        alpha = 1.1f
                                    ),
                                    disabledContentColor = MaterialTheme.colorScheme.primary
                                )
                            ) {
                                Text(
                                    text = "Принять"
                                )
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
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
fun SettingsScreenPreview() {
    AndroidBootcamp2026FrontendTheme() {
        SettingsScreen()
    }
}