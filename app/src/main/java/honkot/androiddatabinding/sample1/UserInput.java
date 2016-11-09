package honkot.androiddatabinding.sample1;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableBoolean;
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
    @Bindable
    private ObservableBoolean checkBox  = new ObservableBoolean();
    @Bindable
    private ObservableBoolean toggleButton  = new ObservableBoolean();
    @Bindable
    private ObservableInt seekBar = new ObservableInt();

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
    public ObservableBoolean getCheckBox() {
        return this.checkBox;
    }
    public ObservableBoolean getToggleButton() {
        return this.toggleButton;
    }
    public ObservableInt getSeekBar() {
        return this.seekBar;
    }

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
        buf.append(System.getProperty("line.separator"));
        buf.append("CheckBox:'");
        buf.append(checkBox.get());
        buf.append("'");
        buf.append(System.getProperty("line.separator"));
        buf.append("ToggleButton:'");
        buf.append(toggleButton.get());
        buf.append("'");
        buf.append(System.getProperty("line.separator"));
        buf.append("SeekBar:'");
        buf.append(seekBar.get());
        buf.append("'");

        Log.i("InputUser", buf.toString());
    }
}
