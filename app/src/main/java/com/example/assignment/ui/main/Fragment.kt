package com.example.assignment.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assignment.R

class Fragment : Fragment() {

    companion object {
        fun newInstance(someData: Int): Fragment{
            val fragment = Fragment()
            val bundle = Bundle()
            bundle.putInt("ABC", someData)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var viewModel: FragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle = arguments
        viewModel = ViewModelProvider(this)[FragmentViewModel::class.java]
        // TODO: Use the ViewModel
    }

}