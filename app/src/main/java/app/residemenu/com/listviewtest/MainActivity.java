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
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnDataListner{

    private RecyclerView mRecyclerList;
    private ListAdapter mListAdapter;
    private DividerItemDecoration dividerItemDecoration;
    private List<Data> mList;
    private TextView mTxtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mList.add(new Data("Ram",false));
        mList.add(new Data("Shyam",false));
        mList.add(new Data("Suresh",false));
        mList.add(new Data("Mohan",false));
        mList.add(new Data("Sohan",false));
        mList.add(new Data("Arjun",false));
        mList.add(new Data("komal",false));

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
    }

    @Override
    public void getData(int pos,String name, boolean isSelected) {

    }
}
