package ru.artbez.moviepop.screens.en5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*
import ru.artbez.moviepop.MAIN
import ru.artbez.moviepop.R
import ru.artbez.moviepop.models.MovieItemModel
import ru.artbez.moviepop.screens.en5.En5Adapter
import ru.artbez.moviepop.screens.en5.En5Fragment

class En5Adapter: RecyclerView.Adapter<En5Adapter.MyViewHolder>() {

    private var moviesList = emptyList<MovieItemModel>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.item_title.text = moviesList[position].title
        holder.itemView.item_date.text = moviesList[position].release_date

        Glide.with(MAIN)
            .load("https:/www.themoviedb.org/t/p/w600_and_h900_bestv2${moviesList[position].poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.itemView.item_img)

    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun setList(list: List<MovieItemModel>){
        moviesList = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            En5Fragment.click5Movie(moviesList[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        holder.itemView.setOnClickListener(null)
    }
}