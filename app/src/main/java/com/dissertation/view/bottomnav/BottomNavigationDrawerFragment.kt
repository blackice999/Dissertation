package com.dissertation.view.bottomnav


import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.dissertation.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_navigation_drawer.*
import org.jetbrains.anko.toast

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_navigation_drawer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        closeMenu.setOnClickListener {
            this.dismiss()
        }

        navigation_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_profile -> activity?.toast("Clicked profile")
                R.id.action_settings -> activity?.toast("Clicked settings")
            }

            true
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        dialog.setOnShowListener {
            val bottomSheet = dialog.findViewById<View>(R.id.design_bottom_sheet) as FrameLayout?
            val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet!!)
            bottomSheetBehavior.setBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback() {
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    if (slideOffset > 0.5) {
                        closeMenu.visibility = View.VISIBLE
                    } else {
                        closeMenu.visibility = View.GONE
                    }
                }

                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    when (newState) {
                        BottomSheetBehavior.STATE_HIDDEN-> dismiss()
//                        else -> close_imageview.visibility = View.GONE
                    }
                }
            })
        }

        return dialog
    }

    companion object {
        val TAG: String = BottomNavigationDrawerFragment::class.java.simpleName
    }
}
