package com.rhymartmanchus.kointraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import com.rhymartmanchus.kointraining.data.UsersRepository
import com.rhymartmanchus.kointraining.databinding.ActivityMainBinding
import com.rhymartmanchus.kointraining.domain.FetchUserByIdUseCase
import com.rhymartmanchus.kointraining.domain.FetchUsersUseCase
import com.rhymartmanchus.kointraining.ui.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Study:
 * 1. Coroutines + ViewModel + LiveData
 * 2. DI using Dagger
 * 3. Hilt
 * 4. DI using Koin
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val views: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(views.root)


        views.btnAddItem.setOnClickListener {
            userViewModel.addUser()
        }

    }

    override fun onStart() {
        super.onStart()
        userViewModel.users.observe(this) {
            it.forEach { user ->
                Log.e("MainActivity", user.name)
            }
        }
    }

}