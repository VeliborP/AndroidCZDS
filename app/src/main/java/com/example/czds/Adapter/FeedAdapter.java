package com.example.czds.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.czds.Interface.ItemClickListener;
import com.example.czds.Model.RSSObject;
import com.example.czds.R;



class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener
{

    public TextView txtTitle,txtPubDate, txtContent;
    private ItemClickListener itemClickListener;

    public ItemViewHolder(View itemView) {
        super(itemView);

        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtPubDate = itemView.findViewById(R.id.txtPubDate);

        //Set Event
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v,getAdapterPosition(),false);

    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}

class FooterViewHolder extends RecyclerView.ViewHolder
{

    public TextView txtFooter;
    private ItemClickListener itemClickListener;

    public FooterViewHolder(View itemView) {
        super(itemView);
        txtFooter = itemView.findViewById(R.id.footer_text);
    }
}

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;

    private RSSObject rssObject;
    private Context mContext;
    private LayoutInflater inflater;

    public FeedAdapter(RSSObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_ITEM){
            View itemView = inflater.inflate(R.layout.recycler_view_item,parent,false);
            return new ItemViewHolder(itemView);
        }
        if(viewType == TYPE_FOOTER){
            View itemView = inflater.inflate(R.layout.footer,parent,false);
            return new FooterViewHolder(itemView);
        }
        else return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            String title = rssObject.getItems().get(position).getTitle();
            if(title.length()>46)
                title = title.substring(0, 46) + "...";

            itemViewHolder.txtTitle.setText(title);
            itemViewHolder.txtPubDate.setText(rssObject.getItems().get(position).getPubDate());

            ((ItemViewHolder) holder).setItemClickListener(new ItemClickListener() {
                @Override
                public void onClick(View view, int position, boolean isLongClick) {
                    if(!isLongClick)
                    {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(rssObject.getItems().get(position).getLink()));
                        mContext.startActivity(browserIntent);
                    }
                }
            });
        }
        if(holder instanceof FooterViewHolder){
           // FooterViewHolder footerViewHolder = (FooterViewHolder) holder;
            //footerViewHolder.txtFooter.setText("Text footera smor");
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position >= rssObject.items.size()) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return rssObject.items.size()+2;
    }
}
