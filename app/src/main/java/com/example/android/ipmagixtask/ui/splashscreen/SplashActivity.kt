package com.example.android.ipmagixtask.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.example.android.ipmagixtask.R
import com.example.android.ipmagixtask.ui.studentsactivity.StudentsActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash)

        //3second splash time
        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this@SplashActivity, StudentsActivity::class.java))
            //finish this activity
            finish()
        },3000)
    }
}
