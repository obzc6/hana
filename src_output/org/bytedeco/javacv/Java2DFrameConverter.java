/*
 * Decompiled with CFR 0.145.
 */
package org.bytedeco.javacv;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferDouble;
import java.awt.image.DataBufferFloat;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferShort;
import java.awt.image.DataBufferUShort;
import java.awt.image.ImageObserver;
import java.awt.image.MultiPixelPackedSampleModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;
import java.awt.image.WritableRaster;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Hashtable;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameConverter;

public class Java2DFrameConverter
extends FrameConverter<BufferedImage> {
    public static final byte[] gamma22inv;
    public static final byte[] gamma22;
    protected BufferedImage bufferedImage = null;

    public static BufferedImage cloneBufferedImage(BufferedImage a222) {
        BufferedImage bufferedImage = a222;
        if (bufferedImage == null) {
            return null;
        }
        int a222 = bufferedImage.getType();
        if (a222 == 0) {
            return new BufferedImage(bufferedImage.getColorModel(), bufferedImage.copyData(null), bufferedImage.isAlphaPremultiplied(), null);
        }
        BufferedImage bufferedImage2 = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), a222);
        Graphics a222 = bufferedImage2.getGraphics();
        a222.drawImage(bufferedImage, 0, 0, null);
        a222.dispose();
        return bufferedImage2;
    }

    @Override
    public Frame convert(BufferedImage bufferedImage) {
        BufferedImage a = bufferedImage;
        Java2DFrameConverter a2 = this;
        return a2.getFrame(a);
    }

    public Frame getFrame(BufferedImage bufferedImage) {
        BufferedImage a = bufferedImage;
        Java2DFrameConverter a2 = this;
        return a2.getFrame(a, 1.0);
    }

    /*
     * WARNING - void declaration
     */
    public static void copy(BufferedImage bufferedImage, Frame frame, double d) {
        void a;
        Frame a2 = frame;
        BufferedImage a3 = bufferedImage;
        Java2DFrameConverter.copy(a3, a2, (double)a, false, null);
    }

    /*
     * WARNING - void declaration
     */
    public BufferedImage getBufferedImage(Frame frame, double d, boolean bl, ColorSpace colorSpace) {
        ColorSpace a;
        AutoCloseable a2 = frame;
        Java2DFrameConverter a3 = this;
        if (a2 == null || ((Frame)a2).image == null) {
            return null;
        }
        int n = Java2DFrameConverter.getBufferedImageType((Frame)a2);
        if (a3.bufferedImage == null || a3.bufferedImage.getWidth() != ((Frame)a2).imageWidth || a3.bufferedImage.getHeight() != ((Frame)a2).imageHeight || a3.bufferedImage.getType() != n) {
            BufferedImage bufferedImage;
            if (!n || a != null) {
                bufferedImage = null;
            } else {
                AutoCloseable autoCloseable;
                bufferedImage = new BufferedImage(((Frame)autoCloseable).imageWidth, ((Frame)autoCloseable).imageHeight, n);
                autoCloseable = a2;
            }
            a3.bufferedImage = bufferedImage;
        }
        if (a3.bufferedImage == null) {
            Java2DFrameConverter java2DFrameConverter;
            n = 0;
            int[] arrn = null;
            if (((Frame)a2).imageChannels == 1) {
                n = 0;
                if (a == null) {
                    a = ColorSpace.getInstance(1003);
                }
                int[] arrn2 = new int[1];
                arrn2[0] = 0;
                arrn = arrn2;
            } else if (((Frame)a2).imageChannels == 3) {
                n = 0;
                if (a == null) {
                    a = ColorSpace.getInstance(1004);
                }
                int[] arrn3 = new int[3];
                arrn3[0] = 2;
                arrn3[1] = 1;
                arrn3[2] = 0;
                arrn = arrn3;
            } else if (((Frame)a2).imageChannels == 4) {
                n = 1;
                if (a == null) {
                    a = ColorSpace.getInstance(1004);
                }
                int[] arrn4 = new int[4];
                arrn4[0] = 0;
                arrn4[1] = 1;
                arrn4[2] = 2;
                arrn4[3] = 3;
                arrn = arrn4;
            } else assert (false);
            ComponentColorModel componentColorModel = null;
            WritableRaster writableRaster = null;
            if (((Frame)a2).imageDepth == 8 || ((Frame)a2).imageDepth == -8) {
                componentColorModel = new ComponentColorModel(a, n != 0, 0 != 0, 1, 0);
                AutoCloseable autoCloseable = a2;
                AutoCloseable autoCloseable2 = a2;
                writableRaster = Raster.createWritableRaster(new ComponentSampleModel(0, ((Frame)autoCloseable).imageWidth, ((Frame)autoCloseable).imageHeight, ((Frame)autoCloseable2).imageChannels, ((Frame)autoCloseable2).imageStride, arrn), null);
                java2DFrameConverter = a3;
            } else if (((Frame)a2).imageDepth == 16) {
                componentColorModel = new ComponentColorModel(a, n != 0, false, 1, 1);
                AutoCloseable autoCloseable = a2;
                AutoCloseable autoCloseable3 = a2;
                writableRaster = Raster.createWritableRaster(new ComponentSampleModel(1, ((Frame)autoCloseable).imageWidth, ((Frame)autoCloseable).imageHeight, ((Frame)autoCloseable3).imageChannels, ((Frame)autoCloseable3).imageStride, arrn), null);
                java2DFrameConverter = a3;
            } else if (((Frame)a2).imageDepth == -16) {
                componentColorModel = new ComponentColorModel(a, n != 0, false, 1, 2);
                AutoCloseable autoCloseable = a2;
                AutoCloseable autoCloseable4 = a2;
                writableRaster = Raster.createWritableRaster(new ComponentSampleModel(2, ((Frame)autoCloseable).imageWidth, ((Frame)autoCloseable).imageHeight, ((Frame)autoCloseable4).imageChannels, ((Frame)autoCloseable4).imageStride, arrn), null);
                java2DFrameConverter = a3;
            } else if (((Frame)a2).imageDepth == -32) {
                componentColorModel = new ComponentColorModel(a, n != 0, false, 1, 3);
                AutoCloseable autoCloseable = a2;
                AutoCloseable autoCloseable5 = a2;
                writableRaster = Raster.createWritableRaster(new ComponentSampleModel(3, ((Frame)autoCloseable).imageWidth, ((Frame)autoCloseable).imageHeight, ((Frame)autoCloseable5).imageChannels, ((Frame)autoCloseable5).imageStride, arrn), null);
                java2DFrameConverter = a3;
            } else if (((Frame)a2).imageDepth == 32) {
                componentColorModel = new ComponentColorModel(a, n != 0, false, 1, 4);
                AutoCloseable autoCloseable = a2;
                AutoCloseable autoCloseable6 = a2;
                writableRaster = Raster.createWritableRaster(new ComponentSampleModel(4, ((Frame)autoCloseable).imageWidth, ((Frame)autoCloseable).imageHeight, ((Frame)autoCloseable6).imageChannels, ((Frame)autoCloseable6).imageStride, arrn), null);
                java2DFrameConverter = a3;
            } else if (((Frame)a2).imageDepth == 64) {
                componentColorModel = new ComponentColorModel(a, n != 0, false, 1, 5);
                AutoCloseable autoCloseable = a2;
                AutoCloseable autoCloseable7 = a2;
                writableRaster = Raster.createWritableRaster(new ComponentSampleModel(5, ((Frame)autoCloseable).imageWidth, ((Frame)autoCloseable).imageHeight, ((Frame)autoCloseable7).imageChannels, ((Frame)autoCloseable7).imageStride, arrn), null);
                java2DFrameConverter = a3;
            } else {
                assert (false);
                java2DFrameConverter = a3;
            }
            java2DFrameConverter.bufferedImage = new BufferedImage(componentColorModel, writableRaster, false, null);
        }
        if (a3.bufferedImage != null) {
            void a4;
            void a5;
            Java2DFrameConverter.copy((Frame)a2, a3.bufferedImage, (double)a4, (boolean)a5, null);
        }
        return a3.bufferedImage;
    }

    /*
     * WARNING - void declaration
     */
    public static void copy(Frame frame, BufferedImage bufferedImage, double d, boolean bl, Rectangle rectangle) {
        int n;
        void a;
        DataBuffer a2;
        void a3;
        Object a222 = bufferedImage;
        Frame a4 = frame;
        Buffer buffer = a4.image[0];
        int n2 = a2 == null ? 0 : ((Rectangle)a2).y * a4.imageStride + ((Rectangle)a2).x * a4.imageChannels;
        Object object = a222;
        a222 = ((BufferedImage)object).getSampleModel();
        WritableRaster writableRaster = ((BufferedImage)object).getRaster();
        a2 = writableRaster.getDataBuffer();
        int n3 = -writableRaster.getSampleModelTranslateX();
        int n4 = -writableRaster.getSampleModelTranslateY();
        Object object2 = a222;
        Object object3 = a222;
        int n5 = ((SampleModel)object2).getWidth() * ((SampleModel)object3).getNumBands();
        int n6 = ((SampleModel)object2).getNumBands();
        if (object3 instanceof ComponentSampleModel) {
            n5 = ((ComponentSampleModel)a222).getScanlineStride();
            n6 = ((ComponentSampleModel)a222).getPixelStride();
            n = n4;
        } else {
            Object object4 = a222;
            if (a222 instanceof SinglePixelPackedSampleModel) {
                n5 = ((SinglePixelPackedSampleModel)object4).getScanlineStride();
                n6 = 1;
                n = n4;
            } else {
                if (object4 instanceof MultiPixelPackedSampleModel) {
                    n5 = ((MultiPixelPackedSampleModel)a222).getScanlineStride();
                    n6 = ((MultiPixelPackedSampleModel)a222).getPixelBitStride() / 8;
                }
                n = n4;
            }
        }
        int a222 = n * n5 + n3 * n6;
        if (a2 instanceof DataBufferByte) {
            byte[] arrby = ((DataBufferByte)a2).getData();
            Java2DFrameConverter.flipCopyWithGamma((ByteBuffer)buffer, n2, a4.imageStride, ByteBuffer.wrap(arrby), a222, n5, false, (double)a, false, a3 != false ? n6 : 0);
            return;
        }
        if (a2 instanceof DataBufferDouble) {
            double[] arrd = ((DataBufferDouble)a2).getData();
            Java2DFrameConverter.flipCopyWithGamma((DoubleBuffer)buffer, n2, a4.imageStride, DoubleBuffer.wrap(arrd), a222, n5, (double)a, false, a3 != false ? n6 : 0);
            return;
        }
        if (a2 instanceof DataBufferFloat) {
            float[] arrf = ((DataBufferFloat)a2).getData();
            Java2DFrameConverter.flipCopyWithGamma((FloatBuffer)buffer, n2, a4.imageStride, FloatBuffer.wrap(arrf), a222, n5, (double)a, false, a3 != false ? n6 : 0);
            return;
        }
        if (a2 instanceof DataBufferInt) {
            int[] arrn = ((DataBufferInt)a2).getData();
            n4 = a4.imageStride;
            if (buffer instanceof ByteBuffer) {
                buffer = ((ByteBuffer)buffer).order(a3 != false ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN).asIntBuffer();
                n4 /= 4;
            }
            Java2DFrameConverter.flipCopyWithGamma((IntBuffer)buffer, n2, n4, IntBuffer.wrap(arrn), a222, n5, (double)a, false, a3 != false ? n6 : 0);
            return;
        }
        if (a2 instanceof DataBufferShort) {
            short[] arrs = ((DataBufferShort)a2).getData();
            Java2DFrameConverter.flipCopyWithGamma((ShortBuffer)buffer, n2, a4.imageStride, ShortBuffer.wrap(arrs), a222, n5, true, (double)a, false, a3 != false ? n6 : 0);
            return;
        }
        if (a2 instanceof DataBufferUShort) {
            short[] arrs = ((DataBufferUShort)a2).getData();
            Java2DFrameConverter.flipCopyWithGamma((ShortBuffer)buffer, n2, a4.imageStride, ShortBuffer.wrap(arrs), a222, n5, false, (double)a, false, a3 != false ? n6 : 0);
            return;
        }
        assert (false);
    }

    /*
     * WARNING - void declaration
     */
    public Frame getFrame(BufferedImage bufferedImage, double d) {
        void a;
        BufferedImage a2 = bufferedImage;
        Java2DFrameConverter a3 = this;
        return a3.getFrame(a2, (double)a, false);
    }

    /*
     * WARNING - void declaration
     */
    public static void flipCopyWithGamma(FloatBuffer floatBuffer, int n, int n2, FloatBuffer floatBuffer2, int n3, int n4, double d, boolean bl, int n5) {
        int a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        FloatBuffer floatBuffer3 = floatBuffer;
        assert (floatBuffer3 != a2);
        int n6 = Math.min((int)a6, (int)a5);
        void var11_13 = a;
        void var12_14 = a3;
        float[] arrf = new float[a4];
        void v0 = var11_13;
        while (v0 < floatBuffer3.capacity() && var12_14 < a2.capacity()) {
            void a7;
            float f;
            void a8;
            int n7;
            void v1;
            if (a7 != false) {
                a = floatBuffer3.capacity() - var11_13 - a6;
                v1 = var12_14;
            } else {
                a = var11_13;
                v1 = var12_14;
            }
            a3 = v1;
            n6 = Math.min(Math.min(n6, floatBuffer3.capacity() - a), a2.capacity() - a3);
            if (a4 > true) {
                int n8 = n7 = 0;
                while (n8 < n6) {
                    int a9;
                    int n9 = a9 = 0;
                    while (n9 < a4) {
                        float f2;
                        float[] arrf2;
                        f = floatBuffer3.get(a);
                        ++a;
                        if (a8 == 1.0) {
                            f2 = f;
                            arrf2 = arrf;
                        } else {
                            f2 = (float)Math.pow(f, (double)a8);
                            arrf2 = arrf;
                        }
                        arrf2[a9++] = f2;
                        n9 = a9;
                    }
                    int n10 = a9 = a4 - true;
                    while (n10 >= 0) {
                        a2.put((int)a3++, arrf[a9--]);
                        n10 = a9;
                    }
                    n8 = n7 + a4;
                }
            } else {
                int n11 = n7 = 0;
                while (n11 < n6) {
                    void v7;
                    float a9 = floatBuffer3.get(a);
                    ++a;
                    if (a8 == 1.0) {
                        f = a9;
                        v7 = a2;
                    } else {
                        f = (float)Math.pow(f, (double)a8);
                        v7 = a2;
                    }
                    v7.put((int)a3, f);
                    ++a3;
                    n11 = ++n7;
                }
            }
            var12_14 += a5;
            v0 = var11_13 += a6;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void flipCopyWithGamma(ByteBuffer byteBuffer, int n, int n2, ByteBuffer byteBuffer2, int n3, int n4, boolean bl, double d, boolean bl2, int n5) {
        void a;
        int a2;
        void a3;
        void a4;
        void a5;
        void a6;
        ByteBuffer byteBuffer3 = byteBuffer;
        assert (byteBuffer3 != a);
        int n6 = Math.min((int)a5, (int)a6);
        void var12_16 = a2;
        void var13_17 = a4;
        byte[] arrby = new byte[a3];
        void v0 = var12_16;
        while (v0 < byteBuffer3.capacity() && var13_17 < a.capacity()) {
            int n7;
            void a7;
            byte by;
            int n8;
            void a8;
            void a9;
            void v1;
            if (a8 != false) {
                a2 = byteBuffer3.capacity() - var12_16 - a5;
                v1 = var13_17;
            } else {
                a2 = var12_16;
                v1 = var13_17;
            }
            a4 = v1;
            n6 = Math.min(Math.min(n6, byteBuffer3.capacity() - a2), a.capacity() - a4);
            if (a9 != false) {
                if (a3 > true) {
                    int n9 = n7 = 0;
                    while (n9 < n6) {
                        int a10;
                        int n10 = a10 = 0;
                        while (n10 < a3) {
                            byte[] arrby2;
                            by = byteBuffer3.get(a2);
                            ++a2;
                            if (a7 == 1.0) {
                                n8 = by;
                                arrby2 = arrby;
                            } else {
                                n8 = (byte)Math.round(Math.pow((double)by / 127.0, (double)a7) * 127.0);
                                arrby2 = arrby;
                            }
                            arrby2[a10++] = n8;
                            n10 = a10;
                        }
                        int n11 = a10 = a3 - true;
                        while (n11 >= 0) {
                            a.put((int)a4++, arrby[a10--]);
                            n11 = a10;
                        }
                        n9 = n7 + a3;
                    }
                } else {
                    int n12 = n7 = 0;
                    while (n12 < n6) {
                        void v8;
                        byte a10 = byteBuffer3.get(a2);
                        ++a2;
                        byte by2 = a10;
                        if (a7 == 1.0) {
                            by = by2;
                            v8 = a;
                        } else {
                            by = (byte)Math.round(Math.pow((double)by2 / 127.0, (double)a7) * 127.0);
                            v8 = a;
                        }
                        v8.put((int)a4, by);
                        ++a4;
                        n12 = ++n7;
                    }
                }
            } else if (a3 > true) {
                int n13 = n7 = 0;
                while (n13 < n6) {
                    int a10;
                    int n14 = a10 = 0;
                    while (n14 < a3) {
                        byte[] arrby3;
                        int n15 = byteBuffer3.get(a2) & 255;
                        ++a2;
                        n8 = n15;
                        if (a7 == 1.0) {
                            by = (byte)n8;
                            arrby3 = arrby;
                        } else if (a7 == 2.2) {
                            by = gamma22[n8];
                            arrby3 = arrby;
                        } else if (a7 == 0.45454545454545453) {
                            by = gamma22inv[n8];
                            arrby3 = arrby;
                        } else {
                            by = (byte)Math.round(Math.pow((double)n8 / 255.0, (double)a7) * 255.0);
                            arrby3 = arrby;
                        }
                        arrby3[a10++] = by;
                        n14 = a10;
                    }
                    int n16 = a10 = a3 - true;
                    while (n16 >= 0) {
                        a.put((int)a4++, arrby[a10--]);
                        n16 = a10;
                    }
                    n13 = n7 + a3;
                }
            } else {
                int n17 = n7 = 0;
                while (n17 < n6) {
                    byte a10;
                    void v16;
                    byte by3 = byteBuffer3.get(a2) & 255;
                    ++a2;
                    by = by3;
                    if (a7 == 1.0) {
                        a10 = by;
                        v16 = a;
                    } else if (a7 == 2.2) {
                        a10 = gamma22[by];
                        v16 = a;
                    } else if (a7 == 0.45454545454545453) {
                        a10 = gamma22inv[by];
                        v16 = a;
                    } else {
                        a10 = (byte)Math.round(Math.pow((double)by / 255.0, (double)a7) * 255.0);
                        v16 = a;
                    }
                    v16.put((int)a4, a10);
                    ++a4;
                    n17 = ++n7;
                }
            }
            var13_17 += a6;
            v0 = var12_16 += a5;
        }
    }

    public static int encodeGamma22(int a) {
        return gamma22inv[a & 255] & 255;
    }

    /*
     * Exception decompiling
     */
    public Frame getFrame(BufferedImage var1_2, double var2_3, boolean var4_4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [11[DOLOOP]], but top level block is 1[CASE]
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

    public BufferedImage getBufferedImage(Frame frame) {
        AutoCloseable a = frame;
        Java2DFrameConverter a2 = this;
        return a2.getBufferedImage((Frame)a, 1.0);
    }

    public static void applyGamma(Frame a, double a2) {
        Frame frame = a;
        Java2DFrameConverter.applyGamma(a.image[0], frame.imageDepth, frame.imageStride, a2);
    }

    public static void copy(BufferedImage bufferedImage, Frame frame) {
        Frame a = frame;
        BufferedImage a2 = bufferedImage;
        Java2DFrameConverter.copy(a2, a, 1.0);
    }

    public Java2DFrameConverter() {
        Java2DFrameConverter a;
    }

    public static int getBufferedImageType(Frame a2) {
        Frame frame = a2;
        int a2 = 0;
        if (frame.imageChannels == 1) {
            if (frame.imageDepth == 8 || frame.imageDepth == -8) {
                a2 = 10;
                return 10;
            }
            if (frame.imageDepth == 16) {
                a2 = 11;
                return 11;
            }
        } else if (frame.imageChannels == 3) {
            if (frame.imageDepth == 8 || frame.imageDepth == -8) {
                a2 = 5;
                return 5;
            }
        } else if (frame.imageChannels == 4 && (frame.imageDepth == 8 || frame.imageDepth == -8)) {
            a2 = 6;
        }
        return a2;
    }

    /*
     * WARNING - void declaration
     */
    public static void copy(Frame frame, BufferedImage bufferedImage, double d) {
        void a;
        BufferedImage a2 = bufferedImage;
        Frame a3 = frame;
        Java2DFrameConverter.copy(a3, a2, (double)a, false, null);
    }

    @Override
    public BufferedImage convert(Frame frame) {
        AutoCloseable a = frame;
        Java2DFrameConverter a2 = this;
        return a2.getBufferedImage((Frame)a);
    }

    public static int decodeGamma22(int a) {
        return gamma22[a & 255] & 255;
    }

    /*
     * WARNING - void declaration
     */
    public static void flipCopyWithGamma(DoubleBuffer doubleBuffer, int n, int n2, DoubleBuffer doubleBuffer2, int n3, int n4, double d, boolean bl, int n5) {
        void a;
        void a2;
        int a3;
        void a4;
        void a5;
        void a6;
        DoubleBuffer doubleBuffer3 = doubleBuffer;
        assert (doubleBuffer3 != a4);
        int n6 = Math.min((int)a2, (int)a);
        void a7 = a3;
        void var12_12 = a5;
        double[] arrd = new double[a6];
        void v0 = a7;
        while (v0 < doubleBuffer3.capacity() && var12_12 < a4.capacity()) {
            void a8;
            void a9;
            int n7;
            int n8;
            void v1;
            if (a8 != false) {
                a3 = doubleBuffer3.capacity() - a7 - a2;
                v1 = var12_12;
            } else {
                a3 = a7;
                v1 = var12_12;
            }
            a5 = v1;
            n6 = Math.min(Math.min(n6, doubleBuffer3.capacity() - a3), a4.capacity() - a5);
            if (a6 > true) {
                int n9 = n8 = 0;
                while (n9 < n6) {
                    int n10 = n7 = 0;
                    while (n10 < a6) {
                        double[] arrd2;
                        double d2;
                        double d3 = doubleBuffer3.get(a3);
                        ++a3;
                        if (a9 == 1.0) {
                            d2 = d3;
                            arrd2 = arrd;
                        } else {
                            d2 = Math.pow(d3, (double)a9);
                            arrd2 = arrd;
                        }
                        arrd2[n7++] = d2;
                        n10 = n7;
                    }
                    int n11 = n7 = a6 - true;
                    while (n11 >= 0) {
                        a4.put((int)a5++, arrd[n7--]);
                        n11 = n7;
                    }
                    n9 = n8 + a6;
                }
            } else {
                int n12 = n8 = 0;
                while (n12 < n6) {
                    int n13;
                    void v7;
                    n7 = doubleBuffer3.get(a3);
                    ++a3;
                    if (a9 == 1.0) {
                        n13 = n7;
                        v7 = a4;
                    } else {
                        n13 = Math.pow(n7, (double)a9);
                        v7 = a4;
                    }
                    v7.put((int)a5, n13);
                    ++a5;
                    n12 = ++n8;
                }
            }
            var12_12 += a;
            v0 = a7 += a2;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void flipCopyWithGamma(IntBuffer intBuffer, int n, int n2, IntBuffer intBuffer2, int n3, int n4, double d, boolean bl, int n5) {
        int a;
        void a2;
        void a3;
        void a4;
        void a5;
        void a6;
        IntBuffer intBuffer3 = intBuffer;
        assert (intBuffer3 != a2);
        int n6 = Math.min((int)a6, (int)a5);
        void var11_13 = a;
        void var12_14 = a3;
        int[] arrn = new int[a4];
        void v0 = var11_13;
        while (v0 < intBuffer3.capacity() && var12_14 < a2.capacity()) {
            int n7;
            void a7;
            void a8;
            int n8;
            void v1;
            if (a7 != false) {
                a = intBuffer3.capacity() - var11_13 - a6;
                v1 = var12_14;
            } else {
                a = var11_13;
                v1 = var12_14;
            }
            a3 = v1;
            n6 = Math.min(Math.min(n6, intBuffer3.capacity() - a), a2.capacity() - a3);
            if (a4 > true) {
                int n9 = n8 = 0;
                while (n9 < n6) {
                    int a9;
                    int n10 = a9 = 0;
                    while (n10 < a4) {
                        int[] arrn2;
                        int n11;
                        n7 = intBuffer3.get(a);
                        ++a;
                        if (a8 == 1.0) {
                            n11 = n7;
                            arrn2 = arrn;
                        } else {
                            n11 = (int)Math.round(Math.pow((double)n7 / 2.147483647E9, (double)a8) * 2.147483647E9);
                            arrn2 = arrn;
                        }
                        arrn2[a9++] = n11;
                        n10 = a9;
                    }
                    int n12 = a9 = a4 - true;
                    while (n12 >= 0) {
                        a2.put((int)a3++, arrn[a9--]);
                        n12 = a9;
                    }
                    n9 = n8 + a4;
                }
            } else {
                int n13 = n8 = 0;
                while (n13 < n6) {
                    void v7;
                    int a9 = intBuffer3.get(a);
                    ++a;
                    if (a8 == 1.0) {
                        n7 = a9;
                        v7 = a2;
                    } else {
                        n7 = (int)Math.round(Math.pow((double)n7 / 2.147483647E9, (double)a8) * 2.147483647E9);
                        v7 = a2;
                    }
                    v7.put((int)a3, n7);
                    ++a3;
                    n13 = ++n8;
                }
            }
            var12_14 += a5;
            v0 = var11_13 += a6;
        }
    }

    /*
     * Exception decompiling
     */
    public static void applyGamma(Buffer var0, int var1_2, int var2_3, double var3_5) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [9[DOLOOP]], but top level block is 5[CASE]
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

    static {
        int n;
        gamma22 = new byte[256];
        gamma22inv = new byte[256];
        int n2 = n = 0;
        while (n2 < 256) {
            int n3 = n;
            Java2DFrameConverter.gamma22[n3] = (byte)Math.round(Math.pow((double)n3 / 255.0, 2.2) * 255.0);
            int n4 = n++;
            Java2DFrameConverter.gamma22inv[n4] = (byte)Math.round(Math.pow((double)n4 / 255.0, 0.45454545454545453) * 255.0);
            n2 = n;
        }
    }

    public static void copy(Frame frame, BufferedImage bufferedImage) {
        BufferedImage a = bufferedImage;
        Frame a2 = frame;
        Java2DFrameConverter.copy(a2, a, 1.0);
    }

    /*
     * WARNING - void declaration
     */
    public static void copy(BufferedImage object, Frame frame, double d, boolean bl, Rectangle rectangle) {
        void a;
        SampleModel a22;
        void a3;
        int n;
        void a4;
        BufferedImage bufferedImage = object;
        object = rectangle;
        BufferedImage a5 = bufferedImage;
        Buffer buffer = a4.image[0];
        int n2 = a22 == null ? 0 : ((Rectangle)a22).y * a4.imageStride + ((Rectangle)a22).x * a4.imageChannels;
        BufferedImage bufferedImage2 = a5;
        a22 = bufferedImage2.getSampleModel();
        WritableRaster writableRaster = bufferedImage2.getRaster();
        DataBuffer dataBuffer = writableRaster.getDataBuffer();
        int n3 = -writableRaster.getSampleModelTranslateX();
        int n4 = -writableRaster.getSampleModelTranslateY();
        Object object2 = a22;
        Object object3 = a22;
        int n5 = ((SampleModel)object2).getWidth() * ((SampleModel)object3).getNumBands();
        int n6 = ((SampleModel)object2).getNumBands();
        if (object3 instanceof ComponentSampleModel) {
            n5 = ((ComponentSampleModel)a22).getScanlineStride();
            n6 = ((ComponentSampleModel)a22).getPixelStride();
            n = n4;
        } else {
            SampleModel sampleModel = a22;
            if (a22 instanceof SinglePixelPackedSampleModel) {
                n5 = ((SinglePixelPackedSampleModel)sampleModel).getScanlineStride();
                n6 = 1;
                n = n4;
            } else {
                if (sampleModel instanceof MultiPixelPackedSampleModel) {
                    n5 = ((MultiPixelPackedSampleModel)a22).getScanlineStride();
                    n6 = ((MultiPixelPackedSampleModel)a22).getPixelBitStride() / 8;
                }
                n = n4;
            }
        }
        int a22 = n * n5 + n3 * n6;
        if (dataBuffer instanceof DataBufferByte) {
            byte[] arrby = ((DataBufferByte)dataBuffer).getData();
            Java2DFrameConverter.flipCopyWithGamma(ByteBuffer.wrap(arrby), a22, n5, (ByteBuffer)buffer, n2, a4.imageStride, false, (double)a, false, a3 != false ? n6 : 0);
            return;
        }
        if (dataBuffer instanceof DataBufferDouble) {
            double[] arrd = ((DataBufferDouble)dataBuffer).getData();
            Java2DFrameConverter.flipCopyWithGamma(DoubleBuffer.wrap(arrd), a22, n5, (DoubleBuffer)buffer, n2, a4.imageStride, (double)a, false, a3 != false ? n6 : 0);
            return;
        }
        if (dataBuffer instanceof DataBufferFloat) {
            float[] arrf = ((DataBufferFloat)dataBuffer).getData();
            Java2DFrameConverter.flipCopyWithGamma(FloatBuffer.wrap(arrf), a22, n5, (FloatBuffer)buffer, n2, a4.imageStride, (double)a, false, a3 != false ? n6 : 0);
            return;
        }
        if (dataBuffer instanceof DataBufferInt) {
            int[] arrn = ((DataBufferInt)dataBuffer).getData();
            n4 = a4.imageStride;
            if (buffer instanceof ByteBuffer) {
                buffer = ((ByteBuffer)buffer).order(a3 != false ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN).asIntBuffer();
                n4 /= 4;
            }
            Java2DFrameConverter.flipCopyWithGamma(IntBuffer.wrap(arrn), a22, n5, (IntBuffer)buffer, n2, n4, (double)a, false, a3 != false ? n6 : 0);
            return;
        }
        if (dataBuffer instanceof DataBufferShort) {
            short[] arrs = ((DataBufferShort)dataBuffer).getData();
            Java2DFrameConverter.flipCopyWithGamma(ShortBuffer.wrap(arrs), a22, n5, (ShortBuffer)buffer, n2, a4.imageStride, true, (double)a, false, a3 != false ? n6 : 0);
            return;
        }
        if (dataBuffer instanceof DataBufferUShort) {
            short[] arrs = ((DataBufferUShort)dataBuffer).getData();
            Java2DFrameConverter.flipCopyWithGamma(ShortBuffer.wrap(arrs), a22, n5, (ShortBuffer)buffer, n2, a4.imageStride, false, (double)a, false, a3 != false ? n6 : 0);
            return;
        }
        assert (false);
    }

    /*
     * WARNING - void declaration
     */
    public BufferedImage getBufferedImage(Frame frame, double d) {
        void a;
        AutoCloseable a2 = frame;
        Java2DFrameConverter a3 = this;
        return a3.getBufferedImage((Frame)a2, (double)a, false, null);
    }

    /*
     * WARNING - void declaration
     */
    public static void flipCopyWithGamma(ShortBuffer shortBuffer, int n, int n2, ShortBuffer shortBuffer2, int n3, int n4, boolean bl, double d, boolean bl2, int n5) {
        void a;
        int a2;
        void a3;
        void a4;
        void a5;
        void a6;
        ShortBuffer shortBuffer3 = shortBuffer;
        assert (shortBuffer3 != a);
        int n6 = Math.min((int)a5, (int)a6);
        void var12_16 = a2;
        void var13_17 = a4;
        short[] arrs = new short[a3];
        void v0 = var12_16;
        while (v0 < shortBuffer3.capacity() && var13_17 < a.capacity()) {
            short s;
            int n7;
            void a7;
            void a8;
            void a9;
            void v1;
            short s2;
            if (a8 != false) {
                a2 = shortBuffer3.capacity() - var12_16 - a5;
                v1 = var13_17;
            } else {
                a2 = var12_16;
                v1 = var13_17;
            }
            a4 = v1;
            n6 = Math.min(Math.min(n6, shortBuffer3.capacity() - a2), a.capacity() - a4);
            if (a9 != false) {
                if (a3 > true) {
                    int n8 = n7 = 0;
                    while (n8 < n6) {
                        int a10;
                        int n9 = a10 = 0;
                        while (n9 < a3) {
                            short[] arrs2;
                            s = shortBuffer3.get(a2);
                            ++a2;
                            if (a7 == 1.0) {
                                s2 = s;
                                arrs2 = arrs;
                            } else {
                                s2 = (short)Math.round(Math.pow((double)s / 32767.0, (double)a7) * 32767.0);
                                arrs2 = arrs;
                            }
                            arrs2[a10++] = s2;
                            n9 = a10;
                        }
                        int n10 = a10 = a3 - true;
                        while (n10 >= 0) {
                            a.put((int)a4++, arrs[a10--]);
                            n10 = a10;
                        }
                        n8 = n7 + a3;
                    }
                } else {
                    int n11 = n7 = 0;
                    while (n11 < n6) {
                        void v8;
                        short a10 = shortBuffer3.get(a2);
                        ++a2;
                        short s3 = a10;
                        if (a7 == 1.0) {
                            s = s3;
                            v8 = a;
                        } else {
                            s = (short)Math.round(Math.pow((double)s3 / 32767.0, (double)a7) * 32767.0);
                            v8 = a;
                        }
                        v8.put((int)a4, s);
                        ++a4;
                        n11 = ++n7;
                    }
                }
            } else if (a3 > true) {
                int n12 = n7 = 0;
                while (n12 < n6) {
                    int a10;
                    int n13 = a10 = 0;
                    while (n13 < a3) {
                        short[] arrs3;
                        s = shortBuffer3.get(a2);
                        ++a2;
                        short s4 = s;
                        if (a7 == 1.0) {
                            s2 = s4;
                            arrs3 = arrs;
                        } else {
                            s2 = (short)Math.round(Math.pow((double)s4 / 65535.0, (double)a7) * 65535.0);
                            arrs3 = arrs;
                        }
                        arrs3[a10++] = s2;
                        n13 = a10;
                    }
                    int n14 = a10 = a3 - true;
                    while (n14 >= 0) {
                        a.put((int)a4++, arrs[a10--]);
                        n14 = a10;
                    }
                    n12 = n7 + a3;
                }
            } else {
                int n15 = n7 = 0;
                while (n15 < n6) {
                    int a10;
                    void v17;
                    int n16 = shortBuffer3.get(a2) & 65535;
                    ++a2;
                    int n17 = a10 = n16;
                    if (a7 == 1.0) {
                        s = (short)n17;
                        v17 = a;
                    } else {
                        s = (short)Math.round(Math.pow((double)n17 / 65535.0, (double)a7) * 65535.0);
                        v17 = a;
                    }
                    v17.put((int)a4, s);
                    ++a4;
                    n15 = ++n7;
                }
            }
            var13_17 += a6;
            v0 = var12_16 += a5;
        }
    }
}
