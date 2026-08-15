package com.tiv.magic.tower.game;

import com.tiv.magic.tower.game.constants.Constants;
import com.tiv.magic.tower.game.panel.GameIntroPanel;
import com.tiv.magic.tower.game.panel.GamePanel;
import com.tiv.magic.tower.game.panel.OpeningCGPanel;
import com.tiv.magic.tower.game.panel.StartPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏窗口
 */
public class GameFrame extends JFrame {

    private final CardLayout cardLayout = new CardLayout();

    private final JPanel contentPanel = new JPanel(cardLayout);

    private final StartPanel startPanel;

    private final GamePanel gamePanel;

    private final GameIntroPanel gameIntroPanel;

    private final OpeningCGPanel openingCGPanel;

    public GameFrame() throws HeadlessException {
        startPanel = new StartPanel(this::showPanel);
        gamePanel = new GamePanel();
        gameIntroPanel = new GameIntroPanel(this::showPanel);
        openingCGPanel = new OpeningCGPanel(this::showPanel);

        // 窗口标题
        super.setTitle(Constants.CN_TITLE);
        // 窗口大小
        super.setSize(Constants.WIDTH, Constants.HEIGHT);
        // 窗口位置
        super.setLocationRelativeTo(null);
        // 禁止缩放窗口
        super.setResizable(false);

        // 把面板加入窗口
        addPanels();

        // 设置关闭窗口时退出程序
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口显示
        super.setVisible(true);
    }

    /**
     * 把面板加入窗口
     */
    private void addPanels() {
        contentPanel.add(startPanel, StartPanel.class.getSimpleName());
        contentPanel.add(openingCGPanel, OpeningCGPanel.class.getSimpleName());
        contentPanel.add(gamePanel, GamePanel.class.getSimpleName());
        contentPanel.add(gameIntroPanel, GameIntroPanel.class.getSimpleName());
        super.add(contentPanel);
    }

    /**
     * 切换面板
     *
     * @param name 面板名称
     */
    private void showPanel(String name) {
        cardLayout.show(contentPanel, name);
    }

}
