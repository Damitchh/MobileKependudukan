package com.example.kependudukan.pojo;

import android.os.Parcel;
import android.os.Parcelable;

public class ListKk implements Parcelable {

    public String nama, alamat, image;
    public int id, no_kk;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo_kk() {
        return no_kk;
    }

    public void setNo_kk(int no_kk) {
        this.no_kk = no_kk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.alamat);
        dest.writeString(this.image);
        dest.writeInt(this.id);
        dest.writeInt(this.no_kk);
    }

    public ListKk() {
    }

    protected ListKk(Parcel in) {
        this.nama = in.readString();
        this.alamat = in.readString();
        this.image = in.readString();
        this.id = in.readInt();
        this.no_kk = in.readInt();
    }

    public static final Parcelable.Creator<ListKk> CREATOR = new Parcelable.Creator<ListKk>() {
        @Override
        public ListKk createFromParcel(Parcel source) {
            return new ListKk(source);
        }

        @Override
        public ListKk[] newArray(int size) {
            return new ListKk[size];
        }
    };

    @Override
    public String toString() {
        return "ListKk{" +
                "nama='" + nama + '\'' +
                ", alamat='" + alamat + '\'' +
                ", image='" + image + '\'' +
                ", id=" + id +
                ", no_kk=" + no_kk +
                '}';
    }
}
