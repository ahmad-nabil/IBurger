package com.ahmad.iburger.adabter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmad.iburger.adabter.module_options;
import com.ahmad.iburger.R;
import java.util.ArrayList;

public class adabter_order extends RecyclerView.Adapter<adabter_order.items_order> {
    Context context;
    ArrayList<module_options> items;
    int num_item;
    int total_price = 0;

    public adabter_order(ArrayList<module_options> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public items_order onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_orders, parent, false);
        return new items_order(itemview);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final items_order holder, final int position) {
        holder.iconorder.setImageResource(this.items.get(position).getImg());
        holder.itembg.setImageResource(this.items.get(position).getImg1());
        holder.items.setText(this.items.get(position).getNum_item());
        holder.numberitems.setText(String.valueOf(this.items.get(position).getNum_item()));
        holder.priceitems.setText(String.valueOf(this.items.get(position).getPrice() + "JD"));
        this.total_price += this.items.get(position).getNum_item() * this.items.get(position).getPrice();
        if (this.items.size() - 1 == position) {
            Toast.makeText(this.context, "your total price is: \t" + String.valueOf(this.total_price), 0).show();
        }
        holder.increasebtn_order.setOnClickListener(new View.OnClickListener() {
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                adabter_order adabter_orderVar = adabter_order.this;
                adabter_orderVar.num_item = adabter_orderVar.items.get(position).getNum_item();
                adabter_order.this.total_price -= adabter_order.this.num_item * adabter_order.this.items.get(position).getPrice();
                adabter_order.this.num_item++;
                adabter_order.this.total_price += adabter_order.this.num_item * adabter_order.this.items.get(position).getPrice();
                Toast.makeText(adabter_order.this.context, "your total price is: \t" + String.valueOf(adabter_order.this.total_price), 0).show();
                adabter_order.this.items.set(position, new module_options(adabter_order.this.items.get(position).getPrice(), adabter_order.this.num_item, adabter_order.this.items.get(position).option, adabter_order.this.items.get(position).img1, adabter_order.this.items.get(position).img));
                holder.numberitems.setText(String.valueOf(adabter_order.this.items.get(position).getNum_item()));
            }
        });
        holder.dcreasebtn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (adabter_order.this.num_item == 0) {
                    Toast.makeText(adabter_order.this.context, "your order in  " + adabter_order.this.items.get(position).option + " will become 0 items and u cant decrease it", 0).show();
                    return;
                }
                adabter_order adabter_orderVar = adabter_order.this;
                adabter_orderVar.num_item = adabter_orderVar.items.get(position).getNum_item();
                adabter_order.this.total_price -= adabter_order.this.num_item * adabter_order.this.items.get(position).price;
                adabter_order adabter_orderVar2 = adabter_order.this;
                adabter_orderVar2.num_item--;
                adabter_order.this.total_price += adabter_order.this.num_item * adabter_order.this.items.get(position).price;
                adabter_order.this.items.set(position, new module_options(adabter_order.this.items.get(position).price, adabter_order.this.num_item, adabter_order.this.items.get(position).option, adabter_order.this.items.get(position).img1, adabter_order.this.items.get(position).img));
                holder.numberitems.setText(String.valueOf(adabter_order.this.items.get(position).num_item));
            }
        });
    }

    public int getTotalPrice() {
        return this.total_price;
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class items_order extends RecyclerView.ViewHolder {
        ImageView dcreasebtn_order;
        ImageView iconorder;
        ImageView increasebtn_order;
        ImageView itembg;
        TextView items;
        TextView numberitems;
        TextView priceitems;

        public items_order(View itemView) {
            super(itemView);
            this.iconorder = (ImageView) itemView.findViewById(R.id.icon_items);
            this.items = (TextView) itemView.findViewById(R.id.items);
            this.itembg = (ImageView) itemView.findViewById(R.id.itembg);
            this.priceitems = (TextView) itemView.findViewById(R.id.priceitems);
            this.numberitems = (TextView) itemView.findViewById(R.id.numberitems);
            this.increasebtn_order = (ImageView) itemView.findViewById(R.id.increasebtn_order);
            this.dcreasebtn_order = (ImageView) itemView.findViewById(R.id.dcreasebtn_order);
        }
    }
}