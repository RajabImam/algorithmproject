package subway;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

import ng.pencode.algorithmproject.DijkstraSP;
import ng.pencode.algorithmproject.WDgraph;
import subway.factories.SubwayGraphFactory;

public class Main {

    public static void main(String[] args) {
        // Opening the file that contains the Parisian Subway informations
        File subwayTextFile = new File("src/main/java/subway/metro.txt");

        // Calling the factory for the graph
        SubwayGraphFactory subwayGraphFactory = new SubwayGraphFactory(subwayTextFile);

        // Making the list of the sations
        SubwayStations subwayStations;
        try {
            subwayStations = subwayGraphFactory.buildSubwayStations();
        } catch (Exception e) {
            System.out.println("An error has occured during the reading of the file");
            e.printStackTrace();
            return;
        }

        // Making the graph of the stations
        WDgraph subwayGraph;
        try {
            subwayGraph = subwayGraphFactory.buildSubwayGraph();
        } catch (Exception e) {
            System.out.println("An error has occured during the reading of the file");
            e.printStackTrace();
            return;
        }

        // Asking the type of input yo want to do
        Scanner answerScan = new Scanner(System.in);
        boolean isChoiceMade = false;
        boolean isSearchByID = true;
        do {
            System.out.println("Please enter the type of input you want to make (ID : i / Station name : n) :");
            String inputChoice = answerScan.nextLine();
            if (inputChoice.trim().toLowerCase().equals("i") || inputChoice.trim().toLowerCase().equals("n")) {
                isChoiceMade = true;
                isSearchByID = inputChoice.trim().toLowerCase().equals("i");
            } else {
                System.out.println("The input is wrong, please try again");
            }

        } while (!isChoiceMade);

        if (isSearchByID) {
            // We ask for the id of the starting station
            boolean isStartingStationIDConfirmed = false;
            int startingStationID = -1;
            do {
                System.out.println("Please enter the ID of the station where you are starting");
                String inputChoice = answerScan.nextLine().trim();
                System.out.println(inputChoice);
                boolean numberMatch = Pattern.matches("\\d*", inputChoice);
                if (numberMatch) {
                    isStartingStationIDConfirmed = true;
                    startingStationID = Integer.parseInt(inputChoice);
                } else {
                    System.out.println("The input is wrong, please try again");
                }

            } while (!isStartingStationIDConfirmed);

            // We ask for the id of the starting station
            boolean isEndingStationIDConfirmed = false;
            int endingStationID = -1;
            do {
                System.out.println("Please enter the ID of the station where you want to go");
                String inputChoice = answerScan.nextLine().trim();
                System.out.println(inputChoice);
                boolean numberMatch = Pattern.matches("\\d*", inputChoice);
                if (numberMatch) {
                    isEndingStationIDConfirmed = true;
                    endingStationID = Integer.parseInt(inputChoice);
                } else {
                    System.out.println("The input is wrong, please try again");
                }
            } while (!isEndingStationIDConfirmed);

            // We know try to calculate the shortest path between the two stations
            System.out.println("Dijkstra's Algorithm : ");
            long timeDijkstraBeginningExecution = System.currentTimeMillis();
            DijkstraSP subwayDijkstraSP = new DijkstraSP(subwayGraph, startingStationID);
            long executionTimeDijkstra = System.currentTimeMillis() - timeDijkstraBeginningExecution;
            // We look if there is a path between the two stations
            if (subwayDijkstraSP.hasPathTo(endingStationID)) {
                System.out.println("There is a path between the station " + subwayStations.getStationName(startingStationID) + " and the station " + subwayStations.getStationName(endingStationID) );
                subwayDijkstraSP.printSP(endingStationID);
                System.out.println("(only stations ID)");
            } else {
                System.out.println("There is no path between the station " + subwayStations.getStationName(startingStationID) + " and the station " + subwayStations.getStationName(endingStationID));
            }
            System.out.println("execution Time : " + executionTimeDijkstra + " ms");
        } else {
            System.out.println(
                    "WIP : Implementation with the search fonction will be odne in a second version of the program");
        }
    }
}
