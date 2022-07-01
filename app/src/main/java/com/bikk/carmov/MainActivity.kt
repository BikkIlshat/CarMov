package com.bikk.carmov

import android.os.Bundle
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.bikk.carmov.databinding.ActivityMainBinding
import com.bikk.carmov.view.CarViewAnimation

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private var isMoved: Boolean = true
    private val anim: CarViewAnimation by lazy {
        CarViewAnimation(
            maxYOfScreen = binding.root.height.toFloat(),
            maxXOfScreen = binding.root.width.toFloat(),
            view = binding.taxiImage,
            interpolator = AnticipateOvershootInterpolator()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.taxiImage.setOnClickListener {
            onStartAnimation()
        }
    }


    private fun onStartAnimation() {
        isMoved = !isMoved
        anim.onStartAnimation(800, 0f, isMoved)
    }
}