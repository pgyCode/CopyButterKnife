package com.github.pgycode.copybutterknife.copybutterknife;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface BindView {
    int id();
}
