package com.example.recycle_view

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
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


        //1 список книг
        val categoryItemList: MutableList<BookinfoClass> = ArrayList()
        categoryItemList.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Атлант расправит плечи",
                "Айн Ренд"
            )
        )
        categoryItemList.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Королевство",
                "Ю Несбё"
            )
        )
        categoryItemList.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Вторая жизнь Уве",
                "Фредрик Бакман"
            )
        )
        categoryItemList.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Тревожные люди",
                "Фредрик Бакман"
            )
        )
//1 список книг
        val categoryItemList2: MutableList<BookinfoClass> = ArrayList()
        categoryItemList2.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Убить пересмешника",
                "Харпер Ли"
            )
        )
        categoryItemList2.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Мастер и Маргарита",
                "Михаил Булгаков"
            )
        )
        categoryItemList2.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Война и мир",
                "Лев Толстой"
            )
        )
        categoryItemList2.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Идиот",
                "Федор Достоевский"
            )
        )
//Фантастика
        val categoryItemList3: MutableList<BookinfoClass> = ArrayList()
        categoryItemList3.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Институт",
                "Стивен Кинг"
            )
        )
        categoryItemList3.add(
            BookinfoClass(
                R.drawable.ic_book,
                "1917: Да здравствует император!",
                "Владимир Марков"
            )
        )
        categoryItemList3.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Происхождение",
                "Дэн Браун"
            )
        )
        categoryItemList3.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Последняя одиссея",
                "Джеймс Роллинс"
            )
        )
//Антиутопия
        val categoryItemList4: MutableList<BookinfoClass> = ArrayList()
        categoryItemList4.add(
            BookinfoClass(
                R.drawable.ic_book,
                "О дивный новый мир",
                "Олдос Хаксли"
            )
        )
        categoryItemList4.add(
            BookinfoClass(
                R.drawable.ic_book,
                "1984",
                "Джордж Оруэлл"
            )
        )
        categoryItemList4.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Атлант расправит плечи",
                "Айн Ренд"
            )
        )
        categoryItemList4.add(
            BookinfoClass(
                R.drawable.ic_book,
                "451 градус по Фаренгейту",
                "Рэй Брэдбери"
            )
        )
//Науч-поп
        val categoryItemList5: MutableList<BookinfoClass> = ArrayList()
        categoryItemList5.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Гормоны счастья",
                "Лоретта Бройнинг"
            )
        )
        categoryItemList5.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Очаровательный кишечник",
                "Джулия Эндерс"
            )
        )
        categoryItemList5.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Еда и мозг",
                "Дэвид Перлмуттер"
            )
        )
        categoryItemList5.add(
            BookinfoClass(
                R.drawable.ic_book,
                "Четвертая мировая война",
                "Андрей Курпатов"
            )
        )
//Списки книг
        val mainItemClass: MutableList<ItemClass> = ArrayList()
        mainItemClass.add(ItemClass("Популярное", categoryItemList))
        mainItemClass.add(ItemClass("Классика", categoryItemList2))
        mainItemClass.add(ItemClass("Фантастика", categoryItemList3))
        mainItemClass.add(ItemClass("Антиутопия", categoryItemList4))
        mainItemClass.add(ItemClass("Науч-Поп", categoryItemList5))

        setMainListRecycler(mainItemClass)


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