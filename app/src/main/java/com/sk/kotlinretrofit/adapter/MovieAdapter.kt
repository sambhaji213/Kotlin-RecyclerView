package com.sk.kotlinretrofit.adapter

/*
 * Created by Sambhaji Karad on 01-Feb-18
 * Mobile 9423476192
 * Email sambhaji2134@gmail.com/
*/

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.sk.kotlinretrofit.R
import com.sk.kotlinretrofit.model.Movie
import java.util.*

class MovieAdapter(horizontalList: List<Movie.MovieList>?, private val context: Context) :
        RecyclerView.Adapter<MovieAdapter.MessageViewHolder>() {

    private var imageModelArrayList = ArrayList<Movie.MovieList>()

    init {
        this.imageModelArrayList = horizontalList as ArrayList<Movie.MovieList>
    }

    override fun getItemCount(): Int {
        return imageModelArrayList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val model = imageModelArrayList[position]
        val messageViewHolder = holder

        Glide.with(context).load(model.imageurl)
                .into(messageViewHolder.imageViewMovie)

        messageViewHolder.textViewMovieName.text = model.name
        messageViewHolder.textViewReleaseDate.text = "Release Date: "+model.releaseDate
    }

    inner class MessageViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {

        internal var imageViewMovie: ImageView = view.findViewById<View>(R.id.imageViewMovie) as ImageView
        internal var textViewMovieName: TextView = view.findViewById<View>(R.id.textViewMovieName) as TextView
        internal var textViewReleaseDate: TextView = view.findViewById<View>(R.id.textViewReleaseDate) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return MessageViewHolder(itemView)
    }
}
