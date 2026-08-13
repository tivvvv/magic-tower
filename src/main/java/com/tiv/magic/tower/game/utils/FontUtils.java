package com.tiv.magic.tower.game.utils;

import java.awt.*;
import java.io.InputStream;

/**
 * 字体工具类
 */
public class FontUtils {

    private static final String CN_FONT_PATH = "/assets/fonts/font_cn.ttf";

    private static final String EN_FONT_PATH = "/assets/fonts/font_en.ttf";

    /**
     * 加载中文字体
     *
     * @return
     */
    public static Font loadCnFont() {
        return loadFont(CN_FONT_PATH);
    }

    /**
     * 加载英文字体
     *
     * @return
     */
    public static Font loadEnFont() {
        return loadFont(EN_FONT_PATH);
    }

    /**
     * 从类路径加载字体
     */
    private static Font loadFont(String path) {
        try (InputStream fontStream = FontUtils.class.getResourceAsStream(path)) {
            if (fontStream == null) {
                throw new RuntimeException("字体文件未找到: " + path);
            }
            return Font.createFont(Font.TRUETYPE_FONT, fontStream);
        } catch (Exception e) {
            throw new RuntimeException("字体加载失败: " + path, e);
        }
    }

}
