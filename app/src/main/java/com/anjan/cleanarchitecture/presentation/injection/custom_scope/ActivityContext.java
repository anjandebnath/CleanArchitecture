package com.anjan.cleanarchitecture.presentation.injection.custom_scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Anjan Debnath on 8/10/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */

/**
 * If different objects of the same type are necessary
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContext {
}
