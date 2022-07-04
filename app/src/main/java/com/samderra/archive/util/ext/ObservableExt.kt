package com.samderra.archive.util.ext

import androidx.databinding.ObservableBoolean

fun ObservableBoolean.reverse() = this.set(this.get().not())