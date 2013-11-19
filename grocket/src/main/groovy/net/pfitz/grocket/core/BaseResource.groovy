package net.pfitz.grocket.core

import java.lang.annotation.Annotation
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method



/**
 * Created with IntelliJ IDEA.
 * User: patrick
 * Date: 6/23/13
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */

class BaseResource<T> {
    Class model;
    HashMap<String, List<RegisteredEventHandler>> eventHandlers;

    public void init() {
        eventHandlers = new HashMap<String, List<RegisteredEventHandler>>();
        // Find and attach all mixins
        println("Finding meta property values -------------------")
        for(pv in this.metaPropertyValues) {
            println("PV: ${pv}")
        }
        println("Finding properites -------------------")
        for(Map.Entry item in this.properties) {
            if (item.value in BaseMixin) {
                println("We found a mixin!!!")
                attachMixinEvents(item.value)
            }
            println("Key: ${item.key} Val: ${item.value}")
        }
        //Class cls = ReflectionUtils.callingClass;
        //println("The calling class is: ${cls}")
        //cls.fields.each { it ->
        //    println("FieldsIter: ${it}");
        //}
        //cls.properties.each { prop, val ->
         //   println("Prop: ${prop}")
        //    println("Val: ${val}")
        //}

    }

    private void attachMixinEvents(BaseMixin mixin) {
        for(Method method in mixin.class.declaredMethods) {
            println("method: ${method}")
            for(Annotation annotation in method.declaredAnnotations) {
                println("annotation: ${annotation}")
                println("Annotation type ${annotation.annotationType()}");

                if (annotation in GrocketEventHandler) {
                    println("Found annotation with event name ${annotation.eventName()}")
                    if (!eventHandlers.containsKey(annotation.eventName())) {
                        eventHandlers.put(annotation.eventName(), new ArrayList<RegisteredEventHandler>());
                    }
                    def handler = new RegisteredEventHandler(method: method, mixinObject: mixin);
                    eventHandlers[annotation.eventName()].add(handler)
                }
            }
        }
    }

    void trigger(String eventName, Object[] args) {
        println("Triggering event ${eventName}")
        if (!eventHandlers.containsKey(eventName)) {
            return;
        }
        println("Iterating over handlers")
        for(RegisteredEventHandler handler in eventHandlers.get(eventName)) {
            println("Calling method ${handler.method}")
            try {
                handler.method.invoke(handler.mixinObject, args);
            } catch (InvocationTargetException e) {
                throw e.targetException;
            }
        }
    }
    void chain(String eventName) {

    }

    String toJson(T obj) {

    }

    T fromJson(String json) {

    }

}
