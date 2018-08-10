package com.anjan.cleanarchitecture.presentation.injection.custom_scope;

/**
 * Created by Anjan Debnath on 8/9/2018.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * A scoping annotation to permit objects whose lifetime should
 * conform to the life of the activity to be memorized in the
 * correct component.
 */


/**
 * Enables to create global and local singletons
 */
@Scope
/**
 * @Retention: annotation indicates how the custom annotation is stored.
 * There are 3 types of retention.
 * SOURCE — analyses by compiler and never stored
 * CLASS — stored into class file and not retained in runtime
 * RUNTIME — store into class file and usable in runtime(by reflection)
 */
@Retention(RUNTIME)

//This @interface annotation tells to compiler this is the custom annotation
public @interface PerActivity {
}
