package caraoucoroa.cursoandroid.com.caraoucoroa;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DetalheActivity extends AppCompatActivity {

    private ImageView imagemVoltar, imagemResposta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        imagemVoltar = findViewById(R.id.imageVoltarId);
        imagemResposta = findViewById(R.id.imageRespostaId);

        Bundle extra = getIntent().getExtras();

        if(extra != null){
            String opcaoEscolhida = extra.getString("opcao");
            if(opcaoEscolhida.equals("cara")){
                imagemResposta.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.moeda_cara));
            }
            else if(opcaoEscolhida.equals("coroa")){
                imagemResposta.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.moeda_coroa));
            }
        }

        imagemVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetalheActivity.this,MainActivity.class));
            }
        });
    }
}
