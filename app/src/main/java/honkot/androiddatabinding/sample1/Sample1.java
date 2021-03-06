package honkot.androiddatabinding.sample1;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import honkot.androiddatabinding.R;
import honkot.androiddatabinding.databinding.Sample1Binding;

public class Sample1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // MEMO: Sample1Binding class is created by build so we do not make it.
        // The class name is based on layout file. (In this case, the layout file name is sample1.xml)
        Sample1Binding binding = DataBindingUtil.setContentView(this, R.layout.sample1);
        User user = new User("Test", "User");
        binding.setUser(user);

        // You can get View Object from ViewID you've defined in layout file.
        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
