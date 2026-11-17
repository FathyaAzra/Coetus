
package com.fazra.coetus.domain.repository

import com.fazra.coetus.domain.model.AuthUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun observeAuthState(): Flow<AuthUser?>

    suspend fun signIn(
        email: String,
        password: String
    ): Result<AuthUser>

    suspend fun register(
        email: String,
        password: String
    ): Result<AuthUser>

    suspend fun signOut()
}
