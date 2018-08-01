package app.residemenu.com.listviewtest;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnDataListner{

    private RecyclerView mRecyclerList;
    private ListAdapter mListAdapter;
    private DividerItemDecoration dividerItemDecoration;
    private ArrayList<Data> mList;
    private ArrayList<String> mListSecond;
    private TextView mTxtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mList.add(new Data("1",false));
        mList.add(new Data("2",false));
        mList.add(new Data("3",false));
        mList.add(new Data("4",false));
        mList.add(new Data("5",false));
        mList.add(new Data("6",false));
        mList.add(new Data("7",false));
        mList.add(new Data("8",false));
        mList.add(new Data("9",false));
        mList.add(new Data("10",false));


        mRecyclerList.setHasFixedSize ( true );
        mRecyclerList.setLayoutManager ( new LinearLayoutManager( getApplicationContext() ) );
        dividerItemDecoration = new DividerItemDecoration(mRecyclerList.getContext(),
                new LinearLayoutManager(getApplicationContext()).getOrientation());
        mRecyclerList.addItemDecoration(dividerItemDecoration);
        mListAdapter = new ListAdapter(this,mList ,this);
        mRecyclerList.setAdapter ( mListAdapter );


    }

    private void init(){
        mRecyclerList = findViewById(R.id.recylcler_list);
        mTxtOutput = findViewById(R.id.text_output);
        mList = new ArrayList<>();
        mListSecond = new ArrayList<>();

    }

    @Override
    public void getData(int pos,String name, boolean isSelected) {
        if (isSelected){
            mListSecond.add(name);
        }
        else {
            mListSecond.remove(name);
        }
        // Collections.addAll(mList,name.split(","));
        String h = android.text.TextUtils.join((","),mListSecond);
        Log.e("NAME",h+" ");
        mTxtOutput.setText(h+" ");
    }
}
