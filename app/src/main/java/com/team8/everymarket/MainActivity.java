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
import android.view.MenuItem;

import com.team8.everymarket.main.ItemObject;
import com.team8.everymarket.main.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ichaeeun on 2017. 2. 4..
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    private LinearLayoutManager lLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        List<ItemObject> rowListItem = getAllItemList();
        lLayout = new LinearLayoutManager(MainActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.nav_meal1) {
            startActivity((new Intent(this, BasketActivity.class)).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
        } else if(id == R.id.nav_meal2) {
            startActivity((new Intent(this, OrderActivity.class)).setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY));
        } else if(id == R.id.nav_meal3) {
            Intent intent = new Intent( Intent.ACTION_VIEW );
            Uri facebookUrl = Uri.parse( "http://www.facebook.com/DDPFarmersmarket/?fref=ts" );
            intent.setData(facebookUrl);
            startActivity( intent );
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("현강농원", R.drawable.hyungang_farm));
        allItems.add(new ItemObject("새아침농장", R.drawable.new_morning_farm));
        allItems.add(new ItemObject("우포농장", R.drawable.upo_farm));
        allItems.add(new ItemObject("아름농원", R.drawable.beautiful_farm));
        allItems.add(new ItemObject("현강농원", R.drawable.hyungang_farm));
        allItems.add(new ItemObject("우포농장", R.drawable.upo_farm));
        allItems.add(new ItemObject("아름농원", R.drawable.beautiful_farm));
        allItems.add(new ItemObject("현강농원", R.drawable.hyungang_farm));

        return allItems;
    }
}
