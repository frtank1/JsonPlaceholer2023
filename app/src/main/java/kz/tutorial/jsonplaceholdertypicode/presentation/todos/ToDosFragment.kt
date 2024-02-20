package kz.tutorial.jsonplaceholdertypicode.presentation.users.user

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kz.tutorial.jsonplaceholdertypicode.databinding.FragmentToDosBinding
import kz.tutorial.jsonplaceholdertypicode.domain.model.User
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.DEFAULT_STRING
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ID
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.openEmailWithAddress
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.openLocation
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.openWebsite
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ToDosFragment : Fragment() {
    private lateinit var binding: FragmentToDosBinding
    private val viewModel: UserViewModel by viewModel {
        parametersOf(arguments?.getInt(ID, 0) ?: 0)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToDosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initObserver()
        showMapObserver()
        obesrveMail(binding.userNameCard.mail)
        openBrowser(binding.userNameCard.website)
    }


    fun initObserver() {
        viewModel.userDetailsLiveData.observe(viewLifecycleOwner) {
            with(binding) {
                when (it) {
                    is UserState.Error -> {
                    }

                    UserState.Loading -> {
                        changeLoading(true)
                    }

                    is UserState.Success -> {
                        changeLoading(false)
                        initTitle(it.user.name ?: DEFAULT_STRING)
                        initName(it.user)
                        it.user.company?.let {
                            initCompany(it)
                        }
                        it.user.address?.let {
                            initAddress(it)
                        }
                    }

                    is UserState.ShowOnMap -> {
                        openLocation(it.address)
                    }
                }
            }
        }

    }

    private fun initTitle(name: String) {
        with(binding) {
            userName.text = name
        }
    }

    private fun initName(user: User) {
        with(binding) {
            userNameCard.mail.text = user.email
            userNameCard.fullName.text = user.name
            userNameCard.phone.text = user.phone
            userNameCard.website.text = user.website
        }
    }

    private fun initCompany(company: User.Company) {
        with(binding) {
            userCompanyCard.cmName.text = company.name
            userCompanyCard.fullName.text = company.catchPhrase
            userCompanyCard.businessServices.text = company.bs
        }
    }

    private fun initAddress(address: User.Address) {
        with(binding) {
            userAddressCard.street.text = address.street
            userAddressCard.suite.text = address.suite
            userAddressCard.city.text = address.city
            userAddressCard.zipcode.text = address.zipcode
        }
    }

    private fun showMapObserver() {
        binding.userAddressCard.showOnMap.setOnClickListener {
            viewModel.openLocation()
        }
    }


    private fun changeLoading(status: Boolean) {
        when (status) {
            true -> binding.loading.visibility = View.VISIBLE
            else -> binding.loading.visibility = View.GONE
        }
    }

    private fun openLocation(uri: Uri) {
        context?.openLocation(uri)
    }

    private fun openBrowser(view: TextView) {
        view.setOnClickListener {
            context?.openWebsite(view.text.toString())
        }

    }

    private fun obesrveMail(view: TextView) {
        view.setOnClickListener {
            context?.openEmailWithAddress(view.text.toString())
        }
    }
}