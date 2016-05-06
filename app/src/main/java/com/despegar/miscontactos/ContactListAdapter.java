package com.despegar.miscontactos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by leandronarosky on 05/05/16.
 */
public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactItemViewHolder> {
    List<Contact> contacts;
    Context context;

    public interface OnItemClickListener {
        void onItemClick(Contact contact);
    }

    private final OnItemClickListener onItemClickListener;

    public ContactListAdapter(List<Contact> contacts, OnItemClickListener onItemClickListener){

        this.contacts=contacts;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ContactItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(context)
                .inflate(R.layout.fragment_contactitem, parent, false);
        return new ContactItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactItemViewHolder holder, int position) {
        final Contact contact = contacts.get(position);
        holder.nameTextView.setText(contact.getName());
        Picasso.with(context).load(contact.getImageUrl()).placeholder(R.drawable.contact_icon).fit().into(holder.photoView);
        if(contact.isFavorite()) {
            Picasso.with(context).load(R.drawable.star_pink).fit().into(holder.favView);
        }
        holder.container.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(contact);
            }
        }));

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public static class ContactItemViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView photoView, favView;
        View container;

        public ContactItemViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.contactName);
            photoView = (ImageView) itemView.findViewById(R.id.contactImage);
            favView = (ImageView) itemView.findViewById(R.id.favorite);
            container = itemView.findViewById(R.id.container);
            }
    }
}
