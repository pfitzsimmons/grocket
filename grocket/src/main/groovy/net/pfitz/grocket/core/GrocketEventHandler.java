package net.pfitz.grocket.core;

import groovy.transform.CompileStatic;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: patrick
 * Date: 6/23/13
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
@CompileStatic
@Retention(RetentionPolicy.RUNTIME)
public @interface GrocketEventHandler {
    String eventName();
}
