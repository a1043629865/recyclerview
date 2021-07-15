package com.example.myapplication1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //需要添加的数据
    private val list = listOf(
        weightData(25.0, "2020-7-1", 22.0),
        weightData(23.0, "2020-7-2", 22.0),
        weightData(22.0, "2020-7-3", 22.0),
        weightData(21.0, "2020-7-4", 22.0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_View)
        //线性布局
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WeightAdapter(list)
    }

    class WeightAdapter(private val list: List<weightData>) :
        RecyclerView.Adapter<WeightAdapter.MyViewHolder>() {

        class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val time: TextView = itemView.findViewById(R.id.time)
            val weight: TextView = itemView.findViewById(R.id.detail)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.weight_item, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        //模型与视图的绑定
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val w = list[position]
            holder.time.text = w.time
            holder.weight.text = w.weight.toString()
        }
    }
}






