package app.residemenu.com.listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context mContext;
    private List<Data> mList;
    public OnDataListner onDataListner;

    public ListAdapter(Context mContext, List<Data> mList, OnDataListner onDataListner) {
        this.mContext = mContext;
        this.mList = mList;
        this.onDataListner = onDataListner;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_custom_layout, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {
        Data data = mList.get(i);
        if (data.isSelected()){
            listViewHolder.mCheckBox.setChecked(true);
        }
        else {
            listViewHolder.mCheckBox.setChecked(false);
        }
        listViewHolder.mTxtName.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        private CheckBox mCheckBox;
        private TextView mTxtName;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            mCheckBox = itemView.findViewById(R.id.checkbox);
            mTxtName = itemView.findViewById(R.id.edit_text_name);
            mCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mCheckBox.isChecked()){
                        mList.get(getAdapterPosition()).setSelected(true);
                        onDataListner.getData(getAdapterPosition(),mTxtName.getText().toString().trim(),true);

                    }
                    else {
                        mList.get(getAdapterPosition()).setSelected(false);
                        onDataListner.getData(getAdapterPosition(),mTxtName.getText().toString().trim(),false);
                    }
                }
            });

        }
    }
}
