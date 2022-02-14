package kr.co.openit.digitaltwin.tablinghw.view

import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kr.co.openit.digitaltwin.tablinghw.util.Util.dpToPx


class RecyclerViewItemDecoration(
    private val context: Context,
    private val topPadding: Int,
    private val bottomPadding: Int,
    private val leftPadding: Int,
    private val rightPadding: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position: Int = parent.getChildAdapterPosition(view)
        val itemCount = state.itemCount

        if (position == 0) {
            outRect.top = dpToPx(context, topPadding + 30)
        } else {
            outRect.top = dpToPx(context, topPadding)
        }

        if (position == itemCount - 1) {
            outRect.bottom = dpToPx(context, bottomPadding + 30)
        } else {
            outRect.bottom = dpToPx(context, bottomPadding)
        }

        outRect.left = dpToPx(context, leftPadding)
        outRect.right = dpToPx(context, rightPadding)
    }

}