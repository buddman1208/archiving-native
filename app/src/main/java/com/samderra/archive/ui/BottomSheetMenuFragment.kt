package com.samderra.archive.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.samderra.archive.R
import com.samderra.archive.base.BaseRecyclerAdapter
import com.samderra.archive.databinding.ItemBottomMenuBinding
import com.samderra.archive.databinding.LayoutBottomMenuFragmentBinding

class BottomMenuFragment
private constructor() : BottomSheetDialogFragment() {

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
        binding.rvContent.adapter = listAdapter

        arguments?.getStringArray("items")?.let {
            listAdapter.updateItems(it.toList())
        } ?: run {
            Toast.makeText(context, "argument null", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        fun newInstance(
            items: Array<String>
        ): BottomMenuFragment {
            val fragment = BottomMenuFragment()
            fragment.arguments = Bundle().apply {
                putStringArray("items", items)
            }
            return fragment
        }
    }
}

class BottomMenuAdapter : BaseRecyclerAdapter<String, ItemBottomMenuBinding>(
    R.layout.item_bottom_menu
)