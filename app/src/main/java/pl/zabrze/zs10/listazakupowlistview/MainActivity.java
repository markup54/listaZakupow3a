package pl.zabrze.zs10.listazakupowlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> produkty = new ArrayList<>();
    private EditText editTextProdukt;
    private Button button;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextProdukt = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                produkty
        );
        listView.setAdapter(adapter);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String produkt = editTextProdukt.getText().toString();
                        editTextProdukt.setText("");
                        produkty.add(produkt);
                        adapter.notifyDataSetChanged();
                    }
                }
        );
    }
}