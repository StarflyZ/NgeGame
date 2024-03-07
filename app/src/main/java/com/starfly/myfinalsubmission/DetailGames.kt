package com.starfly.myfinalsubmission

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.starfly.myfinalsubmission.databinding.ActivityDetailGamesBinding

class DetailGames : AppCompatActivity() {
    companion object{
        const val GAMES_KEY = "game_key"
    }
    private lateinit var binding: ActivityDetailGamesBinding

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailGamesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataGame = if(Build.VERSION.SDK_INT >= 33){
            intent.getParcelableExtra<Games>(GAMES_KEY, Games::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Games>(GAMES_KEY)
        }

        if (dataGame != null) {
            binding.txtTitleDetail.text = dataGame.title
            binding.txtDescDetail.text = dataGame.description
            Glide.with(this)
                .load(dataGame.photo)
                .into(binding.imgDetail)
        }
    }
}