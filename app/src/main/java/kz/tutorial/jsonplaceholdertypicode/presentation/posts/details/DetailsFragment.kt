package kz.tutorial.jsonplaceholdertypicode.presentation.posts.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import kz.tutorial.jsonplaceholdertypicode.databinding.FragmentDetailsBinding
import kz.tutorial.jsonplaceholdertypicode.domain.model.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.model.Post
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ID
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.extensions.openEmailWithAddress
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    private val id_post: Int by lazy {
        arguments?.getInt(ID, 0) ?: 0
    }

    private val viewModel: DetailsViewModel by viewModel {
        parametersOf(id_post)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailsBinding.inflate(inflater, container, false)
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
                        changeLoading()
                    }

                    is PostState.Success -> {
                        changeLoading()
                        initTitle(it.post, it.name)
                        initComments(it.listComment)
                    }
                }
            }
        }

    }

    private fun changeLoading() {
        if (binding.loading.visibility == View.GONE) {
            binding.loading.visibility = View.VISIBLE
        } else {
            binding.loading.visibility = View.GONE
        }
    }

    private fun initTitle(post: Post, name: String) {
        with(binding) {
            titleMain.text = post.title
            body.text = post.body
            userName.text = name
        }
    }

    private fun initComments(list: List<Comment>) {
        with(binding) {
            with(comments) {
                with(firstCommit) {
                    title.text = list[0].name
                    bodyComments.text = list[0].body
                    mail.text = list[0].email
                }
                with(secondCommit) {
                    title.text = list[1].name
                    bodyComments.text = list[1].body
                    mail.text = list[1].email
                }
                with(thirdCommit) {
                    title.text = list[2].name
                    bodyComments.text = list[2].body
                    mail.text = list[2].email
                }

            }
        }

    }

    private fun observeOnclick() {
        binding.showAll.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(
                DetailsFragmentDirections.detailsToComments(
                    id_post
                )
            )
        }
        with(binding) {

            with(comments) {
                obesrveCommit(firstCommit.mail)
                obesrveCommit(secondCommit.mail)
                obesrveCommit(thirdCommit.mail)

            }
        }

    }

        private fun obesrveCommit(view:TextView){
            view.setOnClickListener {
                context?.openEmailWithAddress(view.text.toString())
            }
        }


}