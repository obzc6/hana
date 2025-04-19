/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.mod.commands;

import dev.recollect.hana.api.managers.CommandManager;
import dev.recollect.hana.api.utils.Wrapper;
import java.util.List;
import java.util.Objects;

public abstract class Command
implements Wrapper {
    protected final String description;
    protected final String name;
    protected final String syntax;

    public abstract String[] getAutocorrect(int var1, List<String> var2);

    public void sendUsage() {
        Command a;
        CommandManager.sendChatMessage("\u00a7b[!] \u00a7fUsage: \u00a7e" + a.getName() + " " + a.getSyntax());
    }

    /*
     * WARNING - void declaration
     */
    public Command(String string, String string2, String string3) {
        void a;
        void a2;
        String a3 = string3;
        Command a4 = this;
        a4.name = (String)Objects.requireNonNull(a2);
        a4.description = (String)Objects.requireNonNull(a);
        a4.syntax = (String)Objects.requireNonNull(a3);
    }

    public String getDescription() {
        Command a;
        return a.description;
    }

    public String getName() {
        Command a;
        return a.name;
    }

    public abstract void runCommand(String[] var1);

    public String getSyntax() {
        Command a;
        return a.syntax;
    }
}
