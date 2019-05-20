package com.bawei.caolina20190520;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.caolina20190520.adapter.HomeAdapter;
import com.bawei.caolina20190520.bean.SeaBean;
import com.bawei.caolina20190520.homemvp.HomePresent;
import com.bawei.caolina20190520.homemvp.IHomeContract;
import com.bawei.caolina20190520.net.HttpUtil;
import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IHomeContract.IHomeView {

    private EditText sea;
    private Button button;
    private RecyclerView recyclerView;
    private IHomeContract.IHomePresent present;
    private Gson gson;
    private SeaBean bean;
    private List<SeaBean.ResultBean> result;
    private String str;
    private StaggeredGridLayoutManager manager;
    private HomeAdapter adapter;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        sea = findViewById(R.id.sea);
        button = findViewById(R.id.but);
        recyclerView = findViewById(R.id.recycler);
        //判断网络
        if (HttpUtil.getInstance().isNetWord(MainActivity.this)) {
            Toast.makeText(this, "有网络", Toast.LENGTH_SHORT).show();
        }
        //利用presenter接口调用数据
        present = new HomePresent();
        present.attach(this);
        present.showList(Api.SEAURL + URLEncoder.encode("板鞋"));

        //设置recycleview的适配器
        manager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(manager);

        //设置button点击事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = sea.getText().toString();
                if (!str.isEmpty()) {
                    present.showList(Api.SEAURL + URLEncoder.encode(str));
                }
            }
        });
    }

    @Override
    public void getHomePre(String data) {
        gson = new Gson();
        bean = gson.fromJson(data, SeaBean.class);
        result = bean.getResult();
        //适配器
        adapter = new HomeAdapter(MainActivity.this, result);
        recyclerView.setAdapter(adapter);
        //条目点击事件
        adapter.setItemClick(new HomeAdapter.onItemClick() {
            @Override
            public void Click(String id) {
                intent = new Intent(MainActivity.this, ShopInfoActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        present.dettach();
    }
}
