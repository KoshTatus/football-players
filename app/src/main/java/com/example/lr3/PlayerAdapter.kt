package com.example.lr3

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lr3.databinding.PlayerCardBinding

class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.PlayerHolder>() {
    private val players = getPlayersList()

    class PlayerHolder(item: View): RecyclerView.ViewHolder(item){
        private val binding = PlayerCardBinding.bind(item)
        @SuppressLint("SetTextI18n")
        fun bind(player: Player) = with(binding){
            dayView.text = player.day.toString()
            playerImage.setImageResource(player.imageId)
            playerName.text = player.name
            ageValue.text = player.age.toString()
            positionValue.text = player.position
            totalScoreValue.text = player.totalScore.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.player_card, parent, false)
        return PlayerHolder(view)
    }

    override fun getItemCount(): Int {
        return players.size
    }

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        holder.bind(players[position])
    }
}