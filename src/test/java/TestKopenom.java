import org.junit.Test;
import org.kopenom.Game;
import org.kopenom.Kopenom;
import org.kopenom.LinkedListNode;
import org.kopenom.Main;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class TestKopenom {
    @Test
    public void testWin() {
        Kopenom[] startingEnemy = {
                new Kopenom("enemychu", "fire", 60, 10),
        };
        LinkedListNode<Kopenom> enemyTeam = Game.initTeam(startingEnemy);

        Kopenom[] starting = {
                new Kopenom("notachu", "fire", 500, 10),
                new Kopenom("waterchu", "water", 40, 5),
        };
        LinkedListNode<Kopenom> team = Game.initTeam(starting);

        LinkedListNode<Kopenom> winner = Game.playGame(team, enemyTeam);

        assertSame(winner, team);
    }

    @Test
    public void testLoss() {
        Kopenom[] startingEnemy = {
                new Kopenom("enemychu", "fire", 600, 10),
        };
        LinkedListNode<Kopenom> enemyTeam = Game.initTeam(startingEnemy);

        Kopenom[] starting = {
                new Kopenom("notachu", "fire", 50, 10),
                new Kopenom("waterchu", "water", 40, 5),
        };
        LinkedListNode<Kopenom> team = Game.initTeam(starting);

        LinkedListNode<Kopenom> winner = Game.playGame(team, enemyTeam);

        assertSame(winner, enemyTeam);
    }
}
