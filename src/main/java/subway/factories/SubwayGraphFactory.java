package subway.factories;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ng.pencode.algorithmproject.DirectedEdge;
import ng.pencode.algorithmproject.WDgraph;
import subway.SubwayStations;

public class SubwayGraphFactory {

    private File texteFile;

    public SubwayGraphFactory(File textFile) {
        this.texteFile = textFile;
    }

    public WDgraph buildSubwayGraph() throws FileNotFoundException {
        Scanner scanFile = new Scanner(texteFile);
        String[] graphProprieties = scanFile.nextLine().split(" ");
        int nbStations = Integer.parseInt(graphProprieties[0]);
        int nbEdges = Integer.parseInt(graphProprieties[1]);
        WDgraph subwayGraph = new WDgraph(nbStations, nbEdges);

        // Reading the file until we arrive to the edges of the graph
        while (!scanFile.nextLine().trim().equals("$")) {
            continue;
        }

        // Continuing to read the file to get the edges
        System.out.println(scanFile.nextLine());
        while (scanFile.hasNext()) {
            String[] dataEdge = scanFile.nextLine().split(" ");
            int edgeFrom = Integer.parseInt(dataEdge[0].trim());
            int edgeTo = Integer.parseInt(dataEdge[1].trim());
            int edgeWeight = Integer.parseInt(dataEdge[2].trim());
            if (edgeWeight == -1) {
                // the "-1" indicates that it is a correspondence within a same station
                // We choose an arbitrary value for the correspondence that is 300
                // Normally, the values depends on the way you have to cross between the "stations" within the station
                edgeWeight = 300;
            }
            DirectedEdge edgeBetweenTwoStations = new DirectedEdge(edgeFrom, edgeTo, edgeWeight);
            subwayGraph.addEdge(edgeBetweenTwoStations);
        }

        // We finished the reading of the file, we now return the graph
        scanFile.close();
        return subwayGraph;
    }

    public SubwayStations buildSubwayStations() throws FileNotFoundException {
        SubwayStations stations = new SubwayStations();
        Scanner scanFile = new Scanner(texteFile);
        String[] graphProprieties = scanFile.nextLine().split(" ");
        int nbStations = Integer.parseInt(graphProprieties[0]);

        // We now make the list of stations
        for (int i = 0; i < nbStations; i++) {
            String[] dataStation = scanFile.nextLine().split(" ");
            int stationID = Integer.parseInt(dataStation[0].trim());
            String stationName = dataStation[1].trim();
            
        }
        return stations;
    }
}
