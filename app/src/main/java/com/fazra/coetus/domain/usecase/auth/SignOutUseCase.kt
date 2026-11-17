
package com.fazra.coetus.domain.usecase.auth

import com.fazra.coetus.domain.repository.AuthRepository

class SignOutUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke() {
        repository.signOut()
    }
}
