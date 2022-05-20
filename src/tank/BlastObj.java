package tank;


import java.awt.*;

public class BlastObj extends GameObject {

    static Image[] imgs = new Image[3];

    int explodeCount = 0;

    public static void init() { // 初始化
        for (int i = 0; i < 3; i++) {
            imgs[i] = Toolkit.getDefaultToolkit().getImage("images/blast/blast" +(i + 1)+".png");
        }
    }

    public BlastObj() {
        super();
    }

    public BlastObj(int x, int y) {
        this.x = x;
        this.y = y;
        init();
    }

    @Override
    public void paintSelf(Graphics g) {
        //绘制点击爆炸效果(连续绘制)
        if (explodeCount < 3 && explodeCount>=0){
            g.drawImage(imgs[explodeCount],x,y,null);
            explodeCount++;
        }
    }

    @Override
    public Rectangle getRec() {
        return null;
    }
}

