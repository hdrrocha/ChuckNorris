package com.example.chucknorris.view.categories

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chucknorris.R
import com.example.chucknorris.ViewModelFactory
import com.example.chucknorris.view.categories.adapter.CategoriesAdapter
import com.example.chucknorris.view_model.CategoriesViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class CategoriesActivity : AppCompatActivity() {
    lateinit var adapter: CategoriesAdapter

    @Inject
    lateinit var categoriesVMFactory: ViewModelFactory<CategoriesViewModel>

    private val categoriesViewModel by lazy {
        ViewModelProviders.of(this, categoriesVMFactory)[CategoriesViewModel::class.java]
    }

    private val categoriesObserver = Observer<List<String>>(::onCategoriesFetched)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress_bar_categories.visibility = View.VISIBLE
        categoriesViewModel.data.observe(this, categoriesObserver)
        categoriesViewModel.fethCategories()
    }

    private fun onCategoriesFetched(list: List<String>?) {
        list?.let { updateAdapter(it) }
    }

    private fun updateAdapter(list: List<String>) {
        rc_categories.layoutManager = LinearLayoutManager(this)
        rc_categories.setHasFixedSize(true)
        adapter = CategoriesAdapter({ category: String -> partItemClicked(category) } )
        adapter.update(list)
        rc_categories.adapter = adapter
        progress_bar_categories.visibility = View.GONE
    }

    private fun partItemClicked(category: String) {
        Toast.makeText(this, category, Toast.LENGTH_SHORT).show()
    }

}
