package qualserie.cursoandroid.com.qualserie;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;


public class MainActivity extends AppCompatActivity {

    private SeekBar quantoGostoSeek;
    private ImageView imagemGosto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        quantoGostoSeek = findViewById(R.id.seekBarId);
        imagemGosto = findViewById(R.id.imageViewId);


        quantoGostoSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i == 1) {
                    imagemGosto.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.pouco));
                } else if (i == 2) {
                    imagemGosto.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.medio));
                } else if (i == 3) {
                    imagemGosto.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.muito));
                } else if (i == 4) {
                    imagemGosto.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.susto));
                }else if (i == 0){
                    imagemGosto.setImageResource(android.R.color.transparent);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
