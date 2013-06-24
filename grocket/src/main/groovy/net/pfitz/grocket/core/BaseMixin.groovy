package net.pfitz.grocket.core

import groovy.transform.CompileStatic

/**
 * Created with IntelliJ IDEA.
 * User: patrick
 * Date: 6/23/13
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
@CompileStatic
class BaseMixin {
    BaseResource parentResource

    public BaseMixin() {

    }

    public BaseMixin(BaseResource resource) {
        parentResource = resource;
    }
}
