package viceCity.models.guns;

public class Rifle extends BaseGun{
    public Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public int fire() {
        setBulletsPerBarrel(getBulletsPerBarrel()-5);
        if (getTotalBullets()==0 && getBulletsPerBarrel()==0){
            return 0;
        }else if (getBulletsPerBarrel()<=0){
            setTotalBullets(getTotalBullets()-50);
            setBulletsPerBarrel(50);
            return 5;
        }
        return 5;
    }
}
