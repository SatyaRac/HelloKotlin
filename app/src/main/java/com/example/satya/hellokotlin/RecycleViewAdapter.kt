package com.example.satya.hellokotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_item_list.view.*
class RecycleViewAdapter (private val context: Context,private val items: List<Item>,
private val listener:(Item) -> Unit)
    :RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>(){




        override fun onCreateViewHolder(parent: ViewGroup,viewType: Int)=
                ViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_item_list, parent,false))

        override fun onBindViewHolder(holder:ViewHolder, position: Int) {

            holder.bindItem(items[position],listener)

        }

    override fun getItemCount(): Int = items.size


        class ViewHolder( override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer{



            fun bindItem(item: Item,listener: (Item) -> Unit){
            itemView.name.text = item.name
                Glide.with(itemView.context).load(item.image).into(itemView.image)
                itemView.setOnClickListener {
                    listener(item)
                }
            }
        }
    }
