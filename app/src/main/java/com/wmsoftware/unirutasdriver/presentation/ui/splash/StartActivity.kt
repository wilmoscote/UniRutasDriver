package com.wmsoftware.unirutasdriver.presentation.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.wmsoftware.unirutasdriver.R
import com.wmsoftware.unirutasdriver.databinding.ActivityStartBinding
import com.wmsoftware.unirutasdriver.presentation.ui.main.MainActivity
import kotlinx.coroutines.launch

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        screenSplash.setKeepOnScreenCondition { true }

        checkUserLogged()
    }

    private fun checkUserLogged(){
        startActivity(Intent(this@StartActivity, MainActivity::class.java))
        finish()

        /*lifecycleScope.launch {
            userPreferences.getUser().firstOrNull {  user ->
                if(user == null){
                    startActivity(Intent(this@StartActivity, LoginActivity::class.java))
                    finish()
                } else {
                    startActivity(Intent(this@StartActivity, MainActivity::class.java))
                    finish()
                }
                return@firstOrNull true
            }
        }*/
    }
}