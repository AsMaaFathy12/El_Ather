package com.example.asmaa.el_ather;



import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asmaa.el_ather.About.compDetail;
import com.example.asmaa.el_ather.Employee.employee;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;

import com.luseen.spacenavigation.SpaceOnClickListener;


public class baseActivity extends AppCompatActivity {
    private SpaceNavigationView spaceNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.addSpaceItem(new SpaceItem("map", R.mipmap.maps));
        spaceNavigationView.addSpaceItem(new SpaceItem("employee",  R.mipmap.profile));
        spaceNavigationView.addSpaceItem(new SpaceItem("Call Us",  R.mipmap.call));
        spaceNavigationView.addSpaceItem(new SpaceItem("About", R.mipmap.about));
        spaceNavigationView.showIconOnly();

       spaceNavigationView.setCentreButtonIconColorFilterEnabled(true
       );

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                loadFragment(new HomeFragment());

            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                display(itemIndex);

            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });



       // display(0);
        loadFragment(new HomeFragment());




    }




    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        spaceNavigationView.onSaveInstanceState(outState);
    }

   private void display(int position) {
       switch (position){
           case 0:
               loadFragment(new map());

//               Intent i=new Intent(baseActivity.this,MapsActivity.class);
//               startActivity(i);

               break;
           case 1:
        loadFragment(new employee());
               break;
           case 2:
              loadFragment(new CallUs());

               break;

           case 3:
               loadFragment(new compDetail());
       }
   }
    private void loadFragment(Fragment mfragment)  {
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.contentFrame, mfragment);
        ft.commit();




//      FragmentManager fragmentManager=getFragmentManager();
//      FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//
//        fragmentTransaction.replace(R.id.contentFrame,mfragment);
//        fragmentTransaction.commit();
    }
}
