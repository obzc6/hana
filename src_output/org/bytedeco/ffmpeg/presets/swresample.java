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

import dev.recollect.hana.api.utils.dev.BOEntityUtils;
import dev.recollect.hana.socket.network.info.record.GameInfo;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;

@Properties(inherit={avutil.class}, target="org.bytedeco.ffmpeg.swresample", global="org.bytedeco.ffmpeg.global.swresample", value={@Platform(cinclude={"<libswresample/swresample.h>", "<libswresample/version_major.h>", "<libswresample/version.h>"}, link={"swresample@.4"}), @Platform(value={"windows"}, preload={"swresample-4"})})
public class swresample
implements InfoMapper {
    public void map(InfoMap infoMap) {
        swresample a = infoMap;
        swresample a2 = this;
        String[] arrstring = new String[1];
        arrstring[0] = BOEntityUtils.ALLATORIxDEMO("=InWShE{M|^{AdF}LzYt");
        String[] arrstring2 = new String[2];
        arrstring2[0] = GameInfo.ALLATORIxDEMO("]GT\u0000\u001c\\SYSBGTEQ@YVCAB[N@VT");
        arrstring2[1] = BOEntityUtils.ALLATORIxDEMO("`MjRzDSm_nRw\\f[vXn");
        a.put(new Info(arrstring).cppTypes(new String[0])).put(new Info(arrstring2).translate(false));
    }

    public swresample() {
        swresample a;
    }
}
