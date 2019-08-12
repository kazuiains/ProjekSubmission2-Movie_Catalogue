package com.muhammad_adi_yusuf.projeksubmission2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DataList implements Parcelable {
    private int dataImage;
    private String dataTitle, dataGenre, dataRelease, dataOverview, dataLanguage, dataRuntime, dataCrew, dataRate;

    public int getDataImage() {
        return dataImage;
    }

    public void setDataImage(int dataImage) {
        this.dataImage = dataImage;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle;
    }

    public String getDataGenre() {
        return dataGenre;
    }

    public void setDataGenre(String dataGenre) {
        this.dataGenre = dataGenre;
    }

    public String getDataRelease() {
        return dataRelease;
    }

    public void setDataRelease(String dataRelease) {
        this.dataRelease = dataRelease;
    }

    public String getDataOverview() {
        return dataOverview;
    }

    public void setDataOverview(String dataOverview) {
        this.dataOverview = dataOverview;
    }

    public String getDataLanguage() {
        return dataLanguage;
    }

    public void setDataLanguage(String dataLanguage) {
        this.dataLanguage = dataLanguage;
    }

    public String getDataRuntime() {
        return dataRuntime;
    }

    public void setDataRuntime(String dataRuntime) {
        this.dataRuntime = dataRuntime;
    }

    public String getDataCrew() {
        return dataCrew;
    }

    public void setDataCrew(String dataCrew) {
        this.dataCrew = dataCrew;
    }

    public String getDataRate() {
        return dataRate;
    }

    public void setDataRate(String dataRate) {
        this.dataRate = dataRate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.dataImage);
        dest.writeString(this.dataTitle);
        dest.writeString(this.dataGenre);
        dest.writeString(this.dataRelease);
        dest.writeString(this.dataOverview);
        dest.writeString(this.dataLanguage);
        dest.writeString(this.dataRuntime);
        dest.writeString(this.dataCrew);
        dest.writeString(this.dataRate);
    }

    public DataList() {
    }

    protected DataList(Parcel in) {
        this.dataImage = in.readInt();
        this.dataTitle = in.readString();
        this.dataGenre = in.readString();
        this.dataRelease = in.readString();
        this.dataOverview = in.readString();
        this.dataLanguage = in.readString();
        this.dataRuntime = in.readString();
        this.dataCrew = in.readString();
        this.dataRate = in.readString();
    }

    public static final Parcelable.Creator<DataList> CREATOR = new Parcelable.Creator<DataList>() {
        @Override
        public DataList createFromParcel(Parcel source) {
            return new DataList(source);
        }

        @Override
        public DataList[] newArray(int size) {
            return new DataList[size];
        }
    };
}
