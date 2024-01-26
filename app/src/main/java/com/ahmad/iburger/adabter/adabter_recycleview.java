package com.ahmad.iburger.adabter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.ahmad.iburger.R;
import java.util.ArrayList;


public class adabter_recycleview extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    int activityIdentifier;
    private Context context;
    private ArrayList<itemsList_and_price> itemsListAndPrices;
    ArrayList<module_options> items_order_cart;
    int position_Index;
    private SharedPreferences save_custom_models;
    ArrayList<Integer> positionlist = new ArrayList<>();
    private int column1 = 0;
    private int column2 = 1;
    int num_delivery = 0;

    public adabter_recycleview(Context context, ArrayList<itemsList_and_price> itemsListAndPrices, ArrayList<module_options> items_order_cart, int activityIdentifier) {
        this.context = context;
        this.itemsListAndPrices = itemsListAndPrices;
        this.activityIdentifier = activityIdentifier;
        this.items_order_cart = items_order_cart;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? this.column1 : this.column2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == this.column1) {
            View itemsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items1, parent, false);
            RecyclerView.ViewHolder viewHolder = new layoutItems1(itemsView);
            return viewHolder;
        }else {
            View itemsView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.items2, parent, false);
            RecyclerView.ViewHolder viewHolder2 = new layoutItems2(itemsView2);
            return viewHolder2;
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        //change color radio button depend on prd and pdd
        ColorStateList greenitem = new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910}}, new int[]{ViewCompat.MEASURED_STATE_MASK, Color.rgb(255, 0, 0)});
        ColorStateList otheritems = new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910}}, new int[]{ViewCompat.MEASURED_STATE_MASK, Color.rgb(34, 74, 21)});

        if (holder instanceof layoutItems1) {
            ((layoutItems1) holder).itemsBtnRadio1.setText(this.itemsListAndPrices.get(position).getItem1());
            ((layoutItems1) holder).priceItemTV1.setText(String.valueOf(this.itemsListAndPrices.get(position).getPrice1() + "   JD"));
            ((layoutItems1) holder).itemsBtnRadio2.setText(this.itemsListAndPrices.get(position).getItem2());
            ((layoutItems1) holder).priceItemTV2.setText(String.valueOf(this.itemsListAndPrices.get(position).getPrice2() + "   JD"));
            ((layoutItems1) holder).item_bg.setImageResource(this.itemsListAndPrices.get(position).getImg());
            ((layoutItems1) holder).increment_btn.setOnClickListener(new View.OnClickListener() {
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (adabter_recycleview.this.positionlist.contains(Integer.valueOf(position))) {
                        adabter_recycleview adabter_recycleviewVar = adabter_recycleview.this;
                        adabter_recycleviewVar.position_Index = adabter_recycleviewVar.positionlist.indexOf(Integer.valueOf(position));
                        if (((layoutItems1) holder).itemsBtnRadio1.isChecked()) {
                            if (adabter_recycleview.this.activityIdentifier == 1) {
                                adabter_recycleview adabter_recycleviewVar2 = adabter_recycleview.this;
                                adabter_recycleviewVar2.num_delivery = adabter_recycleviewVar2.items_order_cart.get(adabter_recycleview.this.position_Index).num_item;
                                adabter_recycleview.this.num_delivery++;
                                ((layoutItems1) holder).finalpriceItem_c1.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                                adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice1(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1(), R.drawable.items3, R.drawable.fast_food));
                                return;
                            }
                            adabter_recycleview adabter_recycleviewVar3 = adabter_recycleview.this;
                            adabter_recycleviewVar3.num_delivery = adabter_recycleviewVar3.items_order_cart.get(adabter_recycleview.this.position_Index).num_item;
                            adabter_recycleview.this.num_delivery++;
                            ((layoutItems1) holder).finalpriceItem_c1.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                            adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice1(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1(), R.drawable.items3, R.drawable.chicken_bucket));
                            return;
                        } else if (((layoutItems1) holder).itemsBtnRadio2.isChecked()) {
                            if (adabter_recycleview.this.activityIdentifier == 1) {
                                adabter_recycleview adabter_recycleviewVar4 = adabter_recycleview.this;
                                adabter_recycleviewVar4.num_delivery = adabter_recycleviewVar4.items_order_cart.get(adabter_recycleview.this.position_Index).num_item;
                                adabter_recycleview.this.num_delivery++;
                                ((layoutItems1) holder).finalpriceItem_c1.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                                adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice2(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1() + "\t MEAL", R.drawable.items3, R.drawable.fast_food));
                                return;
                            }
                            adabter_recycleview adabter_recycleviewVar5 = adabter_recycleview.this;
                            adabter_recycleviewVar5.num_delivery = adabter_recycleviewVar5.items_order_cart.get(adabter_recycleview.this.position_Index).num_item;
                            adabter_recycleview.this.num_delivery++;
                            ((layoutItems1) holder).finalpriceItem_c1.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                            adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice2(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1() + "\t-MEAL", R.drawable.items3, R.drawable.chicken_bucket));
                            return;
                        } else {
                            return;
                        }
                    }
                    adabter_recycleview.this.num_delivery = 0;
                    adabter_recycleview.this.positionlist.add(Integer.valueOf(position));
                    if (((layoutItems1) holder).itemsBtnRadio1.isChecked()) {
                        adabter_recycleview.this.num_delivery++;
                        if (adabter_recycleview.this.activityIdentifier == 1) {
                            ((layoutItems1) holder).finalpriceItem_c1.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                            adabter_recycleview.this.items_order_cart.add(new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice1(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1(), R.drawable.items3, R.drawable.fast_food));
                            return;
                        }
                        ((layoutItems1) holder).finalpriceItem_c1.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                        adabter_recycleview.this.items_order_cart.add(new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice1(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1(), R.drawable.items3, R.drawable.chicken_bucket));
                    } else if (!((layoutItems1) holder).itemsBtnRadio2.isChecked()) {
                        Toast.makeText(adabter_recycleview.this.context, "Choose one of options", 0).show();
                    } else {
                        adabter_recycleview.this.num_delivery++;
                        if (adabter_recycleview.this.activityIdentifier == 1) {
                            ((layoutItems1) holder).finalpriceItem_c1.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                            adabter_recycleview.this.items_order_cart.add(new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice2(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1() + "\t MEAL", R.drawable.items3, R.drawable.fast_food));
                            return;
                        }
                        ((layoutItems1) holder).finalpriceItem_c1.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                        adabter_recycleview.this.items_order_cart.add(new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice2(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1() + "\t MEAL", R.drawable.items3, R.drawable.chicken_bucket));
                    }
                }
            });
            ((layoutItems1) holder).decrement_btn.setOnClickListener(new View.OnClickListener() {
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (!adabter_recycleview.this.positionlist.contains(Integer.valueOf(position))) {
                        Toast.makeText(adabter_recycleview.this.context, "add 1 items at least", 0).show();
                        return;
                    }
                    adabter_recycleview adabter_recycleviewVar = adabter_recycleview.this;
                    adabter_recycleviewVar.position_Index = adabter_recycleviewVar.positionlist.indexOf(Integer.valueOf(position));
                    if (((layoutItems1) holder).itemsBtnRadio1.isChecked()) {
                        if (adabter_recycleview.this.activityIdentifier == 1) {
                            adabter_recycleview adabter_recycleviewVar2 = adabter_recycleview.this;
                            adabter_recycleviewVar2.num_delivery = adabter_recycleviewVar2.items_order_cart.get(adabter_recycleview.this.position_Index).getNum_item();
                            adabter_recycleview.this.num_delivery--;
                            ((layoutItems1) holder).finalpriceItem_c1.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                            adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice1(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1(), R.drawable.items3, R.drawable.fast_food));
                            return;
                        }
                        adabter_recycleview adabter_recycleviewVar3 = adabter_recycleview.this;
                        adabter_recycleviewVar3.num_delivery = adabter_recycleviewVar3.items_order_cart.get(adabter_recycleview.this.position_Index).getNum_item();
                        adabter_recycleview.this.num_delivery--;
                        ((layoutItems1) holder).finalpriceItem_c1.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                        adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice1(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1(), R.drawable.items3, R.drawable.chicken_bucket));
                    } else if (((layoutItems1) holder).itemsBtnRadio2.isChecked()) {
                        if (adabter_recycleview.this.activityIdentifier == 1) {
                            adabter_recycleview adabter_recycleviewVar4 = adabter_recycleview.this;
                            adabter_recycleviewVar4.num_delivery = adabter_recycleviewVar4.items_order_cart.get(adabter_recycleview.this.position_Index).getNum_item();
                            adabter_recycleview.this.num_delivery--;
                            ((layoutItems1) holder).finalpriceItem_c1.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                            adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice2(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1() + "\t MEAL", R.drawable.items3, R.drawable.fast_food));
                            return;
                        }
                        adabter_recycleview adabter_recycleviewVar5 = adabter_recycleview.this;
                        adabter_recycleviewVar5.num_delivery = adabter_recycleviewVar5.items_order_cart.get(adabter_recycleview.this.position_Index).getNum_item();
                        adabter_recycleview.this.num_delivery--;
                        ((layoutItems1) holder).finalpriceItem_c1.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                        adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice2(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1() + "\t MEAL", R.drawable.items3, R.drawable.chicken_bucket));
                    }
                }
            });
            if (this.itemsListAndPrices.get(position).getImg() == R.drawable.items_1) {
                ((layoutItems1) holder).itemsBtnRadio1.setButtonTintList(greenitem);
                ((layoutItems1) holder).itemsBtnRadio2.setButtonTintList(greenitem);
                return;
            }
            ((layoutItems1) holder).itemsBtnRadio1.setButtonTintList(otheritems);
            ((layoutItems1) holder).itemsBtnRadio2.setButtonTintList(otheritems);
        } else if (holder instanceof layoutItems2) {
            ((layoutItems2) holder).itemsBtnRadio1_c2.setText(this.itemsListAndPrices.get(position).getItem1());
            ((layoutItems2) holder).priceItemTV1_c2.setText(String.valueOf(this.itemsListAndPrices.get(position).getPrice1() + "   JD"));
            ((layoutItems2) holder).itemsBtnRadio2_c2.setText(this.itemsListAndPrices.get(position).getItem2());
            ((layoutItems2) holder).priceItemTV2_c2.setText(String.valueOf(this.itemsListAndPrices.get(position).getPrice2() + "  JD"));
            ((layoutItems2) holder).item_bg_c2.setImageResource(this.itemsListAndPrices.get(position).getImg());
            ((layoutItems2) holder).increment_btn_c2.setOnClickListener(new View.OnClickListener() {
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (adabter_recycleview.this.positionlist.contains(Integer.valueOf(position))) {
                        adabter_recycleview adabter_recycleviewVar = adabter_recycleview.this;
                        adabter_recycleviewVar.position_Index = adabter_recycleviewVar.positionlist.indexOf(Integer.valueOf(position));
                        if (((layoutItems2) holder).itemsBtnRadio1_c2.isChecked()) {
                            if (adabter_recycleview.this.activityIdentifier == 1) {
                                adabter_recycleview adabter_recycleviewVar2 = adabter_recycleview.this;
                                adabter_recycleviewVar2.num_delivery = adabter_recycleviewVar2.items_order_cart.get(adabter_recycleview.this.position_Index).num_item;
                                adabter_recycleview.this.num_delivery++;
                                ((layoutItems2) holder).finalpriceItem_c2.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                                adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice1(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1(), R.drawable.items3, R.drawable.fast_food));
                                return;
                            }
                            adabter_recycleview adabter_recycleviewVar3 = adabter_recycleview.this;
                            adabter_recycleviewVar3.num_delivery = adabter_recycleviewVar3.items_order_cart.get(adabter_recycleview.this.position_Index).num_item;
                            adabter_recycleview.this.num_delivery++;
                            ((layoutItems2) holder).finalpriceItem_c2.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                            adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice1(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1(), R.drawable.items3, R.drawable.chicken_bucket));
                            return;
                        } else if (((layoutItems2) holder).itemsBtnRadio2_c2.isChecked()) {
                            if (adabter_recycleview.this.activityIdentifier == 1) {
                                adabter_recycleview adabter_recycleviewVar4 = adabter_recycleview.this;
                                adabter_recycleviewVar4.num_delivery = adabter_recycleviewVar4.items_order_cart.get(adabter_recycleview.this.position_Index).num_item;
                                adabter_recycleview.this.num_delivery++;
                                ((layoutItems2) holder).finalpriceItem_c2.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                                adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice2(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1() + "\t -MEAL", R.drawable.items3, R.drawable.fast_food));
                                return;
                            }
                            adabter_recycleview adabter_recycleviewVar5 = adabter_recycleview.this;
                            adabter_recycleviewVar5.num_delivery = adabter_recycleviewVar5.items_order_cart.get(adabter_recycleview.this.position_Index).num_item;
                            adabter_recycleview.this.num_delivery++;
                            ((layoutItems2) holder).finalpriceItem_c2.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                            adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice2(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1() + "\t -MEAL", R.drawable.items3, R.drawable.chicken_bucket));
                            return;
                        } else {
                            return;
                        }
                    }
                    adabter_recycleview.this.num_delivery = 0;
                    adabter_recycleview.this.positionlist.add(Integer.valueOf(position));
                    if (((layoutItems2) holder).itemsBtnRadio1_c2.isChecked()) {
                        adabter_recycleview.this.num_delivery++;
                        if (adabter_recycleview.this.activityIdentifier == 1) {
                            ((layoutItems2) holder).finalpriceItem_c2.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                            adabter_recycleview.this.items_order_cart.add(new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice1(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1(), R.drawable.items3, R.drawable.fast_food));
                            return;
                        }
                        ((layoutItems2) holder).finalpriceItem_c2.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                        adabter_recycleview.this.items_order_cart.add(new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice1(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1(), R.drawable.items3, R.drawable.chicken_bucket));
                    } else if (((layoutItems2) holder).itemsBtnRadio2_c2.isChecked()) {
                        adabter_recycleview.this.num_delivery++;
                        if (adabter_recycleview.this.activityIdentifier == 1) {
                            ((layoutItems2) holder).finalpriceItem_c2.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                            adabter_recycleview.this.items_order_cart.add(new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice2(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1() + "\t -MEAL", R.drawable.items3, R.drawable.fast_food));
                            return;
                        }
                        ((layoutItems2) holder).finalpriceItem_c2.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                        adabter_recycleview.this.items_order_cart.add(new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice2(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1() + "\t -MEAL", R.drawable.items3, R.drawable.chicken_bucket));
                    }
                }
            });
            ((layoutItems2) holder).decrement_btn_c2.setOnClickListener(new View.OnClickListener() {
                @Override // android.view.View.OnClickListener
                public void onClick(View v) {
                    if (!adabter_recycleview.this.positionlist.contains(Integer.valueOf(position))) {
                        Toast.makeText(adabter_recycleview.this.context, "add 1 items at least", 0).show();
                        return;
                    }
                    adabter_recycleview adabter_recycleviewVar = adabter_recycleview.this;
                    adabter_recycleviewVar.position_Index = adabter_recycleviewVar.positionlist.indexOf(Integer.valueOf(position));
                    if (((layoutItems2) holder).itemsBtnRadio1_c2.isChecked()) {
                        if (adabter_recycleview.this.activityIdentifier == 1) {
                            adabter_recycleview adabter_recycleviewVar2 = adabter_recycleview.this;
                            adabter_recycleviewVar2.num_delivery = adabter_recycleviewVar2.items_order_cart.get(adabter_recycleview.this.position_Index).getNum_item();
                            adabter_recycleview.this.num_delivery--;
                            ((layoutItems2) holder).finalpriceItem_c2.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                            adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice1(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1(), R.drawable.items3, R.drawable.fast_food));
                            return;
                        }
                        adabter_recycleview adabter_recycleviewVar3 = adabter_recycleview.this;
                        adabter_recycleviewVar3.num_delivery = adabter_recycleviewVar3.items_order_cart.get(adabter_recycleview.this.position_Index).getNum_item();
                        adabter_recycleview.this.num_delivery--;
                        ((layoutItems2) holder).finalpriceItem_c2.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                        adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice1(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1(), R.drawable.items3, R.drawable.chicken_bucket));
                    } else if (((layoutItems2) holder).itemsBtnRadio2_c2.isChecked()) {
                        if (adabter_recycleview.this.activityIdentifier == 1) {
                            adabter_recycleview adabter_recycleviewVar4 = adabter_recycleview.this;
                            adabter_recycleviewVar4.num_delivery = adabter_recycleviewVar4.items_order_cart.get(adabter_recycleview.this.position_Index).getNum_item();
                            adabter_recycleview.this.num_delivery--;
                            ((layoutItems2) holder).finalpriceItem_c2.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                            adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice2(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1() + "\t -MEAL", R.drawable.items3, R.drawable.fast_food));
                            return;
                        }
                        adabter_recycleview adabter_recycleviewVar5 = adabter_recycleview.this;
                        adabter_recycleviewVar5.num_delivery = adabter_recycleviewVar5.items_order_cart.get(adabter_recycleview.this.position_Index).getNum_item();
                        adabter_recycleview.this.num_delivery--;
                        ((layoutItems2) holder).finalpriceItem_c2.setText(String.valueOf(adabter_recycleview.this.num_delivery));
                        adabter_recycleview.this.items_order_cart.set(adabter_recycleview.this.position_Index, new module_options(((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getPrice2(), adabter_recycleview.this.num_delivery, ((itemsList_and_price) adabter_recycleview.this.itemsListAndPrices.get(position)).getItem1() + "\t -MEAL", R.drawable.items3, R.drawable.chicken_bucket));
                    }
                }
            });
            if (this.itemsListAndPrices.get(position).getImg() == R.drawable.items_1) {
                ((layoutItems2) holder).itemsBtnRadio1_c2.setButtonTintList(greenitem);
                ((layoutItems2) holder).itemsBtnRadio2_c2.setButtonTintList(greenitem);
                return;
            }
            ((layoutItems2) holder).itemsBtnRadio1_c2.setButtonTintList(otheritems);
            ((layoutItems2) holder).itemsBtnRadio2_c2.setButtonTintList(otheritems);
        }
    }

    @Override
    public int getItemCount() {
        return this.itemsListAndPrices.size();
    }
//initialize every layout
    public class layoutItems1 extends RecyclerView.ViewHolder {
        ImageView decrement_btn;
        TextView finalpriceItem_c1;
        ImageView increment_btn;
        ImageView item_bg;
        RadioButton itemsBtnRadio1;
        RadioButton itemsBtnRadio2;
        TextView priceItemTV1;
        TextView priceItemTV2;
        RadioGroup radioGroup_c1;

        public layoutItems1(View itemView) {
            super(itemView);
            this.itemsBtnRadio1 = (RadioButton) itemView.findViewById(R.id.itemsBtnRadio1);
            this.itemsBtnRadio2 = (RadioButton) itemView.findViewById(R.id.itemsBtnRadio2);
            this.priceItemTV1 = (TextView) itemView.findViewById(R.id.priceItemTV1);
            this.priceItemTV2 = (TextView) itemView.findViewById(R.id.priceItemTV2);
            this.item_bg = (ImageView) itemView.findViewById(R.id.item_bg);
            this.decrement_btn = (ImageView) itemView.findViewById(R.id.decrement_btn_c1);
            this.increment_btn = (ImageView) itemView.findViewById(R.id.increment_btn_c1);
            this.finalpriceItem_c1 = (TextView) itemView.findViewById(R.id.finalnumitem_c1);
            this.radioGroup_c1 = (RadioGroup) itemView.findViewById(R.id.radioGroup_c1);
        }
    }

    public class layoutItems2 extends RecyclerView.ViewHolder {
        ImageView decrement_btn_c2;
        TextView finalpriceItem_c2;
        ImageView increment_btn_c2;
        ImageView item_bg_c2;
        RadioButton itemsBtnRadio1_c2;
        RadioButton itemsBtnRadio2_c2;
        TextView priceItemTV1_c2;
        TextView priceItemTV2_c2;
        RadioGroup radioGroup_c2;

        public layoutItems2(View itemView) {
            super(itemView);
            this.itemsBtnRadio1_c2 = (RadioButton) itemView.findViewById(R.id.itemsBtnRadio1_c2);
            this.itemsBtnRadio2_c2 = (RadioButton) itemView.findViewById(R.id.itemsBtnRadio2_c2);
            this.priceItemTV1_c2 = (TextView) itemView.findViewById(R.id.priceItemTV1_c2);
            this.priceItemTV2_c2 = (TextView) itemView.findViewById(R.id.priceItemTV2_c2);
            this.item_bg_c2 = (ImageView) itemView.findViewById(R.id.item_bg_c2);
            this.decrement_btn_c2 = (ImageView) itemView.findViewById(R.id.decrement_btn_c2);
            this.increment_btn_c2 = (ImageView) itemView.findViewById(R.id.increment_btn_c2);
            this.finalpriceItem_c2 = (TextView) itemView.findViewById(R.id.finalnumitem_c2);
            this.radioGroup_c2 = (RadioGroup) itemView.findViewById(R.id.radioGroup_c2);
        }
    }
}