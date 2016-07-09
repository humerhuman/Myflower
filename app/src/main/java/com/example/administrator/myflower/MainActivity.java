package com.example.administrator.myflower;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.myflower.Fragment.ArtDesignImagesFragment;
import com.example.administrator.myflower.Fragment.ArticleImagesFragment;
import com.example.administrator.myflower.Fragment.CamerImagesFragment;
import com.example.administrator.myflower.Fragment.DressingImagesFragment;
import com.example.administrator.myflower.Fragment.FashionImagesFragment;
import com.example.administrator.myflower.Fragment.FocuseImagesFragment;
import com.example.administrator.myflower.Fragment.FoodImagesFragment;
import com.example.administrator.myflower.Fragment.IndexFragment;
import com.example.administrator.myflower.Fragment.LiveImagesFragment;
import com.example.administrator.myflower.Fragment.PaintImagesFragment;
import com.example.administrator.myflower.Fragment.TravelImagesFragment;
import com.example.administrator.myflower.View.GooeyMenu;

import java.io.File;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawLayout;//找到控件
    private GooeyMenu.GooeyMenuInterface menuInterface;

    //    找到fragment
    private IndexFragment indexFragment;
    private FocuseImagesFragment focuseImagesFragment;
    private ArticleImagesFragment articleImagesFragment;
    private FoodImagesFragment foodImagesFragment;
    private CamerImagesFragment camerImagesFragment;
    private PaintImagesFragment paintImagesFragment;
    private ArtDesignImagesFragment artDesignImagesFragment;
    private TravelImagesFragment travelImagesFragment;
    private FashionImagesFragment fashionImagesFragment;
    private LiveImagesFragment liveImagesFragment;
    private DressingImagesFragment dressingImagesFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initToolBar();

        initDrawlayout();

//        initfloatBar();
        initgooeyMenu();

        initFragment(0);

//        initlogin();



    }

    private void initlogin() {
        final Button btn_login= (Button) findViewById(R.id.name_show);
//        SharedPreferences info = getSharedPreferences("info", 0);
//        System.out.println("我mende");
//        final String userName = info.getString("userName", null);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                if (userName!=null){
//                    btn_login.setText(userName);
//
//                }else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
//                }
            }
        });

    }

    private void initgooeyMenu() {
        System.out.println("啊多年前的我");
        final GooeyMenu mGooeyMenu = (GooeyMenu) findViewById(R.id.gooey_menu);
        mGooeyMenu.setClickable(true);
            menuInterface = new GooeyMenu.GooeyMenuInterface() {
                @Override
                public void menuOpen() {

                }

                @Override
                public void menuClose() {

                }

                public String name;
                @Override
                public void menuItemClicked(int menuNumber) {
                    switch (menuNumber){
                        case 1:
                            Toast.makeText(MainActivity.this, "上传本地照片", Toast.LENGTH_SHORT).show();
                            break;
                        case 2:
//                            Toast.makeText(MainActivity.this, "拍照", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            File file = new File(Environment.getExternalStorageDirectory().getPath(),name);
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                            startActivityForResult(intent,1);
                            break;
                        case 3:
                            Toast.makeText(MainActivity.this, "采集网络照片", Toast.LENGTH_SHORT).show();
                            break;
                        case 4:
                            Toast.makeText(MainActivity.this, "软文编写", Toast.LENGTH_SHORT).show();
                            break;
                        case 5:
                            Toast.makeText(MainActivity.this, "聊天", Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                            startActivity(intent1);
                            break;
                    }

                }
            };
        mGooeyMenu.setOnMenuListener(menuInterface);


    }

//
//    private void initfloatBar() {
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        if (fab != null) {
//            fab.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(MainActivity.this, "hah", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//    }

    private void initDrawlayout() {


//        获得抽屉布局实例
        drawLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawLayout, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawLayout.setDrawerListener(toggle);
        toggle.syncState();

//        获得左侧menu条目监听器
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

//        设置当条目被点击时监听器
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
    }

    private void initToolBar() {

        //        找到toolbar控件
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);



//        toolbar.setNavigationIcon(R.drawable.ic_menu_camera);
        setSupportActionBar(toolbar);//
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);/*将导航按钮显示出来*/
        }
        if (toolbar != null) {
            /*为导航按钮设置点击事件*/
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    点击导航按钮打开左侧菜单
                    drawLayout.openDrawer(GravityCompat.START);
                }
            });
        }

    }


    //    显示出右侧menu的图标
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {

                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        将一个menu资源文件转换为menu
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchitem = menu.findItem(R.id.searchview);
//        SearchView searchView= (SearchView) MenuItemCompat.getActionView(searchitem);
//        searchView.setIconified(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int actionitemId;
        actionitemId = item.getItemId();

        return actionitemId == R.id.action_cammer || super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawLayout.isDrawerOpen(GravityCompat.START)) {
            drawLayout.closeDrawer(GravityCompat.START);

        } else {

            super.onBackPressed();
        }
    }
    private void initFragment(int index){
        int CONTAINER = R.id.frame_contain;

//        获得fragment管理器
        FragmentManager manager = getFragmentManager();
//        开启事务
        FragmentTransaction transaction = manager.beginTransaction();
//        隐藏所有fragment
        hideFragment(transaction);
        switch (index){
            case 0:
                if(indexFragment==null) {
                    indexFragment = new IndexFragment();
                    transaction.add(CONTAINER, indexFragment);
                }else{
                    transaction.show(indexFragment);
                }
                break;
            case 1:
                if (focuseImagesFragment==null){
                    focuseImagesFragment=new FocuseImagesFragment();
                    transaction.add(CONTAINER,focuseImagesFragment);
                }else{
                    transaction.show(focuseImagesFragment);
                }
                break;
            case 2:
                if (articleImagesFragment==null){
                    articleImagesFragment=new ArticleImagesFragment();
                    transaction.add(CONTAINER,articleImagesFragment);
                }else{
                    transaction.show(articleImagesFragment);
                }
                break;
            case 3:
                if (foodImagesFragment==null){
                    foodImagesFragment=new FoodImagesFragment();
                    transaction.add(CONTAINER,foodImagesFragment);
                }else{
                    transaction.show(foodImagesFragment);
                }
                break;
            case 4:
                if (camerImagesFragment==null){
                    camerImagesFragment=new CamerImagesFragment();
                    transaction.add(CONTAINER,camerImagesFragment);
                }else {
                    transaction.show(camerImagesFragment);
                }
                break;
            case 5:
                if (paintImagesFragment==null){
                    paintImagesFragment=new PaintImagesFragment();
                    transaction.add(CONTAINER,paintImagesFragment);
                }else {
                    transaction.show(paintImagesFragment);
                }
                break;
            case 6:
                if (artDesignImagesFragment==null){
                    artDesignImagesFragment=new ArtDesignImagesFragment();
                    transaction.add(CONTAINER,artDesignImagesFragment);
                }else {
                    transaction.show(artDesignImagesFragment);
                }
                break;
            case 7:
                if (travelImagesFragment==null){
                    travelImagesFragment= new TravelImagesFragment();
                    transaction.add(CONTAINER,travelImagesFragment);
                }else {
                    transaction.show(travelImagesFragment);
                }
                break;
            case 8:
                if (fashionImagesFragment==null){
                    fashionImagesFragment=new FashionImagesFragment();
                    transaction.add(CONTAINER,fashionImagesFragment);
                }else {
                    transaction.show(fashionImagesFragment);
                }
                break;
            case 9:
                if (liveImagesFragment==null){
                    liveImagesFragment=new LiveImagesFragment();
                    transaction.add(CONTAINER,liveImagesFragment);
                }else {
                    transaction.show(liveImagesFragment);
                }
                break;
            case 10:
                if (dressingImagesFragment==null){
                    dressingImagesFragment=new DressingImagesFragment();
                    transaction.add(CONTAINER,dressingImagesFragment);
                }else {
                    transaction.show(dressingImagesFragment);
                }
                break;
        }
        transaction.commit();

    }
//    隐藏fragment
    private void hideFragment(FragmentTransaction transaction) {
        if (indexFragment!=null){
            transaction.hide(indexFragment);
        }
        if (focuseImagesFragment!=null){
            transaction.hide(focuseImagesFragment);
        }
        if (articleImagesFragment!=null){
            transaction.hide(articleImagesFragment);
        }
        if (foodImagesFragment!=null){
            transaction.hide(foodImagesFragment);
        }
        if (camerImagesFragment!=null){
            transaction.hide(camerImagesFragment);
        }
        if (paintImagesFragment!=null){
            transaction.hide(paintImagesFragment);
        }
        if (artDesignImagesFragment!=null){
            transaction.hide(artDesignImagesFragment);
        }
        if (travelImagesFragment!=null){
            transaction.hide(travelImagesFragment);
        }
        if (fashionImagesFragment!=null){
            transaction.hide(fashionImagesFragment);
        }
        if (liveImagesFragment!=null){
            transaction.hide(liveImagesFragment);
        }
        if (dressingImagesFragment!=null){
            transaction.hide(dressingImagesFragment);
        }

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.item_image_index:
                initFragment(0);
                break;
            case R.id.item_image_focues:
                initFragment(1);
                break;
            case R.id.item_image_article:
                initFragment(2);
                break;
            case R.id.item_image_food:
                initFragment(3);
                break;
            case R.id.item_image_camer:
                initFragment(4);
                break;
            case R.id.item_image_paint:
                initFragment(5);
                break;
            case R.id.item_image_design:
                initFragment(6);
                break;
            case R.id.item_image_travel:
                initFragment(7);
                break;
            case R.id.item_image_fashion:
                initFragment(8);
                break;
            case R.id.item_image_live:
                initFragment(9);
                break;
            case R.id.item_image_dresser:
                initFragment(10);
                break;
        }

//        transaction.commit();

        drawLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
