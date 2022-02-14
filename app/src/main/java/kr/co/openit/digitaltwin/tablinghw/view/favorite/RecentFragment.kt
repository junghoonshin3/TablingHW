package kr.co.openit.digitaltwin.tablinghw.view.favorite

import android.os.Bundle
import android.util.Log
import android.view.View
import kr.co.openit.digitaltwin.tablinghw.BR
import kr.co.openit.digitaltwin.tablinghw.R
import kr.co.openit.digitaltwin.tablinghw.databinding.FragmentRecentBinding
import kr.co.openit.digitaltwin.tablinghw.databinding.ItemRecentBinding
import kr.co.openit.digitaltwin.tablinghw.model.Recent
import kr.co.openit.digitaltwin.tablinghw.view.BaseFragment
import kr.co.openit.digitaltwin.tablinghw.view.BaseRecyclerView
import kr.co.openit.digitaltwin.tablinghw.view.Item
import kr.co.openit.digitaltwin.tablinghw.view.RecyclerViewItemDecoration
import kr.co.openit.digitaltwin.tablinghw.viewmodel.FavoriteViewModel

class RecentFragment : BaseFragment<FragmentRecentBinding, FavoriteViewModel>() {

    companion object Factory {
        fun create(): RecentFragment {
            return RecentFragment()
        }
    }

    override fun createViewModelClass(): Class<FavoriteViewModel> {
        return FavoriteViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_recent
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvRecent.apply {
            addItemDecoration(RecyclerViewItemDecoration(requireContext(), 10, 10, 15, 0))
            adapter = object : BaseRecyclerView.Adapter<Recent, ItemRecentBinding>(
                layoutResId = R.layout.item_recent,
                bindingListenerId = BR.listener,
                bindingVariableId = BR.recent
            ) {
                override fun onItemClick(item: Recent) {
                    Log.i("sjh", item.restaurantName)
                }

            }
        }
    }

}