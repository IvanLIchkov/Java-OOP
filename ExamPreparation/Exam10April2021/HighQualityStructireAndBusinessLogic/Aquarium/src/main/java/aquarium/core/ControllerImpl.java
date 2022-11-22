package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.BaseAquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{

    private DecorationRepository decorationRepository;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorationRepository = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        switch (aquariumType){
            case "FreshwaterAquarium":
                aquariums.add(new FreshwaterAquarium(aquariumName));
                break;
            case "SaltwaterAquarium":
                aquariums.add(new SaltwaterAquarium(aquariumName));
                break;
            default:
                throw new NullPointerException("Invalid aquarium type.");
        }
        return "Successfully added "+aquariumType+".";
    }

    @Override
    public String addDecoration(String type) {
        switch (type){
            case "Ornament":
                decorationRepository.add(new Ornament());
                break;
            case "Plant":
                decorationRepository.add(new Plant());
                break;
            default:
                throw new IllegalArgumentException("Invalid decoration type.");
        }
        return String.format("Successfully added %s.",type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        if (decorationRepository.findByType(decorationType)!=null){
            aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().get().addDecoration(decorationRepository.findByType(decorationType));
            decorationRepository.remove(decorationRepository.findByType(decorationType));

        }else{
            throw new IllegalArgumentException(String.format("There isn't a decoration of type %s.",decorationType));
        }
        return String.format("Successfully added %s to %s.",decorationType,aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        switch (fishType){
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName,fishSpecies,price);
                break;
            case "SaltwaterFish":
                fish = new SaltwaterFish(fishName,fishSpecies,price);
                break;
            default:
                throw new IllegalArgumentException("Invalid fish type.");
        }
        BaseAquarium aquarium = (BaseAquarium) aquariums.stream().filter(aquarium1 -> aquarium1.getName().equals(aquariumName)).findFirst().get();

        if (aquarium.getFish().size()<aquarium.getCapacity()) {
            if (aquarium.getClass().getSimpleName().replace("Aquarium","").equals(fishType.replace("Fish",""))) {
                aquarium.addFish(fish);
                return String.format("Successfully added %s to %s.",fishType,aquariumName);
            }else{
                return "Water not suitable.";
            }
        }else{
            return "Not enough capacity.";
        }
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquariumForFeed = aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().get();
        aquariumForFeed.feed();
        return String.format("Fish fed: %d",aquariumForFeed.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquariumForCalculation = aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().get();
        double value=aquariumForCalculation.getFish().stream().mapToDouble(Fish::getPrice).sum();
        value+=aquariumForCalculation.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
        return String.format("The value of Aquarium %s is %.2f.",aquariumName,value);
    }

    @Override
    public String report() {
        StringBuilder output= new StringBuilder();
        aquariums.forEach(aquarium -> output.append(aquarium.getInfo()).append(System.lineSeparator()));
        return String.valueOf(output);
    }
}
