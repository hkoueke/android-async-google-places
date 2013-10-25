package io.github.axxiss.places.request;

import java.util.EnumMap;
import java.util.List;

import io.github.axxiss.places.PlacesSettings;
import io.github.axxiss.places.enums.Params;
import io.github.axxiss.places.enums.PlaceType;

/**
 * @author Axxiss
 */
public class PlaceParams {
    private static final String TAG = "PlaceParams";

    private String mUrl;


    private EnumMap<Params, String> params = new EnumMap<Params, String>(Params.class);


    public PlaceParams() {
        params.put(Params.Key, PlacesSettings.getInstance().getApiKey());
        params.put(Params.Sensor, "true");
    }


    public void put(Params key, String value) {
        params.put(key, value);
    }

    public void put(Params key, boolean value) {
        params.put(key, String.valueOf(value));
    }

    public void put(Params key, int value) {
        params.put(key, String.valueOf(value));
    }

    public void put(Params key, double value) {
        params.put(key, String.valueOf(value));
    }

    public void put(Params key) {

    }


    public void put(Params key, List<PlaceType> value) {
//FIXME
//        String types = "";
//
//        for(PlaceType t: value){
//
//        }
//
//        params.put(key, String.valueOf(value));
    }

    protected String getUrl() {
        return mUrl;
    }

    protected void setUrl(final String url) {
        mUrl = url;
    }


    public PlaceParams setTypes(PlaceType[] places) {
        final String divider = "|";
        String types = "";
        for (PlaceType place : places) {
            types = place + divider;
        }

        types.substring(0, types.length() - 1);

        params.put(Params.Types, types);
        return this;
    }

}