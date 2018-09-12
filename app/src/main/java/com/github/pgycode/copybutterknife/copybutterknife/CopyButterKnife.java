package com.github.pgycode.copybutterknife.copybutterknife;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

public class CopyButterKnife {

    public static void bind(Object host, View view) {
        Field[] fields = host.getClass().getFields();
        for (Field field : fields) {
            BindView bindView = field.getAnnotation(BindView.class);
            if (bindView != null) {
                try {
                    field.set(host, view.findViewById(bindView.id()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        BindClick bindClick = host.getClass().getAnnotation(BindClick.class);
        if (bindClick != null) {
            int[] ids = bindClick.ids();
            for (int id : ids) {
                view.findViewById(id).setOnClickListener((View.OnClickListener) host);
            }
        }
    }
}
