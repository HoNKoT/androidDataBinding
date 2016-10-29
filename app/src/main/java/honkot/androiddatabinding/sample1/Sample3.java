package honkot.androiddatabinding.sample1;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import honkot.androiddatabinding.R;
import honkot.androiddatabinding.databinding.Sample2inflaterBinding;
import honkot.androiddatabinding.databinding.Sample3inflaterBinding;

public class Sample3 extends AppCompatActivity {

    public ArrayList<UserObservable> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample2);

        data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(
                    new UserObservable(
                            Integer.toString(i),
                            Long.toHexString(this.hashCode())));
        }

        ListView lv = (ListView) findViewById(R.id.list);
        ListViewAdapter adapter = new ListViewAdapter(this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                android.util.Log.e("TAG", "### " + i);
                UserObservable clickedUser = data.get(i);
                clickedUser.setFirstName("HIROKI");
                clickedUser.setLastName("HONDA");
                clickedUser.setNickname(": HONDY");
            }
        });
    }

    private class ListViewAdapter extends ArrayAdapter<UserObservable> {

        public ListViewAdapter(Context context) {
            super(context, 0);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                Sample3inflaterBinding binding
                        = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.sample3inflater, parent, false);
                convertView = binding.getRoot();
            }
            Sample3inflaterBinding binding = DataBindingUtil.getBinding(convertView);
            binding.setUser(getItem(position));
            return convertView;
        }

        @Override
        public UserObservable getItem(int position) {
            return data.get(position);
        }

        @Override
        public int getCount() {
            return data.size();
        }
    }
}
