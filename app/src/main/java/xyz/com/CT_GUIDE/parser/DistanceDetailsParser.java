package xyz.com.CT_GUIDE.parser;

import android.content.Context;

import xyz.com.CT_GUIDE.extra.PskHttpRequest;
import xyz.com.CT_GUIDE.holder.DistanceDetails;
import xyz.com.CT_GUIDE.model.DistanceText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;

public class DistanceDetailsParser {
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

        DistanceDetails.removeAll();

        final JSONObject detailsObject = new JSONObject(result);

        DistanceText dText;

        JSONArray rowArray = detailsObject.getJSONArray("rows");

        for (int i = 0; i < rowArray.length(); i++) {
            final JSONObject eleObject = rowArray.getJSONObject(i);


            final JSONArray eleArray = eleObject.getJSONArray("elements");

            for (int j = 0; j < eleArray.length(); j++) {
                final JSONObject eleeeObject = eleArray.getJSONObject(j);
                JSONObject textD = eleeeObject.getJSONObject("distance");
                dText = new DistanceText();

                try {
                    dText.setdText(textD
                            .getString("text"));

                } catch (Exception e) {
                    // TODO: handle exception
                }

                DistanceDetails.setDistanceText(dText);
                dText = null;

            }
        }


        return true;

    }
}