package minhasanotacoes.cursoandroid.com.minhasanotacoes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private ImageView imageSalvar;
    private EditText textoEditado;
    private static final String ARQUIVO_ANOTACAO = "anotação.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSalvar = findViewById(R.id.imagemSalvarId);
        textoEditado = findViewById(R.id.textoEditavelId);

        imageSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoDigitado = textoEditado.getText().toString();
                gravarNoArquivo(textoDigitado);
                Toast.makeText(getApplicationContext(),"Anotação salva",Toast.LENGTH_SHORT).show();

            }
        });

        if(lerArquivo() != null){
            textoEditado.setText(lerArquivo());
        }


    }

    public void gravarNoArquivo(String texto){
        try {
            //escrevendo em um arquivo, passando como parametro o nome do arquivo e o contexto em que ele pode ser usado
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(ARQUIVO_ANOTACAO, Context.MODE_PRIVATE));
            outputStreamWriter.write(texto);
            //fechando o arquivo
            outputStreamWriter.close();

        }catch (IOException e){ //excecao de input ou output
            Log.v("MainActivity",e.toString());
        }
    }

    public String lerArquivo(){
        String resultado = "";
        try{
            //abrir o arquivo
            InputStream arquivo = openFileInput(ARQUIVO_ANOTACAO);
            if(!arquivo.equals(null)){
                //ler o arquivo
                InputStreamReader inputStreamReader = new InputStreamReader(arquivo);
                //gerar um buffer
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                //Recuperar texto do arquivo
                String linhaArquivo = "";
                while((linhaArquivo = bufferedReader.readLine()) != null) {
                    resultado += linhaArquivo;
                }
                arquivo.close();
            }

        }catch (IOException e){
            Log.v("MainActivity",e.toString());
        }


        return resultado;
    }
}
