package kr.co.openit.digitaltwin.tablinghw.view.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kr.co.openit.digitaltwin.tablinghw.R
import kr.co.openit.digitaltwin.tablinghw.databinding.FragmentFavoriteBinding
import kr.co.openit.digitaltwin.tablinghw.view.BaseFragment
import kr.co.openit.digitaltwin.tablinghw.view.MainActivity
import kr.co.openit.digitaltwin.tablinghw.view.ViewPagerAdapter
import kr.co.openit.digitaltwin.tablinghw.viewmodel.FavoriteViewModel

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {


    override fun createViewModelClass(): Class<FavoriteViewModel> {
        return FavoriteViewModel::class.java
    }

    companion object Factory {
        fun create(): FavoriteFragment {
            return FavoriteFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var fragment = arrayListOf<Fragment>(SaveFragment.create(), RecentFragment.create())

        binding.vpFavorite.apply {
            adapter = ViewPagerAdapter(parentFragmentManager, fragment, lifecycle)
            (activity as MainActivity).run {
                setTabLayoutMediator(this@apply, arrayOf("저장", "최근본"))
            }
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    when (position) {
                        0 -> {
//                            viewModel.loadSaveData()
                        }
                        1 -> {
//                            viewModel.loadRecentData()
                        }
                    }
                }
            })
        }

    }

    override fun getLayoutRes(): Int = R.layout.fragment_favorite


}