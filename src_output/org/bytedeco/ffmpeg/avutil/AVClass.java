/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.FunctionPointer
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.PointerPointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.Const
 *  org.bytedeco.javacpp.annotation.Properties
 */
package org.bytedeco.ffmpeg.avutil;

import org.bytedeco.ffmpeg.avutil.AVOption;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.FunctionPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.PointerPointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Const;
import org.bytedeco.javacpp.annotation.Properties;

@Properties(inherit={avutil.class})
public class AVClass
extends Pointer {
    private native /* synthetic */ void allocate();

    @Cast(value={"AVClassCategory"})
    public native int category();

    public AVClass() {
        super((Pointer)null);
        AVClass a;
        a.allocate();
    }

    public native AVClass query_ranges(Query_ranges_PointerPointer_Pointer_BytePointer_int var1);

    @Cast(value={"const char*"})
    public native BytePointer class_name();

    public AVClass position(long a) {
        AVClass a2;
        return (AVClass)super.position(a);
    }

    private native /* synthetic */ void allocateArray(long var1);

    public native int log_level_offset_offset();

    public native AVClass item_name(Item_name_Pointer var1);

    public native Child_class_iterate_PointerPointer child_class_iterate();

    public native AVClass get_category(Get_category_Pointer var1);

    public native AVClass child_class_iterate(Child_class_iterate_PointerPointer var1);

    public AVClass getPointer(long a) {
        AVClass a2;
        return (AVClass)new AVClass(a2).offsetAddress(a);
    }

    public native int version();

    public native Get_category_Pointer get_category();

    public native AVClass category(int var1);

    public native Query_ranges_PointerPointer_Pointer_BytePointer_int query_ranges();

    public native int parent_log_context_offset();

    public native AVClass parent_log_context_offset(int var1);

    public native AVClass version(int var1);

    public native AVClass option(AVOption var1);

    @Const
    public native AVOption option();

    static {
        Loader.load();
    }

    public native Child_next_Pointer_Pointer child_next();

    public AVClass(Pointer pointer) {
        AVClass a = pointer;
        AVClass a2 = this;
        super((Pointer)a);
    }

    public native AVClass child_next(Child_next_Pointer_Pointer var1);

    public native AVClass class_name(BytePointer var1);

    public native AVClass log_level_offset_offset(int var1);

    public native Item_name_Pointer item_name();

    public AVClass(long a) {
        super((Pointer)null);
        AVClass a2;
        a2.allocateArray(a);
    }

    public static class Child_class_iterate_PointerPointer
    extends FunctionPointer {
        static {
            Loader.load();
        }

        protected Child_class_iterate_PointerPointer() {
            Child_class_iterate_PointerPointer a;
            Child_class_iterate_PointerPointer child_class_iterate_PointerPointer = a;
            child_class_iterate_PointerPointer.allocate();
        }

        @Const
        public native AVClass call(@Cast(value={"void**"}) PointerPointer var1);

        private native /* synthetic */ void allocate();

        public Child_class_iterate_PointerPointer(Pointer pointer) {
            Child_class_iterate_PointerPointer a = pointer;
            Child_class_iterate_PointerPointer a2 = this;
            super((Pointer)a);
        }
    }

    public static class Child_next_Pointer_Pointer
    extends FunctionPointer {
        private native /* synthetic */ void allocate();

        public Child_next_Pointer_Pointer(Pointer pointer) {
            Child_next_Pointer_Pointer a = pointer;
            Child_next_Pointer_Pointer a2 = this;
            super((Pointer)a);
        }

        public native Pointer call(Pointer var1, Pointer var2);

        protected Child_next_Pointer_Pointer() {
            Child_next_Pointer_Pointer a;
            Child_next_Pointer_Pointer child_next_Pointer_Pointer = a;
            child_next_Pointer_Pointer.allocate();
        }

        static {
            Loader.load();
        }
    }

    public static class Query_ranges_PointerPointer_Pointer_BytePointer_int
    extends FunctionPointer {
        static {
            Loader.load();
        }

        private native /* synthetic */ void allocate();

        protected Query_ranges_PointerPointer_Pointer_BytePointer_int() {
            Query_ranges_PointerPointer_Pointer_BytePointer_int a;
            Query_ranges_PointerPointer_Pointer_BytePointer_int query_ranges_PointerPointer_Pointer_BytePointer_int = a;
            query_ranges_PointerPointer_Pointer_BytePointer_int.allocate();
        }

        public Query_ranges_PointerPointer_Pointer_BytePointer_int(Pointer pointer) {
            Query_ranges_PointerPointer_Pointer_BytePointer_int a = pointer;
            Query_ranges_PointerPointer_Pointer_BytePointer_int a2 = this;
            super((Pointer)a);
        }

        public native int call(@Cast(value={"AVOptionRanges**"}) PointerPointer var1, Pointer var2, @Cast(value={"const char*"}) BytePointer var3, int var4);
    }

    public static class Get_category_Pointer
    extends FunctionPointer {
        public Get_category_Pointer(Pointer pointer) {
            Get_category_Pointer a = pointer;
            Get_category_Pointer a2 = this;
            super((Pointer)a);
        }

        @Cast(value={"AVClassCategory"})
        public native int call(Pointer var1);

        protected Get_category_Pointer() {
            Get_category_Pointer a;
            Get_category_Pointer get_category_Pointer = a;
            get_category_Pointer.allocate();
        }

        private native /* synthetic */ void allocate();

        static {
            Loader.load();
        }
    }

    public static class Item_name_Pointer
    extends FunctionPointer {
        @Cast(value={"const char*"})
        public native BytePointer call(Pointer var1);

        public Item_name_Pointer(Pointer pointer) {
            Item_name_Pointer a = pointer;
            Item_name_Pointer a2 = this;
            super((Pointer)a);
        }

        protected Item_name_Pointer() {
            Item_name_Pointer a;
            Item_name_Pointer item_name_Pointer = a;
            item_name_Pointer.allocate();
        }

        static {
            Loader.load();
        }

        private native /* synthetic */ void allocate();
    }

}
