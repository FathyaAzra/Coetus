package com.fazra.coetus.domain.usecase.auth

import com.fazra.coetus.domain.model.AuthUser
import com.fazra.coetus.domain.repository.AuthRepository

class RegisterUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<AuthUser> {
        return repository.register(
            email = email.trim(),
            password = password
        )
    }
}
