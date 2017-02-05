package com.team8.everymarket;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.team8.everymarket.application.ApplicationController;
import com.team8.everymarket.farm.Adapter;
import com.team8.everymarket.farm.FarmListData;
import com.team8.everymarket.farm.FarmResult;
import com.team8.everymarket.network.NetworkService;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FarmActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    LinearLayoutManager mLayoutManager;
    RecyclerView recyclerView;
    ArrayList<FarmListData> mDatas;
    Adapter adapter;
    NetworkService service;
    String farmName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        farmName = intent.getStringExtra("farmName");

        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().findItem(R.id.nav_meal2).setChecked(true);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        // layoutManager 설정
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);



        mDatas = new ArrayList<>();
        service = ApplicationController.getInstance().getNetworkService();


        Call<ArrayList> showProduct =  service.show_product("아름농원");
        showProduct.enqueue(new Callback<ArrayList>() {
            @Override
            public void onResponse(Call<ArrayList> call, Response<ArrayList> response) {
                if (response.isSuccessful()) {
                    Log.d("aaa",response.body().toString());
                    ArrayList farmLists = response.body();
                    adapter.setAdapter(response.body());
                    adapter.addCardItem(farmLists);
                    mDatas = response.body();


                }
            }

            @Override
            public void onFailure(Call<ArrayList> call, Throwable t) {
                Log.d("aaa","실패");
            }
        });

        adapter = new Adapter(mDatas,this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_meal1) {
            startActivity((new Intent(this, BasketActivity.class)).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
        }  else if(id == R.id.nav_meal3) {
            Intent intent = new Intent( Intent.ACTION_VIEW );
            Uri facebookUrl = Uri.parse( "http://www.facebook.com/DDPFarmersmarket/?fref=ts" );
            intent.setData(facebookUrl);
            startActivity( intent );
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
