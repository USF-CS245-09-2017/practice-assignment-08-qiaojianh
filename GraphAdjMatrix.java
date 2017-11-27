/*
    @author Qiaojian Hu
*/
import java.util.*;

public class GraphAdjMatrix implements Graph{

	private int[][] graph;
	private int v;

	public GraphAdjMatrix(int vertices){
		this.graph = new int[vertices][vertices];
		this.v = vertices;
	}

	public void addEdge(int v1, int v2){
		graph[v1][v2] = 1;
	}


	public int[] neighbors(int vertex){
		int i,j=0,y=0;

		for (i = 0; i < v; i++ ) {
			if (graph[vertex][i] == 1) {
				j++;
			}
		}
		int[] tmp = new int[j];
		for (i = 0; i < v; i++ ) {
			if (graph[vertex][i] == 1) {
				tmp[y] = i;
				y++;
			}
		}
		return tmp;
	}

	private void topologicalSort(int x, boolean visited[],Stack stack){
        visited[x] = true;
        Integer i;
        int tmp[] = neighbors(x);

        for (int j = 0; j < tmp.length ; j++ ) {
        	i = tmp[j];
        	if (!visited[i]){
                topologicalSort(i, visited, stack);
            }
        }

        stack.push(new Integer(x));

    }
 
    public void topologicalSort(){
        Stack stack = new Stack();
 
        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++){
            visited[i] = false;
        }
 
        for (int i = 0; i < v; i++){
            if (visited[i] == false){
                topologicalSort(i, visited, stack);
 			}
 		}

        while (stack.empty()==false){
            System.out.print(stack.pop() + " ");
        }
    }

}