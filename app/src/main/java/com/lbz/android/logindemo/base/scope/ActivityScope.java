package com.lbz.android.logindemo.base.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by laibinzhi on 2017/2/21.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {
}
