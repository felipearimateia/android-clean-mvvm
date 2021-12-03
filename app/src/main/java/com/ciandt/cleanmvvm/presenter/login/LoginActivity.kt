package com.ciandt.cleanmvvm.presenter.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ciandt.cleanmvvm.R
import com.ciandt.cleanmvvm.databinding.ActivityLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    val loginViewModel: LoginViewModel by viewModel()

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        loginViewModel.login("teste@mail.com", "123456")
    }
}