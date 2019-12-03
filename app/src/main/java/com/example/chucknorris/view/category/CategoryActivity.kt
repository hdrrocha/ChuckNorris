package com.example.chucknorris.view.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.example.chucknorris.R
import com.example.chucknorris.ViewModelFactory
import com.example.chucknorris.model.Category
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.chucknorris.view_model.CategoryViewModel
import kotlinx.android.synthetic.main.activity_category.*
import dagger.android.AndroidInjection
import javax.inject.Inject

class CategoryActivity : AppCompatActivity() {

    @Inject
    lateinit var categoryVMFactory: ViewModelFactory<CategoryViewModel>

    private val categoryViewModel by lazy {
        ViewModelProviders.of(this, categoryVMFactory)[CategoryViewModel::class.java]
    }

    private val categoryObserver = Observer<Category>(::onCategoryFetched)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        progress_bar_category.visibility = View.VISIBLE
        val data: Bundle? = intent.extras
        var category  = data?.getString("category")
        categoryViewModel.data.observe(this, categoryObserver)
        category?.let { categoryViewModel.fethCategory(it) }
    }

    private fun onCategoryFetched(category: Category?) {
        tv_value.setText(category?.value)
        Glide.with(this)
            .load("${category?.icon_url}")
            .into(img_avatar)
        progress_bar_category.visibility = View.GONE
    }
}
