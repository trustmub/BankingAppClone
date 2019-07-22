package com.trustathanas.absaclone.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelProviderFactory @Inject constructor() : ViewModelProvider.Factory {

    @Inject
    lateinit var creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>


    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val creator: Provider<out ViewModel> = creators[modelClass]
                ?: creators.entries.firstOrNull {
                    modelClass.isAssignableFrom(it.key)
                }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")

//        if (creator == null) { // if the view models has not been created
//            for ((key, value) in creators.entries) { // if its allowed set the Provider<ViewModel>
//                if (modelClass.isAssignableFrom(key)) {
//                    creator = value
//                    break
//                }
//            }
//        }
//
//        if (creator == null) {
//            throw IllegalArgumentException("unknown model class $modelClass")
//        }

//         return the provider
        return try {
            @Suppress("UNCHECKED_CAST")
            creator.get() as T

        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}