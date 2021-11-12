
package com.ahkam.myliftexpress.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ahkam.myliftexpress.R
import com.ahkam.myliftexpress.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSplashAnimation()
        startTimer()
    }

    private fun setSplashAnimation() {
        val myLiftAnimation = AnimationUtils.loadAnimation(
            this,
            R.anim.slide_in_left
        )

        val expressAnimation = AnimationUtils.loadAnimation(
            this,
            R.anim.slide_in_right
        )

        binding.myLift.startAnimation(myLiftAnimation)
        myLiftAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(arg0: Animation) {}
            override fun onAnimationRepeat(arg0: Animation) {}
            override fun onAnimationEnd(arg0: Animation) {
                binding.express.visibility = View.VISIBLE
                binding.express.startAnimation(expressAnimation)
            }
        })


    }

    private fun startTimer() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
            finish()
        }, 2000)
    }

}