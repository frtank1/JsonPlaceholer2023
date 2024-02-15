package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details.comments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import kz.tutorial.jsonplaceholdertypicode.databinding.FragmentCommentsBinding
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CommentsFragment : Fragment() {

    private var _binding : FragmentCommentsBinding? = null
    private val binding get() = _binding!!
    private  lateinit var  adapter: CommetsAdapter
    private val viewModel: CommentsViewModel by viewModel{
        parametersOf(arguments?.getInt("id", 0))
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommentsBinding.inflate(inflater,container,false)
        adapter = CommetsAdapter()
        binding.recycleComments.layoutManager =  LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        binding.recycleComments.adapter =adapter
        init()
        initObservers()
        return binding.root
    }

    private fun init() {

        val spaceItemDecoration = SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        binding.recycleComments.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers() {
       viewModel.commentsDetailsLiveData.observe(viewLifecycleOwner){
           when(it){
               is CommentsState.Error -> {

               }
               CommentsState.Loading -> {

               }
               is CommentsState.Success -> {
                   adapter.setData(it.listComment)
                   adapter.notifyDataSetChanged()
               }
           }
       }
    }


}