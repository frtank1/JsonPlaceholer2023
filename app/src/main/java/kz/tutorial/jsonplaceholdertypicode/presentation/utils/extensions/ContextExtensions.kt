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

fun Context?.openLocation(uri: Uri) {
    if (this == null) return

    val intent = Intent(Intent.ACTION_VIEW,uri)

    try {
        startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        this?.showToast("No map app")
    }
}


fun Context?.openWebsite(url: String) {
    if (this == null) return
    val webpage = Uri.parse(url)

    val browserIntent = Intent(Intent.ACTION_VIEW, webpage)

    try {
        startActivity(browserIntent)
    } catch (e: ActivityNotFoundException) {
        this?.showToast("No browser app")
    }
}