package kz.tutorial.jsonplaceholdertypicode.presentation.todos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.tutorial.jsonplaceholdertypicode.databinding.FragmentToDosBinding
import kz.tutorial.jsonplaceholdertypicode.presentation.users.user.UserState
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.DEFAULT_STRING
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ID
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.openLocation
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ToDosFragment : Fragment() {
    private lateinit var binding: FragmentToDosBinding
    private val viewModel: ToDosViewModel by viewModel {
        parametersOf(ToDosFragmentArgs.fromBundle(requireArguments()).id)
    }
    private lateinit var adapter: TodoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToDosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initTodoListView()
        initObserver()
    }

    private fun initTodoListView() {
        adapter = TodoAdapter()
        binding.rvTodos.layoutManager = LinearLayoutManager(context)
        binding.rvTodos.adapter = adapter
    }


        fun initObserver() {
        viewModel.todoListLiveData.observe(viewLifecycleOwner) {
            with(binding) {
                when (it) {
                    is ToDosState.Error -> {
                    }

                    ToDosState.Loading -> {
                        changeLoading(true)
                    }

                    is ToDosState.Success -> {
                        adapter.setData(it.todos)
                        changeLoading(false)
                    }
                }
            }
        }

    }

    private fun changeLoading(status: Boolean) {
        when (status) {
            true -> binding.loading.visibility = View.VISIBLE
            else -> binding.loading.visibility = View.GONE
        }
    }

}