package com.fazra.coetus.domain.usecase.auth

import com.fazra.coetus.domain.repository.AuthRepository

class ObserveAuthStateUseCase(
    private val repository: AuthRepository
) {
    operator fun invoke() = repository.observeAuthState()
}