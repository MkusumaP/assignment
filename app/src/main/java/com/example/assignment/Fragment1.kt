package com.example.assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.ui.main.FragmentViewModel

class Fragment1 : Fragment(), FragmentOneListener {

    companion object{
        fun newInstance() = Fragment1()
    }

    lateinit var model: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val data = arrayListOf<String>()
        for (i in 1..20){
            data.add("Item $i")
        }

        val adapter = FragmentOneAdapter(requireContext(), data, this)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(),LinearLayoutManager.VERTICAL))
        recyclerView.adapter = adapter
    }

    override fun onButtonClicked(data: String) {
        model.setMessage(data)
        val tag = "Fragment2"
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, Fragment2.newInstance(), tag)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.addToBackStack(tag)
        transaction.commit()
    }
}