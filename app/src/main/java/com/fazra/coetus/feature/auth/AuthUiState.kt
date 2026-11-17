package com.fazra.coetus.feature.auth

import com.fazra.coetus.domain.model.AuthUser

data class AuthUiState(
    val user: AuthUser? = null,
    val isLoading: Boolean = true,
    val error: String? = null
) {
    val isAuthenticated: Boolean
        get() = user != null
}
