package edu.msudenver.cs3013.colorfragments

// Brandon Hornick

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ChoiceFragment : Fragment() {

    private var choiceListener: ChoiceListener? = null

    interface ChoiceListener {
        fun onSelected(id: Int)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ChoiceListener) {
            choiceListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val blueT = view.findViewById<TextView>(R.id.blueText)
        val redT = view.findViewById<TextView>(R.id.redText)

        blueT.setOnClickListener {
            choiceListener?.onSelected(1)
        }

        redT.setOnClickListener {
            choiceListener?.onSelected(2)
        }
    }
}