package com.example.myactivity1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class my1activity extends AppCompatActivity {
    Spinner branchName;
    RecyclerView recyclerView;
    String searchBranched ="";
    BranchAdapter branchAdapter;
    ArrayList<String> branchDetailset,branchNameset;

    ArrayAdapter<String> adplv;
    ArrayAdapter<String> adplv1;
    ArrayAdapter<String> adplv2;
    String[] branches;
    String[] branches1;
    String[] branches2;
    String branchn;
    String scity;
    ListView l;
    int adapterv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my1activity);

        scity="";
        l = (ListView) findViewById(R.id.listview);

        String[] sa = getResources().getStringArray(R.array.branch_names);

        final ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sa);

        branches=getResources().getStringArray(R.array.lhr_branch_detail);

        branches1=getResources().getStringArray(R.array.rwp_branch_detail);

        branches2=getResources().getStringArray(R.array.kcr_branch_detail);

        Spinner s = (Spinner) findViewById(R.id.branchName);

        s.setAdapter(dataAdapter);

        adplv = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branches);
        adplv1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branches1);

        Log.d("TAG", branches[0]);

        adplv2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branches2);


        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                scity = dataAdapter.getItem(position);
                if(scity.equalsIgnoreCase("lahore"))
                {
                   l.setAdapter(adplv);
                   adplv.notifyDataSetChanged();
                   adapterv =0;
                }
                else if(scity.equalsIgnoreCase("Rawalpindi"))
                {
                    l.setAdapter(adplv1);
                    adplv1.notifyDataSetChanged();
                    adapterv=1;
                }
                else
                {
                    l.setAdapter(adplv2);
                    adplv2.notifyDataSetChanged();
                    adapterv=2;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(adapterv==0) {
                    branchn = adplv.getItem(position);
                    Toast.makeText(my1activity.this, branchn, Toast.LENGTH_SHORT).show();
                    //Intent i = new Intent(this, Menu.class);
                    //i.putExtra("value",branchn);
                    //i.putExtra("city",scity);
                    //startActivity(i);

                }
                else if(adapterv==1)
                {
                    branchn = adplv1.getItem(position);
                    Toast.makeText(my1activity.this, branchn, Toast.LENGTH_SHORT).show();
                }
                else
                {
                    branchn = adplv2.getItem(position);
                    Toast.makeText(my1activity.this, branchn, Toast.LENGTH_SHORT).show();
                }
            }
        });


        /*setupID();
        setupValues();

        RecyclerView r = (RecyclerView) findViewById(R.id.listview);
        r.setOnI;
    }
    private void setupID() {
        branchName=findViewById(R.id.branchName);
        recyclerView=findViewById(R.id.listview);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(layoutManager);
    }
    private void setupValues() {
        branchName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                searchBranched =adapterView.getItemAtPosition(i).toString();
                if(!searchBranched.isEmpty()){
                    searchBranch(searchBranched);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }
    private void searchBranch(String searchBranched) {
        switch (searchBranched){
            case "Rawalpindi":
                branchNameset= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.rwp_branch_name)));
                branchDetailset= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.rwp_branch_detail)));
                branchAdapter=new BranchAdapter(this,branchDetailset,branchNameset,searchBranched);
                recyclerView.setAdapter(branchAdapter);
                break;

            case "Karachi":
                branchNameset= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.karachi_branch_name)));
                branchDetailset= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.kcr_branch_detail)));
                branchAdapter=new BranchAdapter(this,branchDetailset,branchNameset,searchBranched);
                recyclerView.setAdapter(branchAdapter);
                break;

            case "Lahore":
                branchNameset= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.lhr_branch_name)));
                branchDetailset= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.lhr_branch_detail)));
                branchAdapter=new BranchAdapter(this,branchDetailset,branchNameset,searchBranched);
                recyclerView.setAdapter(branchAdapter);
                break;
        }*/
    }


}