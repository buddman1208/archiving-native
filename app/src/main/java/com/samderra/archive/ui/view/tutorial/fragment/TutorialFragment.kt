package com.samderra.archive.ui.view.tutorial.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.samderra.archive.R

class TutorialFragment private constructor() : Fragment() {

    private val pageIndex by lazy { arguments?.getInt(PAGE_INDEX) ?: 0 }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = when (pageIndex) {
            0 -> R.layout.fragment_tutorial_1
            1 -> R.layout.fragment_tutorial_2
            else -> R.layout.fragment_tutorial_3
        }
        return inflater.inflate(layout, container, false)
    }

    companion object {
        private const val PAGE_INDEX = "pageIndex"
        fun newInstance(pageIndex: Int): TutorialFragment {
            val args = Bundle().apply { putInt(PAGE_INDEX, pageIndex) }
            return TutorialFragment().apply { arguments = args }
        }
    }
}