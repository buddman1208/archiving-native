package com.samderra.archive.ui.view.post.fromshare

import com.samderra.archive.R
import com.samderra.archive.base.BaseVmActivity
import com.samderra.archive.databinding.ActivityPostFromShareBinding
import com.samderra.archive.ui.adapter.CategorySelectAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostFromShareActivity() : BaseVmActivity<ActivityPostFromShareBinding>(
    R.layout.activity_post_from_share,
    PostFromShareViewModel::class.java
) {

    val categorySelectAdapter: CategorySelectAdapter by lazy { CategorySelectAdapter(viewModel) }

    private fun PostFromShareViewModel.setObserves() {
    }

    override fun initActivity() {
        binding.rvCategory.adapter = categorySelectAdapter

//        if(intent?.action == Intent.ACTION_SEND) {
//            if (intent.type?.startsWith("image/") == true) {
//                (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let {
//                    // Update UI to reflect image being shared
//
//                    binding.iv.setImageURI(it)
//                }
//            }
//        }
    }

    override val viewModel: PostFromShareViewModel by viewModel()
    override val toolbarId: Int = 0
}

