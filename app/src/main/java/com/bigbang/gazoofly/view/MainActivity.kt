package com.bigbang.gazoofly.view

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.bigbang.gazoofly.R
import com.bigbang.gazoofly.animation.GazooView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    Comments are java equivalents
    //private GazooView gazooView;
    private lateinit var gazooView: GazooView

    private lateinit var slideAnimation: Animation
    private lateinit var scaleAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //gazooView = new GazooView(this);
//        gazooView = GazooView(this)

        slideAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_animation)
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation)

        pause_button.animation = slideAnimation

        pause_button.setOnClickListener { pauseButton ->
            pauseButton.startAnimation(scaleAnimation)
            gazoo_view.setPaused()
        }

        (slide_background as View).setBackgroundResource(R.drawable.image_slideshow)

        val animationDrawable = ((slide_background as View).background as AnimationDrawable)
        animationDrawable.start()
    }
}
