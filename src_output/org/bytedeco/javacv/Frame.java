/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.BytePointer
 *  org.bytedeco.javacpp.DoublePointer
 *  org.bytedeco.javacpp.FloatPointer
 *  org.bytedeco.javacpp.IntPointer
 *  org.bytedeco.javacpp.LongPointer
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.ShortPointer
 *  org.bytedeco.javacpp.indexer.Indexable
 *  org.bytedeco.javacpp.indexer.Indexer
 */
package org.bytedeco.javacv;

import dev.recollect.hana.socket.network.info.ClientInfo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.EnumSet;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.FloatPointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacpp.LongPointer;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.ShortPointer;
import org.bytedeco.javacpp.indexer.Indexable;
import org.bytedeco.javacpp.indexer.Indexer;
import org.bytedeco.javacv.FrameConverter;

public class Frame
implements AutoCloseable,
Indexable {
    public ByteBuffer data;
    public static final int DEPTH_USHORT = 16;
    public int imageStride;
    public Buffer[] image;
    public static final int DEPTH_UBYTE = 8;
    public Type type;
    public int imageHeight;
    public Object opaque;
    public Buffer[] samples;
    public char pictType;
    public int audioChannels;
    public int sampleRate;
    public long timestamp;
    public int streamIndex;
    public static final int DEPTH_INT = -32;
    public static final int DEPTH_FLOAT = 32;
    public int imageChannels;
    public static final int DEPTH_SHORT = -16;
    public int imageDepth;
    public static final int DEPTH_DOUBLE = 64;
    public static final int DEPTH_BYTE = -8;
    public int imageWidth;
    public static final int DEPTH_LONG = -64;
    public boolean keyFrame;

    @Override
    public void close() {
        Frame a;
        Frame frame = a;
        if (frame.opaque instanceof Pointer[]) {
            Pointer[] arrpointer = (Pointer[])frame.opaque;
            int n = arrpointer.length;
            int n2 = a = 0;
            while (n2 < n) {
                Pointer pointer = arrpointer[a];
                if (pointer != null) {
                    pointer.releaseReference();
                    pointer = null;
                }
                n2 = ++a;
            }
            frame.opaque = null;
        }
    }

    public <I extends Indexer> I createIndexer(boolean bl) {
        boolean a = bl;
        Frame a2 = this;
        return a2.createIndexer(a, 0);
    }

    public static int pixelSize(int a) {
        return Math.abs(a) / 8;
    }

    public EnumSet<Type> getTypes() {
        EnumSet<Type> a;
        Frame frame = a;
        a = EnumSet.noneOf(Type.class);
        if (frame.image != null) {
            a.add(Type.VIDEO);
        }
        if (frame.samples != null) {
            a.add(Type.AUDIO);
        }
        if (frame.data != null) {
            a.add(Type.DATA);
        }
        return a;
    }

    /*
     * WARNING - void declaration
     */
    public Frame(int n, int n2, int n3, int n4) {
        void a;
        void a2;
        void a3;
        void a4;
        int n5 = n4;
        Frame a5 = this;
        void v0 = a4;
        void v1 = a;
        a5((int)v0, (int)a3, (int)v1, (int)a2, (v0 * a2 * Frame.pixelSize((int)v1) + 7 & -8) / Frame.pixelSize((int)a));
    }

    public Frame clone() {
        Frame a;
        Frame frame = a;
        Frame frame2 = a = new Frame();
        Frame frame3 = frame;
        Frame frame4 = a;
        Frame frame5 = frame;
        Frame frame6 = a;
        Frame frame7 = frame;
        a.imageWidth = frame.imageWidth;
        a.imageHeight = frame7.imageHeight;
        frame6.imageDepth = frame7.imageDepth;
        frame6.imageChannels = frame.imageChannels;
        a.imageStride = frame5.imageStride;
        frame4.keyFrame = frame5.keyFrame;
        frame4.pictType = frame.pictType;
        a.streamIndex = frame3.streamIndex;
        frame2.type = frame3.type;
        frame2.opaque = new Pointer[3];
        if (frame.image != null) {
            a.image = new Buffer[frame.image.length];
            ((Pointer[])a.opaque)[0] = Frame.cloneBufferArray(frame.image, a.image);
        }
        Frame frame8 = a;
        Frame frame9 = frame;
        frame8.audioChannels = frame9.audioChannels;
        frame8.sampleRate = frame9.sampleRate;
        if (frame.samples != null) {
            a.samples = new Buffer[frame.samples.length];
            ((Pointer[])a.opaque)[1] = Frame.cloneBufferArray(frame.samples, a.samples);
        }
        if (frame.data != null) {
            Buffer[] arrbuffer = new ByteBuffer[1];
            Buffer[] arrbuffer2 = new ByteBuffer[1];
            arrbuffer2[0] = frame.data;
            ((Pointer[])a.opaque)[2] = Frame.cloneBufferArray(arrbuffer2, arrbuffer);
            a.data = arrbuffer[0];
        }
        a.timestamp = frame.timestamp;
        return a;
    }

    private static /* synthetic */ Pointer cloneBufferArray(Buffer[] a32, Buffer[] a2) {
        Buffer[] arrbuffer = a32;
        BytePointer bytePointer = null;
        if (arrbuffer != null && arrbuffer.length > 0) {
            int a32;
            int n;
            int n2 = 0;
            int n3 = a32 = 0;
            while (n3 < arrbuffer.length) {
                arrbuffer[a32].rewind();
                Buffer buffer = arrbuffer[a32];
                n2 += buffer.capacity();
                n3 = ++a32;
            }
            if (arrbuffer[0] instanceof ByteBuffer) {
                BytePointer a32 = new BytePointer((long)n2);
                int n4 = n = 0;
                while (n4 < arrbuffer.length) {
                    BytePointer bytePointer2 = a32;
                    int n5 = n;
                    a2[n5] = bytePointer2.limit(bytePointer2.position() + (long)arrbuffer[n].limit()).asBuffer().put((ByteBuffer)arrbuffer[n5]);
                    BytePointer bytePointer3 = a32;
                    bytePointer3.position(bytePointer3.limit());
                    n4 = ++n;
                }
                bytePointer = a32;
            } else if (arrbuffer[0] instanceof ShortBuffer) {
                ShortPointer a32 = new ShortPointer((long)n2);
                int n6 = n = 0;
                while (n6 < arrbuffer.length) {
                    ShortPointer shortPointer = a32;
                    int n7 = n;
                    a2[n7] = shortPointer.limit(shortPointer.position() + (long)arrbuffer[n].limit()).asBuffer().put((ShortBuffer)arrbuffer[n7]);
                    ShortPointer shortPointer2 = a32;
                    shortPointer2.position(shortPointer2.limit());
                    n6 = ++n;
                }
                bytePointer = a32;
            } else if (arrbuffer[0] instanceof IntBuffer) {
                IntPointer a32 = new IntPointer((long)n2);
                int n8 = n = 0;
                while (n8 < arrbuffer.length) {
                    IntPointer intPointer = a32;
                    int n9 = n;
                    a2[n9] = intPointer.limit(intPointer.position() + (long)arrbuffer[n].limit()).asBuffer().put((IntBuffer)arrbuffer[n9]);
                    IntPointer intPointer2 = a32;
                    intPointer2.position(intPointer2.limit());
                    n8 = ++n;
                }
                bytePointer = a32;
            } else if (arrbuffer[0] instanceof LongBuffer) {
                LongPointer a32 = new LongPointer((long)n2);
                int n10 = n = 0;
                while (n10 < arrbuffer.length) {
                    LongPointer longPointer = a32;
                    int n11 = n;
                    a2[n11] = longPointer.limit(longPointer.position() + (long)arrbuffer[n].limit()).asBuffer().put((LongBuffer)arrbuffer[n11]);
                    LongPointer longPointer2 = a32;
                    longPointer2.position(longPointer2.limit());
                    n10 = ++n;
                }
                bytePointer = a32;
            } else if (arrbuffer[0] instanceof FloatBuffer) {
                FloatPointer a32 = new FloatPointer((long)n2);
                int n12 = n = 0;
                while (n12 < arrbuffer.length) {
                    FloatPointer floatPointer = a32;
                    int n13 = n;
                    a2[n13] = floatPointer.limit(floatPointer.position() + (long)arrbuffer[n].limit()).asBuffer().put((FloatBuffer)arrbuffer[n13]);
                    FloatPointer floatPointer2 = a32;
                    floatPointer2.position(floatPointer2.limit());
                    n12 = ++n;
                }
                bytePointer = a32;
            } else if (arrbuffer[0] instanceof DoubleBuffer) {
                DoublePointer a32 = new DoublePointer((long)n2);
                int n14 = n = 0;
                while (n14 < arrbuffer.length) {
                    DoublePointer doublePointer = a32;
                    int n15 = n;
                    a2[n15] = doublePointer.limit(doublePointer.position() + (long)arrbuffer[n].limit()).asBuffer().put((DoubleBuffer)arrbuffer[n15]);
                    DoublePointer doublePointer2 = a32;
                    doublePointer2.position(doublePointer2.limit());
                    n14 = ++n;
                }
                bytePointer = a32;
            }
            int n16 = a32 = 0;
            while (n16 < arrbuffer.length) {
                arrbuffer[a32].rewind();
                a2[a32++].rewind();
                n16 = a32;
            }
        }
        if (bytePointer != null) {
            bytePointer.retainReference();
        }
        return bytePointer;
    }

    /*
     * WARNING - void declaration
     */
    public Frame(int n, int n2, int n3, int n4, int n5) {
        void a22;
        void a;
        void a3;
        Frame a4;
        void a5;
        int a322 = n2;
        Frame frame = a4 = this;
        Frame frame2 = a4;
        Frame frame3 = a4;
        a4.imageWidth = a22;
        frame3.imageHeight = a322;
        frame3.imageDepth = a5;
        frame2.imageChannels = a3;
        frame2.imageStride = a;
        frame.pictType = '\u0000';
        frame.image = new Buffer[1];
        a4.data = null;
        a4.streamIndex = -1;
        a4.type = null;
        BytePointer a22 = new BytePointer((long)(a4.imageHeight * a * Frame.pixelSize((int)a5)));
        ByteBuffer a322 = a22.asByteBuffer();
        switch (a4.imageDepth) {
            case -8: 
            case 8: {
                Frame frame4 = a4;
                Frame frame5 = frame4;
                frame4.image[0] = a322;
                break;
            }
            case -16: 
            case 16: {
                Frame frame6 = a4;
                Frame frame5 = frame6;
                frame6.image[0] = a322.asShortBuffer();
                break;
            }
            case -32: {
                Frame frame7 = a4;
                Frame frame5 = frame7;
                frame7.image[0] = a322.asIntBuffer();
                break;
            }
            case -64: {
                Frame frame8 = a4;
                while (false) {
                }
                Frame frame5 = frame8;
                frame8.image[0] = a322.asLongBuffer();
                break;
            }
            case 32: {
                Frame frame9 = a4;
                Frame frame5 = frame9;
                frame9.image[0] = a322.asFloatBuffer();
                break;
            }
            case 64: {
                Frame frame10 = a4;
                Frame frame5 = frame10;
                frame10.image[0] = a322.asDoubleBuffer();
                break;
            }
            default: {
                throw new UnsupportedOperationException("Unsupported depth value: " + a4.imageDepth);
            }
        }
        Pointer[] arrpointer = new Pointer[1];
        arrpointer[0] = a22.retainReference();
        frame5.opaque = arrpointer;
    }

    /*
     * Exception decompiling
     */
    public <I extends Indexer> I createIndexer(boolean var1_1, int var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [10[DOLOOP]], but top level block is 6[CASE]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:427)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:479)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:696)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:906)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
        // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    public Frame() {
        Frame a;
    }

    public <I extends Indexer> I createIndexer() {
        Frame a;
        return a.createIndexer(true, 0);
    }

    public static final class Type
    extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES;
        public static final /* enum */ Type AUDIO;
        public static final /* enum */ Type DATA;
        public static final /* enum */ Type ATTACHMENT;
        public static final /* enum */ Type VIDEO;
        public static final /* enum */ Type SUBTITLE;

        static {
            VIDEO = new Type(FrameConverter.ALLATORIxDEMO("G&H`\t"), 0);
            AUDIO = new Type(ClientInfo.ALLATORIxDEMO("\u000fK\u0017\u001dV"), 1);
            DATA = new Type(FrameConverter.ALLATORIxDEMO("+Mq\u0007"), 2);
            SUBTITLE = new Type(ClientInfo.ALLATORIxDEMO("W\u001cA\u001aW\u0007\u0018\\"), 3);
            ATTACHMENT = new Type(FrameConverter.ALLATORIxDEMO("3E!W1Y\"Ik\u0012"), 4);
            $VALUES = Type.$values();
        }

        private static /* synthetic */ Type[] $values() {
            Type[] arrtype = new Type[5];
            arrtype[0] = VIDEO;
            arrtype[1] = AUDIO;
            arrtype[2] = DATA;
            arrtype[3] = SUBTITLE;
            arrtype[4] = ATTACHMENT;
            return arrtype;
        }

        public static Type valueOf(String a) {
            return Enum.valueOf(Type.class, a);
        }

        /*
         * Exception decompiling
         */
        private /* synthetic */ Type() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.IllegalStateException
            // org.benf.cfr.reader.bytecode.analysis.variables.VariableFactory.localVariable(VariableFactory.java:53)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.mkRetrieve(Op02WithProcessedDataAndRefs.java:931)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.createStatement(Op02WithProcessedDataAndRefs.java:979)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.access$100(Op02WithProcessedDataAndRefs.java:56)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2060)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs$11.call(Op02WithProcessedDataAndRefs.java:2057)
            // org.benf.cfr.reader.util.graph.AbstractGraphVisitorFI.process(AbstractGraphVisitorFI.java:60)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.convertToOp03List(Op02WithProcessedDataAndRefs.java:2069)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:342)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:184)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:129)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:397)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:901)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:778)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:886)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:797)
            // org.benf.cfr.reader.Driver.doClass(Driver.java:58)
            // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:67)
            // org.benf.cfr.reader.Main.main(Main.java:48)
            throw new IllegalStateException("Decompilation failed");
        }

        public static Type[] values() {
            return (Type[])$VALUES.clone();
        }
    }

}
