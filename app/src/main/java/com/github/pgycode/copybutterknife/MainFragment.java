package com.github.pgycode.copybutterknife;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.pgycode.copybutterknife.copybutterknife.BindClick;
import com.github.pgycode.copybutterknife.copybutterknife.BindView;
import com.github.pgycode.copybutterknife.copybutterknife.CopyButterKnife;

@BindClick(ids = {
        R.id.btnOne,
        R.id.btnTwo,
        R.id.btnThree
})
public class MainFragment extends Fragment implements View.OnClickListener {

    private View root;

    @BindView(id = R.id.txt)
    public TextView txt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_main, null);
        CopyButterKnife.bind(this, root);

        init();
        return root;
    }

    private void init(){
        txt.setText("hello world");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnOne){
            txt.setText("fragment one click");
        } else if (id == R.id.btnTwo){
            txt.setText("fragment two click");
        } else if (id == R.id.btnThree){
            txt.setText("hello world");
        }
    }
}
