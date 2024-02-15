package kz.tutorial.jsonplaceholdertypicode.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.tutorial.jsonplaceholdertypicode.databinding.FragmentUsersBinding
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersFragment : Fragment() {

    private lateinit var binding: FragmentUsersBinding
    private lateinit var adapter: UsersAdapter
    private val viewModel: UsersViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        initAdapter()
        initObservers()
        return binding.root
    }

    private fun initAdapter() {
        adapter = UsersAdapter()
        adapter.listener = ClickListener {

        }
        binding.recycleUsers.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        binding.recycleUsers.adapter = adapter
        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        binding.recycleUsers.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        viewModel.usersLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is UsersState.Error -> {

                }

                UsersState.Loading -> {

                }

                is UsersState.Success -> {
                    adapter.setData(it.listUsers)
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

}