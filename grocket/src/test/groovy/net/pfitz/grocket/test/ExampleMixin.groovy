package net.pfitz.grocket.test

import groovy.transform.CompileStatic
import net.pfitz.grocket.core.BaseMixin
import net.pfitz.grocket.core.GrocketEventHandler
import net.pfitz.grocket.core.UserError

/**
 * This mixin handles the following actions:
 * - soft deletes
 * - setting created/updated
 */
@CompileStatic
class ExampleMixin extends BaseMixin {

    @GrocketEventHandler(eventName="pre_save_prepare")
    void onPreSavePrepare(ExampleBaseObject o) {
        o.updatedAt = System.currentTimeMillis()
        o.createdAt = System.currentTimeMillis()
    }


    @GrocketEventHandler(eventName="pre_save_validate")
    void onPreSaveValidate(ExampleBaseObject o) {
        println("o.accountId: ${o.accountId}")
        if (o.accountId != getUserAccountId()) {
            throw new UserError("You cannot update an object that does not belong to your account", 403)
        }
    }
    @GrocketEventHandler(eventName="post_update_process")
    void onPostProcessUpdate(ExampleBaseObject o, HashMap<String, Object> previousData) {

    }

    Long getUserAccountId() {
        return 123L
    }

}
