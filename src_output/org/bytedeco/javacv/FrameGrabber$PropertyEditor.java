/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import dev.recollect.hana.api.managers.FPSManager;
import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import java.beans.PropertyEditorSupport;
import java.util.List;
import org.bytedeco.javacv.FrameGrabber;

public static class FrameGrabber.PropertyEditor
extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        Class a;
        FrameGrabber.PropertyEditor propertyEditor = a;
        a = (Class)propertyEditor.getValue();
        if (a == null) {
            return BOEntityUtils.ALLATORIxDEMO("rEmA");
        }
        return a.getSimpleName().split(FPSManager.ALLATORIxDEMO("~,k\u0001H\fn\u001bc\u0005h\u0019"))[0];
    }

    @Override
    public String[] getTags() {
        return list.toArray(new String[list.size()]);
    }

    public FrameGrabber.PropertyEditor() {
        FrameGrabber.PropertyEditor a;
    }

    @Override
    public void setAsText(String string) {
        String a22 = string;
        FrameGrabber.PropertyEditor a = this;
        if (a22 == null) {
            a.setValue(null);
        }
        try {
            a.setValue(FrameGrabber.get(a22));
            return;
        }
        catch (FrameGrabber.Exception a22) {
            throw new IllegalArgumentException(a22);
        }
    }
}
