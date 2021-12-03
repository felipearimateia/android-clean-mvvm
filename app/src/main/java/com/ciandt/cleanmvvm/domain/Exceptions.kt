package com.ciandt.cleanmvvm.domain

import com.ciandt.cleanmvvm.R

data class EmailException(
    val error: Int = R.string.app_name,
): Exception()

data class EmailSizeException(
    val error: Int = R.string.app_name
): Exception()