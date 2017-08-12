package xyz.com.CT_GUIDE.parser;

import android.content.Context;

import xyz.com.CT_GUIDE.extra.PskHttpRequest;
import xyz.com.CT_GUIDE.holder.BiCyleDetails;
import xyz.com.CT_GUIDE.model.BicyleTime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;


public class BiCyleDetailsParser {
    public static boolean connect(Context con, String url)
            throws JSONException, IOException {

        // String result = GetText(con.getResources().openRawResource(
        // R.raw.get_participants));

        String result = "";
        try {
            result = PskHttpRequest.getText(PskHttpRequest
                    .getInputStreamForGetRequest(url));
        } catch (final URISyntaxException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        if (result.length() < 1) {
            return false;
            // Log.e("result is ", "parse " + result);
        }

        //

        BiCyleDetails.removeAll();

        final JSONObject detailsObject = new JSONObject(result);

        BicyleTime bTime;

        JSONArray rowArray = detailsObject.getJSONArray("rows");

        for (int i = 0; i < rowArray.length(); i++) {
            final JSONObject eleObject = rowArray.getJSONObject(i);


            final JSONArray eleArray = eleObject.getJSONArray("elements");

            for (int j = 0; j < eleArray.length(); j++) {
                final JSONObject eleeeObject = eleArray.getJSONObject(j);
                JSONObject textD = eleeeObject.getJSONObject("duration");
                bTime = new BicyleTime();

                try {
                    bTime.setTime(textD
                            .getString("text"));

                } catch (Exception e) {
                    // TODO: handle exception
                }

                BiCyleDetails.setBicyleTime(bTime);
                bTime = null;

            }
        }

        return true;

    }
}