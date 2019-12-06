package com.timpolicar.jetpacknavigationcomponenttutorial


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    //You should inflate your layout in onCreateView but shouldn't initialize other views in onCreateView. SO these views are instantiated here. onViewCreated is a make sure that view is fully created.
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view) //here we instantiate nav controller who takes care of navigation
        //init all buttons
        view_transactions_btn.setOnClickListener(this)
        send_money_btn.setOnClickListener(this)
        view_balance_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //!! = converts any value to a non-null type and throws an exception if the value is null
        when(v!!.id){
            R.id.view_transactions_btn -> navController!!.navigate(R.id.action_mainFragment_to_viewTransactionFragment) //if that button is clicked move to viewTransactionFragment
            R.id.send_money_btn -> navController!!.navigate(R.id.chooseRecipientFragment)
            R.id.view_balance_btn -> navController!!.navigate(R.id.action_mainFragment_to_viewBalanceFragment)
        }
    }


}
