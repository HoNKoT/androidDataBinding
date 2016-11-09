package honkot.androiddatabinding.sample1;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import honkot.androiddatabinding.R;
import honkot.androiddatabinding.databinding.Sample5Binding;

public class Sample5 extends AppCompatActivity {

    private final String TAG = "Sample 1-5";
    UserInput mInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Sample5Binding bind = DataBindingUtil.setContentView(this, R.layout.sample5);
        mInput = new UserInput();
        bind.setInput(mInput);
        bind.dump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dump();
            }
        });
    }

    private void dump() {
        StringBuffer buf = new StringBuffer();
        buf.append("RadioGroup:'Radio ");
        switch (mInput.getRadioGroup().get()) {
            case R.id.radioA: buf.append("A"); break;
            case R.id.radioB: buf.append("B"); break;
            default: buf.append("UNKNOWN"); break;
        }
        buf.append("'");
//        buf.append(System.getProperty("line.separator"));
        Log.i(TAG, buf.toString());
    }
}
