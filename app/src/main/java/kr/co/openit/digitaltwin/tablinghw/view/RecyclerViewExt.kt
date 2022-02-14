package kr.co.openit.digitaltwin.tablinghw.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kr.co.openit.digitaltwin.tablinghw.R
import org.w3c.dom.Text

@SuppressLint("NotifyDataSetChanged")
@BindingAdapter("replaceAll")
fun RecyclerView.replaceAll(list: List<Item>?) {
    list?.let {
        (adapter as? BaseRecyclerView.Adapter<Item, *>)?.run {
            this.replaceAll(it)
            notifyDataSetChanged()
        }
    }
}

@BindingAdapter("setImages")
fun ImageView.setImages(url: String?) {
    url?.let {
        Glide.with(this)
            .load(url)
            .apply(RequestOptions().override(300, 200))
            .fallback(R.drawable.ic_launcher_foreground)
            .into(this)
    }
}

@BindingAdapter("originalText", "partText", "color")
fun TextView.setColorString(originalText: String, partText: String, color: String) {
    text = getApartOfTextColor(originalText, partText, color)
}

fun getApartOfTextColor(
    originalText: String,
    partText: String,
    color: String
): SpannableStringBuilder {
    val str = SpannableStringBuilder(originalText)
    val textPosition = originalText.indexOf(partText)
    str.setSpan(
        ForegroundColorSpan(Color.parseColor(color)),
        textPosition, textPosition + partText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    return str
}