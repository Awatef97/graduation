package com.awatef.loggin.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.awatef.loggin.CheckInternetConnection;
import com.awatef.loggin.List_Item;
import com.awatef.loggin.R;
import com.awatef.loggin.RecyclerViewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
//ليها 4 كلاسات الnews,list_item,checkInternetconction,Recycleviewadapter
public class News extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recycleView_dAdapter;
    public List<List_Item>listItems=new ArrayList<>();
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("News");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        recyclerView =(RecyclerView)findViewById(R.id.m_RecycleView);
        recyclerView.setHasFixedSize(true);
        gridLayoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recycleView_dAdapter=new RecyclerViewAdapter(listItems,this);
        recyclerView.setAdapter(recycleView_dAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            public void onScrollStateChanged(RecyclerView recyclerView, int dx, int dy) {
                if(gridLayoutManager.findLastCompletelyVisibleItemPosition()==listItems.size()-1){
                    Get_All_Users(listItems.get(listItems.size()-1).getId());
                }
            }
        });


    Get_All_Users(0);}
    public void Get_All_Users(int limit){
        CheckInternetConnection cic=new CheckInternetConnection(getApplicationContext());
        Boolean Ch=cic.isConnectingToInternet();
        if(!Ch){
            Toast.makeText(this,"no internet connection",Toast.LENGTH_SHORT).show();
        }
else
        {
            //كود الاتصال بقاعده البيانات
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    "http://192.168.1.5/first/test.php"+ limit
                    ,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray jsonArray = new JSONArray(response);
                                JSONObject jsonResponse = jsonArray.getJSONObject(0);
                                JSONArray jsonArray_usersS = jsonResponse.getJSONArray("All_storys");

                                for (int i = 0; i < jsonArray_usersS.length(); i++) {
                                    JSONObject responsS = jsonArray_usersS.getJSONObject(i);

                                    int id = responsS.getInt("id");
                                    String story = responsS.getString("story");
                                    String img_link = responsS.getString("img_link");

                                    listItems.add(new List_Item(id, story, img_link));

                                }
                                recycleView_dAdapter.notifyDataSetChanged();


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(stringRequest);
            stringRequest.setShouldCache(false);


        }
        }
    }



