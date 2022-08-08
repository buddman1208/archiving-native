package com.samderra.archive.ui

import android.os.Bundle
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.samderra.archive.R
import com.samderra.archive.base.BaseRecyclerAdapter
import com.samderra.archive.databinding.ItemBottomMenuBinding
import com.samderra.archive.databinding.LayoutBottomMenuFragmentBinding
import kotlin.random.Random

class BottomMenuFragment constructor(
    val options: BuildOptions
) : BottomSheetDialogFragment() {

    lateinit var binding: LayoutBottomMenuFragmentBinding
    private val listAdapter: BottomMenuAdapter by lazy { BottomMenuAdapter() }

    init {
        options.items.forEach {
            it.realCallback = {
                dismiss()
                it.callback?.invoke()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LayoutBottomMenuFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList()
    }

    private fun initList() {
        binding.apply {
            tvTitle.text = options.title
            rvContent.adapter = listAdapter
        }

        listAdapter.updateItems(options.items.toList())
    }

    data class BuildOptions(
        val title: String,
        val items: List<BottomMenuItem>
    )

}

class BottomMenuAdapter : BaseRecyclerAdapter<BottomMenuItem, ItemBottomMenuBinding>(
    R.layout.item_bottom_menu
)

data class BottomMenuItem(
    val content: Spanned,
    val callback: (() -> Unit)? = null
) {
    var realCallback: (() -> Unit) = {}
    val id = Random.hashCode()
}