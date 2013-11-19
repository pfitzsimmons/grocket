package net.pfitz.grocket.test

import groovy.transform.CompileStatic

/**
 * Created with IntelliJ IDEA.
 * User: patrick
 * Date: 6/23/13
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
@CompileStatic
class ExamplePersonResource<ExamplePersonObject> extends ExampleBaseResource {
    ExampleMixin exampleMixin;

    public ExamplePersonResource() {
        storage = new HashMap();
        exampleMixin = new ExampleMixin(this);
        init()
    }




}
