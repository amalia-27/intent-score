package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    private TextView homeText;
    private TextView awayText;
    private ImageView homeGambar;
    private ImageView awayGambar;
    private TextView scoreH;
    private TextView scoreA;
    private int scoreHome ;
    private int scoreAway;

    public static final String HASIL_KEY = "hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        //TODO

        homeText = findViewById(R.id.txt_home);
        awayText = findViewById(R.id.txt_away);
        homeGambar=findViewById(R.id.home_logo);
        awayGambar=findViewById(R.id.away_logo);
        scoreH = findViewById(R.id.score_home);
        scoreA = findViewById(R.id.score_away);

        scoreHome=0;
        scoreH.setText("0");
        scoreAway=0;
        scoreA.setText("0");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            // TODO: display value here
            Bundle extra = getIntent().getExtras();

            Bitmap bmp = extra.getParcelable("imageHome");
            Bitmap bmp2 = extra.getParcelable("imageAway");

            homeGambar.setImageBitmap(bmp);
            awayGambar.setImageBitmap(bmp2);

            homeText.setText(extras.getString("home"));
            awayText.setText(extras.getString("away"));
        }

    }

        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"



    public void addScoreHome(View view){
        scoreHome++;
        scoreH.setText(String.valueOf(scoreHome));
    }
    public void addScoreAway(View view){
        scoreAway++;
        scoreA.setText(String.valueOf(scoreAway));
    }
    public void handleScore(View view){
        String hasil;
        if(scoreHome>scoreAway){
            hasil = homeText.getText().toString();
        }else if(scoreAway>scoreHome){
            hasil = awayText.getText().toString();
        }else{
            hasil="Draw";
        }
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra(HASIL_KEY,hasil);
        startActivity(intent);
    }
}
