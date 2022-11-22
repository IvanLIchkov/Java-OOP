package viceCity.models.guns;

public class Pistol extends BaseGun{
    public Pistol(String name) {
        super(name, 10, 100);
    }

    @Override
    public int fire() {
        setBulletsPerBarrel(getBulletsPerBarrel()-1);
        if (getTotalBullets()==0 && getBulletsPerBarrel()==0){
            return 0;
        } else if (getBulletsPerBarrel()<=0){
            setTotalBullets(getTotalBullets()-10);
            setBulletsPerBarrel(10);
            return 1;
        }
        return 1;
    }
}
