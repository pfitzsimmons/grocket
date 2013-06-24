package net.pfitz.grocket.test

import groovy.transform.CompileStatic
import net.pfitz.grocket.core.BaseResource


/**
 * Created with IntelliJ IDEA.
 * User: patrick
 * Date: 6/23/13
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
@CompileStatic
class ExampleBaseResource<T extends ExampleBaseObject> extends BaseResource {
    protected HashMap<Long, T> storage;
    private long counter = 0;

    public T get(Long id) {
        return (T)storage.get(id);
    }
    public T create(T obj) {
        if (!obj.id) {
            counter++;
            obj.id = counter;
        }
        trigger(ExampleEvents.PRE_SAVE_PREPARE, obj)
        trigger(ExampleEvents.PRE_SAVE_VALIDATE, obj)
        storage.put(obj.id, obj)
        return obj;
    }

    public T update(T obj) {
        Map<String, Object> previousData = new HashMap<String, Object>();
        T org = (T)storage.get(obj.id);
        for(Map.Entry<Object, Object> entry in obj.properties.entrySet())
        {

            Object originalValue = org.properties.get(entry.key);//getProperty(entry.key.toString());
            if (originalValue != entry.value) {
                previousData.put(entry.key.toString(), originalValue)
            }
        }
        trigger(ExampleEvents.PRE_SAVE_PREPARE, obj)
        trigger("pre_update_prepare", obj, previousData)
        trigger(ExampleEvents.PRE_SAVE_VALIDATE, obj)
        storage.put(obj.id, obj)
        trigger("pre_update_process", obj, previousData)
    }
}
