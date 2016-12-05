package hairvikings;

/**
 * Created by Quentin Gangler on 05/12/2016.
 */
public class AbstractPlayer {
    protected final Team team;

    public AbstractPlayer(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }
}
