package br.com.lucreitor;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.List;

import br.com.lucreitor.vo.Investment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    EditText initialMoneyEditText;
    EditText monthlyMoneyEditText;
    EditText yearsEditText;

    ExpandableListView investmentsExpandableListView;
    ExpandableListAdapter investmentExpandableListAdapter;
    List<Investment> investmentData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

        initialMoneyEditText = findViewById(R.id.initialMoneyEditText);
        monthlyMoneyEditText =  findViewById(R.id.monthlyMoneyEditText);
        yearsEditText = findViewById(R.id.yearsEditText);
    }

    public void calculate(View view) {
        Log.i("Text", "calculate()");

        if(!validateForm()){
            return;
        }

        double presentValue = Double.parseDouble(initialMoneyEditText.getText().toString());
        double paymentByMounth = Double.parseDouble(monthlyMoneyEditText.getText().toString());
        int month = Integer.parseInt(yearsEditText.getText().toString()) * 12;


        investmentsExpandableListView = findViewById(R.id.investmentsExpandableListView);
        investmentData = InvestmentData.generateInvestmentData(presentValue,paymentByMounth,month);
        investmentExpandableListAdapter = new InvestmentExpandableListAdapter(this, investmentData);
        investmentsExpandableListView.setAdapter(investmentExpandableListAdapter);


        hideKeyboard(this);
    }

    private boolean validateForm(){
        if(initialMoneyEditText.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Insira quanto dinheiro você tem", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(monthlyMoneyEditText.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Insira quanto deseja investir mensalmente", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(yearsEditText.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Insira por quantos anos", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
