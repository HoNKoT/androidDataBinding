package honkot.androiddatabinding.sample1;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableInt;

import honkot.androiddatabinding.BR;
import honkot.androiddatabinding.R;

/**
 * Created by hiroki on 2016-10-29.
 */
public class UserInput extends BaseObservable {

    @Bindable
    private ObservableInt radioGroup = new ObservableInt();

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
}
