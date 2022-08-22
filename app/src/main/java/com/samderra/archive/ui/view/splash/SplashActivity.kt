package com.samderra.archive.ui.view.splash

import android.annotation.SuppressLint
import android.content.Intent
import com.samderra.archive.R
import com.samderra.archive.base.BaseVmActivity
import com.samderra.archive.databinding.ActivitySplashBinding
import com.samderra.archive.ui.view.tutorial.TutorialActivity
import com.samderra.archive.util.observeEvent
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity() : BaseVmActivity<ActivitySplashBinding>(
    R.layout.activity_splash,
    SplashViewModel::class.java
) {
    private fun SplashViewModel.setObserves() {
        event.observeEvent(lifecycleOwner) {
            when (it) {
                SplashEvent.NEXT -> {
                    startActivity(
                        Intent(this@SplashActivity, TutorialActivity::class.java)
                    )
                    finish()
                }
            }
        }
    }

    override fun initActivity() {
        viewModel.setObserves()
    }

    override val viewModel: SplashViewModel by viewModel()
    override val toolbarId: Int = 0
}

