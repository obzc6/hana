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

import dev.recollect.hana.socket.network.packet.Packet;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;
import org.bytedeco.javacv.BufferRing;

@Properties(inherit={avutil.class}, target="org.bytedeco.ffmpeg.swscale", global="org.bytedeco.ffmpeg.global.swscale", value={@Platform(cinclude={"<libswscale/swscale.h>", "<libswscale/version_major.h>", "<libswscale/version.h>"}, link={"swscale@.7"}), @Platform(value={"windows"}, preload={"swscale-7"})})
public class swscale
implements InfoMapper {
    public swscale() {
        swscale a;
    }

    public void map(InfoMap infoMap) {
        swscale a = infoMap;
        swscale a2 = this;
        String[] arrstring = new String[1];
        arrstring[0] = Packet.ALLATORIxDEMO("Eg\u0016 ^}NkEkFh^nExPv");
        String[] arrstring2 = new String[2];
        arrstring2[0] = BufferRing.ALLATORIxDEMO("Bs\u00114\u00000\u0010&\u000f2\u001e#\t*\u00168\u00027\u001e<\u001e0");
        arrstring2[1] = Packet.ALLATORIxDEMO("\u0018:K}ZyJoU{DuRtQl");
        a.put(new Info(arrstring).cppTypes(new String[0])).put(new Info(arrstring2).translate(false));
    }
}
