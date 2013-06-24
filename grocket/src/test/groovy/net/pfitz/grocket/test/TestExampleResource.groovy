package net.pfitz.grocket.test

import groovy.transform.CompileStatic
import net.pfitz.grocket.core.UserError
import org.junit.Before
import org.junit.Test
import org.junit.Assert

/**
 * Created with IntelliJ IDEA.
 * User: patrick
 * Date: 6/23/13
 * Time: 4:26 PM
 * To change this template use File | Settings | File Templates.
 */
@CompileStatic
class TestExampleResource {
    ExamplePersonResource<ExamplePersonObject> personApi;
    @Before
    void setup() {
        personApi = new ExamplePersonResource<ExamplePersonObject>()
    }

    @Test
    void testCrudActions() {

        def person = new ExamplePersonObject(name: "john", age: 17, city: "Cambridge");
        person.accountId = 123L;
        println("Person accountid: ${person.accountId}")
        personApi.create(person)
        Assert.assertTrue("checking updatedAt greater than zero", person.updatedAt > 0)
        Assert.assertTrue("checking createdAt > 0", person.createdAt > 0)

        ExamplePersonObject person2 = new ExamplePersonObject()
        person2.id = person.id
        person2.age = person.age
        person2.name = "john jr."
        person2.accountId = person.accountId
        personApi.update(person2)
        ExamplePersonObject person3 = (ExamplePersonObject)personApi.get(person2.id)
        Assert.assertEquals(person.age, person3.age)
    }

    @Test(expected=UserError)
    void testValidation() {
        def person2 = new ExamplePersonObject(name: "Sam")
        personApi.create(person2)
    }
}
