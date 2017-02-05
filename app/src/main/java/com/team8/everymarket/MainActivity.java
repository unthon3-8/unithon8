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
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.team8.everymarket.main.MainListData;
import com.team8.everymarket.main.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ichaeeun on 2017. 2. 4..
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{


    @BindView(R.id.toolbar)
    Toolbar toolbar;


    private LinearLayoutManager lLayout;
    private RecyclerView rView;
    private List<MainListData> rowListItem;

    //Back 키 두번 클릭 여부 확인
    private final long FINSH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ImageButton booth1 = (ImageButton)findViewById(R.id.booth1);
        ImageButton booth2 = (ImageButton)findViewById(R.id.booth2);
        ImageButton booth3 = (ImageButton)findViewById(R.id.booth3);
        ImageButton booth4 = (ImageButton)findViewById(R.id.booth4);
        ImageButton booth5 = (ImageButton)findViewById(R.id.booth5);
        ImageButton booth6 = (ImageButton)findViewById(R.id.booth6);
        ImageButton booth7 = (ImageButton)findViewById(R.id.booth7);
        ImageButton booth8 = (ImageButton)findViewById(R.id.booth8);

        booth1.setOnClickListener(this);
        booth2.setOnClickListener(this);
        booth3.setOnClickListener(this);
        booth4.setOnClickListener(this);
        booth5.setOnClickListener(this);
        booth6.setOnClickListener(this);
        booth7.setOnClickListener(this);
        booth8.setOnClickListener(this);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        rowListItem = getAllItemList();
       /* lLayout = new LinearLayoutManager(MainActivity.this);

        rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);

        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem, clickEvent);
        rView.setAdapter(rcAdapter);*/
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
    private List<MainListData> getAllItemList(){

        List<MainListData> allItems = new ArrayList<MainListData>();
        allItems.add(new MainListData(0,"현강농원", R.drawable.hyungang_farm));
        allItems.add(new MainListData(1,"새아침농장", R.drawable.new_morning_farm));
        allItems.add(new MainListData(2,"우포농장", R.drawable.upo_farm));
        allItems.add(new MainListData(3,"아름농원", R.drawable.beautiful_farm));
        allItems.add(new MainListData(4,"현강농원", R.drawable.hyungang_farm));
        allItems.add(new MainListData(5,"우포농장", R.drawable.upo_farm));
        allItems.add(new MainListData(6,"아름농원", R.drawable.beautiful_farm));
        allItems.add(new MainListData(7,"현강농원", R.drawable.hyungang_farm));

        return allItems;
    }

    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            int itemPosition = rView.getChildAdapterPosition(v);
            int tempId = rowListItem.get(itemPosition).getId();
            Toast.makeText(getApplicationContext(),String.valueOf(tempId),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), FarmActivity.class);
            intent.putExtra("id",String.valueOf(tempId));
            startActivity(intent);

        }
    };

    @Override
    public void onBackPressed() {
        long tempTime        = System.currentTimeMillis();
        long intervalTime    = tempTime - backPressedTime;

//            super.onBackPressed();
        /**
         * Back키 두번 연속 클릭 시 앱 종료
         */
        if ( 0 <= intervalTime && FINSH_INTERVAL_TIME >= intervalTime ) {
            super.onBackPressed();
        }
        else {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(),"뒤로 가기 키을 한번 더 누르시면 종료됩니다.",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View view) {
        Intent farmIntent = new Intent(MainActivity.this, FarmActivity.class);
        switch (view.getId()) {
            case R.id.booth1:
                farmIntent.putExtra("FarmName", "새아침농장");
                startActivity(farmIntent);
                break;
            case R.id.booth2:
                farmIntent.putExtra("FarmName", "현강농원");
                startActivity(farmIntent);
                break;
            case R.id.booth3:
                farmIntent.putExtra("FarmName", "우포농장");
                startActivity(farmIntent);
                break;
            case R.id.booth4:
                farmIntent.putExtra("FarmName", "아름농원");
                startActivity(farmIntent);
                break;
            case R.id.booth5:
                farmIntent.putExtra("FarmName", "5");
                startActivity(farmIntent);
                break;
            case R.id.booth6:
                farmIntent.putExtra("FarmName", "6");
                startActivity(farmIntent);
                break;
            case R.id.booth7:
                farmIntent.putExtra("FarmName", "7");
                startActivity(farmIntent);
                break;
            case R.id.booth8:
                farmIntent.putExtra("FarmName", "8");
                startActivity(farmIntent);
                break;
        }
    }
}
