package ru.sicampus.bootcamp2026.domain

class CheckPasswordFormatUseCase {
    operator fun invoke(
        password: String
    ): Boolean {
        if(password.length >= 2){
            return true
        }
        else{
            return false
        }
    }
}