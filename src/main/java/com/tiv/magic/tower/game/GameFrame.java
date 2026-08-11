package com.tiv.magic.tower.game;

import com.tiv.magic.tower.game.constants.Constants;
import com.tiv.magic.tower.game.panel.GamePanel;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏窗口.
 */
public class GameFrame extends JFrame {

    private final int width = 1152;

    private final int height = 832 + 35;

    GamePanel gamePanel = new GamePanel();

    public GameFrame() throws HeadlessException {
        // 窗口标题
        super.setTitle(Constants.CN_TITLE);
        // 窗口大小
        super.setSize(width, height);
        // 窗口位置
        super.setLocationRelativeTo(null);

        // 把面板加入窗口
        super.add(gamePanel);

        // 设置关闭窗口时退出程序
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口显示
        super.setVisible(true);
    }

}
