
package com.fazra.coetus.di

import com.fazra.coetus.data.remote.auth.FirebaseAuthDataSource
import com.fazra.coetus.data.repository.AuthRepositoryImpl
import com.fazra.coetus.domain.repository.AuthRepository
import com.fazra.coetus.domain.usecase.auth.ObserveAuthStateUseCase
import com.fazra.coetus.domain.usecase.auth.RegisterUseCase
import com.fazra.coetus.domain.usecase.auth.SignInUseCase
import com.fazra.coetus.domain.usecase.auth.SignOutUseCase
import com.fazra.coetus.feature.auth.AuthViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {FirebaseAuth.getInstance()}
    single {FirebaseAuthDataSource(get())}
    single<AuthRepository> {AuthRepositoryImpl(get())}
    factory {ObserveAuthStateUseCase(get())}
    factory {SignInUseCase(get())}
    factory {RegisterUseCase(get())}
    factory {SignOutUseCase(get())}

    viewModel {
        AuthViewModel(
            observeAuthState = get(),
            signInUseCase = get(),
            registerUseCase = get(),
            signOutUseCase = get()
        )
    }
}
