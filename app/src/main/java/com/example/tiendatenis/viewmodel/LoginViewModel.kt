package com.example.tiendatenis.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    // --- ESTADOS QUE LA VISTA OBSERVARÁ ---

    // Guarda el texto del campo de usuario
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    // Guarda el texto del campo de contraseña
    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    // Nos dice si el login fue exitoso para que la vista pueda navegar
    private val _loginSuccess = MutableStateFlow(false)
    val loginSuccess: StateFlow<Boolean> = _loginSuccess.asStateFlow()

    // --- EVENTOS QUE LA VISTA PUEDE LLAMAR ---

    // La vista llama a esta función cuando el usuario escribe en el campo de usuario
    fun onUsernameChange(newUsername: String) {
        _username.update { newUsername }
    }

    // La vista llama a esta función cuando el usuario escribe en el campo de contraseña
    fun onPasswordChange(newPassword: String) {
        _password.update { newPassword }
    }

    // La vista llama a esta función cuando se presiona el botón "Continuar"
    fun login() {
        // ¡AQUÍ ESTÁ LA LÓGICA!
        if (_username.value == "admin" && _password.value == "123") {
            _loginSuccess.update { true } // Si es correcto, cambiamos el estado a verdadero
        } else {
            // (En un futuro aquí podríamos añadir un estado de error)
            _loginSuccess.update { false }
        }
    }
}