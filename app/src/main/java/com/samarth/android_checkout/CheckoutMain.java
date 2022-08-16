package com.samarth.android_checkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class CheckoutMain extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem orderTab,shippingTab,paymentTab;
    ViewPager viewPager;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_main);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        orderTab=(TabItem) findViewById(R.id.orderTab);
        paymentTab=(TabItem) findViewById(R.id.paymentTab);
        shippingTab=(TabItem) findViewById(R.id.shippingTab);
        viewPager=(ViewPager) findViewById(R.id.viewPager);

        pageAdapter= new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition()==0 || tab.getPosition()==1 || tab.getPosition()==2){
                    pageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}