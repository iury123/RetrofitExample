package com.example.iurymiguel.retrofitexample.views.authentication
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.iurymiguel.retrofitexample.R
import com.example.iurymiguel.retrofitexample.databinding.FragmentSignInBinding
import com.example.iurymiguel.retrofitexample.models.LoggedUser
import com.example.iurymiguel.retrofitexample.viewmodels.AuthenticationViewModel
import kotlinx.android.synthetic.main.fragment_sign_in.*
import org.koin.android.viewmodel.ext.android.viewModel


class SignInFragment : Fragment() {

    private val mViewModel: AuthenticationViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentSignInBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_sign_in, container, false)

        binding.fragment = this

        return binding.root
    }

    fun signIn() {

        val loggedUser = LoggedUser(
            editPassword.text.toString(),
            editPassword.text.toString()
        )
    }


    fun goToRegisterPage() {
        view!!.findNavController().navigate(R.id.action_signInFragment_to_signUpFragment)
    }

    companion object {
        @JvmStatic
        fun newInstance() = SignInFragment()
    }
}
