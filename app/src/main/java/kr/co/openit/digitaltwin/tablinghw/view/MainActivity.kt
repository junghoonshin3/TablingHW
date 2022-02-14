package kr.co.openit.digitaltwin.tablinghw.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import kr.co.openit.digitaltwin.tablinghw.R
import kr.co.openit.digitaltwin.tablinghw.databinding.ActivityScrollingBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityScrollingBinding

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.toolbarLayout.title = "관심매장"


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        navController = navHostFragment.navController

    }

    fun setTabLayoutMediator(vp: ViewPager2, titleArray: Array<String>) {
        binding.tablayout.run {
            for (i in titleArray.indices) {
                addTab(newTab())
            }
        }
        TabLayoutMediator(
            binding.tablayout,
            vp
        ) { tab, position ->
            tab.text = titleArray[position]
        }.attach()
    }
}