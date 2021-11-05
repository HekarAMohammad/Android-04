package com.example.android_04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.example.android_04.adapter.ContacrAdapter
import com.example.android_04.databinding.ActivityMainBinding
import com.example.android_04.model.Contact
import kotlin.contracts.contract

class MainActivity : AppCompatActivity() {
    lateinit var contactList: ArrayList<Contact>
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()


        /*
        val contactlist = ArrayList<String>()
        contactlist.add("hekar")
        contactlist.add("doski")
        contactlist.add("nzar")
        contactlist.add("moz")
        val conttactAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,contactlist)

        binding.lvNames.adapter = conttactAdapter*/

        contactList = ArrayList()
        contactList.add(Contact("hekar","07504030788",R.drawable.ic_launcher_background))
        /*
        contactList.add(Contact("doski","08550005",R.drawable.ic_launcher_background))
        contactList.add(Contact("moh","03255884",R.drawable.ic_launcher_background))
        contactList.add(Contact("muz","07504440508",R.drawable.ic_launcher_background))
        contactList.add(Contact("hekar","07504030788",R.drawable.ic_launcher_background))
        contactList.add(Contact("doski","08550005",R.drawable.ic_launcher_background))
        contactList.add(Contact("moh","03255884",R.drawable.ic_launcher_background))
        contactList.add(Contact("muz","07504440508",R.drawable.ic_launcher_background))*/
        setUprecicularView()
        binding.btnAdd.setOnClickListener{
            if (binding.editName.text.isEmpty())
            {
                binding.editName.setError("enter the name")
            }
            else if (binding.editNumber.text.isEmpty())
            {
                binding.editNumber.setError("enter the number")
            }
            else {
                val contactName = binding.editName.text.toString()
                val contactNumber = binding.editNumber.text.toString()
                contactList.add(Contact(contactName,contactNumber,R.drawable.ic_launcher_foreground))
                binding.editName.text.clear()
                binding.editNumber.text.clear()
                setUprecicularView()
            }
        }
    }

    private  fun setUprecicularView(){
        val contactAdapter = ContacrAdapter(this,contactList)
        //binding.rvContactlist.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        // binding.rvContactlist.layoutManager =  LinearLayoutManager(this)
        binding.rvContactlist.adapter = contactAdapter

    }

    fun deletContact(contact: Contact){
        contactList.remove(contact)
        setUprecicularView()
    }
}