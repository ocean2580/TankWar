package tank;


import java.awt.*;
import java.util.List;

public class EnemyBullet extends Bullet {
    public EnemyBullet(Image img, int x, int y, Direction direction,GamePanel gamePanel){
        super(img, x, y, direction, gamePanel);
    }

    public void hitTank(){
        Rectangle next= this.getRec();
        List<Tank> tanks = this.gamePanel.tankList;
        //子弹和Tank
        for(Tank tank: tanks){
            if(tank.getRec().intersects(next)){
                tank.alive = false;
                this.gamePanel.blastList.add(new BlastObj(tank.x-34, tank.y-14));
                this.gamePanel.tankList.remove(tank);
                this.gamePanel.removeList.add(this);
                break;

            }
        }
    }

    public void paintSelf(Graphics g){
        g.drawImage(img, x, y, null);
        go();
        hitBase();
        hitWall();
        hitTank();
    }
}

