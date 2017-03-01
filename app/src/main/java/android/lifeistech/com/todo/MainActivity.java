package android.lifeistech.com.todo;

import android.graphics.Color;
import android.graphics.Paint;
import android.opengl.ETC1;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    ArrayAdapter adapter;
    List<String> items;
    int change;

    String[] arrayItems = new String[5];
    boolean[] arrayFlags = new boolean[5];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        editText = (EditText)findViewById(R.id.editText);
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1);
        items = new ArrayList<>();

        change = 0;

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                        Log.d("MainActivity", "change=" + change);

                TextView textView = (TextView) view;

                //打ち消し線
                TextPaint paint =  textView.getPaint();

//                        if () {
//                            paint.setFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
//                            textView.setTextColor(Color.GRAY);
//                            paint.setAntiAlias(true);
//                            change = 1;
//                        }else{
//                            paint.setFlags(textView.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
//                            textView.setTextColor(Color.BLACK);
//                            change = 0;
//                        }



//                ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();
//
//                String item = (String)adapter.getItem(position);
//
//                int size = adapter.getCount();
//
//                adapter.remove(item);
//
//                if (size != position + 1) {
//
//                    adapter.insert(item, position + 1);
//
//                }else{
//
//                    adapter.insert(item, position);
//
//                }


            }
        });

        // 匿名クラスを set している匿名クラスを set している
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id){
                ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();

                String item = (String)adapter.getItem(position);
                Toast.makeText(MainActivity.this, item + "を削除しました", Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
//                Toast.makeText(getBaseContext(), item, Toast.LENGTH_SHORT).show();

                adapter.remove(item);

                return false;
            }
        });

    }

    public void add (View v){
        String text;
        text = editText.getText().toString();

        Toast.makeText(this, text + "を追加しました", Toast.LENGTH_SHORT).show();

        adapter.add(text);

        editText.setText("");
    }
}
