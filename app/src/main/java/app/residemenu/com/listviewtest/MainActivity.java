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
    private List<Info> mInfo;
    //private List mUser = new ArrayList();
    private TextView mTxtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerList = findViewById(R.id.recylcler_list);
        mTxtOutput = findViewById(R.id.text_output);
        mList = new ArrayList<>();
        mInfo = new ArrayList<>();

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

    @SuppressLint("SetTextI18n")
    @Override
    public void getData(int pos,String name, boolean isSelected) {

        /*if (isSelected){
            for (int i = 0;i<mList.size();i++){
                String selectedNames[] = {mList.get(i).name};

                mInfo.add(new Info(Arrays.toString(selectedNames)));

                Log.d("names", "names checked: " + mInfo.get(i).getName()+" ,");
                mTxtOutput.setText(mInfo.get(i).getName() );
                *//*mInfo.get(pos).setName(name);
                mUser.add(mInfo);
                 Log.d("names", "names checked: " + mUser+" ,");*//*
               // Log.d("names", "names checked: " + selectedNames[i]+" ,");
               // mTxtOutput.setText(Arrays.toString(selectedNames) +",");
            }

            *//*for (int j =0;i<mInfo.size();j++){
                Iterator itr = mInfo.iterator();
                while (itr.hasNext()){
                    Log.d("names", "names checked: " + mInfo.get(j).getName()+" ,");

                }
            }*//*

        }else {
            mListAdapter.notifyDataSetChanged();
        }*/

       /* if (isSelected){
            for(int j = 0;j<mList.size();j++){
                mInfo.add(new Info(""+name));
            }
            *//*for(int i = 0;i<mInfo.size();i++){
                Log.e("NAME",mInfo.get(i).getName());
            }*//*
            Iterator itr = mInfo.iterator();
            while (itr.hasNext()){
                Log.e("NAME",mInfo.get(pos).getName());
            }
        }*/
        if (isSelected){
            String selectedNames[] = mList.get(pos).getName();
        }

    }
}
