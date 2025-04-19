/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  org.bytedeco.javacpp.annotation.Platform
 *  org.bytedeco.javacpp.annotation.Properties
 *  org.bytedeco.javacpp.tools.Info
 *  org.bytedeco.javacpp.tools.InfoMap
 *  org.bytedeco.javacpp.tools.InfoMapper
 */
package org.bytedeco.ffmpeg.presets;

import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.mod.modules.impl.render.freelook.CameraState;
import org.bytedeco.ffmpeg.presets.avformat;
import org.bytedeco.ffmpeg.presets.postproc;
import org.bytedeco.ffmpeg.presets.swresample;
import org.bytedeco.ffmpeg.presets.swscale;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(inherit={avformat.class, postproc.class, swresample.class, swscale.class}, target="org.bytedeco.ffmpeg.avfilter", global="org.bytedeco.ffmpeg.global.avfilter", value={@Platform(cinclude={"<libavfilter/avfilter.h>", "<libavfilter/buffersink.h>", "<libavfilter/buffersrc.h>", "<libavfilter/version_major.h>", "<libavfilter/version.h>"}, link={"avfilter@.9"}), @Platform(value={"windows"}, preload={"avfilter-9"})})
public class avfilter
implements InfoMapper {
    public avfilter() {
        avfilter a;
    }

    public void map(InfoMap infoMap) {
        avfilter a = infoMap;
        avfilter a2 = this;
        String[] arrstring = new String[4];
        arrstring[0] = CameraState.ALLATORIxDEMO("\u001b`\u0013P<H-V\tZ!N");
        arrstring[1] = TimeHelper.ALLATORIxDEMO("#s!T\u0013X\u000bI:K\u000bE\u000bW\u001f");
        arrstring[2] = CameraState.ALLATORIxDEMO("\tr\tJ~\n8C\tN;X;\\<p)]6@:Q");
        arrstring[3] = TimeHelper.ALLATORIxDEMO("{9j\u001cZ\u0014A7]\u000fL\u001e");
        String[] arrstring2 = new String[1];
        arrstring2[0] = CameraState.ALLATORIxDEMO("l'M7A+P");
        String[] arrstring3 = new String[1];
        arrstring3[0] = TimeHelper.ALLATORIxDEMO("1f/a4c.q+i<d/a4{#v5");
        String[] arrstring4 = new String[2];
        arrstring4[0] = CameraState.ALLATORIxDEMO("y\u0001f\u000euT7\u0011e\u000ft\u0005`\u0010k\u0003u\u0007j\u0006|\u0000v");
        arrstring4[1] = TimeHelper.ALLATORIxDEMO("!i d1{6`:~+{/l/w/");
        String[] arrstring5 = new String[4];
        arrstring5[0] = CameraState.ALLATORIxDEMO("s\u000e{\u000es[!\u000ef\u0019y\nw\u0007x\u001dc\u0007t\r|\u0001l");
        arrstring5[1] = TimeHelper.ALLATORIxDEMO("cn5~-f2b7c!x-'u2{'d&v8");
        arrstring5[2] = CameraState.ALLATORIxDEMO("\u001bw\u0015g\n\ni\u0011x\u0017g\u0016`\u0000v");
        arrstring5[3] = TimeHelper.ALLATORIxDEMO("n,`<$.l%m3m-~;k9g:m(");
        String[] arrstring6 = new String[1];
        arrstring6[0] = CameraState.ALLATORIxDEMO(";Z!N");
        String[] arrstring7 = new String[1];
        arrstring7[0] = TimeHelper.ALLATORIxDEMO(")p;/dy(p$j%v6|/z%%i|$w0n/l'm,t_F\u0004G\u0004n,`<$-i#b8~/k1{6i8j>");
        String[] arrstring8 = new String[2];
        arrstring8[0] = CameraState.ALLATORIxDEMO("_\u001bw\u0015g\n\n\u001fs\u0017g\u0016`\u0000v");
        arrstring8[1] = TimeHelper.ALLATORIxDEMO("i++k3x-b/w&b/m&}(");
        a.put(new Info(arrstring).cast().pointerTypes(arrstring2)).put(new Info(arrstring3).cppTypes(new String[0])).put(new Info(arrstring4).translate(false)).put(new Info(arrstring5).define().translate().cppTypes(arrstring6)).put(new Info(arrstring7).define(true)).put(new Info(arrstring8).define(false));
    }
}
