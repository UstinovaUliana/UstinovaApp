package com.example.ustinova_mobileapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup





// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PurchaseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PurchaseFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v: View = inflater.inflate(R.layout.fragment_purchase, container, false)
        var v1: View = inflater.inflate(R.layout.activity_main, container, false)
        val buttonBack: ImageButton = v.findViewById<ImageButton>(R.id.backwardBtn)
        val buttonSend: ImageButton = v.findViewById<ImageButton>(R.id.sendFileBtn)
        val buttonEnd: ImageButton = v.findViewById<ImageButton>(R.id.endBtn)
        buttonBack.setOnClickListener {
            var frgb : FirstFragment = FirstFragment()
            val activity = view!!.context as AppCompatActivity
            val fragmentManager: FragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout, frgb)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        buttonEnd.setOnClickListener {
            var frgs : StartingFragment = StartingFragment()
            val activity = view!!.context as AppCompatActivity
            val fragmentManager: FragmentManager = activity!!.supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout, frgs)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            val button1: ImageButton = activity.findViewById<ImageButton>(R.id.btn_fragment1)
            val button2: ImageButton = activity.findViewById<ImageButton>(R.id.btn_fragment2)
            button1.setImageResource(R.drawable.shop11)
            button2.setImageResource(R.drawable.shop22)
        }
        buttonSend.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://e.mail.ru"))
            startActivity(browserIntent)
            /**val intent = Intent(Intent.ACTION_SEND)
            intent.data= Uri.parse("mailto: ")
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.")
            startActivity(Intent.createChooser(intent, "Send Email"))
            */
        }
        val buttonPlus: ImageButton = v.findViewById<ImageButton>(R.id.increaseBtn)
        val buttonMinus: ImageButton = v.findViewById<ImageButton>(R.id.decreaseBtn)
        var quantity: Int = 1;
        var price: Int=9;
        val rg: RadioGroup = v.findViewById<RadioGroup>(R.id.radioGroup)
        val rb: RadioButton =  v.findViewById<RadioButton>(R.id.grayRB)
        rb.isChecked=true
        v.findViewById<EditText>(R.id.editQuantity).setText(quantity.toString())
        rg.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{ radioGroup, grayRB ->
            if (rb.isChecked)
                v.findViewById<EditText>(R.id.editPrice).setText((quantity*9).toString()+'р');
            else v.findViewById<EditText>(R.id.editPrice).setText((quantity*20).toString()+'р');
        })
        if (rb.isChecked)
        v.findViewById<EditText>(R.id.editPrice).setText((quantity*9).toString()+'р');
        else v.findViewById<EditText>(R.id.editPrice).setText((quantity*20).toString()+'р');
        buttonPlus.setOnClickListener {
                quantity++;
                v.findViewById<EditText>(R.id.editQuantity).setText(quantity.toString())
            if (rb.isChecked)
                v.findViewById<EditText>(R.id.editPrice).setText((quantity*9).toString()+'р');
            else v.findViewById<EditText>(R.id.editPrice).setText((quantity*20).toString()+'р');

        }
        buttonMinus.setOnClickListener {
            if (quantity>1) {
            quantity--;
            v.findViewById<EditText>(R.id.editQuantity).setText(quantity.toString())
                if (rb.isChecked)
                    v.findViewById<EditText>(R.id.editPrice).setText((quantity*9).toString()+'р');
                else v.findViewById<EditText>(R.id.editPrice).setText((quantity*20).toString()+'р');
            }
        }

        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PurchaseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PurchaseFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}