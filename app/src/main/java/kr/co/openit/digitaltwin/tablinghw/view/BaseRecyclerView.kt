package kr.co.openit.digitaltwin.tablinghw.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.BaseObservable
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerView {

    interface OnItemClickListener<T> {
        fun onItemClick(item: T)
    }

    abstract class Adapter<ITEM : Item, B : ViewDataBinding>(
        @LayoutRes
        private val layoutResId: Int,
        private val bindingVariableId: Int? = null,
        private val bindingListenerId: Int? = null
    ) : RecyclerView.Adapter<ViewHolder<B>>(), OnItemClickListener<ITEM> {

        private val items = mutableListOf<Item>()

        fun replaceAll(items: List<Item>?) {
            items?.let {
                this.items.run {
                    clear()
                    addAll(it)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> {

            val binding: B = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutResId,
                parent,
                false
            )
            bindingListenerId?.let {
                binding.setVariable(it, this)
            }

            return object : ViewHolder<B>(
                bindingVariableId = bindingVariableId,
                binding = binding
            ) {}
        }


        override fun getItemCount() = items.size

        override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) {
            holder.onBindViewHolder(items[position])
            holder.binding.executePendingBindings()
        }
    }

    abstract class ViewHolder<B : ViewDataBinding>(
        private val bindingVariableId: Int?,
        val binding: B
    ) : RecyclerView.ViewHolder(
        binding.root
    ) {


        fun onBindViewHolder(item: Item?) {
            try {
                bindingVariableId?.let {
                    binding.setVariable(it, item)
                }
                binding.executePendingBindings()

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}


abstract class Item : BaseObservable() {

}

