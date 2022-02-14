package kr.co.openit.digitaltwin.tablinghw.view.favorite

import android.os.Bundle
import android.util.Log
import android.view.View
import kr.co.openit.digitaltwin.tablinghw.BR
import kr.co.openit.digitaltwin.tablinghw.R
import kr.co.openit.digitaltwin.tablinghw.databinding.FragmentSaveBinding
import kr.co.openit.digitaltwin.tablinghw.databinding.ItemSaveBinding
import kr.co.openit.digitaltwin.tablinghw.model.Save
import kr.co.openit.digitaltwin.tablinghw.view.BaseFragment
import kr.co.openit.digitaltwin.tablinghw.view.BaseRecyclerView
import kr.co.openit.digitaltwin.tablinghw.view.Item
import kr.co.openit.digitaltwin.tablinghw.view.RecyclerViewItemDecoration
import kr.co.openit.digitaltwin.tablinghw.viewmodel.FavoriteViewModel

class SaveFragment : BaseFragment<FragmentSaveBinding, FavoriteViewModel>() {

    companion object Factory {
        fun create(): SaveFragment {
            return SaveFragment()
        }
    }

    override fun createViewModelClass(): Class<FavoriteViewModel> {
        return FavoriteViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_save

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSave.apply {
            addItemDecoration(RecyclerViewItemDecoration(requireContext(), 10, 10, 20, 0))
            adapter = object : BaseRecyclerView.Adapter<Save, ItemSaveBinding>(
                layoutResId = R.layout.item_save,
                bindingListenerId = BR.listener,
                bindingVariableId = BR.save
            ) {
                override fun onItemClick(item: Save) {
                    Log.i("sjh", item.restaurantName)
                }

            }
        }

    }

}