package io.github.hazyair.data;

import android.content.Context;

import androidx.loader.content.CursorLoader;
import io.github.hazyair.source.Sensor;

public class SensorsLoader extends CursorLoader {

    private SensorsLoader(Context context, int _id) {
        super(context, HazyairProvider.Sensors.CONTENT_URI, Sensor.keys(),
                SensorsContract.COLUMN__STATION_ID + "=?",
                new String[] { String.valueOf(_id) }, HazyairProvider.Sensors.DEFAULT_SORT);
    }

    public static SensorsLoader newInstanceForAllSensorsFromStation(Context context, int _id) {
        return new SensorsLoader(context, _id);
    }

}