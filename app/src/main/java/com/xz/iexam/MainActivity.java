package com.xz.iexam;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    TextView answerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup gp = (RadioGroup)findViewById(R.id.answerGroup);
        gp.setOnCheckedChangeListener(this);

        answerText = (TextView)findViewById(R.id.answerText);
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.answerA)
            answerText.setText("A");
        else if (checkedId == R.id.answerB)
            answerText.setText("B");
        else if (checkedId == R.id.answerC)
            answerText.setText("C");
        else if (checkedId == R.id.answerD)
            answerText.setText("D");
    }
}
