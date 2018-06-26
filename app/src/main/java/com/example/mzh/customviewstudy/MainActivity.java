package com.example.mzh.customviewstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mzh.customviewstudy.bean.PieBean;
import com.example.mzh.customviewstudy.view.CheckView;
import com.example.mzh.customviewstudy.view.PieView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PieView pieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieView = findViewById(R.id.pieView);
        List<PieBean> pieBeanList = new ArrayList<>();
        for (int i = 0; i <= 4; i++) {
            PieBean pieBean = new PieBean();
            pieBean.setValue(i * 30 + 50);
            pieBeanList.add(pieBean);
        }
        pieView.setStartAngel(-90);
        pieView.setPieBeanList(pieBeanList);

//        final CheckView checkView = findViewById(R.id.checkView);
//        checkView.check();
//        checkView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (checkView.isCheck()) {
//                    checkView.unCheck();
//                }else{
//                    checkView.check();
//                }
//            }
//        });

    }
}
