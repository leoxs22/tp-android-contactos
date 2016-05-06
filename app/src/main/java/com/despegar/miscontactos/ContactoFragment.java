package com.despegar.miscontactos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;



public class ContactoFragment extends Fragment {

    Contact contact;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacto, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        this.contact = (Contact) getArguments().getSerializable("Contact");
       }

    @Override
    public void onStart(){
        super.onStart();
        loadData();
        initializeButton();
    }

    private void loadData() {
        TextView name = (TextView) getView().findViewById(R.id.contactName);
        TextView telephone = (TextView) getView().findViewById(R.id.telephone);
        TextView address = (TextView) getView().findViewById(R.id.adress);
        TextView birthDate = (TextView) getView().findViewById(R.id.birthDate);
        TextView mail = (TextView) getView().findViewById(R.id.mail);
        ImageView photo = (ImageView) getView().findViewById(R.id.contactImage);

        name.setText(contact.getName());
        telephone.setText(contact.getPhone());
        address.setText(contact.getAddress());
        birthDate.setText(contact.getBirthdate());
        mail.setText(contact.getEmail());

        String imageUrl = contact.getImageUrl();
        if(imageUrl!=null){
            Picasso.with(getContext()).load(imageUrl).into(photo);
        }
    }

    private void initializeButton(){

        Button callButton= (Button) getView().findViewById(R.id.callButton);
        callButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            TextView textView = (TextView) getView().findViewById(R.id.telephone);
            CharSequence text = textView.getText();
            int duration = Toast.LENGTH_SHORT;
            Toast.makeText(getActivity(), text, duration).show();

        }
    });
    }


}
