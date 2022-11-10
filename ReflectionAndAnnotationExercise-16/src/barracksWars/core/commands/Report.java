package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Report extends Command{
    @Inject
    private Repository repository;

    @Inject
    private UnitFactory unitFactory;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
