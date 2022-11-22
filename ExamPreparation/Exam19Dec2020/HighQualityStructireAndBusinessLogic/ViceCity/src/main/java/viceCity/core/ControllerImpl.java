package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {

    private GangNeighbourhood neighbourhood = new GangNeighbourhood();
    private MainPlayer mainPlayer = new MainPlayer();
    private List<Player> players = new ArrayList<>();
    private ArrayDeque<Gun> guns = new ArrayDeque<>();

    private int initialPlayers = 0;

    public ControllerImpl() {
    }

    @Override
    public String addPlayer(String name) {
        players.add(new CivilPlayer(name));
        return String.format("Successfully added civil player: %s!",name);
    }

    @Override
    public String addGun(String type, String name) {
        switch (type){
            case "Pistol":
                guns.offer(new Pistol(name));
                break;
            case "Rifle":
                guns.offer(new Rifle(name));
                break;
            default:
                return "Invalid gun type!";
        }
        return String.format("Successfully added %s of type: %s",name,type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (guns.size()==0){
            return "There are no guns in the queue!";
        }
        if (name.equals("Vercetti")){
            mainPlayer.getGunRepository().getModels().add(guns.peek());
            return String.format("Successfully added %s to the Main Player: Tommy Vercetti",guns.pop().getName());
        }else if (players.stream().anyMatch(p->p.getName().equals(name))){
            players.stream().filter(p->p.getName().equals(name)).findFirst().get().getGunRepository().add(guns.peek());
            return String.format("Successfully added %s to the Civil Player: %s",guns.pop().getName(),name);
        }
            return "Civil player with that name doesn't exists!";
    }

    @Override
    public String fight() {
        initialPlayers = players.size();
        neighbourhood.action(mainPlayer,players);

        if (initialPlayers ==players.size() && mainPlayer.getLifePoints()==100){
            return "Everything is okay!";
        }
            StringBuilder output = new StringBuilder("A fight happened:").append(System.lineSeparator());
            output.append(String.format("Tommy live points: %d!",mainPlayer.getLifePoints())).append(System.lineSeparator());
            output.append(String.format("Tommy has killed: %d players!",initialPlayers-players.size())).append(System.lineSeparator());
            output.append(String.format("Left Civil Players: %d!",players.size()));
            return String.valueOf(output);
    }
}
