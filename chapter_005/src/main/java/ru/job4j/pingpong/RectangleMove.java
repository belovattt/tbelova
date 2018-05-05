package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int dx = 1;
        int dy = 1;
        boolean flag = true;
        while (flag) {
            if (Thread.interrupted()) {
                flag = false;
            }
            if ((this.rect.getX() == 300) || (this.rect.getX() == 0)) {
                dx = -dx;
            }
            if ((this.rect.getY() == 300) || (this.rect.getY() == 0)) {
                dy = -dy;
            }
            this.rect.setX(this.rect.getX() + dx);
            this.rect.setY(this.rect.getY() + dy);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                flag = false;
            }
        }
    }
}
