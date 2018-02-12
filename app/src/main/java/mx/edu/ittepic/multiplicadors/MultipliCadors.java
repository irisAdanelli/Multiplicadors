package mx.edu.ittepic.multiplicadors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MultipliCadors extends AppCompatActivity {
    TextView resultado;
    SeekBar num;
    Button calcular;
    int M;
    TextView mostrarM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipli_cadors);
        resultado = findViewById(R.id.textView4);
        num = findViewById(R.id.seekBar);
        calcular = findViewById(R.id.button);
        mostrarM = findViewById(R.id.textView2);

        num.setProgress(1);
        num.setMax(20);


        num.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //hace un llamado a la perilla cuando se arrastra
                    @Override
                    public void onProgressChanged(SeekBar seekBar1,
                                                  int progress, boolean fromUser) {
                        mostrarM.setText(String.valueOf(progress));
                    }

                    //hace un llamado  cuando se toca la perilla
                    public void onStartTrackingTouch(SeekBar seekBar1) {
                    }

                    //hace un llamado  cuando se detiene la perilla
                    public void onStopTrackingTouch(SeekBar seekBar1) {
                    }
                }
        );

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularDatos();
            }
        });
    }

    public void calcularDatos(){
        int H;
        String tabla1="",salto="\n";
        M=num.getProgress();
        //int N=Integer.parseInt(n.getText().toString());
        try
        {
            for(int i=1;i<=20;i++){

                //N=Integer.parseInt(n.getText().toString());
                H=M*i;
                tabla1+=(M+" X "+i+" = "+H+salto);
            }
            resultado.setText(tabla1);

        }catch (Exception e){
            Toast.makeText(MultipliCadors.this,"Error",Toast.LENGTH_LONG).show();
        }
    }
}
