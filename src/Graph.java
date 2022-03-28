

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import javax.swing.JPanel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class Graph {
    static final int INF=Integer.MAX_VALUE;
  // private LinkedList<AdjListNode>adj[];
    int dist[] ;
    int graph[][];
    int vertices;
    int edges;
    public boolean visited[];
  //  Edge edge[];
    
    
    
    public Graph(int v) 
    {
        this.vertices=v;
        
        graph=new int[v][v];
        visited=new boolean[v];
    }
    
    
    public int getdist(int i)
    {
        return dist[i];
        
    }
    
    public void add_edge(int s,int d,int weight)
    {
        graph[s][d]=weight;
    }
    
    
    public void print_graph()
    {
      System.out.println("the graph is :");
        for (int i=0;i<vertices;i++){
         for (int j=0;j<vertices;j++){            
          
             System.out.print(graph[i][j]+" ");
             }
         System.out.println();
        }
    }
    
    public boolean find_edge(int i,int j)
    {
        if(graph[i][j]==0)
            return false;
        return true;
    }
    
    public void directed_grapgh(int m)
    {
        
        for (int i=0;i<vertices;i++)
         for (int j=0;j<vertices;j++)
             graph[i][j]=0;
        
        Random r=new Random();
        int n=0;
        while(n<m){
            int s=r.nextInt(vertices);
            int d=r.nextInt(vertices);
            int w=r.nextInt(vertices+10)+1;
            if(s!=d){
                if(s<d){
                    add_edge(s, d, w);
                  //  n++;
                }
                else
                {
                    add_edge(d, s, w);
                  //  n++;
                }
                n++;
            }
        }
    }
    
    
   
    void dijkstra( int src) 
    { 
        dist= new int[vertices];
        boolean sptSet[] = new boolean[vertices]; 
        for (int i = 0; i < vertices; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
        dist[src] = 0; 
        
            int u = minDistance(dist, sptSet); 
           while (u!=-1){
            sptSet[u] = true;
            
            
            
            for (int v = 0; v < vertices; v++) {
                if (!sptSet[v] && graph[u][v] != 0 &&  
                   dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
                     }
             u = minDistance(dist, sptSet); 
           }
           
           
           
        printSolution(dist, vertices); 
    } 
    
    void printSolution(int dist[], int n) 
    { 
        System.out.println("Vertex   Distance from Source"); 
        for (int i = 0; i < vertices; i++) 
            System.out.println(i + " tt " + dist[i]); 
    }
    
     int minDistance(int dist[], boolean sptSet[]) 
    { 
        int min = Integer.MAX_VALUE, min_index = -1; 
        for (int v = 0; v < vertices; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
        return min_index; 
    } 
        
      
    void BellmanFord( int src)
    {    
        int dist[] = new int[vertices];
        for (int i = 0; i < vertices; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
           
            for (int c=0;c<vertices-1;c++)
             for (int i=0;i<vertices;i++)
               for(int j=0;j<vertices;j++)
                   if(dist[i]!=Integer.MAX_VALUE)
                     if((graph[i][j]!=0)&&(dist[i]+graph[i][j]<dist[j]) ){
                          dist[j]=dist[i]+graph[i][j];
                    } 
    } 
  
           
    void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        String out="";
        for (int i = 0; i < V; ++i)
        {
            System.out.println(i + "\t\t" + dist[i]);
            out=i+""+dist[i]+"//n";
        }
    }  
    
    public void run() {
                new interface1().setVisible(true);
                long start = System.currentTimeMillis();
                long end = System.currentTimeMillis();
                long elapsedTime = end -start;
                System.out.println(elapsedTime);
                
            }
    
    public void newrandomGraph(int m)
    {
        Random k=new Random();
        int counterForEdges=1;
        while(counterForEdges<=m)
        {
            int a=k.nextInt(vertices);
             int b=k.nextInt(vertices);
             int weight=k.nextInt(vertices)+100;
             if(a!=b)
             {
                 if (graph[a][b]==0)
                 {
                     graph[a][b]=weight;
                     counterForEdges++;
                 }
             }
        }
    }
    
    
    
    void topologicalSortUtil(int v, boolean visited[],Stack stackVertices)
        {           
            visited[v] = true;

           for(int i=0;i<vertices;i++)
            if (graph[v][i]!=0)
                if(!visited[i])//vertex i is not visited
                     topologicalSortUtil(i, visited,stackVertices);
            stackVertices.push(new Integer(v));
        }
    
    
   void shortestPath(int s)
        {
            Stack stack = new Stack();
            int dist[] = new int[vertices];
  
            // Mark all the vertices as not visited
            boolean visited[] = new boolean[vertices];
            for (int i = 0; i < vertices; i++)
                visited[i] = false;
  
            // Call the recursive helper function to store Topological
            // Sort starting from all vertices one by one
            for (int i = 0; i < vertices; i++)
                if (visited[i] == false)
                    topologicalSortUtil(i, visited, stack);
  
            // Initialize distances to all vertices as infinite and
            // distance to source as 0
            for (int i = 0; i < vertices; i++)
                dist[i] = INF;
            dist[s] = 0;
            //removing all vertices before reaching vertex s
        while((int)stack.peek()!=s)
                      stack.pop();
         while(!stack.empty()){   
             int x=(int)stack.pop();                
              for(int i=0;i<vertices;i++) {
                  if ((graph[x][i]!=0)&&(graph[x][i]+dist[x]<dist[i]))
                      dist[i]=graph[x][i]+dist[x];               
               }
         }
            // Print the calculated shortest distances
            for (int i = 0; i < vertices; i++)
            {
                if (dist[i] == INF)
                    System.out.print( "INF ");
                else
                    System.out.print( dist[i] + " ");
            }
        }
  
   public class FXML implements Initializable{

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
       
   }
   
   
   
   
   
   
}



