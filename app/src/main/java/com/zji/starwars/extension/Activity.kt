package com.zji.starwars.extension

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

inline fun <reified VB : ViewBinding> AppCompatActivity.viewBinding(): Lazy<VB> =
    lazy(LazyThreadSafetyMode.NONE) {
        VB::class.java
            .getDeclaredMethod("inflate", LayoutInflater::class.java)
            .invoke(null, layoutInflater) as VB
    }
