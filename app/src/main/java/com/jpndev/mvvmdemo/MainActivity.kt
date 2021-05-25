package com.jpndev.mvvmdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jpndev.mvvmdemo.databinding.ActivityMainBinding
import com.jpndev.mvvmdemo.databinding.ActivityMovieBinding
import com.jpndev.mvvmdemo.presentation.movie.MovieActivity
import com.jpndev.mvvmdemo.presentation.star.StarActivity
import com.jpndev.mvvmdemo.presentation.tv.TvShowsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  setContentView(R.layout.activity_main)
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        activityMainBinding.apply {
            movieBtn.setOnClickListener{
                val intent= Intent(this@MainActivity,MovieActivity::class.java)
                startActivity(intent)
            }
            starBtn.setOnClickListener{
                val intent= Intent(this@MainActivity,StarActivity::class.java)
                startActivity(intent)
            }
            tvshowsBtn.setOnClickListener{
                val intent= Intent(this@MainActivity,TvShowsActivity::class.java)
                startActivity(intent)
            }

        }
    }
}