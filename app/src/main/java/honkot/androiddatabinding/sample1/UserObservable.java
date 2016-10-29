package honkot.androiddatabinding.sample1;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by hiroki on 2016-10-29.
 */
public class UserObservable extends BaseObservable {
    @Bindable
    private String firstName;
    private String lastName;
    private String Nickname;

    public UserObservable(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    @Bindable
    public String getLastName() {
        return this.lastName;
    }
    public String getNickname() {
        return this.Nickname;
    }

    public void setFirstName(String value) {
        this.firstName = value;
        notifyPropertyChanged(BR.firstName);
    }
    public void setLastName(String value) {
        this.lastName = value;
        notifyPropertyChanged(BR.lastName);
    }
    public void setNickname(String value) {
        this.Nickname = value;
        // You cannot use notifyPropertyChanged since the variable does not have @Bindable
//        notifyPropertyChanged(BR.Nickname);
    }
}
