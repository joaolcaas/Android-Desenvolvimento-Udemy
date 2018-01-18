package signos.cursoandroid.com.signos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] signos = {"Áries",
            "Touro","Gêmeos","Câncer","Leão",
            "Virgem","Libra","Escorpição","Sagitário",
            "Capricónio","Aquário","Peixes"
    };

    private String[] perfis = {
            "Arianos são animados, independentes,individualistas, dinamicos",
            "Taurinos são positivos,pacientes, determinados, noturnos, leais",
            "Germinianos são positivos, mutáveis, racionais e bastante voláteis",
            "...","...","...","...","...","...","...","...","..."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listViewId);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_expandable_list_item_1,
                android.R.id.text1,
                signos
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int posicao = i;
                Toast.makeText(getApplicationContext(),perfis[posicao], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
