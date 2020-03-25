import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static int[] dx = {-1, 1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, -1, 1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, -1, 1};

    public static class Pair{
        int x, y, z;
        public Pair(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] s = br.readLine().split(" ");
            if(s[0].equals("0"))
                break;

            int height = Integer.parseInt(s[0]);
            int row = Integer.parseInt(s[1]);
            int col = Integer.parseInt(s[2]);

            char[][][] board = new char[height][row][col];

            int startHeight = 0, startRow = 0, startCol = 0;
            int endHeight = 0, endRow = 0, endCol = 0;

            for(int i = 0; i < height; i++){
                for(int j = 0; j < row; j++){
                    String temp = br.readLine();
                    for(int k = 0; k < col; k++) {
                        char c = temp.charAt(k);
                        board[i][j][k] = c;
                        if(c == 'S'){
                            startHeight = i;
                            startRow = j;
                            startCol = k;
                        }
                        else if(c == 'E'){
                            endHeight = i;
                            endRow = j;
                            endCol = k;
                        }
                    }
                }
                br.readLine();
            }
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(startHeight, startRow, startCol));

            int[][][] dist = new int[height][row][col];
            for(int i = 0; i < height; i++){
                for(int j = 0; j < row; j++){
                    for(int k = 0; k < col; k++)
                        dist[i][j][k] = -1;
                }
            }
            dist[startHeight][startRow][startCol] = 0;

            while(!queue.isEmpty()){
                Pair p = queue.remove();
                for(int k = 0; k < 6; k++){
                    int x = p.x + dx[k];
                    int y = p.y + dy[k];
                    int z = p.z + dz[k];
                    if(x < 0 || x >= height || y < 0 || y >= row || z < 0 || z >= col) continue;
                    if(dist[x][y][z] != -1) continue;
                    if(board[x][y][z] == '#') continue;
                    dist[x][y][z] = dist[p.x][p.y][p.z] + 1;
                    queue.add(new Pair(x, y, z));
                }
            }
            if(dist[endHeight][endRow][endCol] == -1)
                System.out.println("Trapped!");
            else
                System.out.println("Escaped in " + dist[endHeight][endRow][endCol] + " minute(s).");
        }
    }
}
