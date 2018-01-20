package preferenciascorusuario.cursoandroid.com.preferenciascorusuario;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button botaoSalvar;
    private RelativeLayout relativeLayout;
    private static  final String ARQUIVO_PREFERENCIA = "ArqPreferencia";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroupId);
        botaoSalvar = findViewById(R.id.botaoSalvarId);
        relativeLayout = findViewById(R.id.relativoId);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();
                if(idRadioButtonEscolhido > 0) {
                    radioButton = findViewById(idRadioButtonEscolhido);
                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);//0 é para que o arquivo seja privado
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String corEscolhida = radioButton.getText().toString();
                    editor.putString("corEscolhida",corEscolhida);
                    editor.commit();

                    setBackground(corEscolhida);

                }

            }
        });

        //recuperando a cor salva
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(sharedPreferences.contains("corEscolhida")){
            String corRecuperada = sharedPreferences.getString("corEscolhida","Laranja");
            setBackground(corRecuperada);
        }

    }

    private void setBackground(String cor){
        if(cor.toLowerCase().equals("azul")){
            //setar a cor para azul
            relativeLayout.setBackgroundColor(Color.parseColor("#495b7c"));
        }else if(cor.toLowerCase().equals("laranja")){
            //setar a cor para laranja
            relativeLayout.setBackgroundColor(Color.parseColor("#ffce26"));
        }else{
            //setar a cor para verde
            relativeLayout.setBackgroundColor(Color.parseColor("#009760"));
        }
    }
}
