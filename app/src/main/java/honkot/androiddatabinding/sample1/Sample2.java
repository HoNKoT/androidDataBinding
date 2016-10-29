package honkot.androiddatabinding.sample1;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import honkot.androiddatabinding.R;
import honkot.androiddatabinding.databinding.Sample2inflaterBinding;

public class Sample2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample2);

        ArrayList<User> inputData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            inputData.add(
                    new User(
                            Integer.toString(i),
                            Long.toHexString(this.hashCode())));
        }

        ListView lv = (ListView) findViewById(R.id.list);
        ListViewAdapter adapter = new ListViewAdapter(this, inputData);
        lv.setAdapter(adapter);
    }

    private class ListViewAdapter extends ArrayAdapter<User> {

        ArrayList<User> data;

        public ListViewAdapter(Context context, ArrayList<User> inputData) {
            super(context, 0);
            data = inputData;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                Sample2inflaterBinding binding
                        = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.sample2inflater, parent, false);
                convertView = binding.getRoot();
            }
            Sample2inflaterBinding binding = DataBindingUtil.getBinding(convertView);
            binding.setUser(getItem(position));
            return convertView;
        }

        @Override
        public User getItem(int position) {
            return data.get(position);
        }

        @Override
        public int getCount() {
            return data.size();
        }
    }
}
