/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.Loader
 *  org.bytedeco.javacpp.Pointer
 *  org.bytedeco.javacpp.annotation.Cast
 *  org.bytedeco.javacpp.annotation.MemberGetter
 *  org.bytedeco.javacpp.annotation.Name
 *  org.bytedeco.javacpp.annotation.NoException
 *  org.bytedeco.javacpp.annotation.Platform
 *  org.bytedeco.javacpp.annotation.Properties
 *  org.bytedeco.javacpp.presets.javacpp
 *  org.bytedeco.javacpp.tools.Info
 *  org.bytedeco.javacpp.tools.InfoMap
 *  org.bytedeco.javacpp.tools.InfoMapper
 */
package org.bytedeco.ffmpeg.presets;

import dev.recollect.hana.api.utils.math.FadeUtils;
import dev.recollect.hana.skid.Start;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.MemberGetter;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.NoException;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.presets.javacpp;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(inherit={javacpp.class}, target="org.bytedeco.ffmpeg.avutil", global="org.bytedeco.ffmpeg.global.avutil", value={@Platform(define={"__STDC_CONSTANT_MACROS", "__STDC_FORMAT_MACROS", "STRING_BYTES_CHARSET \"UTF-8\""}, cinclude={"<libavutil/avutil.h>", "<libavutil/error.h>", "<libavutil/mem.h>", "<libavutil/time.h>", "<libavutil/mathematics.h>", "<libavutil/rational.h>", "<libavutil/log.h>", "<libavutil/buffer.h>", "<libavutil/pixfmt.h>", "<libavutil/frame.h>", "<libavutil/samplefmt.h>", "<libavutil/channel_layout.h>", "<libavutil/cpu.h>", "<libavutil/dict.h>", "<libavutil/opt.h>", "<libavutil/pixdesc.h>", "<libavutil/imgutils.h>", "<libavutil/downmix_info.h>", "<libavutil/stereo3d.h>", "<libavutil/ffversion.h>", "<libavutil/motion_vector.h>", "<libavutil/fifo.h>", "<libavutil/audio_fifo.h>", "<libavutil/hwcontext.h>", "<libavutil/adler32.h>", "<libavutil/aes.h>", "<libavutil/aes_ctr.h>", "<libavutil/base64.h>", "<libavutil/blowfish.h>", "<libavutil/cast5.h>", "<libavutil/camellia.h>", "<libavutil/crc.h>", "<libavutil/des.h>", "<libavutil/lfg.h>", "<libavutil/hmac.h>", "<libavutil/md5.h>", "<libavutil/rc4.h>", "<libavutil/ripemd.h>", "<libavutil/tea.h>", "<libavutil/twofish.h>", "<libavutil/sha.h>", "<libavutil/sha512.h>", "<libavutil/xtea.h>", "<libavutil/avstring.h>", "<libavutil/bprint.h>", "<libavutil/common.h>", "<libavutil/display.h>", "<libavutil/eval.h>", "<libavutil/encryption_info.h>", "<libavutil/file.h>", "<libavutil/hash.h>", "<libavutil/hdr_dynamic_metadata.h>", "<libavutil/intfloat.h>", "<libavutil/intreadwrite.h>", "<libavutil/mastering_display_metadata.h>", "<libavutil/murmur3.h>", "<libavutil/parseutils.h>", "<libavutil/pixelutils.h>", "<libavutil/random_seed.h>", "<libavutil/replaygain.h>", "<libavutil/spherical.h>", "<libavutil/threadmessage.h>", "<libavutil/timecode.h>", "<libavutil/timestamp.h>", "<libavutil/tree.h>", "<libavutil/tx.h>", "<libavutil/version.h>", "<libavutil/macros.h>", "log_callback.h"}, includepath={"/usr/local/include/ffmpeg/", "/opt/local/include/ffmpeg/", "/usr/include/ffmpeg/"}, link={"avutil@.58"}, compiler={"default", "nodeprecated"}), @Platform(value={"linux-x86"}, preload={"va@.1", "drm@.2", "va-drm@.1"}, preloadpath={"/usr/lib32/", "/usr/lib/"}), @Platform(value={"linux-x86_64"}, preloadpath={"/usr/lib64/", "/usr/lib/"}), @Platform(value={"windows"}, includepath={"C:/MinGW/local/include/ffmpeg/", "C:/MinGW/include/ffmpeg/"}, preload={"avutil-58"}), @Platform(extension={"-gpl"})})
public class avutil
implements InfoMapper {
    @MemberGetter
    @Name(value={"AVERROR(ENOMEM)"})
    public static native int AVERROR_ENOMEM();

    @MemberGetter
    @Name(value={"AVERROR(EINVAL)"})
    public static native int AVERROR_EINVAL();

    @MemberGetter
    @Name(value={"AVERROR(ENOENT)"})
    public static native int AVERROR_ENOENT();

    @MemberGetter
    @Name(value={"AVERROR(EPERM)"})
    public static native int AVERROR_EPERM();

    @MemberGetter
    @Name(value={"AVERROR(ENXIO)"})
    public static native int AVERROR_ENXIO();

    @MemberGetter
    @Name(value={"AVERROR(EILSEQ)"})
    public static native int AVERROR_EILSEQ();

    static {
        Loader.checkVersion((String)Start.ALLATORIxDEMO("FuK,I|XgUz\u0018:"), (String)FadeUtils.ALLATORIxDEMO("\n[\u001cP^\r"));
    }

    @MemberGetter
    @Name(value={"AVERROR(ENODEV)"})
    public static native int AVERROR_ENODEV();

    @MemberGetter
    @Name(value={"AVERROR(EACCES)"})
    public static native int AVERROR_EACCES();

    @NoException
    public static native void av_log_set_callback(@Cast(value={"void (*)(void*, int, const char*, va_list)"}) Pointer var0);

    @MemberGetter
    @Name(value={"AVERROR(EAGAIN)"})
    public static native int AVERROR_EAGAIN();

    @MemberGetter
    @Name(value={"AVERROR(EFAULT)"})
    public static native int AVERROR_EFAULT();

    public void map(InfoMap infoMap) {
        avutil a = infoMap;
        avutil a2 = this;
        String[] arrstring = new String[1];
        arrstring[0] = FadeUtils.ALLATORIxDEMO("1w.n#m=k7o%y a");
        String[] arrstring2 = new String[1];
        arrstring2[0] = Start.ALLATORIxDEMO("nFr\u0012>jo");
        String[] arrstring3 = new String[2];
        arrstring3[0] = FadeUtils.ALLATORIxDEMO("{4j");
        arrstring3[1] = Start.ALLATORIxDEMO("`InOjCaB");
        String[] arrstring4 = new String[1];
        arrstring4[0] = FadeUtils.ALLATORIxDEMO("\fV\u0011W\u0019A");
        String[] arrstring5 = new String[29];
        arrstring5[0] = Start.ALLATORIxDEMO("qHnKeOlXjGwOjJ");
        arrstring5[1] = FadeUtils.ALLATORIxDEMO("p\u0005E\fT.V\u0016X\u0014P");
        arrstring5[2] = Start.ALLATORIxDEMO("DGbAi|_");
        arrstring5[3] = FadeUtils.ALLATORIxDEMO("c&b>l3n9{7`'r6k");
        arrstring5[4] = Start.ALLATORIxDEMO("\\f]~SsQyDw_gEv\\");
        arrstring5[5] = FadeUtils.ALLATORIxDEMO("6g.c)t%g:j,|3p");
        arrstring5[6] = Start.ALLATORIxDEMO("PisaLnDYHeR)");
        arrstring5[7] = FadeUtils.ALLATORIxDEMO("Y\u001ef\u0007Y\u001cT");
        arrstring5[8] = Start.ALLATORIxDEMO("c_XKjMz\u0003/");
        arrstring5[9] = FadeUtils.ALLATORIxDEMO("@\u0007\u000fQ\u0000H7L\r[\u0001\u001c");
        arrstring5[10] = Start.ALLATORIxDEMO("PisaEnXYMdA#");
        arrstring5[11] = FadeUtils.ALLATORIxDEMO("\u0011W.C\u0000T\u0019g\u001dP\nAD\u0012");
        arrstring5[12] = Start.ALLATORIxDEMO("G@On@wwoJ~\u0004-");
        arrstring5[13] = FadeUtils.ALLATORIxDEMO("\u0011W.C\u0000T\u0019T7P\nAF\u0016");
        arrstring5[14] = Start.ALLATORIxDEMO("G@On@wwoJ~E)");
        arrstring5[15] = FadeUtils.ALLATORIxDEMO("\u0011W.C\u0000T\u0019g\u001dP\nA\u0005\u0016");
        arrstring5[16] = Start.ALLATORIxDEMO("G@AmMX]oJ~E)");
        arrstring5[17] = FadeUtils.ALLATORIxDEMO("\u0010V3N\bL7X\u0000QF\u0016");
        arrstring5[18] = Start.ALLATORIxDEMO("G@_c]XLg@n\u0006)");
        arrstring5[19] = FadeUtils.ALLATORIxDEMO("\u0010V3N\bL7J\u0011WF\u0016");
        arrstring5[20] = Start.ALLATORIxDEMO("G@_c]XLuQh\u0006)");
        arrstring5[21] = FadeUtils.ALLATORIxDEMO("\bN7Z\b\\\u0005B");
        arrstring5[22] = Start.ALLATORIxDEMO("HqweHcE");
        arrstring5[23] = FadeUtils.ALLATORIxDEMO("A\u001ab\u0019W\u0018Z\u000b@\u001bP");
        arrstring5[24] = Start.ALLATORIxDEMO("G@\\mYdGsJ~\u0003/");
        arrstring5[25] = FadeUtils.ALLATORIxDEMO("\\\u001fg\u0018X\u0016\\\u0001]");
        arrstring5[26] = Start.ALLATORIxDEMO("PisqHswg@n\u0003/");
        arrstring5[27] = FadeUtils.ALLATORIxDEMO("\u0010V3N\bL7J\u0011WC\u0010");
        arrstring5[28] = Start.ALLATORIxDEMO("Fz_qHdKeNvQmTwCzU");
        String[] arrstring6 = new String[2];
        arrstring6[0] = FadeUtils.ALLATORIxDEMO("kb8%c&v9m.v)o:q'w;|;p");
        arrstring6[1] = Start.ALLATORIxDEMO("Qy\\pIyV`KwO`O{O");
        String[] arrstring7 = new String[18];
        arrstring7[0] = FadeUtils.ALLATORIxDEMO("7f3|9q7}Vf!v");
        arrstring7[1] = Start.ALLATORIxDEMO("p^4\u0004tClYu]}^~GvFdOcDp_");
        arrstring7[2] = FadeUtils.ALLATORIxDEMO("0at;4|,a?m>r?m({-f*t8a");
        arrstring7[3] = Start.ALLATORIxDEMO("YpG*\u0015mUrKoSpS`Mj]wGvXtB");
        arrstring7[4] = FadeUtils.ALLATORIxDEMO("s5}1q8*t/w7i!p>\u0016");
        arrstring7[5] = Start.ALLATORIxDEMO("\u0003bUrMyAwVjMvHdB{KeR");
        arrstring7[6] = FadeUtils.ALLATORIxDEMO("f*b(h!f<c8g");
        arrstring7[7] = Start.ALLATORIxDEMO("Hw@wH\"\u001akFwBsVpQbGeXdG}E`O");
        arrstring7[8] = FadeUtils.ALLATORIxDEMO("m<;t#k/`'*r9}&f1a3\u001c");
        arrstring7[9] = Start.ALLATORIxDEMO("\u0003bUrMyAaTx]mRzGpCzU");
        arrstring7[10] = FadeUtils.ALLATORIxDEMO("f0xj*-j!g?s5e>x-g'i%d a");
        arrstring7[11] = Start.ALLATORIxDEMO("^fQpOG-\u0017eGvB`WrKyPlXfSiHpI");
        arrstring7[12] = FadeUtils.ALLATORIxDEMO("w0x!a8>cy%2|%k4~%h>x,g;i(|;a");
        arrstring7[13] = Start.ALLATORIxDEMO("u[o_aVsD{FeC{Z~O");
        arrstring7[14] = FadeUtils.ALLATORIxDEMO("f0xj*-j:l$d#l-~,|76t8a");
        arrstring7[15] = Start.ALLATORIxDEMO("u[o_aVsD{FeC{ApB");
        arrstring7[16] = FadeUtils.ALLATORIxDEMO("&w.a&nt*%y6v$d.h-n6{ x*r0`");
        arrstring7[17] = Start.ALLATORIxDEMO("_fQwHiQgJzS*\u000b{I|SdWvJcWzXeCiEgB");
        String[] arrstring8 = new String[1];
        arrstring8[0] = FadeUtils.ALLATORIxDEMO("\u0006Z\u001aH");
        String[] arrstring9 = new String[1];
        arrstring9[0] = Start.ALLATORIxDEMO("HqweKdFo");
        String[] arrstring10 = new String[1];
        arrstring10[0] = FadeUtils.ALLATORIxDEMO("(z\u000b[\u0006P");
        String[] arrstring11 = new String[1];
        arrstring11[0] = Start.ALLATORIxDEMO("LuBsQLx]hQ}RmF\u0000.");
        String[] arrstring12 = new String[5];
        arrstring12[0] = FadeUtils.ALLATORIxDEMO("\u0012T/L\u0010L\u0000R\ng\tM\u0010G\u001cF");
        arrstring12[1] = Start.ALLATORIxDEMO("G@MnEhKYWcO~");
        arrstring12[2] = FadeUtils.ALLATORIxDEMO("\u0012T/@\u001dW\rD\u001ag\u0001W\b\\\u001bA");
        arrstring12[3] = Start.ALLATORIxDEMO("y\u001d\u001aSkAsok_j_gMXZcWYo");
        arrstring12[4] = FadeUtils.ALLATORIxDEMO("\bN7X\b\\\u0014W");
        String[] arrstring13 = new String[1];
        arrstring13[0] = Start.ALLATORIxDEMO("\n1PxZEjT@HgYuMeE~P");
        String[] arrstring14 = new String[1];
        arrstring14[0] = FadeUtils.ALLATORIxDEMO("`(X\u0019J\rZ\u0005A\u0010@");
        String[] arrstring15 = new String[2];
        arrstring15[0] = Start.ALLATORIxDEMO("BsEg_");
        arrstring15[1] = FadeUtils.ALLATORIxDEMO("1|;p");
        String[] arrstring16 = new String[1];
        arrstring16[0] = Start.ALLATORIxDEMO("c[o");
        String[] arrstring17 = new String[3];
        arrstring17[0] = FadeUtils.ALLATORIxDEMO("%S\u001dh\u0007P\nA\u0010V");
        arrstring17[1] = Start.ALLATORIxDEMO("KGsjsBlPi");
        arrstring17[2] = FadeUtils.ALLATORIxDEMO("P\nA.y");
        String[] arrstring18 = new String[21];
        arrstring18[0] = Start.ALLATORIxDEMO("CWIhwiTu");
        arrstring18[1] = FadeUtils.ALLATORIxDEMO("1w2O\bX\n{\u0007W\u0010P\rP");
        arrstring18[2] = Start.ALLATORIxDEMO("CJ]tiG(");
        arrstring18[3] = FadeUtils.ALLATORIxDEMO("~<[\u0007W\u0010P\rP");
        arrstring18[4] = Start.ALLATORIxDEMO("jR[rVoTv");
        arrstring18[5] = FadeUtils.ALLATORIxDEMO("8d_yX\t,\\\u0012\\\u0016A");
        arrstring18[6] = Start.ALLATORIxDEMO("\f`9w,\u0001ZTiEaLDGhPoMo");
        arrstring18[7] = FadeUtils.ALLATORIxDEMO("k4\u00125\u0011]i\f@\u001cL\u0016PG`");
        arrstring18[8] = Start.ALLATORIxDEMO("mN\u0000Y\u0001/gvHgFDGhPoMo");
        arrstring18[9] = FadeUtils.ALLATORIxDEMO("|7\u00114\u0010@v\u0005Y\fW,\\\u0012\\\u0016A");
        arrstring18[10] = Start.ALLATORIxDEMO("Vrq\u0019 G~\u0000Yt{GvOgdfFgCoG\"");
        arrstring18[11] = FadeUtils.ALLATORIxDEMO("|7K\u0002D\u0012T_y:M\u001a_\u0005V\u0010\u001d");
        arrstring18[12] = Start.ALLATORIxDEMO("\"\u0001MxV~DFgvHgFCMeKnPi");
        arrstring18[13] = FadeUtils.ALLATORIxDEMO("\u001eD\bg\u0003A\u0001X:M\u001a_\u0005V\u0010\u0015");
        arrstring18[14] = Start.ALLATORIxDEMO("AdQTMuWcZu");
        arrstring18[15] = FadeUtils.ALLATORIxDEMO(":|*W\u0006_\rR<`");
        arrstring18[16] = Start.ALLATORIxDEMO("ImQ\\uNgGo|_");
        arrstring18[17] = FadeUtils.ALLATORIxDEMO("t1r\u0004R\n\\\n])M\u0010G\u001cF");
        arrstring18[18] = Start.ALLATORIxDEMO("ThCAuTfTb");
        arrstring18[19] = FadeUtils.ALLATORIxDEMO("k\rH,\\\u0012\\\u0016A");
        arrstring18[20] = Start.ALLATORIxDEMO("\\Wmw{EO^mJFLbVoFh");
        String[] arrstring19 = new String[1];
        arrstring19[0] = FadeUtils.ALLATORIxDEMO("h\u0007P\nA\u0010V");
        String[] arrstring20 = new String[1];
        arrstring20[0] = Start.ALLATORIxDEMO("wYsCyNwPeKeR");
        String[] arrstring21 = new String[5];
        arrstring21[0] = FadeUtils.ALLATORIxDEMO("p'&ns%\"x'}1c8+t=g%x7a0v");
        arrstring21[1] = Start.ALLATORIxDEMO("aXiPaXt@V(\niZrIy\\}ZsN`EiP{KwR");
        arrstring21[2] = FadeUtils.ALLATORIxDEMO("Pf*b(h!f<c8g");
        arrstring21[3] = Start.ALLATORIxDEMO("fHiYpGnXsL4\u0007m^`B`[c@CdWdC{LxO");
        arrstring21[4] = FadeUtils.ALLATORIxDEMO("d6~0p%b/q&};z%p");
        String[] arrstring22 = new String[2];
        arrstring22[0] = Start.ALLATORIxDEMO("-\u0003{KcTo\\dYjG{X{O~OjO");
        arrstring22[1] = FadeUtils.ALLATORIxDEMO("m<;t#k/b#y<i&g;p>p*p");
        String[] arrstring23 = new String[1];
        arrstring23[0] = Start.ALLATORIxDEMO("~FQRwS{\u0000\u001aTcK{]jn{IqJuAvPeGh");
        String[] arrstring24 = new String[67];
        arrstring24[0] = FadeUtils.ALLATORIxDEMO("2t/b9*o&v<f(p3p");
        arrstring24[1] = Start.ALLATORIxDEMO("KeBsVnY~MgSwTmM}O");
        arrstring24[2] = FadeUtils.ALLATORIxDEMO("%c,a8~7r#s=g+|*a0v");
        arrstring24[3] = Start.ALLATORIxDEMO("\u0004rUpUoR~HsD{BySaDvB");
        arrstring24[4] = FadeUtils.ALLATORIxDEMO("c&~2h3({#f(p3p");
        arrstring24[5] = Start.ALLATORIxDEMO("rKo]y@nCjLwTmM}O");
        arrstring24[6] = FadeUtils.ALLATORIxDEMO("!g.c>xm(+{'}<d7t3r/g+|*a0v");
        arrstring24[7] = Start.ALLATORIxDEMO("YvQrWi^9\nj^lOyYyKsMoXkCj^pI");
        arrstring24[8] = FadeUtils.ALLATORIxDEMO("t%}3i.b-~\"g+|*a0v");
        arrstring24[9] = Start.ALLATORIxDEMO("\\fArWsQ`CmYhOsO");
        arrstring24[10] = FadeUtils.ALLATORIxDEMO("2t/b9?t-}7k-r=p");
        arrstring24[11] = Start.ALLATORIxDEMO("rKo]y@xMyXkCj^pI");
        arrstring24[12] = FadeUtils.ALLATORIxDEMO("j,;v;}$n!*o&v<f(p3p");
        arrstring24[13] = Start.ALLATORIxDEMO("wN4\u0006lUgR`AwMcL}XkCj^pI");
        arrstring24[14] = FadeUtils.ALLATORIxDEMO("f}%'},v?q.f>r'l7k-r=p");
        arrstring24[15] = Start.ALLATORIxDEMO("\u0004rUpUoJ~Os@hDcYhOsO");
        arrstring24[16] = FadeUtils.ALLATORIxDEMO("f}%'},v?q.b-~\"g+|*a0v");
        arrstring24[17] = Start.ALLATORIxDEMO("*\u0013{I{BdQa@nCjLwTmM}O");
        arrstring24[18] = FadeUtils.ALLATORIxDEMO("t%}3i.s8x;}'f(p3p");
        arrstring24[19] = Start.ALLATORIxDEMO("e\\l^xAbKiPlHwTmM}O");
        arrstring24[20] = FadeUtils.ALLATORIxDEMO("c&~2h3j |-f(p3p");
        arrstring24[21] = Start.ALLATORIxDEMO("rKo]y@{KmBwTmM}O");
        arrstring24[22] = FadeUtils.ALLATORIxDEMO("!g.c>xx/6g<w>e.d%o,{<f(p3p");
        arrstring24[23] = Start.ALLATORIxDEMO("YvQrWiK>\u0017vEfStAuV~GjSwTmM}O");
        arrstring24[24] = FadeUtils.ALLATORIxDEMO("f}%'},n?v.f>x8m-w'l*\u0016");
        arrstring24[25] = Start.ALLATORIxDEMO("\u0004rUpUoJ~OsQ`CmYhOsO");
        arrstring24[26] = FadeUtils.ALLATORIxDEMO("j,;v;}$n!?t-}7k-r=p");
        arrstring24[27] = Start.ALLATORIxDEMO("Og@uP4\u0007k^gR}AwMcL}XkCj^pI");
        arrstring24[28] = FadeUtils.ALLATORIxDEMO("a xh2;w<v$n<*o&v<f(p3p");
        arrstring24[29] = Start.ALLATORIxDEMO("pIi[#\u001afEgISnY~MgSwTmM}O");
        arrstring24[30] = FadeUtils.ALLATORIxDEMO(";2j0j/m0y#h=g&x0|#a");
        arrstring24[31] = Start.ALLATORIxDEMO("KeBsVnSm[fR|YiE{T");
        arrstring24[32] = FadeUtils.ALLATORIxDEMO(";2j0j/m0y#h=g;m!g0k");
        arrstring24[33] = Start.ALLATORIxDEMO("*\u0013{I{B|_hPyVv5xImDa*");
        arrstring24[34] = FadeUtils.ALLATORIxDEMO("2t/b9 |0w=m;\u0007*\u0015");
        arrstring24[35] = Start.ALLATORIxDEMO("Y=\u001agBlQqG~Jx]zRzTk_{_");
        arrstring24[36] = FadeUtils.ALLATORIxDEMO("j,;v;}<`(o9i6\u000b8v-{!\u0015");
        arrstring24[37] = Start.ALLATORIxDEMO("*\u0013{I{B|_hPyVv3xImDa+");
        arrstring24[38] = FadeUtils.ALLATORIxDEMO("j,;v;}<`(o9i6\f8v-{!\u0015");
        arrstring24[39] = Start.ALLATORIxDEMO("rKo]y@`CpH}R{8j)");
        arrstring24[40] = FadeUtils.ALLATORIxDEMO("t%}3i.l-d&m<f5`4`");
        arrstring24[41] = Start.ALLATORIxDEMO("*\u0013{I{B|_hPyVv2xImDa+");
        arrstring24[42] = FadeUtils.ALLATORIxDEMO("j,;v;}<`(o9i6\r8v-{!\u0015");
        arrstring24[43] = Start.ALLATORIxDEMO("Og@uP4\teS|HdA\u0004OcKgS\u0018YfKvP");
        arrstring24[44] = FadeUtils.ALLATORIxDEMO("p'5ot6%l<w$~Dp#t'lYf&t6o");
        arrstring24[45] = Start.ALLATORIxDEMO("*\u0013{I{B|_hPyVv1xImDa+");
        arrstring24[46] = FadeUtils.ALLATORIxDEMO("!g.c>xg;=z&v/\u0017!o%s=\b76z;p");
        arrstring24[47] = Start.ALLATORIxDEMO("wN4\u0006lU\\iQdKsJl_iAkDtW");
        arrstring24[48] = FadeUtils.ALLATORIxDEMO("!g.c>xg;=z&v/\u0012!o%s=\t8v-{!\u0016");
        arrstring24[49] = Start.ALLATORIxDEMO("*\u0013{I{B|_hPyVv1xImDa*");
        arrstring24[50] = FadeUtils.ALLATORIxDEMO("p'5ot6%l<w$~Gp#t'lYf&t6o");
        arrstring24[51] = Start.ALLATORIxDEMO("aXn\\~G'\u0004}EfIo(aPeL}6w@vE{O");
        arrstring24[52] = FadeUtils.ALLATORIxDEMO("j,;v;}<`(o9i6\u000f8v-{!\u0014");
        arrstring24[53] = Start.ALLATORIxDEMO("aXn\\~G'\u0004}EfIo)aPeL}7w@vE{O");
        arrstring24[54] = FadeUtils.ALLATORIxDEMO("j,;v;}<`(o9i6\u000f8v-{!\u0015");
        arrstring24[55] = Start.ALLATORIxDEMO("Og@uP4\teS|HdA\u0006OcKgS\u0019YsCq^");
        arrstring24[56] = FadeUtils.ALLATORIxDEMO("!g)d(n=a/h~.;\u0002#m9o%\u00113j |-f&t6o");
        arrstring24[57] = Start.ALLATORIxDEMO("XvQuPBpFyM?\u001a\u0011Z|T~J\u0000OcKgS\u001aYfKvP");
        arrstring24[58] = FadeUtils.ALLATORIxDEMO("7qt9,j?c)n$t3r*l)~+{4h");
        arrstring24[59] = Start.ALLATORIxDEMO("KeBsVnSm[fR|Yg_w^");
        arrstring24[60] = FadeUtils.ALLATORIxDEMO("g6n5o?}0y9r%Qe<k>u@p#t'l\\f&t6o");
        arrstring24[61] = Start.ALLATORIxDEMO("aXn\\~G'\u0004}EfIo)aPeL}6xImDa)");
        arrstring24[62] = FadeUtils.ALLATORIxDEMO("g6n5o?}0y9r%Se<k>u@p#t'l\\f&t6o");
        arrstring24[63] = Start.ALLATORIxDEMO("aXn\\~G'\u0004}EfIoVtGmFlDiAkDtW");
        arrstring24[64] = FadeUtils.ALLATORIxDEMO("f6n2h)kj#+`'}#u4r)r6|'n*x<|");
        arrstring24[65] = Start.ALLATORIxDEMO("Y=\u001agBlQqG~Jx]\u001b5xImDa)");
        arrstring24[66] = FadeUtils.ALLATORIxDEMO("p x#y.l7~d/0jDr?h?t]b=w8f&t6o");
        String[] arrstring25 = new String[1];
        arrstring25[0] = Start.ALLATORIxDEMO("He[|");
        String[] arrstring26 = new String[37];
        arrstring26[0] = FadeUtils.ALLATORIxDEMO("7qt9,t=l5m.l-d&m<f)z;k");
        arrstring26[1] = Start.ALLATORIxDEMO("pIi[#\u0004jDvQoRpFcW}X{RaXpT");
        arrstring26[2] = FadeUtils.ALLATORIxDEMO("p'5oj4*p?}<`(o9i6\n8v-{!\u0015");
        arrstring26[3] = Start.ALLATORIxDEMO("Y=\u001agBrS~[}@`CpH}R{8j*");
        arrstring26[4] = FadeUtils.ALLATORIxDEMO("!g.c>fe4!y,n1x>u8b:m:k+`;`");
        arrstring26[5] = Start.ALLATORIxDEMO("Og@uP*\u000bjOB|_hPyVv4xImDa*");
        arrstring26[6] = FadeUtils.ALLATORIxDEMO("p'5oj4*p?}<`(o9i6\f8v-{!\u0014");
        arrstring26[7] = Start.ALLATORIxDEMO("Og@uP*\u000bjOB|_hPyVv3xImDa*");
        arrstring26[8] = FadeUtils.ALLATORIxDEMO("f}%'}2l>d= |0w=m;\u0007*\u0016");
        arrstring26[9] = Start.ALLATORIxDEMO("wN4\u0006lK}SuRnSm[fR|Yu_t_");
        arrstring26[10] = FadeUtils.ALLATORIxDEMO("p'5oj4*p?}<`(o9i6\r8v-{!\u0014");
        arrstring26[11] = Start.ALLATORIxDEMO("Og@uP*\u000bjOB|_hPyVv2xImDa*");
        arrstring26[12] = FadeUtils.ALLATORIxDEMO("!g)d(p?n3kt6%l<w$~Dp#t'lXf&t6o");
        arrstring26[13] = Start.ALLATORIxDEMO("aXi[hOQsT4\teS|HdA\u0004OcKgS\u0019YfKvP");
        arrstring26[14] = FadeUtils.ALLATORIxDEMO("p'5oj4*p?}<`(o9i6\u000e8v-{!\u0014");
        arrstring26[15] = Start.ALLATORIxDEMO("XvQuPa@ZzG'\u0004}EfIo(aPeL}7w@vE{O");
        arrstring26[16] = FadeUtils.ALLATORIxDEMO("g6n5o!?e:xg;=z&v/\u0012!o%s=\t8v-{!\u0016");
        arrstring26[17] = Start.ALLATORIxDEMO("YvQrWwV%\u0000hU\\iQdKsJl_iAkDtW");
        arrstring26[18] = FadeUtils.ALLATORIxDEMO("p'5oj4*p?}<`(o9i6\u000e8v-{!\u0015");
        arrstring26[19] = Start.ALLATORIxDEMO("aXi[hOQsT4\teS|HdA\u0007OcKgS\u0019YfKvP");
        arrstring26[20] = FadeUtils.ALLATORIxDEMO("g6n5o!?e:xg;=z&v/\u0017!o%s=\t76z;p");
        arrstring26[21] = Start.ALLATORIxDEMO("Og@uP*\u000bjOB|_hPyVv0xImDa+");
        arrstring26[22] = FadeUtils.ALLATORIxDEMO("g6n5o!?e:xg;=z&v/\u0016!o%s=\b76z;p");
        arrstring26[23] = Start.ALLATORIxDEMO("Og@uP*\u000bjOB|_hPyVv0xImDa*");
        arrstring26[24] = FadeUtils.ALLATORIxDEMO("!g)d(p?n3kt6%l<w$~Fp#t'lYf3|1a");
        arrstring26[25] = Start.ALLATORIxDEMO("\u0004cDtQa@x]lQ}^oW>\u0011{=cRyPe.sU`CmYfKvP");
        arrstring26[26] = FadeUtils.ALLATORIxDEMO("4r(e(p8i%}.l7~d/0jDr?h?t]b=w8f&t6o");
        arrstring26[27] = Start.ALLATORIxDEMO("*\u0013jXXn@sTBpFyM?\u001a\u0011Z|T~J\u0000OcKgS\u001aYfKvP");
        arrstring26[28] = FadeUtils.ALLATORIxDEMO("f6n2h7ie?(j?c)n$t3r*l)~+{4h");
        arrstring26[29] = Start.ALLATORIxDEMO("wN4\u0006lK}SuRnSm[fR|Yg_w^");
        arrstring26[30] = FadeUtils.ALLATORIxDEMO("j,*g?g.3k?}0y9r%Qe<k>u@p#t'l\\f&t6o");
        arrstring26[31] = Start.ALLATORIxDEMO("XvQuPa@ZzG'\u0004}EfIo)aPeL}6xImDa)");
        arrstring26[32] = FadeUtils.ALLATORIxDEMO("j,*g?g.3k?}0y9r%Se<k>u@p#t'l\\f&t6o");
        arrstring26[33] = Start.ALLATORIxDEMO("XvQuPa@ZzG'\u0004}EfIoVtGmFlDiAkDtW");
        arrstring26[34] = FadeUtils.ALLATORIxDEMO("6p?r>f.4l)kj#+`'}#u4r)r6|'n*x<|");
        arrstring26[35] = Start.ALLATORIxDEMO("aXn\\~Y%\u000baFlQqG~Jx]\u001b5xImDa)");
        arrstring26[36] = FadeUtils.ALLATORIxDEMO("p4lh24j9c,n:f9~$t)ff8-f<l9b.f%o:l7v6q0v");
        String[] arrstring27 = new String[1];
        arrstring27[0] = Start.ALLATORIxDEMO("\\f]Y~BlLkdg]e@o");
        String[] arrstring28 = new String[2];
        arrstring28[0] = FadeUtils.ALLATORIxDEMO("t/a4c");
        arrstring28[1] = Start.ALLATORIxDEMO("JcDa^t\\");
        String[] arrstring29 = new String[5];
        arrstring29[0] = FadeUtils.ALLATORIxDEMO("\\\u001bP");
        arrstring29[1] = Start.ALLATORIxDEMO("GbTi");
        arrstring29[2] = FadeUtils.ALLATORIxDEMO("\u0007]\u0014V");
        arrstring29[3] = Start.ALLATORIxDEMO("GbTi");
        arrstring29[4] = FadeUtils.ALLATORIxDEMO("\u0007]\u0014V");
        String[] arrstring30 = new String[1];
        arrstring30[0] = Start.ALLATORIxDEMO("rYm\u0000&\u001c1\bm^qElK3KcW7\u001c>RpBq]'^iMn\u001f2");
        String[] arrstring31 = new String[1];
        arrstring31[0] = FadeUtils.ALLATORIxDEMO("e\rA)d\u000f_\u0002T)wD\u0013\nA\u0016P/b\u001eN\u001fI6h\u0007P\nA\u0010V");
        String[] arrstring32 = new String[1];
        arrstring32[0] = Start.ALLATORIxDEMO("I`E?\u001e2BmReZy\u001a2\u0011iCkM-\u0004&MdA2");
        String[] arrstring33 = new String[1];
        arrstring33[0] = FadeUtils.ALLATORIxDEMO("?I\u0014n\u0017U\u0018Dt*\u000b\\\u001dV\u0015S.p\u0003T\u0007L\rK;\\\u001bP");
        a.put(new Info(arrstring).cppTypes(arrstring2).translate(false)).put(new Info(arrstring3).cppTypes(arrstring4)).put(new Info(arrstring5).cppTypes(new String[0]).translate()).put(new Info(arrstring6).translate(false)).put(new Info(arrstring7).define().translate().cppTypes(arrstring8)).put(new Info(arrstring9).annotations(arrstring10)).put(new Info(arrstring11).annotations(new String[0])).put(new Info(arrstring12).cppTypes(new String[0]).annotations(new String[0])).put(new Info(arrstring13).annotations(arrstring14)).put(new Info(arrstring15).cast().valueTypes(arrstring16).pointerTypes(arrstring17)).put(new Info(arrstring18).cast().pointerTypes(arrstring19)).put(new Info(arrstring20).define()).put(new Info(arrstring21).define(false)).put(new Info(arrstring22).define(true)).put(new Info(arrstring23).skip()).put(new Info(arrstring24).translate(true).cppTypes(arrstring25)).put(new Info(arrstring26).translate(false).cppTypes(arrstring27)).put(new Info(arrstring28).cppTypes(arrstring29)).put(new Info(arrstring30).cast().pointerTypes(arrstring31)).put(new Info(arrstring32).pointerTypes(arrstring33));
    }

    @MemberGetter
    @Name(value={"AVERROR(ENOSYS)"})
    public static native int AVERROR_ENOSYS();

    @MemberGetter
    @Name(value={"AVERROR(EINTR)"})
    public static native int AVERROR_EINTR();

    @MemberGetter
    @Name(value={"AVERROR(EDOM)"})
    public static native int AVERROR_EDOM();

    @MemberGetter
    @Name(value={"AVERROR(EFBIG)"})
    public static native int AVERROR_EFBIG();

    @MemberGetter
    @Name(value={"AVERROR(EIO)"})
    public static native int AVERROR_EIO();

    @MemberGetter
    @Name(value={"AVERROR(EXDEV)"})
    public static native int AVERROR_EXDEV();

    public avutil() {
        avutil a;
    }

    @MemberGetter
    @Name(value={"AVERROR(ERANGE)"})
    public static native int AVERROR_ERANGE();

    @MemberGetter
    @Name(value={"AVERROR(EEXIST)"})
    public static native int AVERROR_EEXIST();

    @MemberGetter
    @Name(value={"AVERROR(ENOSPC)"})
    public static native int AVERROR_ENOSPC();

    @MemberGetter
    @Cast(value={"void (*)(void*, int, const char*, va_list)"})
    public static native Pointer av_log_default_callback();

    @MemberGetter
    @Name(value={"AVERROR(EBADF)"})
    public static native int AVERROR_EBADF();

    @MemberGetter
    @Name(value={"AVERROR(ESPIPE)"})
    public static native int AVERROR_ESPIPE();

    @MemberGetter
    @Name(value={"AVERROR(ENAMETOOLONG)"})
    public static native int AVERROR_ENAMETOOLONG();

    @MemberGetter
    @Name(value={"AVERROR(EPIPE)"})
    public static native int AVERROR_EPIPE();
}
