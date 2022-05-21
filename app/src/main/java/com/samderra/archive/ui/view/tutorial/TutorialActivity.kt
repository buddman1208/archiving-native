package com.samderra.archive.ui.view.tutorial

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.samderra.archive.R
import com.samderra.archive.base.BaseVmActivity
import com.samderra.archive.databinding.ActivityTutorialBinding
import com.samderra.archive.ui.view.main.MainActivity
import com.samderra.archive.ui.view.tutorial.fragment.TutorialFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class TutorialActivity() : BaseVmActivity<ActivityTutorialBinding>(
    R.layout.activity_tutorial,
    TutorialViewModel::class.java
) {
    private val pageScrollListener by lazy {
        object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val isEndPage = position == 2
                binding.btnStart.isClickable = isEndPage

                val btnStartAlpha = when (position) {
                    2 -> 1.0f
                    1 -> positionOffset
                    else -> 0f
                }

                binding.run {
                    btnStart.alpha = btnStartAlpha
                    tvNext.alpha = 1 - btnStartAlpha
                    tvSkip.alpha = 1 - btnStartAlpha
                }
            }
        }
    }

    private val pageAdapter by lazy { FragmentPagerAdapter(this@TutorialActivity) }

    override fun initActivity() {
        binding.vpTutorial.run {
            adapter = pageAdapter
        }
        binding.tvSkip.setOnClickListener { finishAndStartMain() }
        binding.btnStart.setOnClickListener { finishAndStartMain() }
        binding.tvNext.setOnClickListener {
            binding.vpTutorial.nextPage()
        }
    }

    private fun finishAndStartMain() {
        startActivity(
            Intent(this@TutorialActivity, MainActivity::class.java)
        )
        finish()
    }

    override fun onResume() {
        super.onResume()
        binding.vpTutorial.registerOnPageChangeCallback(pageScrollListener)
    }

    override fun onPause() {
        super.onPause()
        binding.vpTutorial.unregisterOnPageChangeCallback(pageScrollListener)
    }

    override val viewModel: TutorialViewModel by viewModel()
    override val toolbarId: Int = 0

    private inner class FragmentPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment =
            TutorialFragment.newInstance(position)
    }
}


fun ViewPager2.nextPage() {
    setCurrentItem(currentItem + 1, true)
}