package net.pfitz.grocket.test

import groovy.transform.CompileStatic
import net.pfitz.grocket.core.BaseEvents

/**
 * Created with IntelliJ IDEA.
 * User: patrick
 * Date: 6/23/13
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
@CompileStatic
class ExampleEvents extends BaseEvents {
    public static String PRE_SAVE_VALIDATE = "pre_save_validate";
    public static String PRE_SAVE_PREPARE = "pre_save_prepare";
    public static String POST_PROCESS_UPDATE = "post_update_process";
}
