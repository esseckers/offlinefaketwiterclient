package com.esseckers.test.app.offlinefaketwitterclient.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.esseckers.test.app.offlinefaketwitterclient.presentation.AppActivity
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Ivan Danilov.
 */

/**
 * BaseFragment describes base methods for else fragments
 */
abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : Fragment(), BaseView {

    abstract val layoutRes: Int
    abstract val presenter: BasePresenter<V>
    open val progressView: View? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        appActivity = activity as AppActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(layoutRes, container, false)

    @Suppress("UNCHECKED_CAST")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttachView(this as V)
        initView()
    }


    open fun initView() {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onDestroyView()
    }

    open lateinit var appActivity: AppActivity

    override fun showError(errorRes: Int) {
        view?.let {
            Snackbar.make(it, errorRes, Snackbar.LENGTH_LONG).show()
        }
    }

    override fun showLoadingProgress(visibility: Int) {
        progressView?.let {
            it.visibility = visibility
        }
    }
}