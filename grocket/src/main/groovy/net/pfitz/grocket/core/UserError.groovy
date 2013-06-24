package net.pfitz.grocket.core

import groovy.transform.CompileStatic

/**
 * Created with IntelliJ IDEA.
 * User: patrick
 * Date: 6/23/13
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
@CompileStatic
class UserError extends GrocketError {
    String message;
    int statusCode;

    public UserError(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
