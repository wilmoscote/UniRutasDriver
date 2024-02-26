package com.wmsoftware.unirutasdriver.util.extensions

import android.app.Activity
import android.view.WindowManager
import com.wmsoftware.unirutasdriver.R

fun Activity.setupStatusBar(color: Int = R.color.uniguajira_orange) {
    val window = this.window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.statusBarColor = this.resources.getColor(color)
}