package com.samderra.archive.util.ext

import android.text.Html.FROM_HTML_MODE_COMPACT
import androidx.core.text.HtmlCompat

fun String.formatHtml() = HtmlCompat.fromHtml(this, FROM_HTML_MODE_COMPACT)