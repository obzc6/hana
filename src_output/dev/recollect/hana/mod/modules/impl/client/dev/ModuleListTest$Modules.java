/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.impl.client.dev.ModuleListTest;

public class ModuleListTest.Modules {
    public double fold;
    public boolean nameUpdated;
    public boolean isEnabled;
    final /* synthetic */ ModuleListTest this$0;
    public String name;
    public String lastName;
    public double x;
    public double fade;
    public boolean hide;
    public double y;
    public final Module module;

    public void update() {
        String a;
        ModuleListTest.Modules modules;
        ModuleListTest.Modules modules2 = modules = a;
        a = modules2.module.getArrayName();
        if (!modules2.lastName.equals(a)) {
            modules.lastName = a;
            modules.name = (String)a + modules.module.getArrayInfo();
            ModuleListTest.Modules modules3 = modules;
            modules3.this$0.update = true;
            modules3.nameUpdated = true;
        }
    }

    public void enable() {
        ModuleListTest.Modules a;
        if (a.isEnabled) {
            return;
        }
        a.isEnabled = true;
    }

    public void updateName() {
        String a;
        ModuleListTest.Modules modules = a;
        a = modules.module.getArrayName();
        modules.lastName = a;
        modules.name = (String)a + modules.module.getArrayInfo();
        modules.this$0.update = true;
    }

    /*
     * WARNING - void declaration
     */
    public ModuleListTest.Modules(ModuleListTest moduleListTest, Module module) {
        ModuleListTest.Modules a;
        void a2;
        Module a3 = module;
        ModuleListTest.Modules modules = a = this;
        ModuleListTest.Modules modules2 = a;
        ModuleListTest.Modules modules3 = a;
        ModuleListTest.Modules modules4 = a;
        ModuleListTest.Modules modules5 = a;
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

    public void disable() {
        ModuleListTest.Modules a;
        if (!a.isEnabled) {
            return;
        }
        a.isEnabled = false;
    }
}
