package ru.sicampus.bootcamp2026.ui.mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .height(80.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    topStart = 30.dp
                ))
                .background(color = MaterialTheme.colorScheme.surfaceVariant)

        ){

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