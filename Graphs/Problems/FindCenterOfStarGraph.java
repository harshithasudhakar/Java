import java.util.Scanner;

class FindCenterOfStarGraph {
    public static int findCenter(int[][] edges) {
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]){
            return edges[0][0];
        }
        else{
            return edges[0][1];
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] edges = new int[n][2];

        System.out.println(findCenter(edges));
    }
}
