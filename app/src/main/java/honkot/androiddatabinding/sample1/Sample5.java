package honkot.androiddatabinding.sample1;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import honkot.androiddatabinding.R;
import honkot.androiddatabinding.databinding.Sample5Binding;

public class Sample5 extends AppCompatActivity {

    private final String TAG = "Sample 1-5";
    Sample5Binding mBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBind = DataBindingUtil.setContentView(this, R.layout.sample5);
        UserInput input = new UserInput();
        mBind.setInput(input);
        mBind.dump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dump();
            }
        });
    }

    private void dump() {
        StringBuffer buf = new StringBuffer();
        buf.append("RadioGroup:'Radio ");
        switch (mBind.radioG.getCheckedRadioButtonId()) {
            case R.id.radioA: buf.append("A"); break;
            case R.id.radioB: buf.append("B"); break;
            default: buf.append("UNKNOWN:" + mBind.radioG.getCheckedRadioButtonId()); break;
        }
        buf.append("'");
//        buf.append(System.getProperty("line.separator"));
        Log.i(TAG, buf.toString());
    }
}
