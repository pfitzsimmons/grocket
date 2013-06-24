package net.pfitz.grocket.core

import groovy.transform.CompileStatic

/**
 * Created with IntelliJ IDEA.
 * User: patrick
 * Date: 6/23/13
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */
@CompileStatic
class BaseEvents {
    static String AUTHENTICATE = "authenticate"
    static String AUTHORIZE = "authorize"
    static String PRE_DISPATCH = "pre_dispatch"
    static String PROCESS_RESPONSE = "process_response"
}
