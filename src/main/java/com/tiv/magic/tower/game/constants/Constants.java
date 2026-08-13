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
     * 游戏介绍
     */
    public static final String INTRO = "游戏介绍";

    /**
     * 退出游戏
     */
    public static final String QUIT = "退出游戏";

    /**
     * 返回
     */
    public static final String BACK = "返回";

    /**
     * 作者
     */
    public static final String AUTHOR = "作者: tivvvv";

    /**
     * 项目链接
     */
    public static final String GITHUB_LINK = "https://github.com/tivvvv/magic-tower";

    /**
     * 游戏背景介绍
     */
    public static final String GAME_INTRO_TEXT = "在遥远的国度, 邪恶的魔王掳走了公主, 将她囚禁在魔塔之巅. 一位勇士响应国王号召, 毅然闯入魔塔. 塔内危机四伏, 每一层都盘踞着凶猛的怪物. 唯有披荆斩棘, 登临塔顶, 方能战胜魔王, 救回公主.";

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
