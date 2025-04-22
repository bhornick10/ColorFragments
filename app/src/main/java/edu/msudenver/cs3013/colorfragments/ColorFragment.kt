package edu.msudenver.cs3013.colorfragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ColorFragment : Fragment() {

    companion object {
        private var fragmentCount = 0

        fun newInstance(choice: Int): ColorFragment {
            val fragment = ColorFragment()
            val args = Bundle()
            args.putInt("COLOR CHOICE", choice)
            fragment.arguments = args
            return fragment
        }
    }

    private var myIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            fragmentCount++
            myIndex = fragmentCount
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val choiceId = arguments?.getInt("COLOR CHOICE", 0) ?: 0
        val textView = view.findViewById<TextView>(R.id.mycolor)

        when (choiceId) {
            1 -> {
                textView.text = "GENERIC BLUE FRAGMENT – UID $myIndex"
                view.setBackgroundColor(Color.rgb(150, 150, 255))
            }
            2 -> {
                textView.text = "GENERIC RED FRAGMENT – UID $myIndex"
                view.setBackgroundColor(Color.rgb(255, 150, 150))
            }
        }
    }
}
