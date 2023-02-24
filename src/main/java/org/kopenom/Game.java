package org.kopenom;

public class Game {
    public static boolean computeGameOver(
            Kopenom p1,
            Kopenom e1
    ) {
        return e1 == null || p1 == null;
    }

    public static void printDeath(String prefix, Kopenom dead) {
        System.out.println(prefix + " " + dead.name + " has fallen!");
    }

    public static void printGameOver(String prefix) {
        System.out.println(prefix + " team has fallen! Game over.");
    }

    public static Kopenom getNextInTeam(LinkedListNode<Kopenom> team, String prefix) {
        LinkedListNode nextKopenom = team.getNext();
        if(nextKopenom == null) {
            printGameOver(prefix);
            return null;
        } else {
            return team.getNext().getValue();
        }
    }

    public static LinkedListNode<Kopenom> initTeam(Kopenom[] startingTeam) {
        LinkedListNode<Kopenom> team = new LinkedListNode(null, null);
        for(int i = 0; i < startingTeam.length; i++) {
            team.append(startingTeam[i]);
        }

        return team;
    }

    public static LinkedListNode<Kopenom> initTeam(Kopenom startingKopenom) {
        return new LinkedListNode(startingKopenom, null);
    }

    public static LinkedListNode<Kopenom> playGame(LinkedListNode<Kopenom> team, LinkedListNode<Kopenom> enemyTeam) {
        Kopenom currentKopenom = team.getValue();
        Kopenom currentEnemy = enemyTeam.getValue();

        while(!Game.computeGameOver(currentEnemy, currentKopenom)) {
            currentKopenom.attackKopenom(currentEnemy);
            if(currentEnemy.isDead()) {
                Game.printDeath("Enemy", currentEnemy);

                currentEnemy = Game.getNextInTeam(enemyTeam, "Enemy");
                enemyTeam = enemyTeam.getNext();
                continue;
            }

            currentEnemy.attackKopenom(currentKopenom);
            if(currentKopenom.isDead()) {
                Game.printDeath("Your kopenom", currentKopenom);

                currentKopenom = Game.getNextInTeam(team, "Your");
                team = team.getNext();
            }
        }

        return team != null ? team : enemyTeam;
    }
}
