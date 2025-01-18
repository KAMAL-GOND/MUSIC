package com.example.music

import android.app.Activity
import android.media.MediaPlayer
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val datalist :List<Data>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview=context.layoutInflater.inflate(R.layout.one_veiw,parent,false)
        return MyViewHolder(itemview)
    }

    override fun getItemCount(): Int {

        return datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=datalist[position]
        val mediaPlayer= MediaPlayer.create(context,currentItem.preview.toUri())
        holder.text.text=currentItem.title
        Picasso.get().load(currentItem.album.cover).into(holder.image)
        holder.play.setOnClickListener {
            mediaPlayer.start()
        }
        holder.pause.setOnClickListener {
            mediaPlayer.pause()}

    }
    class MyViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        val text: TextView
        val image:ImageView
        val play:ImageView
        val pause:ImageView
        init {
            text=itemview.findViewById(R.id.musicText)
            image=itemview.findViewById(R.id.musicImage)
            play=itemview.findViewById(R.id.playButton)
            pause=itemview.findViewById(R.id.pauseButton)
        }



    }

}
