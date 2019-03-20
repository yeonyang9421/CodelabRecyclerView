package kr.co.woobi.imyeon.codelabrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private  final LinkedList<String> mItem;
    private LayoutInflater mInflater;

    public RecyclerViewAdapter(Context context,LinkedList<String> mItem) {
        mInflater=LayoutInflater.from(context);
        this.mItem = mItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wordlist_item,viewGroup,false);

        return new ViewHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String str=mItem.get(i);
        viewHolder.mTextWord.setText(str);

    }

    @Override
    public int getItemCount() {
        return mItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView mTextWord;
        RecyclerViewAdapter mAdapter;
        public ViewHolder(@NonNull View itemView, RecyclerViewAdapter adapter) {
            super(itemView);
            mTextWord=itemView.findViewById(R.id.text_word);
            mAdapter=adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition =getLayoutPosition();
            String element = mItem.get(mPosition);
            mItem.set(mPosition,"Clicked! " + element);
            mAdapter.notifyDataSetChanged();
        }
    }
}
