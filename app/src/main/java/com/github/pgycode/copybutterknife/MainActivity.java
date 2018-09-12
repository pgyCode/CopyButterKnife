package com.github.pgycode.copybutterknife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.pgycode.copybutterknife.copybutterknife.BindClick;
import com.github.pgycode.copybutterknife.copybutterknife.BindView;
import com.github.pgycode.copybutterknife.copybutterknife.CopyButterKnife;


@BindClick(ids =  {
        R.id.btnOne,
        R.id.btnTwo,
        R.id.btnThree
})
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(id = R.id.txt)
    public TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CopyButterKnife.bind(this, getWindow().getDecorView());

        init();
    }


    private void init() {
        txt.setText("hello copybutterknife");
        getSupportFragmentManager().beginTransaction().add(R.id.container, new MainFragment()).commit();
    }

    public void onClick(View view){
        int id = view.getId();
        if (id == R.id.btnOne){
            txt.setText("activity buttonOne Click");
        } if (id == R.id.btnTwo){
            txt.setText("activity buttonTwo Click");
        } if (id == R.id.btnThree){
            txt.setText("hello copybutterknife");
        }
    }
}
