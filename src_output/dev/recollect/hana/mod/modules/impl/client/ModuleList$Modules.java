/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client;

import dev.recollect.hana.api.utils.dev.BetterDynamicAnimation;
import dev.recollect.hana.api.utils.render.ColorUtil;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.ModuleList;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;

public class ModuleList.Modules {
    final /* synthetic */ ModuleList this$0;
    public boolean isEnabled;
    public double fade;
    public final Module module;
    public String lastName;
    public String name;
    public boolean nameUpdated;
    public double x;
    public boolean hide;
    public double fold;
    public double y;

    /*
     * WARNING - void declaration
     */
    public ModuleList.Modules(ModuleList moduleList, Module module) {
        ModuleList.Modules a;
        void a2;
        Module a3 = module;
        ModuleList.Modules modules = a = this;
        ModuleList.Modules modules2 = a;
        ModuleList.Modules modules3 = a;
        ModuleList.Modules modules4 = a;
        ModuleList.Modules modules5 = a;
        a.this$0 = a2;
        modules5.isEnabled = false;
        modules5.x = 0.0;
        modules4.y = 0.0;
        modules4.fade = 0.0;
        modules3.hide = true;
        modules3.fold = 0.0;
        modules2.lastName = "";
        modules2.name = "";
        modules.nameUpdated = false;
        modules.module = a3;
    }

    public void update() {
        Object a;
        ModuleList.Modules modules;
        ModuleList.Modules modules2 = modules = a;
        a = modules2.module.getArrayName();
        if (!modules2.lastName.equals(a)) {
            modules.lastName = a;
            if (modules.this$0.space.getValue()) {
                a = modules.module.getDisplayName().replaceAll(ColorUtil.ALLATORIxDEMO("oZ *>_y>\u000eRm\\\f>"), BetterDynamicAnimation.ALLATORIxDEMO(";\u00136\u00102"));
                if (((String)a).startsWith(ColorUtil.ALLATORIxDEMO("7"))) {
                    a = ((String)a).replaceFirst(BetterDynamicAnimation.ALLATORIxDEMO(" "), "");
                }
                a = (String)a + modules.module.getArrayInfo();
            }
            ModuleList.Modules modules3 = modules;
            modules3.name = a;
            modules3.this$0.update = true;
            modules.nameUpdated = true;
        }
    }

    public void disable() {
        ModuleList.Modules a;
        if (!a.isEnabled) {
            return;
        }
        a.isEnabled = false;
    }

    public void enable() {
        ModuleList.Modules a;
        if (a.isEnabled) {
            return;
        }
        a.isEnabled = true;
    }

    public void updateName() {
        Object a;
        ModuleList.Modules modules;
        ModuleList.Modules modules2 = modules = a;
        a = modules2.module.getArrayName();
        modules2.lastName = a;
        if (modules2.this$0.space.getValue()) {
            a = modules.module.getDisplayName().replaceAll(ColorUtil.ALLATORIxDEMO("}H!++JS\u0014\u000eRtE\f>"), BetterDynamicAnimation.ALLATORIxDEMO(";\u00136\u00102"));
            if (((String)a).startsWith(ColorUtil.ALLATORIxDEMO("7"))) {
                a = ((String)a).replaceFirst(BetterDynamicAnimation.ALLATORIxDEMO(" "), "");
            }
            a = (String)a + modules.module.getArrayInfo();
        }
        ModuleList.Modules modules3 = modules;
        modules3.name = a;
        modules3.this$0.update = true;
    }
}
