package com.tiv.magic.tower.game.adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 退出游戏适配器
 */
public class GameExitAdapter extends MouseAdapter {

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        System.exit(0);
    }

}
