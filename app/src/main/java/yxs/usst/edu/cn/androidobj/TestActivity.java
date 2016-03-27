package yxs.usst.edu.cn.androidobj;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/3/27.
 * @author yxs
 */
public class TestActivity extends ListActivity {

    String[] sources = null;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity_view);
        sources = getResources().getStringArray(R.array.city_names);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        tv = (TextView) findViewById(R.id.showClickItem);
        tv.setText(name);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,//上下文
                R.layout.list_item,//每一项的布局
                R.id.cityItem,//显示数据的控件id
                sources);//数据源
        setListAdapter(arrayAdapter);//如果activity中只有一个Listview,可以使用ListActivity，android:id/list
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String cityName = sources[position];
        tv.setText(cityName);
        super.onListItemClick(l, v, position, id);
    }
}
