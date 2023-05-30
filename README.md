# Dota-Heroes

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tihonyakovlev.worldskillz.presentation.viewmodels.LoginRegistrationViewModel

//@Composable
//fun LoginRegistrationScreen(navController: NavHostController, viewModel: LoginRegistrationViewModel) {
//    val email by viewModel.email.collectAsState("")
//    val error by viewModel.error.collectAsState("")
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        TextField(
//            value = email,
//            onValueChange = { viewModel.setEmail(it) },
//            label = { Text("Email") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        if (error.isNotEmpty()) {
//            Text(
//                text = error,
//                color = Color.Red,
//                modifier = Modifier.padding(vertical = 8.dp)
//            )
//        }
//        Button(
//            onClick = { viewModel.onContinueClicked(navController) },
//            modifier = Modifier.padding(top = 16.dp)
//        ) {
//            Text("Continue")
//        }
//    }
//}
@Composable
fun LoginScreen(onNextClicked: () -> Unit) {
    val navController = rememberNavController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Вход и регистрация",
            style = TextStyle(fontSize = 24.sp),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                onNextClicked()
                navController.navigate("emailCode")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Далее")
        }
    }

}
fun isEmailValid(email: String): Boolean {
    val pattern = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+".toRegex()
    return pattern.matches(email)
}





package com.tihonyakovlev.worldskillz.presentation.screens
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tihonyakovlev.worldskillz.presentation.viewmodels.EmailCodeViewModel
import org.koin.androidx.compose.getViewModel
import androidx.compose.foundation.layout.padding as padding1

@Composable
fun EmailCodeScreen(onCodeEntered: () -> Unit, onBackClicked: () -> Unit) {
    val code = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding1(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Код из Email",
            style = TextStyle(fontSize = 24.sp),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding1(bottom = 16.dp)
        )

        OutlinedTextField(
            value = code.value,
            onValueChange = { code.value = it },
            label = { Text("Введите код") },
            modifier = Modifier
                .fillMaxWidth()
                .padding1(vertical = 8.dp)
        )

        Button(
            onClick = {
                if (code.value == "ваш_код") {
                    onCodeEntered()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding1(vertical = 8.dp)
        ) {
            Text(text = "Далее")
        }

        Button(
            onClick = { onBackClicked() },
            modifier = Modifier
                .fillMaxWidth()
                .padding1(vertical = 8.dp)
        ) {
            Text(text = "Назад")
        }
    }
}

fun isCodeValid(code: String): Boolean {
    // Проверка правильности кода
    // Вернуть true, если код правильный, иначе false
    return true
}



package com.tihonyakovlev.worldskillz.presentation.screens
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tihonyakovlev.worldskillz.presentation.viewmodels.EmailCodeViewModel
import org.koin.androidx.compose.getViewModel
import androidx.compose.foundation.layout.padding as padding1
@Composable
fun CreatePasswordScreen(onSkipClicked: () -> Unit) {
    val password = remember { mutableStateOf("") }
    val isSkipped = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding1(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Создание пароля",
            style = TextStyle(fontSize = 24.sp),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding1(bottom = 16.dp)
        )

        if (!isSkipped.value) {
            OutlinedTextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Введите пароль") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding1(vertical = 8.dp)
            )
        }

        Button(
            onClick = {
                if (password.value.isNotEmpty() || isSkipped.value) {
                    // Действия при создании пароля или пропуске этапа
                    // Например, сохранение пароля в хранилище или обработка пропуска этапа
                    // ...
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding1(vertical = 8.dp)
        ) {
            Text(text = "Готово")
        }

        Button(
            onClick = {
                isSkipped.value = true
                onSkipClicked()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding1(vertical = 8.dp)
        ) {
            Text(text = "Пропустить")
        }
    }
}



package com.tihonyakovlev.worldskillz.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.tihonyakovlev.worldskillz.domain.UserRepository
import com.tihonyakovlev.worldskillz.presentation.screens.isEmailValid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginRegistrationViewModel(
    private val userRepository: UserRepository,
    private val navController: NavHostController
) : ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _error = MutableStateFlow("")
    val error: StateFlow<String> = _error

    fun setEmail(email: String) {
        _email.value = email
    }

    fun onContinueClicked(navController: NavHostController) {
        viewModelScope.launch {
            if (isEmailValid(email.value)) {
                val isCodeSent = userRepository.sendCodeToEmail(email.value)
                if (isCodeSent) {
                    this@LoginRegistrationViewModel.navController.navigate("emailCodeScreen")
                } else {
                    // Ошибка при отправке кода
                }
            } else {
                _error.value = "Некорректный email"
            }
        }
    }
}
  
  
  
  package com.tihonyakovlev.worldskillz.presentation.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tihonyakovlev.worldskillz.domain.UserRepository
import com.tihonyakovlev.worldskillz.presentation.screens.isCodeValid
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EmailCodeViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _code = MutableStateFlow("")
    val code: StateFlow<String> = _code

    fun setCode(code: String) {
        _code.value = code
    }

    fun onCodeConfirmed() {
        viewModelScope.launch {
            val isCodeValid = userRepository.verifyCode(code.value)
            if (isCodeValid) {
                // Правильный код
            } else {
                // Ошибка при проверке кода
            }
        }
    }

    fun onBackClicked() {
        // Возврат на предыдущий экран
    }
}
  
  
  val dataModule = module {
    single<UserRepository> { UserRepositoryImpl() }
}
  val presentationModule = module {
    viewModel { LoginRegistrationViewModel(get(), get<NavHostController>()) }
    viewModel { EmailCodeViewModel(get()) }
}
  
  
  package com.tihonyakovlev.worldskillz.presentation.application

import android.app.Application
import com.tihonyakovlev.worldskillz.di.dataModule
import com.tihonyakovlev.worldskillz.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
        }
    }
}
val appModule = listOf(dataModule, presentationModule)
