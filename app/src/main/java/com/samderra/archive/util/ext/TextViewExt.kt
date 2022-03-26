package com.samderra.archive.util.ext

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.samderra.archive.R

@BindingAdapter("highLightTargetText")
fun TextView.highListTargetText(targetText: String) {
    val index = this.text.indexOf(targetText)
    if (index > -1) {
        val highlighted = SpannableString(this.text)
        val foregroundSpan = ForegroundColorSpan(
            ContextCompat.getColor(this.context, R.color.green200)
        )
        highlighted.setSpan(
            foregroundSpan,
            index,
            index + targetText.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        this.text = highlighted
    } else {
        this.text = this.text
    }
}