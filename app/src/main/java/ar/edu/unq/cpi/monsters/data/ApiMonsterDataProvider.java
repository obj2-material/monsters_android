package ar.edu.unq.cpi.monsters.data;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.cpi.monsters.tools.ApplicationToolset;


/**
 * Created by Carlos on 01/12/2017.
 */

public class ApiMonsterDataProvider extends MonsterDataProvider {

    @Override
    public void fetchBandNames(MonsterBandListConsumer consumer) {
        String ip = "192.168.10.168";
        String port = "8080";
        String url =  "http://" + ip + ":" + port + "/monsters-wicket-to-see/api/bandas";
        JsonArrayRequest jsArrayRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            List<String> names = new ArrayList<>();
                            for (int i = 0; i < response.length() ; i++) {
                                JSONObject bandData = null;
                                    bandData = response.getJSONObject(i);
                                String bandName = bandData.getString("nombre");
                                names.add(bandName);
                            }
                            consumer.accept(names);
                        } catch (JSONException e) {
                            throw new RuntimeException("Error en el procesamiento del JSON obtenido", e);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        throw new RuntimeException("Error en el request REST", error);
                    }
                });
        ApplicationToolset.toolset().addToRequestQueue(jsArrayRequest);
    }
}
