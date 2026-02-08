package ru.sicampus.bootcamp2026.ui.loginscreen.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.sicampus.bootcamp2026.data.AuthRepository
import ru.sicampus.bootcamp2026.data.source.AuthLocalDataSource
import ru.sicampus.bootcamp2026.data.source.AuthNetworkDataSource
import ru.sicampus.bootcamp2026.domain.CheckAndSaveAuthUseCase
import ru.sicampus.bootcamp2026.domain.CheckEmailFormatUseCase
import ru.sicampus.bootcamp2026.domain.CheckPasswordFormatUseCase
import ru.sicampus.bootcamp2026.navigation.Graphs

class LoginViewModel : ViewModel(){
    private val checkEmailFormatUseCase by lazy { CheckEmailFormatUseCase() }
    private val checkPasswordFormatUseCase by lazy { CheckPasswordFormatUseCase() }
    private val checkAndSaveAuthUseCase by lazy { CheckAndSaveAuthUseCase(
        AuthRepository(
            authNetworkDataSource = AuthNetworkDataSource(),
            authLocalDataSource = AuthLocalDataSource
        )
    ) }
    private val _uiState = MutableStateFlow<AuthState>(
        AuthState.Data(
            isEnabledSend = false,
            isValidEmail = false,
            error = null
        )
    )

    val uiState: StateFlow<AuthState> = _uiState.asStateFlow()

    private val _actionFlow = MutableSharedFlow<AuthAction>()

    val actionFlow = _actionFlow.asSharedFlow()

    fun onIntent(intent: AuthIntent){
        when(intent){
            is AuthIntent.EmailTextInput -> {
                updateStateIfData { oldState ->
                    oldState.copy(
                        isValidEmail = checkEmailFormatUseCase.invoke(
                            intent.email
                        ),
                        error = null
                    )
                }
            }

            is AuthIntent.PasswordTextInput -> {
                updateStateIfData { oldState ->
                    oldState.copy(
                        isEnabledSend = checkPasswordFormatUseCase.invoke(
                            intent.password
                        ),
                        error = null
                    )
                }
            }

            is AuthIntent.Send -> {
                viewModelScope.launch {
                    val authCompleted = checkAndSaveAuthUseCase.invoke(
                        intent.login,
                        intent.password
                    )
                    if(authCompleted){
                        _actionFlow.emit(AuthAction.OpenScreen(Graphs.MAIN.route))
                    }
                    else{
                        updateStateIfData { uiState ->
                            uiState.copy(
                                error = "Auth error"
                            )
                        }
                    }
                }
            }
        }
    }

    private fun updateStateIfData(lambda: (AuthState.Data) -> AuthState) {
        _uiState.update { state ->
            (state as? AuthState.Data)?.let { lambda.invoke(it) } ?: state
        }

    }
}