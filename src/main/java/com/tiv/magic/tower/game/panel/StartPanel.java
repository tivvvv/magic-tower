package com.tiv.magic.tower.game.panel;

import com.tiv.magic.tower.game.adapter.LabelHoverAdapter;
import com.tiv.magic.tower.game.constants.Constants;
import com.tiv.magic.tower.game.utils.FontUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Consumer;

/**
 * 开始面板
 */
public class StartPanel extends JPanel {

    /**
     * 标题字体大小
     */
    private static final float TITLE_FONT_SIZE = 80f;

    /**
     * 菜单项字体大小
     */
    private static final float MENU_FONT_SIZE = 50f;

    /**
     * 版本号字体大小
     */
    private static final float VERSION_FONT_SIZE = 40f;

    /**
     * 菜单项宽度
     */
    private static final int MENU_ITEM_WIDTH = 200;

    /**
     * 菜单项高度
     */
    private static final int MENU_ITEM_HEIGHT = 80;

    /**
     * 菜单项起始 Y 坐标
     */
    private static final int MENU_START_Y = 380;

    /**
     * 菜单项间距
     */
    private static final int MENU_ITEM_GAP = 100;

    /**
     * 菜单项 X 坐标
     */
    private static final int MENU_ITEM_X = Constants.WIDTH / 2 - MENU_ITEM_WIDTH / 2;

    private final JLabel cnTitle = new JLabel(Constants.CN_TITLE);

    private final JLabel enTitle = new JLabel(Constants.EN_TITLE);

    private final JLabel version = new JLabel(Constants.VERSION);

    private final JLabel play = new JLabel(Constants.PLAY);

    private final JLabel save = new JLabel(Constants.SAVE);

    private final JLabel intro = new JLabel(Constants.INTRO);

    private final JLabel quit = new JLabel(Constants.QUIT);

    private final LabelHoverAdapter labelHoverAdapter = new LabelHoverAdapter();

    private final Consumer<String> navigate;

    public StartPanel(Consumer<String> navigate) {
        this.navigate = navigate;
        super.setLayout(null);
        super.setName(getClass().getSimpleName());
        super.setBackground(Color.BLACK);
        initComponents();
    }

    private void initComponents() {
        Font cnFont = FontUtils.loadCnFont();
        Font enFont = FontUtils.loadEnFont();

        // 中文标题
        cnTitle.setFont(cnFont.deriveFont(TITLE_FONT_SIZE));
        cnTitle.setForeground(Color.WHITE);
        cnTitle.setBounds(Constants.WIDTH / 2 - 80, 40, 160, 80);
        super.add(cnTitle);

        // 英文标题
        enTitle.setFont(enFont.deriveFont(TITLE_FONT_SIZE));
        enTitle.setForeground(Color.WHITE);
        enTitle.setBounds(Constants.WIDTH / 2 - 170, 150, 350, 180);
        super.add(enTitle);

        // 版本号
        version.setFont(cnFont.deriveFont(VERSION_FONT_SIZE));
        version.setForeground(Color.WHITE);
        version.setBounds(Constants.WIDTH / 2 - 80, 280, 160, 80);
        super.add(version);

        // 菜单项
        addMenuItem(play, cnFont, 0);
        addMenuItem(save, cnFont, 1);
        addMenuItem(intro, cnFont, 2);
        addMenuItem(quit, cnFont, 3);

        // 游戏介绍: 点击进入介绍面板
        intro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                navigate.accept(GameIntroPanel.class.getSimpleName());
            }
        });
    }

    private void addMenuItem(JLabel label, Font font, int index) {
        label.setName(label.getText());
        label.setFont(font.deriveFont(MENU_FONT_SIZE));
        label.setForeground(Color.WHITE);
        label.setBounds(MENU_ITEM_X, MENU_START_Y + index * MENU_ITEM_GAP, MENU_ITEM_WIDTH, MENU_ITEM_HEIGHT);
        label.addMouseListener(labelHoverAdapter);
        super.add(label);
    }

}
