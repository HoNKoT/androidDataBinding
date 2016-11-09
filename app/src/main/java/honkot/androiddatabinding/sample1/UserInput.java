package honkot.androiddatabinding.sample1;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableInt;
import android.util.Log;

import honkot.androiddatabinding.BR;
import honkot.androiddatabinding.R;

/**
 * Created by hiroki on 2016-10-29.
 */
public class UserInput extends BaseObservable {

    @Bindable
    private ObservableInt radioGroup = new ObservableInt();
    @Bindable
    private String editText = "";

    public UserInput() {
        // initialize
        radioGroup.set(R.id.radioA);
    }
    public ObservableInt getRadioGroup() {
        return this.radioGroup;
    }
    public void setRadioGroup(ObservableInt value) {
        radioGroup = value;
        notifyPropertyChanged(BR.radioGroup);
    }
    public String getEditText() { return editText;}
    public void setEditText(String value) { this.editText = value;}

    public void dump() {
        StringBuffer buf = new StringBuffer();
        buf.append("RadioGroup:'Radio ");
        switch (radioGroup.get()) {
            case R.id.radioA: buf.append("A"); break;
            case R.id.radioB: buf.append("B"); break;
            default: buf.append("UNKNOWN"); break;
        }
        buf.append("'");
        buf.append(System.getProperty("line.separator"));
        buf.append("EditText:'");
        buf.append(editText);
        buf.append("'");
        Log.i("InputUser", buf.toString());
    }
}
