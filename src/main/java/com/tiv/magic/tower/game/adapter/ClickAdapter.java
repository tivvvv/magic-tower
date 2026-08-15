package com.tiv.magic.tower.game.adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 点击适配器
 */
public class ClickAdapter extends MouseAdapter {

    private final Runnable action;

    public ClickAdapter(Runnable action) {
        this.action = action;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        action.run();
    }

}
