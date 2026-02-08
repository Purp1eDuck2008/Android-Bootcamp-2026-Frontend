package ru.sicampus.bootcamp2026.ui.mainscreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import ru.sicampus.bootcamp2026.data.userList
import ru.sicampus.bootcamp2026.ui.mainscreen.components.ListState
import ru.sicampus.bootcamp2026.ui.mainscreen.components.ListViewModel

@Composable
fun ListComponent(
    viewModel: ListViewModel = viewModel<ListViewModel>()
){
    val state by viewModel.uiState.collectAsState()

    when (val currentState = state){
        is ListState.Error -> ListErrorState(currentState, onRefresh = {viewModel.getData()})
        is ListState.Loading -> ListLoadingState()
        is ListState.Content -> ListContentState(currentState)
    }
}

@Composable
private fun ListLoadingState(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
        CircularProgressIndicator(
            modifier = Modifier.size(48.dp),
            color = MaterialTheme.colorScheme.onPrimary

        )
    }
}

@Composable
private fun ListErrorState(
    state: ListState.Error,
    onRefresh: () -> Unit
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
        ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(state.reason)
            Button(
                onClick = onRefresh,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f),
                    contentColor = MaterialTheme.colorScheme.primary
            )
            ){
                Text("Обновить")
            }
        }

    }
}

@Composable
private fun ListContentState(
    state: ListState.Content
){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        LazyColumn {
            items(state.users.size) { index ->
                val user = state.users[index]
                UserRow(
                    modifier = Modifier.padding(bottom = 8.dp),
                    name = user.name,
                    photoUrl = user.photoUrl
                )
            }
        }

    }
}

@Composable
fun UserRow(
    modifier: Modifier,
    name: String,
    photoUrl: String,
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {


        AsyncImage(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(8.dp)),
            model = photoUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

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

