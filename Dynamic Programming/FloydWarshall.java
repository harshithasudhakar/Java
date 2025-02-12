import java.util.*;

class FloydWarshall{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int n = input.nextInt();
        int[][] graph = new int[n][n];
        
        //Initialize graph to infinity
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        //Populate graph(putting in the weights in the matrix)
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.println("Enter the weight for "+i+","+j+" : ");
                graph[i][j] = input.nextInt();
                if(graph[i][j] == -1){
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        //Updating the matrix with the shortest paths
        for(int k = 0; k<n; k++){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(graph[i][k]!= Integer.MAX_VALUE && graph[k][j]!= Integer.MAX_VALUE && (graph[i][j]>+graph[i][k]+graph[k][j])){
                        graph[i][j] = graph[i][k]+graph[k][j];
                    }
                }
            }
        }

        //Printing the matrix
        System.out.println("Shortest paths between all pairs: ");
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(graph[i][j] == Integer.MAX_VALUE){
                    System.out.print("Infinity\t");
                }
                else{
                    System.out.print("("+i+","+j+")=>"+ graph[i][j]+"\t");
                }
            }
            System.out.println();
        }

    }
}
