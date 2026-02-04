package ru.sicampus.bootcamp2026.ui.mainscreen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ru.sicampus.bootcamp2026.R

@Composable
fun UserRow(
    modifier: Modifier,
    name: String,
    photoUrl: String,
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {

        AsyncImage(
            modifier = Modifier.size(100.dp),
            model = photoUrl,
            contentDescription = null
        )

//        Icon(
//            painter = painterResource(id = R.drawable.profile_scrap),
//            contentDescription = null,
//            tint = Color.Unspecified,
//            modifier = Modifier
//                .size(48.dp)
//                .clip(RoundedCornerShape(64.dp))
//        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = name,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f), //если добавлен в список становить onPrimary
            modifier = Modifier.weight(1f)
        )

        Button( // "+" на плюс меняется, и делаем кнопку более серой, добавленного пользователя вверх по списку
            onClick = {},
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier.size(36.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f),
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(26.dp)
            )
        }
    }
}