package io.github.hazyair.source;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class Station extends Base implements Parcelable {
    public boolean _status;
    public int _id;
    public String id;
    public String name;
    public double latitude;
    public double longitude;
    public String country;
    public String locality;
    public String address;
    public String source;

    public static Bundle toBundleFromCursor(Cursor cursor) {
        return new Station()._toBundleFromCursor(cursor);
    }

    public static String[] keys() {
        return new Station()._keys();
    }

    public Station() {
        this(null, null, 0, 0, null, null,
                null, null);
    }

    public Station(String id, String name, double latitude, double longitude, String country,
                   String locality, String address, String source) {
        this._status = false;
        this.id = (id == null ? "" : id);
        this.name = (name == null ? "" : name);
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = (country == null ? "" : country);
        this.locality = (locality == null ? "" : locality);
        this.address = (address == null ? "" : address);
        this.source = (source == null ? "" : source);
    }

    public Station(Bundle bundle) {
        super(bundle);
    }

    public Station(Cursor cursor) {
        super(cursor);
    }

    Station(Parcel in) {
        _id = in.readInt();
        id = in.readString();
        name = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        country = in.readString();
        locality = in.readString();
        address = in.readString();
        source = in.readString();
    }

    public static final Creator<Station> CREATOR = new Creator<Station>() {
        @Override
        public Station createFromParcel(Parcel in) {
            return new Station(in);
        }

        @Override
        public Station[] newArray(int size) {
            return new Station[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(id);
        dest.writeString(name);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeString(country);
        dest.writeString(locality);
        dest.writeString(address);
        dest.writeString(source);
    }
}
