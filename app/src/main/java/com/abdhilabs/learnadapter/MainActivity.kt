package com.abdhilabs.learnadapter

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdhilabs.learnadapter.adapter.HeroAdapter
import com.abdhilabs.learnadapter.adapter.HeroListener
import com.abdhilabs.learnadapter.model.Hero
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HeroListener {

    //List datanya
    private val listHeroes = listOf(
            Hero("Gundala", "https://cdn0-production-images-kly.akamaized.net/mzLiaBtfR74eIHgBpYG7cn2Glzk=/640x853/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2394314/original/066536100_1540717167-gundala.jpg"),
            Hero("Sri Asih", "https://mmc.tirto.id/image/otf/500x0/2019/08/19/bumi-film-langit_ratio-16x9.jpg"),
            Hero("Aquanus", "https://cdn0-production-images-kly.akamaized.net/iKLnKY_0gvxPa9nFevh6NEWWTX4=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2885227/original/062212600_1566125016-bumilangita.jpg"),
            Hero("Gundala", "https://cdn0-production-images-kly.akamaized.net/mzLiaBtfR74eIHgBpYG7cn2Glzk=/640x853/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2394314/original/066536100_1540717167-gundala.jpg"),
            Hero("Sri Asih", "https://mmc.tirto.id/image/otf/500x0/2019/08/19/bumi-film-langit_ratio-16x9.jpg"),
            Hero("Aquanus", "https://cdn0-production-images-kly.akamaized.net/iKLnKY_0gvxPa9nFevh6NEWWTX4=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2885227/original/062212600_1566125016-bumilangita.jpg"),
            Hero("Gundala", "https://cdn0-production-images-kly.akamaized.net/mzLiaBtfR74eIHgBpYG7cn2Glzk=/640x853/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2394314/original/066536100_1540717167-gundala.jpg"),
            Hero("Sri Asih", "https://mmc.tirto.id/image/otf/500x0/2019/08/19/bumi-film-langit_ratio-16x9.jpg"),
            Hero("Aquanus", "https://cdn0-production-images-kly.akamaized.net/iKLnKY_0gvxPa9nFevh6NEWWTX4=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2885227/original/062212600_1566125016-bumilangita.jpg")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Panggil Adapternya
        val heroAdapter = HeroAdapter(listHeroes, this)

        //Implementasi RecyclerView nya
        rvListVertical.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = heroAdapter
        }

        rvListHorizontal.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = heroAdapter
        }

        rvListGrid.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3)
            adapter = heroAdapter
        }

        //Btn Pindah
        btnMove.setOnClickListener {
            val intent = Intent(this, AnotherActivity::class.java)
            startActivity(intent)
        }
    }

    //When Click, mau apa...
    override fun onHeroClick(hero: Hero) {
        Toast.makeText(this, "Hero clicked ${hero.name}", Toast.LENGTH_SHORT).show()
    }
}
