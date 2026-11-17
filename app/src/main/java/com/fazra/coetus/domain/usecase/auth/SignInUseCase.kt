package com.fazra.coetus.domain.usecase.auth

import com.fazra.coetus.domain.model.AuthUser
import com.fazra.coetus.domain.repository.AuthRepository

class SignInUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<AuthUser> {
        return repository.signIn(
            email = email.trim(),
            password = password
        )
    }
}
