package com.starfly.myfinalsubmission

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnticipateInterpolator
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.Instant
import kotlin.time.Duration
import androidx.core.splashscreen.SplashScreen

class MainActivity : AppCompatActivity() {

    private lateinit var rvGames: RecyclerView
    private val list = ArrayList<Games>()

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContentView(R.layout.activity_main)

        rvGames = findViewById(R.id.rv_games)
        rvGames.setHasFixedSize(true)

        list.addAll(listGames())
        showRecyclerList()

    }

    private fun listGames(): ArrayList<Games> {
        val dataTitle = resources.getStringArray(R.array.data_nama_game)
        val dataDesc = resources.getStringArray(R.array.game_desc)
        val dataPhoto = resources.getStringArray(R.array.game_photo)
        val listGames = ArrayList<Games>()

        for (i in dataTitle.indices) {
            val games = Games(dataTitle[i], dataDesc[i], dataPhoto[i])
            listGames.add(games)
        }
        return listGames
    }

    private fun showRecyclerList() {
        rvGames.layoutManager = LinearLayoutManager(this)
        val listGameAdapter = GameAdapter(list)
        rvGames.adapter = listGameAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about_me, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_me -> {
                val iabout_me = Intent(this@MainActivity, AboutMeActivity::class.java)
                startActivity(iabout_me)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}