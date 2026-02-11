package ru.sicampus.bootcamp2026.ui.mainscreen.components.subscreens.profilescreen.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.sicampus.bootcamp2026.ui.theme.AndroidBootcamp2026FrontendTheme

@Composable
fun EditableTextField(
    singleLine: Boolean,
    onValueChange: (String) -> Unit,
    value: String,
    label: String,
    onClick: () -> Unit,
    ){
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = singleLine,
            modifier = Modifier
                .weight(1f)
                .padding(
                    end = 16.dp,
                    start = 24.dp
                    ),
            shape = RoundedCornerShape(16.dp),
            label = {
                Text (
                    text = label,
                    color = MaterialTheme.colorScheme.secondary
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedLabelColor = MaterialTheme.colorScheme.secondary
            )
        )
        Icon(
            tint = MaterialTheme.colorScheme.secondary,
            imageVector = Icons.Default.Edit,
            contentDescription = null,
            modifier = Modifier
                .padding(
                    end = 24.dp,
                    top = 4.dp
                )
                .size(24.dp)
        )
    }
}


@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun prewiewEditableTextField(){
    AndroidBootcamp2026FrontendTheme() {
        EditableTextField(
            singleLine = false,
            value = "Пример текста ООООООООООООООчень длинного ООООООООООООООООООООООООООООООООООООООО",
            onValueChange = {},
            label = "Имя",
            onClick = {}
        )
    }
}