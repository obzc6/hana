/*
 * Decompiled with CFR 0.145.
 */
package dev.recollect.hana.api.events;

public class Event {
    private final Stage stage;
    private boolean cancel = false;

    public Event(Stage stage) {
        this.stage = stage;
    }

    public void cancel() {
        this.setCancelled(true);
    }

    public boolean isCancel() {
        return this.cancel;
    }

    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }

    public boolean isCancelled() {
        return this.cancel;
    }

    public Stage getStage() {
        return this.stage;
    }

    public boolean isPost() {
        return this.stage == Stage.Post;
    }

    public boolean isPre() {
        return this.stage == Stage.Pre;
    }

    public static final class Stage
    extends Enum<Stage> {
        public static final /* enum */ Stage Pre = new Stage();
        public static final /* enum */ Stage Post = new Stage();
        private static final /* synthetic */ Stage[] $VALUES;

        public static Stage[] values() {
            return (Stage[])$VALUES.clone();
        }

        public static Stage valueOf(String name) {
            return Enum.valueOf(Stage.class, name);
        }

        private static /* synthetic */ Stage[] $values() {
            return new Stage[]{Pre, Post};
        }

        static {
            $VALUES = Stage.$values();
        }
    }

}
