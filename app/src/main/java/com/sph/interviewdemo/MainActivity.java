package com.sph.interviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView)findViewById(R.id.listView);

        Retrofit.Builder builder =new Retrofit.Builder()
                //this is the base URL. URL we created in interface will be added to it
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        IRetrofitClient client = retrofit.create(IRetrofitClient.class);
        //this is where we call the method fromRetrofitClient.
        // I passed my ID from github for getting data. Try your own
        Call <List<GithubRepo>>call =client.reposForUser("janaka1984");

        call.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                List<GithubRepo>repos= response.body();
                // this is where we handle the response ofc
                listView.setAdapter(new GitHubRepoAdapter(MainActivity.this,repos));
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Something wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
