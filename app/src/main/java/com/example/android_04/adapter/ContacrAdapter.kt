package com.example.android_04.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_04.MainActivity
import com.example.android_04.R
import com.example.android_04.model.Contact
import com.squareup.picasso.Picasso

class ContacrAdapter (var context: Context, var contactlist:ArrayList<Contact>): RecyclerView.Adapter<ContacrAdapter.ViewHolder>(){
    inner class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
          val contactName :TextView  = itemView.findViewById(R.id.txt_name)
          val contactNumber :TextView  = itemView.findViewById(R.id.txt_number)
          val image :ImageView  = itemView.findViewById(R.id.image_contect)

        val deletbutton:ImageView =itemView.findViewById(R.id.image_delete)
        fun bind(contact: Contact , position: Int){
            contactName.text = contact.name
            contactNumber.text = contact.number
           // image.setImageResource(contact.image)

            Picasso.get().load(R.drawable.per).into(image)

            image.setOnClickListener{
                Toast.makeText(
                    itemView.context,
                    "Contact name = ${contactlist[position].name}",
                    Toast.LENGTH_SHORT
                ).show()
            }
            deletbutton.setOnClickListener{
                if (context is MainActivity ){
                    (context as MainActivity).deletContact(contact)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v:View = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
            return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = Contact(contactlist[position].name , contactlist[position].number , contactlist[position].image)
        holder.bind(contact , position)

    }

    override fun getItemCount(): Int {
        return contactlist.size
    }
}