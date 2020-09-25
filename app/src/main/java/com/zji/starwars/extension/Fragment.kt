package com.zji.starwars.extension

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import androidx.viewbinding.ViewBinding
import java.lang.reflect.Method
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified VB : ViewBinding> Fragment.viewBinding(): FragmentViewBindingDelegate<VB> {
    val bindMethod = VB::class.java.getDeclaredMethod("bind", View::class.java)
    return FragmentViewBindingDelegate(this, bindMethod)
}

class FragmentViewBindingDelegate<VB : ViewBinding>(
    private val fragment: Fragment,
    private val method: Method
) : ReadOnlyProperty<Fragment, VB> {
    private var binding: VB? = null

    init {
        fragment.lifecycle.addObserver(
            object : DefaultLifecycleObserver {
                override fun onCreate(owner: LifecycleOwner) {
                    fragment.viewLifecycleOwnerLiveData.observe(fragment) { viewLifecycleOwner ->
                        viewLifecycleOwner.lifecycle.addObserver(
                            object : DefaultLifecycleObserver {
                                override fun onDestroy(owner: LifecycleOwner) {
                                    binding = null
                                }
                            }
                        )
                    }
                }
            }
        )
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): VB {
        val binding = binding
        if (binding != null) {
            return binding
        }

        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            throw IllegalStateException("Should not attempt to get bindings when Fragment views are destroyed.")
        }

        return method.invoke(null, thisRef.requireView())
            .let { it as? VB }
            ?.also { this.binding = it }
            ?: throw IllegalStateException("Invalid ViewBinding")
    }
}
