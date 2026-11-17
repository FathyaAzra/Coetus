
package com.fazra.coetus.data.repository

import com.fazra.coetus.data.remote.auth.FirebaseAuthDataSource
import com.fazra.coetus.domain.model.AuthUser
import com.fazra.coetus.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthRepositoryImpl(
    private val dataSource: FirebaseAuthDataSource
) : AuthRepository {

    override fun observeAuthState(): Flow<AuthUser?> {
        return dataSource.observeAuthState().map { user ->
            user?.let {
                AuthUser(
                    uid = it.uid,
                    email = it.email
                )
            }
        }
    }

    override suspend fun signOut() {
        dataSource.signOut()
    }
}
