package com.ahmad.iburger.adabter;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class module_options implements Parcelable {
    int price;
    int img1;
    String option;
int img;
 int num_item;

    public module_options(int price,int num_item, String option, int img1, int img) {
        this.price =price;
        this.num_item=num_item;
        this.option = option;
        this.img = img;
this.img1=img1;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getNum_item() {
        return num_item;
    }

    public void setNum_item(int num_item) {
        this.num_item = num_item;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
    dest.writeInt(price);
        dest.writeInt(num_item);
        dest.writeString(option);
        dest.writeInt(img1);
        dest.writeInt(img);
         }
    public static final Parcelable.Creator<module_options> CREATOR=new Parcelable.Creator<module_options>(){
        @Override
        public module_options createFromParcel(Parcel source) {
            return new module_options(source);
        }

        @Override
        public module_options[] newArray(int size) {
            return new module_options[size];
        }
    };
    public module_options(Parcel source){
        price=source.readInt();
     num_item=source.readInt();
     option=source.readString();
        img1=source.readInt();
        img=source.readInt();

    }

}
