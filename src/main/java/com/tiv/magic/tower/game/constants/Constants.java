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
     * 版本号默认值
     */
    private static final String DEFAULT_VERSION = "1.0";

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
     * 开场 CG 跳过提示
     */
    public static final String CG_SKIP_HINT = "按空格跳过动画";

    /**
     * 窗口宽度
     */
    public static final int WIDTH = 1152;

    /**
     * 标题栏高度
     */
    private static final int TITLE_BAR_HEIGHT = 35;

    /**
     * 窗口高度
     */
    public static final int HEIGHT = 832 + TITLE_BAR_HEIGHT;

    private static String loadAppVersion() {
        try (InputStream in = Constants.class.getResourceAsStream("/app.properties")) {
            if (in == null) {
                return DEFAULT_VERSION;
            }
            Properties props = new Properties();
            props.load(in);
            String version = props.getProperty("app.version");
            if (version == null || version.startsWith("${")) {
                return DEFAULT_VERSION;
            }
            return version;
        } catch (Exception e) {
            return DEFAULT_VERSION;
        }
    }

}
