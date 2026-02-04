package ru.sicampus.bootcamp2026.ui.mainscreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.sicampus.bootcamp2026.data.userList
import ru.sicampus.bootcamp2026.model.uistate.homescreen.ListState
import ru.sicampus.bootcamp2026.viewmodel.ListViewModel

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
        Column {
            state.users.forEach { user ->
                UserRow(
                    modifier = Modifier,
                    name = user.name,
                    photoUrl = user.photoUrl
                    )
            }
        }

    }
}

