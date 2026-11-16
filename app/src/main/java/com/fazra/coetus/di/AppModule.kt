package com.fazra.coetus.di


import com.google.firebase.auth.FirebaseAuth
import org.koin.dsl.module

val appModule = module {

    // Firebase
    single<FirebaseAuth> {
        FirebaseAuth.getInstance()
    }

    // Repositories
    // single<AuthRepository> {
    //     AuthRepositoryImpl(
    //         firebaseAuth = get()
    //     )
    // }

    // ViewModels
    // viewModel {
    //     AuthViewModel(
    //         authRepository = get()
    //     )
    // }
}