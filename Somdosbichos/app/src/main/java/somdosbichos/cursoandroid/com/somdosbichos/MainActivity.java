package somdosbichos.cursoandroid.com.somdosbichos;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView imageCachorro,imageGato,imageLeao,imageMacaco,imageOvelha,imageVaca;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageCachorro = findViewById(R.id.imageCachorroId);
        imageGato = findViewById(R.id.imageGatoId);
        imageLeao = findViewById(R.id.imageLeaoId);
        imageMacaco = findViewById(R.id.imageMacacoId);
        imageOvelha = findViewById(R.id.imageOvelhaId);
        imageVaca = findViewById(R.id.imageVacaId);

        imageCachorro.setOnClickListener(this);
        imageGato.setOnClickListener(this);
        imageLeao.setOnClickListener(this);
        imageMacaco.setOnClickListener(this);
        imageOvelha.setOnClickListener(this);
        imageVaca.setOnClickListener(this);
    }

    //metodo que vai servir  para destruir o player depois que a activity parar
    @Override
    protected void onDestroy() {
        if(mediaPlayer != null){
            mediaPlayer.release();//libertando o media player
            mediaPlayer = null;
        }
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageCachorroId:
                mediaPlayer =  MediaPlayer.create(getApplicationContext(),R.raw.cao);
                tocarSom();
                break;

            case R.id.imageGatoId:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.gato);
                tocarSom();
                break;
            case R.id.imageLeaoId:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.leao);
                tocarSom();
                break;
            case R.id.imageMacacoId:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.macaco);
                tocarSom();
                break;
            case R.id.imageOvelhaId:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.ovelha);
                tocarSom();
                break;
            case R.id.imageVacaId:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.vaca);
                tocarSom();
                break;
        }


    }

    public void tocarSom(){
        if (mediaPlayer != null){
            mediaPlayer.start();
        }
    }


}
