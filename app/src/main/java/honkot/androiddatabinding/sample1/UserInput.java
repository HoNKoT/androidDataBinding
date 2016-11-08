package honkot.androiddatabinding.sample1;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableInt;

/**
 * Created by hiroki on 2016-10-29.
 */
public class UserInput extends BaseObservable {

    @Bindable
    private ObservableInt radioGroup;

    public UserInput() {
    }
    public ObservableInt getRadioGroup() {
        return this.radioGroup;
    }
    public void setLastName(ObservableInt value) {
        radioGroup = value;
    }
}
