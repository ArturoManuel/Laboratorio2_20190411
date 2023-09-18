package com.example.laboratorio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private  String url ="https://randomuser.me/api/";
    private RequestQueue requestQueue;
    private Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp= findViewById(R.id.signUp);
        requestQueue= Volley.newRequestQueue(this);


        signUp.setOnClickListener(view -> {
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>(){
                        @Override
                        public void onResponse(JSONObject response) {
                            // Procesar la respuesta JSON aquí
                            try {
                                // Aquí puedes trabajar con el objeto JSON 'response'
                                // Por ejemplo, extraer datos y realizar acciones en función de la respuesta.


                                JSONArray resultsArray = response.getJSONArray("results");

                                // Get the first item from the "results" array
                                JSONObject firstResult = resultsArray.getJSONObject(0);

                                // Extract email, password, first name, and last name
                                String username = firstResult.getJSONObject("login").getString("username");
                                String email = firstResult.getString("email");
                                String password = firstResult.getJSONObject("login").getString("password");
                                String firstName = firstResult.getJSONObject("name").getString("first");
                                String lastName = firstResult.getJSONObject("name").getString("last");
                                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                                intent.putExtra("firstName",firstName);
                                intent.putExtra("lastName",lastName);
                                intent.putExtra("email",email);
                                intent.putExtra("password",password);
                                intent.putExtra("username",username);
                                startActivity(intent);

                            } catch (JSONException e) {

                                Log.i("error", String.valueOf(e));
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Manejar errores de la solicitud aquí
                            // Por ejemplo, mostrar un mensaje de error al usuario.

                            Log.i("error", String.valueOf(error));
                        }


                    });

                requestQueue.add(request);
        });



    }
}