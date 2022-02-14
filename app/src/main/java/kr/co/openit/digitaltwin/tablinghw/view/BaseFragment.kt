package kr.co.openit.digitaltwin.tablinghw.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import kr.co.openit.digitaltwin.tablinghw.dagger.dagger.viewmodelmodules.ViewModelFactory
import dagger.android.support.DaggerFragment
import kr.co.openit.digitaltwin.tablinghw.BR
import javax.inject.Inject

abstract class BaseFragment<B : ViewDataBinding, VM : ViewModel> :
    DaggerFragment() {

    lateinit var binding: B

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected abstract fun createViewModelClass(): Class<VM>

    lateinit var viewModel: VM

    @LayoutRes
    abstract fun getLayoutRes(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(createViewModelClass())

        binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)

        binding.setVariable(BR.viewModel, viewModel)

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root

    }
}