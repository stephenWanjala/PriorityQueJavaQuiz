import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Collections.*;

public class Driver {

    public static void main(String[] args) {
        Athlete[] athletes = new Athlete[]{new Athlete("Pete Sampras", 14), new Athlete("Novak Djokovic", 21), new Athlete("Roger Federer", 20), new Athlete("Roy Emerson", 12), new Athlete("Rafael Nadal", 22), new Athlete("Bjorn Borg", 11),};
        for (String rank : classifyAthletes(athletes)) {
            System.out.println(rank);
        }

    }

    public static ArrayList<String> classifyAthletes(Athlete[] athletes) {


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        ArrayList<String> athleteWins = new ArrayList<>();
        var athleteMap = new HashMap<Integer, String>();
        ArrayList<Integer> winInts = new ArrayList<>();
        for (Athlete athlete : athletes) {
            priorityQueue.offer(athlete.wins());
            athleteMap.put(athlete.wins(), athlete.name());
        }
//        System.out.println("The que->" + priorityQueue);
        while (!priorityQueue.isEmpty()) {
            winInts.add(priorityQueue.poll());

        }
        sort(winInts);

        Collections.reverse(winInts);

//        athleteMap.forEach((theIndex, theName) -> System.out.println(theIndex + " " + theName));
        AtomicInteger iterationCheck = new AtomicInteger();
        winInts.forEach((theNum) -> {
            if (iterationCheck.get() == 0) {
                athleteWins.add(athleteMap.get(theNum) + " :" + "Highest wins");
                iterationCheck.addAndGet(1);
            } else if (iterationCheck.get() == 2) {
                athleteWins.add(athleteMap.get(theNum) + " :" + (iterationCheck.get() + 1) + "nd" + " Highest wins");
                iterationCheck.addAndGet(1);
            } else if (iterationCheck.get() == 2) {
                athleteWins.add(athleteMap.get(theNum) + " :" + (iterationCheck.get() + 1) + "rd" + " Highest wins");
                iterationCheck.addAndGet(1);
            } else {
                athleteWins.add(athleteMap.get(theNum) + " :" + (iterationCheck.get() + 1) + "th" + " Highest wins");
                iterationCheck.addAndGet(1);
            }
        });
        return athleteWins;
    }
}

