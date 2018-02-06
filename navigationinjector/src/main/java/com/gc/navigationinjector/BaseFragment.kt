package com.gc.navigationinjector

import android.content.*
import android.databinding.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*

abstract class BaseFragment : Fragment(), NavigationManager, ViewManager {

    class Default : BaseFragment()

    override lateinit var currentOperation : Operation
    override lateinit var currentState : BaseState
    override var currentFragment : BaseFragment? = null
    override lateinit var currentActivity : BaseActivity

    override fun navigateTo(state : BaseState) = navigationManager?.navigateTo(state)!!

    override fun navigateBack() = navigationManager?.navigateBack()!!

    lateinit var viewModel : BaseViewModel

    override lateinit var binding : ViewDataBinding

    var navigationManager : NavigationManager? = null
        set(value) {
            field = value
            currentOperation = navigationManager!!.currentOperation
            currentState = navigationManager!!.currentState
            currentFragment = navigationManager!!.currentFragment
            currentActivity = navigationManager!!.currentActivity
        }


    override fun onCreateView(inflater : LayoutInflater?,
                              container : ViewGroup?,
                              savedInstanceState : Bundle?
    ) : View? {
        viewModel.navigationManager = this
        viewModel.viewManager = this
        binding =  DataBindingUtil.inflate<ViewDataBinding>(inflater!!, viewModel.getLayout(),null,false)
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }

    //region LifeCycle
    override fun onViewCreated(view : View?,
                               savedInstanceState : Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onCreate()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }
    //endregion


    //region ViewManager implementation
    override fun getContext() : Context = activity

    override fun getView() : View = binding.root

    override fun showProgressDialog(message : String?) = DialogManager.showProgress(activity)

    override fun hideProgressDialog() = DialogManager.hideProgressDialog(activity)

    override fun showDialog(message : String,
                    title : String?,
                    buttonAcceptText : String?,
                    buttonAcceptListener : DialogInterface.OnClickListener?,
                    buttonCancelText : String?,
                    buttonCancelListener : DialogInterface.OnClickListener?) =
            DialogManager.showDialog(activity,message,title,buttonAcceptText, buttonAcceptListener, buttonCancelText, buttonCancelListener)

    override fun hideDialog() {
        DialogManager.hideDialog()
    }

    //endregion

}

