package com.rhymartmanchus.kointraining.domain

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class AppDispatcher {

    open fun ui(): CoroutineContext = Dispatchers.Default
    open fun io(): CoroutineContext = Dispatchers.IO

}