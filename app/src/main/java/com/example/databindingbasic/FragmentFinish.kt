package com.example.databindingbasic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.databindingbasic.databinding.FragmentFinishBinding
import com.example.databindingbasic.databinding.FragmentTwoBinding

class FragmentFinish : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_finish, container, false)
        val binding: FragmentFinishBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_finish, container, false)

        var args = FragmentFinishArgs.fromBundle(arguments!!)
        args.result
        binding.explain.text = args.result

        binding.retry.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_fragmentFinish_to_fragmentOne)
        )

        return binding.root
    }
}