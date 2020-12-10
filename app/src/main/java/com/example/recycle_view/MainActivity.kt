package com.example.recycle_view

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var MainListRecycler: RecyclerView? = null
    private var bookAdapter: BookAdapter? = null

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bookData: ArrayList<BookinfoClass> = ArrayList()
        fun getItem(position: Int) {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle(bookData.get(position).title)
        }






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

    private fun setMainListRecycler(mainItemClass: List<ItemClass>) {

        MainListRecycler = findViewById(R.id.recycler_view)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        MainListRecycler!!.layoutManager = layoutManager
        bookAdapter = BookAdapter(this, mainItemClass)
        MainListRecycler!!.adapter = bookAdapter
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}