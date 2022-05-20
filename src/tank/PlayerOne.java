package tank;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerOne extends Tank {
    private boolean up = false;
    private boolean left = false;
    private boolean right = false;
    private boolean down = false;

    public PlayerOne(Image img, int x, int y, Image upImage, Image downImage, Image leftImage, Image rightImage, GamePanel gamePanel){
        super(img, x, y, upImage, downImage, leftImage, rightImage, gamePanel);
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_SPACE:
                this.attack();
                break;
            case KeyEvent.VK_G: // 开挂：清除现存敌方坦克中存活最久的一个
                Bot b = this.gamePanel.botList.remove(0);
                gamePanel.botList.remove(b);
                gamePanel.blastList.add(new BlastObj(b.x, b.y));
                break;
                //TODO g
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        switch (key){
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
            case KeyEvent.VK_W:
                up = false;
                break;
            default:
                break;
        }
    }

    public void move(){ // 根据状态前进/停止
        if(left){
            leftward();
        }
        else if(right){
            rightward();
        }
        else if(up){
            upward();
        }else if(down){
            downward();
        }
    }

    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
        move();
    }

    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}
