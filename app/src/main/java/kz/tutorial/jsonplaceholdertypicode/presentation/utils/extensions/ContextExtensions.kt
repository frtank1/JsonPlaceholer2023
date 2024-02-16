package kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, length).show()
}

fun Context.showToast(@StringRes resId: Int, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resId, length).show()
}

fun Context?.openEmailWithAddress(email: String) {
    if (this == null) return

    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:$email")
    }

    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        this?.showToast("No email app")
    }
}