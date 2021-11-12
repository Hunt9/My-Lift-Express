package com.ahkam.myliftexpress.base

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.FrameLayout
import com.ahkam.myliftexpress.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class BaseBottomSheetDialog: BottomSheetDialogFragment() {
    //protected var pActivity: ParentActivity? = null
    protected var bottomSheet: FrameLayout? = null
    protected var currentScreen: String? = null
    protected var fullScreen: Boolean = false
    protected var animate: Boolean = true
    protected var cancelOnTouchOutside = true
    private var rootView: View? = null
    private val TAG = "BaseBottomSheetDialog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   pActivity = activity as ParentActivity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }




    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog1 = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog1.setOnShowListener { dialog ->
            val d = dialog as BottomSheetDialog
            bottomSheet = d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet!!)
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            bottomSheetBehavior.isDraggable = false
            if (fullScreen) setupFullHeight(bottomSheetBehavior)
        }
        dialog1.setCanceledOnTouchOutside(cancelOnTouchOutside)
        if (!animate) dialog1.window?.setWindowAnimations(-1)
        return dialog1
    }

    override fun getTheme(): Int = R.style.BottomSheetDialogTheme


    private fun setupFullHeight(bottomSheetBehavior: BottomSheetBehavior<FrameLayout>) {
        val layoutParams = bottomSheet?.layoutParams
        val windowHeight = getWindowHeight()
        if (layoutParams != null) {
            layoutParams.height = windowHeight
        }
        bottomSheet?.layoutParams = layoutParams
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun getWindowHeight(): Int {
        // Calculate window height for fullscreen use
        val displayMetrics = DisplayMetrics()
        (context as Activity?)?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        return displayMetrics.heightPixels
    }

    fun getPersistentView(inflater: LayoutInflater?, container: ViewGroup?, layout: Int): View? {
        if (rootView == null) {
            // Inflate the layout for this fragment
            rootView = inflater?.inflate(layout, container, false)

        } else {
            // Do not inflate the layout again.
            // The returned View of onCreateView will be added into the fragment.
            // However it is not allowed to be added twice even if the parent is same.
            // So we must remove rootView from the existing parent view group
            // (it will be added back).
            try {
                (rootView?.getParent() as? ViewGroup)?.removeView(rootView)
            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())
            }
        }

        return rootView
    }
}