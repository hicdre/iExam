package com.xz.iexam;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.xz.iexam.model.Question;
import com.xz.iexam.model.QuestionProvider;

import java.util.ArrayList;


public class MainActivity extends Activity implements RadioGroup.OnCheckedChangeListener {

    TextView textAnswer;
    TextView textDetails;
    ArrayList<Question> questions;
    int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup gp = (RadioGroup)findViewById(R.id.answerGroup);
        gp.setOnCheckedChangeListener(this);

        textAnswer = (TextView)findViewById(R.id.answerText);
        textDetails = (TextView)findViewById(R.id.textDetails);

        questions =  QuestionProvider.getInstance().GetQuestions();
        currentIndex = 0;
        ShowQuestion();
    }

    public void ShowQuestion()
    {
        Question q = questions.get(currentIndex);
        textDetails.setText(q.getDetails());

        ArrayList<String> answers = q.getAnswers();
        int ids[] = {R.id.answerA, R.id.answerB, R.id.answerC, R.id.answerD};
        for (int i =0; i < answers.size(); ++i)
        {
            RadioButton b = (RadioButton)findViewById(ids[i]);
            b.setText(answers.get(i));
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
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.answerA)
            textAnswer.setText("A");
        else if (checkedId == R.id.answerB)
            textAnswer.setText("B");
        else if (checkedId == R.id.answerC)
            textAnswer.setText("C");
        else if (checkedId == R.id.answerD)
            textAnswer.setText("D");
    }
}
