package com.abdhilabs.learnadapter

import com.abdhilabs.learnadapter.model.Hero
import com.squareup.picasso.Picasso
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_list.view.*

class ItemGroupie(private val hero: Hero): Item() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.txtHero.text = hero.name
        Picasso.get().load(hero.image).into(viewHolder.itemView.imgHero)
    }

    override fun getLayout(): Int = R.layout.item_list
}