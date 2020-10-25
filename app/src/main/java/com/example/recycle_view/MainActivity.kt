package com.example.recycle_view

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exampleList = generateList(15)
        recycler_view.adapter = BookAdapter(exampleList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_books -> Toast.makeText(
                    applicationContext,
                    "Мы летим в раздел книг!", Toast.LENGTH_SHORT
                ).show()
                R.id.nav_authors -> Toast.makeText(
                    applicationContext,
                    "Мы быстро доскачем до авторов!", Toast.LENGTH_SHORT
                ).show()
                R.id.nav_favorit -> Toast.makeText(
                    applicationContext,
                    "Даже нам интересно что вы любите!", Toast.LENGTH_SHORT
                ).show()
                R.id.settings -> Toast.makeText(
                    applicationContext,
                    "Что вы хотите починить? Может вызвать мастера?", Toast.LENGTH_SHORT
                ).show()
                R.id.about -> Toast.makeText(
                    applicationContext,
                    "Вы все о нас узнаете!", Toast.LENGTH_SHORT
                ).show()
                R.id.bug -> Toast.makeText(
                    applicationContext,
                    "Отправьте нам пару ласковых!", Toast.LENGTH_SHORT
                ).show()
            }
            true
        }
    }

    private fun generateList(size: Int): List<ItemClass> {
        val list = ArrayList<ItemClass>()
        for (i in 0 until size) {

            val item = ItemClass(R.drawable.ic_book, "Название книги $i", "Автор, Жанр")
            list += item
        }
        return list

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}