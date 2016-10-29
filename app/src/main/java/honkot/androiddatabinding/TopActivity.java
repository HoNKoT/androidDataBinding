package honkot.androiddatabinding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import honkot.androiddatabinding.sample1.*;

public class TopActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        findViewById(R.id.sample1_1).setOnClickListener(this);
        findViewById(R.id.sample1_2).setOnClickListener(this);
        findViewById(R.id.sample1_3).setOnClickListener(this);
        findViewById(R.id.sample1_4).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.sample1_1: intent.setClass(this, Sample1.class); break;
            case R.id.sample1_2: intent.setClass(this, Sample2.class); break;
            case R.id.sample1_3: intent.setClass(this, Sample3.class); break;
            case R.id.sample1_4: intent.setClass(this, Sample4.class); break;
            default:
                return;
        }
        startActivity(intent);
    }
}
