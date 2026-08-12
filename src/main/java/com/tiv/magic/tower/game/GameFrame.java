package com.tiv.magic.tower.game;

import com.tiv.magic.tower.game.constants.Constants;
import com.tiv.magic.tower.game.panel.GamePanel;
import com.tiv.magic.tower.game.panel.StartPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏窗口.
 */
public class GameFrame extends JFrame {

    GamePanel gamePanel = new GamePanel();

    StartPanel startPanel = new StartPanel();

    public GameFrame() throws HeadlessException {
        // 窗口标题
        super.setTitle(Constants.CN_TITLE);
        // 窗口大小
        super.setSize(Constants.WIDTH, Constants.HEIGHT);
        // 窗口位置
        super.setLocationRelativeTo(null);

        // 把面板加入窗口
        super.add(startPanel);

        // 设置关闭窗口时退出程序
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置窗口显示
        super.setVisible(true);
    }

}
