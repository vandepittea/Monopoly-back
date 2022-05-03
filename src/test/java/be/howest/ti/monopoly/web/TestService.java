package be.howest.ti.monopoly.web;

import be.howest.ti.monopoly.logic.IService;
import be.howest.ti.monopoly.logic.ServiceAdapter;
import be.howest.ti.monopoly.logic.implementation.Game;

import java.util.List;


public class TestService implements IService {

    IService delegate = new ServiceAdapter();

    void setDelegate(IService delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getVersion() {
        return delegate.getVersion();
    }

    @Override
    public Game createGame(int numberOfPlayers, String prefix) {
        return delegate.createGame(numberOfPlayers, prefix);
    }

    @Override
    public List<Game> getGames(boolean started, boolean startedMatters, int numberOfPlayers, boolean playersMatter, String prefix) {
        return delegate.getGames(started, startedMatters, numberOfPlayers, playersMatter, prefix);
    }
}
