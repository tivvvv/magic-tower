package com.tiv.magic.tower.game.constants;

import java.io.InputStream;
import java.util.Properties;

public final class Constants {

    /**
     * 中文标题
     */
    public static final String CN_TITLE = "魔塔";

    /**
     * 英文标题
     */
    public static final String EN_TITLE = "MAGIC TOWER";

    /**
     * 版本号
     */
    public static final String VERSION = "(Ver " + loadAppVersion() + ")";

    /**
     * 开始游戏
     */
    public static final String PLAY = "开始游戏";

    /**
     * 保存游戏
     */
    public static final String SAVE = "保存游戏";

    /**
     * 游戏说明
     */
    public static final String INTRO = "游戏说明";

    /**
     * 退出游戏
     */
    public static final String QUIT = "退出游戏";

    /**
     * 窗口宽度
     */
    public static final int WIDTH = 1152;

    /**
     * 窗口高度
     */
    public static final int HEIGHT = 832 + 35;

    private static String loadAppVersion() {
        try (InputStream in = Constants.class.getResourceAsStream("/app.properties")) {
            Properties props = new Properties();
            props.load(in);
            return props.getProperty("app.version");
        } catch (Exception e) {
            return null;
        }
    }

}
