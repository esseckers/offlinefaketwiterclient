package com.esseckers.test.app.offlinefaketwiterclient.presentation.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.esseckers.test.app.offlinefaketwiterclient.presentation.AppActivity

/**
 * Created by Ivan Danilov.
 */
abstract class BaseFragment : Fragment() {

    abstract val layoutRes: Int

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    open fun initView() {
    }

    open lateinit var appActivity: AppActivity
}