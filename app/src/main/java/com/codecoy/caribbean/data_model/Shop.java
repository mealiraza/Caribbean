package com.codecoy.caribbean.data_model;


import android.os.Parcel;
import android.os.Parcelable;

public class Shop implements Parcelable {
    private String name;
    private String logoUrl;
    private String bannerUrl;
    private String contact;
    private String categoryId;
    private int shopVisitor;
    private double lat;
    private double lng;
    private String id;

    public Shop() {
    }


    protected Shop(Parcel in) {
        name = in.readString();
        logoUrl = in.readString();
        bannerUrl = in.readString();
        contact = in.readString();
        categoryId = in.readString();
        shopVisitor = in.readInt();
        lat = in.readDouble();
        lng = in.readDouble();
        id = in.readString();
    }

    public static final Creator<Shop> CREATOR = new Creator<Shop>() {
        @Override
        public Shop createFromParcel(Parcel in) {
            return new Shop(in);
        }

        @Override
        public Shop[] newArray(int size) {
            return new Shop[size];
        }
    };

    public int getShopVisitor() {
        return shopVisitor;
    }

    public void setShopVisitor(int shopVisitor) {
        this.shopVisitor = shopVisitor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(logoUrl);
        dest.writeString(bannerUrl);
        dest.writeString(contact);
        dest.writeString(categoryId);
        dest.writeInt(shopVisitor);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
        dest.writeString(id);
    }
}
