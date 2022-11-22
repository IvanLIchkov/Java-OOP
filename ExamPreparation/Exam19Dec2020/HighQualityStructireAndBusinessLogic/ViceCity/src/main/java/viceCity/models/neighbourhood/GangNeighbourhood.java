package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;
import viceCity.repositories.interfaces.Repository;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood{

    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        Repository<Gun> gunRepository = mainPlayer.getGunRepository();
        Gun gun = gunRepository.getModels().stream().findFirst().orElse(null);
        if (gun==null){
            return;
        }
        Player civilPlayer = civilPlayers.stream().findFirst().get();
        while (gunRepository.getModels().size()>0 || civilPlayers.size()>0){
            civilPlayer.takeLifePoints(gun.fire());
            if (gun.getBulletsPerBarrel()<=0){
                gunRepository.remove(gun);
                if (gunRepository.getModels().size()==0){
                    break;
                }
                gun=gunRepository.getModels().stream().findFirst().get();

            }
            if (civilPlayer.getLifePoints()<=0){
                civilPlayers.remove(civilPlayer);
                if (civilPlayers.isEmpty()){
                    return;
                }
                civilPlayer = civilPlayers.stream().findFirst().get();
            }
        }
        Gun civilGun = civilPlayer.getGunRepository().getModels().stream().findFirst().get();
        while (civilPlayers.size()>0 || mainPlayer.isAlive()){
            mainPlayer.takeLifePoints(civilGun.fire());
            if (mainPlayer.getLifePoints()==0){
                return;
            }
            if (civilGun.getTotalBullets()<=0){
                civilPlayer.getGunRepository().remove(gun);
                if (civilPlayer.getGunRepository().getModels().size()==0){
                    civilPlayers.remove(civilPlayer);
                    if (civilPlayers.isEmpty()){
                        return;
                    }
                    civilPlayer = civilPlayers.stream().findFirst().get();
                }else{
                    gun=civilPlayer.getGunRepository().getModels().stream().findFirst().get();
                }
            }

        }
    }
}
