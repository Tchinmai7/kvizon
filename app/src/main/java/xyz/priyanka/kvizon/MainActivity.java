package xyz.priyanka.kvizon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       String score= getIntent().getStringExtra("score");
        TextView textView=(TextView)findViewById(R.id.score);
        textView.setText("Your score is"+score);
    }
}
