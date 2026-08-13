package com.tiv.magic.tower.game.panel;

import com.tiv.magic.tower.game.adapter.LabelHoverAdapter;
import com.tiv.magic.tower.game.constants.Constants;
import com.tiv.magic.tower.game.utils.FontUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.function.Consumer;

/**
 * 游戏介绍面板
 */
public class GameIntroPanel extends JPanel {

    /**
     * 标题字体大小
     */
    private static final float TITLE_FONT_SIZE = 60f;

    /**
     * 正文字体大小
     */
    private static final float TEXT_FONT_SIZE = 28f;

    /**
     * 返回按钮字体大小
     */
    private static final float BACK_FONT_SIZE = 40f;

    private final Consumer<String> navigate;

    private final JLabel title = new JLabel(Constants.INTRO);

    private final JTextArea description = new JTextArea(Constants.GAME_INTRO_TEXT);

    private final JLabel author = new JLabel(Constants.AUTHOR);

    private final JLabel link = new JLabel(Constants.GITHUB_LINK);

    private final JLabel back = new JLabel(Constants.BACK);

    public GameIntroPanel(Consumer<String> navigate) {
        this.navigate = navigate;
        super.setLayout(null);
        super.setName(getClass().getSimpleName());
        super.setBackground(Color.BLACK);
        initComponents();
    }

    private void initComponents() {
        Font cnFont = FontUtils.loadCnFont();

        // 标题
        title.setFont(cnFont.deriveFont(TITLE_FONT_SIZE));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(Constants.WIDTH / 2 - 120, 60, 240, 80);
        super.add(title);

        // 背景介绍
        description.setEditable(false);
        description.setFocusable(false);
        description.setOpaque(false);
        description.setBorder(null);
        description.setForeground(Color.WHITE);
        description.setFont(cnFont.deriveFont(TEXT_FONT_SIZE));
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setBounds(150, 180, Constants.WIDTH - 300, 250);
        super.add(description);

        // 作者
        author.setFont(cnFont.deriveFont(TEXT_FONT_SIZE));
        author.setForeground(Color.WHITE);
        author.setBounds(150, 460, 600, 40);
        super.add(author);

        // 链接
        link.setName(Constants.GITHUB_LINK);
        link.setFont(cnFont.deriveFont(TEXT_FONT_SIZE));
        link.setForeground(Color.CYAN);
        link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        link.setBounds(150, 510, 800, 40);
        link.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openLink(Constants.GITHUB_LINK);
            }
        });
        super.add(link);

        // 返回按钮
        back.setName(Constants.BACK);
        back.setFont(cnFont.deriveFont(BACK_FONT_SIZE));
        back.setForeground(Color.WHITE);
        back.setHorizontalAlignment(SwingConstants.CENTER);
        back.setBounds(Constants.WIDTH / 2 - 100, 700, 200, 60);
        back.addMouseListener(new LabelHoverAdapter());
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                navigate.accept(StartPanel.class.getSimpleName());
            }
        });
        super.add(back);
    }

    /**
     * 在浏览器中打开链接
     *
     * @param url 要打开的链接
     */
    private void openLink(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
