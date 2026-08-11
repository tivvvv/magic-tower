package com.tiv.magic.tower.game.panel;

import javax.swing.*;
import java.awt.*;

/**
 * 游戏面板
 */
public class GamePanel extends JPanel {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Hello, world!", 200, 200);
    }

}
