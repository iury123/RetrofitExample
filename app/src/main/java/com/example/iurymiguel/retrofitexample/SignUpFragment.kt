package com.example.iurymiguel.retrofitexample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.iurymiguel.retrofitexample.databinding.FragmentSignUpBinding
import com.example.iurymiguel.retrofitexample.interfaces.ConnectionCallbacks
import com.example.iurymiguel.retrofitexample.pojos.LoggedUser
import com.example.iurymiguel.retrofitexample.providers.ProgressDialogProvider
import com.example.iurymiguel.retrofitexample.viewmodels.AuthenticationViewModel
import kotlinx.android.synthetic.main.fragment_sign_in.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class SignUpFragment : Fragment() {

    private val mViewModel: AuthenticationViewModel by viewModel()
    private val mProgressDialog: ProgressDialogProvider by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentSignUpBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_sign_up, container, false)

        binding.fragment = this

        return binding.root
    }


    fun signUp() {
        val loggedUser = LoggedUser(
            editPassword.text.toString(),
            editPassword.text.toString()
        )
        mProgressDialog.show(context)
        mViewModel.signUp(loggedUser, object : ConnectionCallbacks {
            override fun onSuccessConnection(response: Any?) {
                mProgressDialog.dismiss()
            }

            override fun onFailedConnected(error: Any?) {
                mProgressDialog.dismiss()
            }
        })
    }


    companion object {
        @JvmStatic
        fun newInstance() = SignUpFragment()
    }
}
