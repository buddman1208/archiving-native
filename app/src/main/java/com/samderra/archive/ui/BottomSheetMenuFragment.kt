package com.samderra.archive.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.samderra.archive.R
import com.samderra.archive.base.BaseRecyclerAdapter
import com.samderra.archive.databinding.ItemBottomMenuBinding
import com.samderra.archive.databinding.LayoutBottomMenuFragmentBinding

class BottomMenuFragment
private constructor(
    val items: Array<BottomMenuItem>,
    val title: String?
) : BottomSheetDialogFragment() {

    lateinit var binding: LayoutBottomMenuFragmentBinding
    private val listAdapter: BottomMenuAdapter by lazy { BottomMenuAdapter() }

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
            tvTitle.text = title
            rvContent.adapter = listAdapter
        }

        listAdapter.updateItems(items.toList())
    }

    companion object {
        fun newInstance(
            items: Array<BottomMenuItem>,
            title: String? = null
        ): BottomMenuFragment {
            return BottomMenuFragment(
                items, title
            )
        }
    }
}

class BottomMenuAdapter : BaseRecyclerAdapter<BottomMenuItem, ItemBottomMenuBinding>(
    R.layout.item_bottom_menu
)

data class BottomMenuItem(
    val content: String,
    val isBold: Boolean = false
)