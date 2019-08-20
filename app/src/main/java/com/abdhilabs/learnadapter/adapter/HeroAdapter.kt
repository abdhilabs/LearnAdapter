package com.abdhilabs.learnadapter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abdhilabs.learnadapter.R
import com.abdhilabs.learnadapter.model.Hero
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class HeroAdapter(private val hero: List<Hero>, private val listener: HeroListener) :
    RecyclerView.Adapter<HeroHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        return HeroHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun getItemCount(): Int = hero.size

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.bindHero(hero[position], listener)
    }
}

interface HeroListener {
    fun onHeroClick(hero: Hero)
}

class HeroHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvHeroName = view.txtHero
    private val imageHero = view.imgHero

    fun bindHero(hero: Hero, listener: HeroListener) {
        tvHeroName.text = hero.name
        Picasso.get().load(hero.image).into(imageHero)

        itemView.setOnClickListener { listener.onHeroClick(hero) }
    }

}
