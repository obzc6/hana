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

import dev.recollect.hana.api.utils.dev.NCPRaytracer;
import org.bytedeco.ffmpeg.presets.avutil;
import org.bytedeco.javacpp.annotation.Platform;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.tools.Info;
import org.bytedeco.javacpp.tools.InfoMap;
import org.bytedeco.javacpp.tools.InfoMapper;
import org.bytedeco.javacv.FrameConverter;

@Properties(inherit={avutil.class}, target="org.bytedeco.ffmpeg.postproc", global="org.bytedeco.ffmpeg.global.postproc", value={@Platform(cinclude={"<libpostproc/postprocess.h>", "<libpostproc/version_major.h>", "<libpostproc/version.h>"}, link={"postproc@.57"}, extension={"-gpl"}), @Platform(value={"windows"}, preload={"postproc-57"}, extension={"-gpl"})})
public class postproc
implements InfoMapper {
    public void map(InfoMap infoMap) {
        postproc a = infoMap;
        postproc a2 = this;
        String[] arrstring = new String[1];
        arrstring[0] = FrameConverter.ALLATORIxDEMO("%G'H\"Z(\\4\\");
        String[] arrstring2 = new String[1];
        arrstring2[0] = NCPRaytracer.ALLATORIxDEMO("fR|B");
        String[] arrstring3 = new String[1];
        arrstring3[0] = FrameConverter.ALLATORIxDEMO("H\rc\u001dK\u0019|\u0014m\u000ez");
        String[] arrstring4 = new String[1];
        arrstring4[0] = NCPRaytracer.ALLATORIxDEMO("{\f(K{WHePsDb\\dWbGi");
        String[] arrstring5 = new String[3];
        arrstring5[0] = FrameConverter.ALLATORIxDEMO("\u001a\"J$X;_?^$K6\\1E+R9[%P%\\");
        arrstring5[1] = NCPRaytracer.ALLATORIxDEMO("&RvTdKcObTwFtQbDc");
        arrstring5[2] = FrameConverter.ALLATORIxDEMO("G&N;G:^$E7X)\\>\\%\\");
        String[] arrstring6 = new String[1];
        arrstring6[0] = NCPRaytracer.ALLATORIxDEMO("\t#YdVeZqJxM~IuJd\f%UkMeL\u0017#\u00103\u0001+\n8\u001a>\u000e");
        a.put(new Info(arrstring).cppTypes(new String[0]).valueTypes(arrstring2).pointerTypes(arrstring3)).put(new Info(arrstring4).cppTypes(new String[0])).put(new Info(arrstring5).skip()).put(new Info(arrstring6).define(false));
    }

    public postproc() {
        postproc a;
    }
}
