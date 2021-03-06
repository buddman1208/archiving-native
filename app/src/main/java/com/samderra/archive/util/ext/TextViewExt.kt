package com.samderra.archive.util.ext

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.samderra.archive.R

@BindingAdapter("highLightTargetText")
fun TextView.highListTargetText(targetText: String) {
    Log.e("asdf", "## highlighting $targetText")
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

@BindingAdapter("isBold")
fun TextView.isBold(isBold: Boolean) {
    if (isBold) this.typeface = Typeface.DEFAULT_BOLD
}