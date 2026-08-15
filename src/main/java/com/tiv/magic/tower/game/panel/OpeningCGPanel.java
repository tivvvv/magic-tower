package com.tiv.magic.tower.game.panel;

import com.tiv.magic.tower.game.constants.Constants;
import com.tiv.magic.tower.game.utils.FontUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.function.Consumer;

/**
 * 开场 CG 面板
 */
public class OpeningCGPanel extends JPanel {

    /**
     * CG 图片路径
     */
    private static final String CG_IMAGE_PATH = "/assets/images/849.png";

    /**
     * 每次滚动的像素
     */
    private static final int SCROLL_STEP = 3;

    /**
     * 滚动计时器间隔(毫秒)
     */
    private static final int SCROLL_DELAY = 30;

    /**
     * 提示闪烁间隔(毫秒)
     */
    private static final int BLINK_DELAY = 500;

    /**
     * 滚到底部后的停留时长(毫秒)
     */
    private static final int END_HOLD_DELAY = 1000;

    /**
     * 提示文字字体大小
     */
    private static final float HINT_FONT_SIZE = 24f;

    private final Consumer<String> navigateTo;

    private final BufferedImage cgImage;

    private final Font hintFont;

    /**
     * 当前滚动偏移
     */
    private int scrollY = 0;

    /**
     * 提示是否可见
     */
    private boolean hintVisible = true;

    /**
     * 动画是否已结束
     */
    private boolean finished = false;

    private final Timer scrollTimer;

    private final Timer blinkTimer;

    private final Timer holdTimer;

    public OpeningCGPanel(Consumer<String> navigateTo) {
        this.navigateTo = navigateTo;
        super.setLayout(null);
        super.setName(getClass().getSimpleName());
        super.setBackground(Color.BLACK);

        this.cgImage = loadImage();
        this.hintFont = FontUtils.loadCnFont().deriveFont(HINT_FONT_SIZE);

        this.scrollTimer = new Timer(SCROLL_DELAY, e -> scroll());
        this.blinkTimer = new Timer(BLINK_DELAY, e -> blink());
        this.holdTimer = new Timer(END_HOLD_DELAY, e -> finish());

        super.setFocusable(true);
        initListeners();
    }

    private void initListeners() {
        // 空格键跳过动画
        super.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    finish();
                }
            }
        });

        // 面板显示时开始动画, 隐藏时停止
        super.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                startAnimation();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                stopAnimation();
            }
        });
    }

    private void startAnimation() {
        scrollY = 0;
        hintVisible = true;
        finished = false;
        scrollTimer.start();
        blinkTimer.start();
        SwingUtilities.invokeLater(this::requestFocusInWindow);
    }

    private void stopAnimation() {
        scrollTimer.stop();
        blinkTimer.stop();
        holdTimer.stop();
    }

    private void scroll() {
        scrollY += SCROLL_STEP;
        int maxScrollY = getMaxScrollY();
        if (scrollY >= maxScrollY) {
            // 滚到底部, 停留一段时间再跳转
            scrollY = maxScrollY;
            scrollTimer.stop();
            holdTimer.start();
            super.repaint();
        } else {
            super.repaint();
        }
    }

    private void blink() {
        hintVisible = !hintVisible;
        super.repaint();
    }

    private void finish() {
        if (finished) {
            return;
        }
        finished = true;
        stopAnimation();
        navigateTo.accept(GamePanel.class.getSimpleName());
    }

    /**
     * 图片初始 Y 位置(屏幕高度的 1/3)
     */
    private int getStartY() {
        return super.getHeight() / 3;
    }

    private int getMaxScrollY() {
        return Math.max(0, cgImage.getHeight() + getStartY() - super.getHeight());
    }

    private BufferedImage loadImage() {
        BufferedImage source;
        try (InputStream in = getClass().getResourceAsStream(CG_IMAGE_PATH)) {
            if (in == null) {
                throw new IllegalStateException("CG 图片未找到: " + CG_IMAGE_PATH);
            }
            source = ImageIO.read(in);
        } catch (Exception e) {
            throw new IllegalStateException("CG 图片加载失败: " + CG_IMAGE_PATH, e);
        }

        // 转换为与屏幕兼容的图像, 避免每帧重绘时重复做颜色转换
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();
        BufferedImage compatible = gc.createCompatibleImage(
                source.getWidth(), source.getHeight(), Transparency.TRANSLUCENT);
        Graphics2D g = compatible.createGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return compatible;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (super.getWidth() - cgImage.getWidth()) / 2;
        int y = getStartY() - scrollY;
        g.drawImage(cgImage, x, y, null);

        if (hintVisible) {
            g.setFont(hintFont);
            g.setColor(Color.WHITE);
            FontMetrics fm = g.getFontMetrics();
            String hint = Constants.CG_SKIP_HINT;
            g.drawString(hint, super.getWidth() - fm.stringWidth(hint) - 30, 40);
        }
    }

}
