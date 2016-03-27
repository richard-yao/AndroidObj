package yxs.usst.edu.cn.androidobj;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewUse extends Activity {

    TextView activityPara;
    String[] sources = null;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        sources = getResources().getStringArray(R.array.city_names);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        activityPara = (TextView) findViewById(R.id.activityPara);
        activityPara.setText(name);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//id=position-headerView
                String city = sources[position];
                Log.i("CityName", city);
            }
        });

        ArrayAdapter<String> adapterArr = new ArrayAdapter<String>(
                this,//上下文
                R.layout.list_item,//每一项的布局
                R.id.cityItem,//显示数据的控件id
                sources);//数据源
        listView.setAdapter(adapterArr);
    }

}
