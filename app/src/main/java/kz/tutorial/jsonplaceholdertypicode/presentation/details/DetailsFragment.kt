package kz.tutorial.jsonplaceholdertypicode.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import kz.tutorial.jsonplaceholdertypicode.databinding.FragmentDetailsBinding
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val id_post: Int by lazy {
        arguments?.getInt("id", 0) ?: 0
    }
    private val binding get() = _binding!!

    private val viewModel: DetailsViewModel by viewModel {
        parametersOf(id_post)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews()
        observeOnclick()
    }

    fun initViews() {
        viewModel.postDetailsLiveData.observe(viewLifecycleOwner) {
            with(binding) {
                when (it) {
                    is PostState.Error -> {
                    }

                    PostState.Loading -> {
                        loading.visibility = View.VISIBLE
                    }

                    is PostState.Success -> {
                        loading.visibility = View.GONE
                        titleMain.text = it.post.title
                        body.text = it.post.body
                        with(comments) {
                            with(firstCommit) {
                                title.text = it.listComment[0].name
                                bodyComments.text = it.listComment[0].body
                                mail.text = it.listComment[0].email
                            }
                            with(secondCommit) {
                                title.text = it.listComment[1].name
                                bodyComments.text = it.listComment[1].body
                                mail.text = it.listComment[1].email
                            }
                            with(thirdCommit) {
                                title.text = it.listComment[2].name
                                bodyComments.text = it.listComment[2].body
                                mail.text = it.listComment[2].email
                            }

                        }
                    }
                }

            }
        }
    }

    private fun observeOnclick(){
        binding.showAll.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(DetailsFragmentDirections.detailsToComments(id_post))
        }
    }

}