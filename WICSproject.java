import java.io.*;
import java.util.*;

class Request{
    int ID;
    int start;
    int finish;
    int weight;
    float capacity;
    
    Request(){
        this.ID=0;
        this.start=0;
        this.finish=0;
        this.capacity=0;
        this.weight=0;
    }
    Request(int ID, int start, int finish, float capacity, int weight){
        this.ID=ID;
        this.start=start;
        this.finish=finish;
        this.capacity=capacity;
        this.weight=weight;
    }
    public void display(){
        System.out.println("ID:"+ID+",start:"+start+",finish:"+finish+",capacity:"+capacity+",weight:"+weight);
    }
}

class RequestWeightComparator implements Comparator<Request> { 
    public int compare(Request r1, Request r2) {
        return r1.weight - r2.weight;
    }
}

public class WICSproject {

    
    public static void main(String[] args) {
       Request[] jobs = new Request[]{new Request(1,0,3,0.5f,2),new Request(2,1,4,0.5f,4),new Request(3,3,5,0.25f,4),new Request(4,1, 7, 0.125f, 7),new Request(5,5,7,0.5f,2),new Request(6,5,8,0.5f,1)};
       int d, tot_wt;
       ArrayList<ArrayList<Request>> machines = new ArrayList<ArrayList<Request>>();
       
       System.out.println("Unsorted");
       for (int i=0; i<jobs.length; i++)
           jobs[i].display();
       
       Arrays.sort(jobs, new RequestWeightComparator());
 
       System.out.println("Sorted by weight");
       /*for (int i=0; i<jobs.length; i++)
           jobs[i].display();=*/
       
       Collections.reverse(Arrays.asList(jobs));
       
       //System.out.println("reversed");
       for (int i=0; i<jobs.length; i++)
           jobs[i].display();
       
       System.out.println("=========================================");
       
       d=1;
       System.out.println("First machine created");
       ArrayList<Request> m1 = new ArrayList<Request>();
       m1.add(jobs[0]);
       machines.add(m1);
       int flag = 0;
       
       for(int j=1;j<jobs.length;j++){
           //System.out.println("j = "+j);
           flag = 0;
           for(ArrayList<Request> mech : machines){
               float sum=0f;
               for(Request x : mech){
                  if(jobs[j].start > x.finish)
                  continue;
                  else
                  sum=sum+x.capacity;
               }
               if(jobs[j].capacity<=(1-sum)){
                   //System.out.println("Adding this job: "+ jobs[j].ID);
                   mech.add(jobs[j]);
                   flag = 1;
                   break;
               }
           }
           if (flag == 0)
           {
               System.out.println("Capacity of machine is full! Creating a new machine...");
               ArrayList<Request> m2=new ArrayList<Request>();
               m2.add(jobs[j]);
               machines.add(m2);
           }
       }
       
       for(ArrayList<Request> mech : machines){
           System.out.println("new machine");
           tot_wt=0;
           for(Request x : mech){
                   x.display();
                   tot_wt=tot_wt+x.weight;
               }
           System.out.println("Optimum weight is "+tot_wt);
       }
        
    }
    
}
