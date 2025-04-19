/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2665
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_332
 */
package dev.recollect.hana.mod.modules.impl.client.dev;

import dev.recollect.hana.api.utils.dev.TimeHelper;
import dev.recollect.hana.api.utils.entity.InventoryUtil;
import dev.recollect.hana.api.utils.math.RadiusUtils;
import dev.recollect.hana.mod.modules.Module;
import dev.recollect.hana.mod.modules.settings.impl.BooleanSetting;
import dev.recollect.hana.mod.modules.settings.impl.SliderSetting;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2665;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_332;

public class ItemsCount
extends Module {
    int x;
    private final SliderSetting offset;
    class_1799 webStack;
    public final BooleanSetting enderChest;
    class_1799 xpStack;
    public final BooleanSetting obsidian;
    class_332 drawContext;
    class_1799 pearlStack;
    class_1799 pistonStack;
    class_1799 anchorStack;
    class_1799 enderChestStack;
    private final SliderSetting xOffset;
    public final BooleanSetting crystal;
    class_1799 glowstoneStack;
    class_1799 gappleStack;
    public static ItemsCount INSTANCE;
    public final BooleanSetting glowstone;
    int y;
    public final BooleanSetting hideEmpty;
    public final BooleanSetting gApple;
    public final BooleanSetting piston;
    class_1799 totemStack;
    private final SliderSetting yOffset;
    class_1799 crystalStack;
    public final BooleanSetting xp;
    public final BooleanSetting pearl;
    public final BooleanSetting anchor;
    class_1799 obsidianStack;
    public final BooleanSetting web;
    public final BooleanSetting redstone;
    class_1799 redstoneStack;
    public final BooleanSetting totem;

    public ItemsCount() {
        ItemsCount a;
        ItemsCount itemsCount = a;
        ItemsCount itemsCount2 = a;
        super(TimeHelper.ALLATORIxDEMO("+I\u001a\u001aF"), Module.Category.Client);
        ItemsCount itemsCount3 = a;
        itemsCount3.xOffset = itemsCount2.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("o"), 100, 0, 1500));
        itemsCount2.yOffset = itemsCount2.add(new SliderSetting(TimeHelper.ALLATORIxDEMO("l"), 100, 0, 1000));
        itemsCount2.offset = itemsCount2.add(new SliderSetting(RadiusUtils.ALLATORIxDEMO("{\u0006O\u000e\u0006C"), 18, 0, 30));
        itemsCount2.hideEmpty = itemsCount2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("*N\u0001E'P\u000f\u0003L"), true));
        itemsCount2.crystal = itemsCount2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("$F\u0019Z\t\u0002["), true));
        itemsCount2.xp = itemsCount2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("/e"), true));
        itemsCount2.pearl = itemsCount2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("0L\u001c\u0011["), true));
        itemsCount2.obsidian = itemsCount2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("h\u0007S\u000bY\u0016\u0016["), true));
        itemsCount2.gApple = itemsCount2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("s!Y\r\u000fR"), true));
        itemsCount2.totem = itemsCount2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("6R\u000b\u0012X"), true));
        itemsCount2.web = itemsCount2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("*\u0006U"), true));
        itemsCount2.anchor = itemsCount2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("a\f^\u0017\u0018G"), true));
        itemsCount2.glowstone = itemsCount2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("'_\bC\u0013]\u0012\rR"), true));
        itemsCount2.piston = itemsCount2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("p\u000bN\u000b\u0018["), true));
        itemsCount2.redstone = itemsCount2.add(new BooleanSetting(RadiusUtils.ALLATORIxDEMO("a\u0002P3]\u0012\rR"), true));
        itemsCount2.enderChest = itemsCount2.add(new BooleanSetting(TimeHelper.ALLATORIxDEMO("e\fC\u0000R!U\u001a\u0004A"), true));
        itemsCount2.crystalStack = new class_1799((class_1935)class_1802.field_8301);
        itemsCount2.xpStack = new class_1799((class_1935)class_1802.field_8287);
        itemsCount2.pearlStack = new class_1799((class_1935)class_1802.field_8634);
        itemsCount2.obsidianStack = new class_1799((class_1935)class_1802.field_8281);
        itemsCount2.gappleStack = new class_1799((class_1935)class_1802.field_8367);
        itemsCount2.totemStack = new class_1799((class_1935)class_1802.field_8288);
        itemsCount2.webStack = new class_1799((class_1935)class_1802.field_8786);
        itemsCount2.anchorStack = new class_1799((class_1935)class_1802.field_23141);
        itemsCount2.glowstoneStack = new class_1799((class_1935)class_1802.field_8801);
        itemsCount2.pistonStack = new class_1799((class_1935)class_1802.field_8249);
        itemsCount2.redstoneStack = new class_1799((class_1935)class_1802.field_8793);
        itemsCount.enderChestStack = new class_1799((class_1935)class_1802.field_8466);
        itemsCount.setChinese(RadiusUtils.ALLATORIxDEMO("\u7240\u54bc\u665d\u790d"));
        INSTANCE = itemsCount;
    }

    @Override
    public void onRender2D(class_332 class_3322, float f) {
        ItemsCount a;
        ItemsCount a2 = class_3322;
        ItemsCount itemsCount = a = this;
        itemsCount.drawContext = a2;
        a.x = itemsCount.xOffset.getValueInt() - a.offset.getValueInt();
        itemsCount.y = itemsCount.yOffset.getValueInt();
        if (itemsCount.crystal.getValue()) {
            ItemsCount itemsCount2 = a;
            ItemsCount itemsCount3 = a;
            itemsCount2.crystalStack.method_7939(itemsCount3.getItemCount(class_1802.field_8301));
            itemsCount3.drawItem(itemsCount2.crystalStack);
        }
        if (a.xp.getValue()) {
            ItemsCount itemsCount4 = a;
            ItemsCount itemsCount5 = a;
            itemsCount4.xpStack.method_7939(itemsCount5.getItemCount(class_1802.field_8287));
            itemsCount5.drawItem(itemsCount4.xpStack);
        }
        if (a.pearl.getValue()) {
            ItemsCount itemsCount6 = a;
            ItemsCount itemsCount7 = a;
            itemsCount6.pearlStack.method_7939(itemsCount7.getItemCount(class_1802.field_8634));
            itemsCount7.drawItem(itemsCount6.pearlStack);
        }
        if (a.obsidian.getValue()) {
            ItemsCount itemsCount8 = a;
            ItemsCount itemsCount9 = a;
            itemsCount8.obsidianStack.method_7939(itemsCount9.getItemCount(class_1802.field_8281));
            itemsCount9.drawItem(itemsCount8.obsidianStack);
        }
        if (a.gApple.getValue()) {
            ItemsCount itemsCount10 = a;
            ItemsCount itemsCount11 = a;
            itemsCount10.gappleStack.method_7939(itemsCount11.getItemCount(class_1802.field_8367));
            itemsCount11.drawItem(itemsCount10.gappleStack);
        }
        if (a.totem.getValue()) {
            ItemsCount itemsCount12 = a;
            ItemsCount itemsCount13 = a;
            itemsCount12.totemStack.method_7939(itemsCount13.getItemCount(class_1802.field_8288));
            itemsCount13.drawItem(itemsCount12.totemStack);
        }
        if (a.web.getValue()) {
            ItemsCount itemsCount14 = a;
            ItemsCount itemsCount15 = a;
            itemsCount14.webStack.method_7939(itemsCount15.getItemCount(class_1802.field_8786));
            itemsCount15.drawItem(itemsCount14.webStack);
        }
        if (a.anchor.getValue()) {
            ItemsCount itemsCount16 = a;
            ItemsCount itemsCount17 = a;
            itemsCount16.anchorStack.method_7939(itemsCount17.getItemCount(class_1802.field_23141));
            itemsCount17.drawItem(itemsCount16.anchorStack);
        }
        if (a.glowstone.getValue()) {
            ItemsCount itemsCount18 = a;
            ItemsCount itemsCount19 = a;
            itemsCount18.glowstoneStack.method_7939(itemsCount19.getItemCount(class_1802.field_8801));
            itemsCount19.drawItem(itemsCount18.glowstoneStack);
        }
        if (a.piston.getValue() && ((a2 = InventoryUtil.getItemCount(class_2665.class)) > 0 || !a.hideEmpty.getValue())) {
            ItemsCount itemsCount20 = a;
            ItemsCount itemsCount21 = a;
            itemsCount20.x += itemsCount21.offset.getValueInt();
            itemsCount21.pistonStack.method_7939(Math.max(1, a2));
            itemsCount20.drawItem(itemsCount20.pistonStack);
        }
        if (a.redstone.getValue()) {
            ItemsCount itemsCount22 = a;
            ItemsCount itemsCount23 = a;
            itemsCount22.redstoneStack.method_7939(itemsCount23.getItemCount(class_1802.field_8793));
            itemsCount23.drawItem(itemsCount22.redstoneStack);
        }
        if (a.enderChest.getValue()) {
            ItemsCount itemsCount24 = a;
            ItemsCount itemsCount25 = a;
            itemsCount24.enderChestStack.method_7939(itemsCount25.getItemCount(class_1802.field_8466));
            itemsCount25.drawItem(itemsCount24.enderChestStack);
        }
    }

    private /* synthetic */ void drawItem(class_1799 class_17992) {
        ItemsCount a;
        ItemsCount a2 = class_17992;
        ItemsCount itemsCount = a = this;
        a.drawContext.method_51427((class_1799)a2, itemsCount.x, a.y);
        ItemsCount itemsCount2 = a;
        itemsCount.drawContext.method_51431(ItemsCount.mc.field_1772, (class_1799)a2, itemsCount2.x, itemsCount2.y);
    }

    private /* synthetic */ int getItemCount(class_1792 class_17922) {
        ItemsCount a22 = class_17922;
        ItemsCount a = this;
        int a22 = InventoryUtil.getItemCount((class_1792)a22);
        if (a.hideEmpty.getValue() && a22 == 0) {
            return 0;
        }
        a.x += a.offset.getValueInt();
        return Math.max(a22, 1);
    }
}
