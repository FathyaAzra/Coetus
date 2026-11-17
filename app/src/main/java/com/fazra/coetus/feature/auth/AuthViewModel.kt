package com.fazra.coetus.feature.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fazra.coetus.domain.usecase.auth.ObserveAuthStateUseCase
import com.fazra.coetus.domain.usecase.auth.RegisterUseCase
import com.fazra.coetus.domain.usecase.auth.SignInUseCase
import com.fazra.coetus.domain.usecase.auth.SignOutUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(
    private val observeAuthState: ObserveAuthStateUseCase,
    private val signInUseCase: SignInUseCase,
    private val registerUseCase: RegisterUseCase,
    private val signOutUseCase: SignOutUseCase
)  : ViewModel() {
    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState = _uiState.asStateFlow()
    init {
        observeAuthentication()
    }

    private fun observeAuthentication() {
        viewModelScope.launch {
            observeAuthState().collect { user ->
                _uiState.update {
                    it.copy(
                        user = user,
                        isLoading = false,
                        error = null
                    )
                }
            }
        }
    }

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true, error = null)
            }

            signInUseCase(email, password)
                .onFailure { exception ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = exception.message ?: "Sign in failed."
                        )
                    }
                }
        }
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(isLoading = true, error = null)
            }

            registerUseCase(email, password)
                .onFailure { exception ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            error = exception.message ?: "Registration failed."
                        )
                    }
                }
        }
    }

    fun signOut() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }

            try {
                signOutUseCase()
            } catch (exception: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = exception.message ?: "Sign out failed."
                    )
                }
            }
        }
    }

    fun clearError() {
        _uiState.update {
            it.copy(error = null)
        }
    }
}
