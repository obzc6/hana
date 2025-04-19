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

import dev.recollect.hana.api.utils.dev.TipUtils;
import org.bytedeco.ffmpeg.presets.avfilter;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(inherit={avfilter.class}, target="org.bytedeco.ffmpeg.avdevice", global="org.bytedeco.ffmpeg.global.avdevice", value={@Platform(cinclude={"<libavdevice/avdevice.h>", "<libavdevice/version_major.h>", "<libavdevice/version.h>"}, link={"avdevice@.60"}), @Platform(value={"windows"}, preload={"avdevice-60"})})
public class avdevice
implements InfoMapper {
    public void map(InfoMap infoMap) {
        avdevice a = infoMap;
        avdevice a2 = this;
        String[] arrstring = new String[1];
        arrstring[0] = TipUtils.ALLATORIxDEMO("\f4\u001a\u00147\u0007(\u0001\u0004\f#\u0005\u0005\u000f+\u0003");
        String[] arrstring2 = new String[1];
        arrstring2[0] = TipUtils.ALLATORIxDEMO("\f4\u001a\u00147\u0007(\u0001\u0004\f#\u0005\u0005\u000f+\u0003");
        String[] arrstring3 = new String[1];
        arrstring3[0] = TipUtils.ALLATORIxDEMO("5Pm,\u00107\u0012) ,\u0012?\u0013(\u0002\"\u0010$\u00076;<\u0003*\u000e");
        String[] arrstring4 = new String[1];
        arrstring4[0] = TipUtils.ALLATORIxDEMO("5Pm,\u00107\u0012) ,\u0012?\u0013(\u0002\"\u0010$\u00076;<\u0003*\u000e");
        String[] arrstring5 = new String[1];
        arrstring5[0] = TipUtils.ALLATORIxDEMO("=\u0005!\f4\u001a4\u0017'\b!\u00124\u00008\u001a/\u00179");
        String[] arrstring6 = new String[2];
        arrstring6[0] = TipUtils.ALLATORIxDEMO("e\u0000$\u001f'\b&\u001b+\u001d4\u001e8\u000e6\u001e+\n$\u0016/\u0016#");
        arrstring6[1] = TipUtils.ALLATORIxDEMO("/\u0004 \u001f'\u0005+\u001d-\u000e'\u001a#\r#\u0016#");
        String[] arrstring7 = new String[1];
        arrstring7[0] = TipUtils.ALLATORIxDEMO("\u001d2Yh\u0019/\u00015\t5\u0004!\u001b.\u0002/\u001b%\u000f+\t#\u001d/\u001d$");
        String[] arrstring8 = new String[1];
        arrstring8[0] = TipUtils.ALLATORIxDEMO("+\t7\u001b");
        String[] arrstring9 = new String[1];
        arrstring9[0] = TipUtils.ALLATORIxDEMO("(\u0010\u0001\u0015)\u0015$\u0001;.\"\u000f;\u0005/\u000b)\u0003=\u000f=\u0004");
        a.putFirst(new Info(arrstring).pointerTypes(arrstring2)).putFirst(new Info(arrstring3).pointerTypes(arrstring4)).put(new Info(arrstring5).cppTypes(new String[0])).put(new Info(arrstring6).translate(false)).put(new Info(arrstring7).define().translate().cppTypes(arrstring8)).put(new Info(arrstring9).skip());
    }

    public avdevice() {
        avdevice a;
    }
}
