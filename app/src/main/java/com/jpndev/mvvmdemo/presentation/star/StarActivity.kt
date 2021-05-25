package com.jpndev.mvvmdemo.presentation.star

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jpndev.mvvmdemo.R
import com.jpndev.mvvmdemo.databinding.ActivityStarBinding
import com.jpndev.mvvmdemo.presentation.di.Injector
import javax.inject.Inject

class StarActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: StarViewModelFactory
    private lateinit var starViewModel: StarViewModel
    private lateinit var adapter: StarAdapter
    private lateinit var binding: ActivityStarBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_star)
        (application as Injector).createStarSubComponent()
            .inject(this)

        starViewModel= ViewModelProvider(this,factory)
            .get(StarViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.rcv.layoutManager = LinearLayoutManager(this)
        adapter = StarAdapter()
        binding.rcv.adapter = adapter
        displayPopularStars()
    }

    private fun displayPopularStars(){
        binding.progressBar.visibility = View.VISIBLE
        val responseLiveData = starViewModel.getStars()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            }else{
                binding.progressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateTvShows(){
        binding.progressBar.visibility = View.VISIBLE
        val response = starViewModel.updateStars()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            }else{
                binding.progressBar.visibility = View.GONE
            }
        })
    }
}