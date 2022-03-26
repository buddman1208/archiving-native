package com.samderra.archive.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.samderra.archive.BR

abstract class BaseVmFragment<T : ViewDataBinding>(
    @LayoutRes val layoutRes: Int,
    cls: Class<out ViewModel>
) : Fragment() {

    abstract val viewModel: BaseViewModel
    lateinit var binding: T


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            layoutRes,
            container,
            false
        )
        bindVariables()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initFragment()
        super.onViewCreated(view, savedInstanceState)
    }

    open fun bindVariables() {
        binding.setVariable(BR.vm, viewModel)
        binding.lifecycleOwner = this
    }

    abstract fun initFragment()

}