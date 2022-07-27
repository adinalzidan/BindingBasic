package com.example.databindingbasic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.databindingbasic.databinding.FragmentOneBinding
import com.example.databindingbasic.databinding.FragmentTwoBinding


class FragmentTwo : Fragment() {

    val question = arrayOf(
        "Apa yang kamu minum saat Kerja?",
        "Apa yang kamu minum saat sedang Relax?",
        "Apa yang kamu minum saat menonton Film?"
    )

    var yes = 0
    var no = 0
    var all = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTwoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_two, container, false)

        binding.question.text = question[all]
        binding.button.setOnClickListener {
            yes++
            nextAll(binding)
        }
        binding.button2.setOnClickListener {
            no++
            nextAll(binding)
        }

        return binding.root

    }

    fun nextAll(binding: FragmentTwoBinding) {
        all++

        if (all < question.size) {
            binding.question.text = question[all]
        } else {
            var result = ""
            if (yes >= 1 && no >= 1) {
                result = "Kamu Suka Dua Duanya"
            } else if (yes < 1) {
                result = "Kamu Pecinta Teh"
            } else {
                result = "Kamu Pecinta Kopi"
            }
            view!!.findNavController()
                .navigate(FragmentTwoDirections.actionFragmentTwoToFragmentFinish(result))
        }
    }
}