package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.comments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.tutorial.jsonplaceholdertypicode.databinding.FragmentCommentsBinding
import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class CommentsFragment : Fragment() {

    private lateinit var binding: FragmentCommentsBinding

    private lateinit var adapter: CommetsAdapter
    private val viewModel: CommentsViewModel by viewModel {
        parametersOf(arguments?.getInt("id", 0))
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommentsBinding.inflate(inflater, container, false)

        initAdapter()
        initObservers()
        return binding.root
    }

    private fun initAdapter() {
        adapter = CommetsAdapter()
        binding.recycleComments.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        binding.recycleComments.adapter = adapter
        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        binding.recycleComments.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
        viewModel.commentsDetailsLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is CommentsState.Error -> {

                }

                CommentsState.Loading -> {

                }

                is CommentsState.Success -> {
                    changeAdapter(it.listComment)
                }
            }
        }
    }

    private fun changeAdapter(list: List<Comment>){
        adapter.setData(list)
        adapter.notifyDataSetChanged()
    }


}