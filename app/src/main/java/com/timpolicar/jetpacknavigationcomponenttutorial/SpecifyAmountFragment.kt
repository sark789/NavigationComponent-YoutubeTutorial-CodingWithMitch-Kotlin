package com.timpolicar.jetpacknavigationcomponenttutorial


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipient.*
import kotlinx.android.synthetic.main.fragment_choose_recipient.cancel_btn
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import kotlinx.android.synthetic.main.fragment_specify_amount.view.*
import java.math.BigDecimal

/**
 * A simple [Fragment] subclass.
 */
class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var recipient : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient =
            arguments!!.getString("recipient").toString() // getting the passed info from previous fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        send_btn.setOnClickListener(this)
        cancel_btn2.setOnClickListener(this)

        val message = "Sending money to $recipient"
        view.recipient.text = message

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.send_btn -> {
                if(!TextUtils.isEmpty(input_amount.text.toString())){
                    val amount = Money(BigDecimal(input_amount.text.toString()))
                    val bundle = bundleOf("recipient" to recipient,
                        "amount" to amount)
                    navController!!.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment,
                        bundle)
                }else{
                    Toast.makeText(activity, "Enter an amount", Toast.LENGTH_SHORT).show()
                }

            }
            R.id.cancel_btn2 -> {
                activity!!.onBackPressed() // same as pressing the back arrow
            }
        }
    }
}
