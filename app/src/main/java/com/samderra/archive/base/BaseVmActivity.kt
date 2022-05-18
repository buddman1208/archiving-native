package com.samderra.archive.base

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.samderra.archive.BR
import com.samderra.archive.BuildConfig
import com.samderra.archive.R
import com.samderra.archive.util.observeEvent

abstract class BaseVmActivity<T : ViewDataBinding>(
    @LayoutRes val layoutRes: Int,
    cls: Class<out ViewModel>
) : AppCompatActivity() {

//    val vm by viewModel(this, cls)

    abstract val viewModel: BaseViewModel
    lateinit var binding: T
    lateinit var toolbar: Toolbar
    internal var menu: Menu? = null
    protected abstract val toolbarId: Int
    val lifecycleOwner: LifecycleOwner by lazy { this }

    fun BaseViewModel.setDefaultObserves() {
        messageEvent.observeEvent(lifecycleOwner) {
            Toast.makeText(this@BaseVmActivity, it, Toast.LENGTH_SHORT).show()
        }
        errorMessageEvent.observeEvent(lifecycleOwner) {
            // todo log to crashlytics
            if (BuildConfig.DEBUG) {
                Toast.makeText(this@BaseVmActivity, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        bindVariables()
        initToolbarIfReady()
        initActivity()
        viewModel.setDefaultObserves()
    }

    private fun initToolbarIfReady() {
        if (toolbarId != 0) {
            toolbar = findViewById<View>(toolbarId) as Toolbar
            setSupportActionBar(toolbar)
            toolbar.setTitleTextAppearance(this@BaseVmActivity, R.style.UG_Medium)
            toolbar.setTitleTextColor(Color.WHITE)
            toolbar.contentInsetStartWithNavigation = 0
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }
    }

    abstract fun initActivity()


    open fun bindVariables() {
        binding.setVariable(BR.vm, viewModel)
        binding.lifecycleOwner = this
    }

    var toolbarTitle: String
        get() = supportActionBar!!.title.toString()
        set(value) {
            supportActionBar!!.title = value
        }

    fun setToggleStatus(isEnabled: Boolean) {
        this.supportActionBar!!.setDisplayHomeAsUpEnabled(isEnabled)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

}