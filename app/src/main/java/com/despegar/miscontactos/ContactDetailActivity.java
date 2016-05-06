package com.despegar.miscontactos;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

public class ContactDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        Contact contact = (Contact) getIntent().getSerializableExtra("Contact");
        addFragment(contact);

    }

    private void addFragment(Contact contact){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        ContactoFragment contactoFragment = new ContactoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Contact",contact);
        contactoFragment.setArguments(bundle);
        fragmentTransaction.add(R.id.fragment_container, contactoFragment,"Contacto");
        fragmentTransaction.commit();
    }
}
