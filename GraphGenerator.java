import java.util.Random;

public class GraphGenerator {
    
    private Random random;

    public GraphGenerator() {
        random = new Random();
    }

    public Graph generateGraph(int numNodes, int numEdges) {
        return generateGraph(numNodes, numEdges, false, true);
    }


    // gives control over directedness
    public Graph generateGraph(int numNodes, int numEdges, boolean directed) {
        return generateGraph(numNodes, numEdges, directed, true);
    }

    // total parameter control
    public Graph generateGraph(
        int numNodes, 
        int numEdges, 
        boolean directed, 
        boolean connected
    )
    {
        
        // inititalize constants
        Graph g = new Graph(directed);

        // limit the number of edges that can be in the graph
        if (numEdges > (2 * numNodes)) {
            System.out.println("Number of edges is too large, resetting to 2*n");
            numEdges = 2*numNodes;
        }

        // put a floor for the number of edges in connected graphs
        else if (connected && (numEdges < (numNodes - 1))) {
            System.out.println(
            "Number of edges is too small for a connected graph, setting to minimum numNodes - 1");
            numEdges = numNodes - 1;
        }

        // generate the node values
        for (int i = 0; i < numNodes; i++) {
            g.addNode(i);
        }

        // generate the edges 
        if (connected) {

            for (int i = 0; i < numNodes; i++) {

            }
            
            if (numEdges >= numNodes) {
                for (int j = numNodes; j < numEdges; j++) {
                    
                    Object[] nodeValuesArray = nodeValues.toArray();

                    // generate indices
                    int first = random.nextInt(nodeValues.size() - 1);
                    while (firstIndex == secondIndex) {
                        random.nextInt(nodeValues.size() - 1);
                    }

                    // add the edges
                    g.addEdge((int) nodeValuesArray[firstIndex], (int) nodeValuesArray[secondIndex]);

                }
            }
        }

        else {

        }


        return g;
    }
}