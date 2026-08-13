package com.tiv.magic.tower.game.adapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 标签悬停效果适配器
 * <p>
 * 鼠标移入时标签文字变为红色, 移出时恢复原来的颜色, 用于菜单项等可交互标签的悬停反馈
 */
public class LabelHoverAdapter extends MouseAdapter {

    /**
     * 悬停时文字颜色
     */
    private static final Color HOVER_COLOR = Color.RED;

    /**
     * 用于在组件上暂存原始颜色的 key
     */
    private static final String ORIGINAL_FOREGROUND = "originalForeground";

    /**
     * 鼠标移入
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        JComponent component = (JComponent) e.getComponent();
        component.putClientProperty(ORIGINAL_FOREGROUND, component.getForeground());
        component.setForeground(HOVER_COLOR);
    }

    /**
     * 鼠标移出
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        JComponent component = (JComponent) e.getComponent();
        Object original = component.getClientProperty(ORIGINAL_FOREGROUND);
        if (original instanceof Color color) {
            component.setForeground(color);
        }
    }

}
