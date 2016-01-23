package daaprac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DAAprac3 {

    public static int[][] a ;
    public static float mindistdl =999;
         public static int[][] coordinatesdl = new int[2][2];
         public static float mindistdr =999;
         public static int[][] coordinatesdr = new int[2][2];
          public static float mindistfinal =999;
         public static int[][] coordinatesfinal = new int[2][2];
         public static int arraystrip[][]=new int [10][2];static int j =0;
    public static void main(String[] args) throws IOException
    {
       BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the number of points");
        int num = Integer.parseInt(b.readLine());
        System.out.println("enter the elements in the array");
        a = new int[num][2];
        for(int i=0 ; i < num;i++)
        {
            System.out.println("enter the x y coordinates for "+(i+1)+"th element");
            a[i][0]=Integer.parseInt(b.readLine());
            a[i][1]=Integer.parseInt(b.readLine());
        }
        System.out.println("going by brute force approch");
        float mindist =999;int[][] coordinates= new int[2][2];
        for(int i=0;i<num;i++)
        {
            for(int j=i+1;j<num;j++)
            {
                //calculate distance between ith and jth element
               float xdif = a[j][0]-a[i][0];
               float ydif = a[j][1]-a[i][1];
               xdif = (float) Math.pow(xdif, 2);
               ydif = (float) Math.pow(ydif, 2);
               float dist = (float) Math.sqrt((xdif+ydif));
               if(dist<mindist)
               {
                   mindist = dist;
                   coordinates[0][0]=a[i][0];
                   coordinates[0][1]=a[i][1];
                   coordinates[1][0]=a[j][0];
                   coordinates[1][1]=a[j][1];
               }
            }
        }
        System.out.println("coordinates of minimum distance after brute force approch are");
        System.out.println("1st coordinate are "+coordinates[0][0]+" and "+coordinates[0][1]);
        System.out.println("2nd coordinate are "+coordinates[1][0]+" and "+coordinates[1][1]);
        System.out.println("going by dac approch");
        for(int i=0;i<num;i++)
        {
            for(int j=i+1;j<num;j++)
            {
                //calculate distance between ith and jth element
               if(a[j][0]<a[i][0])
               {
                   int temp = a[j][0];
                   a[j][0]=a[i][0];
                   a[i][0]=temp;
                   temp = a[j][1];
                   a[j][1]=a[i][1];
                   a[i][1]=temp;
               }
            }
        }
        /*System.out.println("coordinates after sorting are");
         for(int i=0 ; i < num;i++)
        {
            System.out.println("x y coordinates for "+(i+1)+"th element are"+ a[i][0]+"and"+a[i][1]);
           
        }*/
         int temp = num-1;
         temp=temp/2;
         //calculate for left
         minleft(0,temp);
         minright(temp+1,num-1);
         //calculate for right
      
        //System.out.println("find the minimum of two dl and dr"); 
        float d;
        if(mindistdl<mindistdr)
        {
            d = mindistdl;
            mindistfinal=mindistdl;
            coordinatesfinal=coordinatesdl;
        }
        else
        {
            d = mindistdr;
            
            mindistfinal=mindistdr;
            coordinatesfinal=coordinatesdr;
           
        }
        int ref = a[temp][0];
       
        for(int i=0;i<num;i++)
        {
            if((a[i][0]>(ref-(int)d))||(a[i][0]>(ref+(int)d)))
            {
                arraystrip[j][0]=a[i][0];
                arraystrip[j][1]=a[i][1];
                j++;
            }
        }
        //sort the array strip based on the y coordinates
        System.out.println("");
        for(int i=0;i<j;i++)
        {
            for(int k=i+1;k<j;k++)
            {
                //calculate distance between ith and jth element
               if(arraystrip[k][1]<arraystrip[i][1])
               {
                   temp = arraystrip[k][0];
                   arraystrip[k][0]=arraystrip[i][0];
                   arraystrip[i][0]=temp;
                   temp = arraystrip[k][1];
                   arraystrip[k][1]=arraystrip[i][1];
                   arraystrip[i][1]=temp;
               }
            }
        }
        minarraystrip(0,j-1);
        System.out.println("after using dac approch the coordinates of minimum distance are");
        System.out.println("1st coordinate are "+coordinatesfinal[0][0]+" and "+coordinatesfinal[0][1]);
        System.out.println("2nd coordinate are "+coordinatesfinal[1][0]+" and "+coordinatesfinal[1][1]);
    }

    private static void minleft(int i1, int i2)
    {
        if(i2-1==i1)
        {
            float xdif = a[i2][0]-a[i1][0];
               float ydif = a[i2][1]-a[i1][1];
               xdif = (float) Math.pow(xdif, 2);
               ydif = (float) Math.pow(ydif, 2);
               float dist = (float) Math.sqrt((xdif+ydif));
               if(mindistdl>dist)
               {
                   mindistdl=dist;
                   coordinatesdl[0][0]=a[i1][0];
                   coordinatesdl[0][1]=a[i1][1];
                   coordinatesdl[1][0]=a[i2][0];
                   coordinatesdl[1][1]=a[i2][1];
               }
        }
        else if(i2==i1)
        {
            float xdif = a[i2][0]-a[i1-1][0];
               float ydif = a[i2][1]-a[i1-1][1];
               xdif = (float) Math.pow(xdif, 2);
               ydif = (float) Math.pow(ydif, 2);
               float dist = (float) Math.sqrt((xdif+ydif));
               if(mindistdl>dist)
               {
                   mindistdl=dist;
                   coordinatesdl[0][0]=a[i1-1][0];
                   coordinatesdl[0][1]=a[i1-1][1];
                   coordinatesdl[1][0]=a[i2][0];
                   coordinatesdl[1][1]=a[i2][1];
               }
            xdif = a[i2][0]-a[i1-2][0];
               ydif = a[i2][1]-a[i1-2][1];
               xdif = (float) Math.pow(xdif, 2);
               ydif = (float) Math.pow(ydif, 2);
               dist = (float) Math.sqrt((xdif+ydif));
               if(mindistdl>dist)
               {
                   mindistdl=dist;
                   coordinatesdl[0][0]=a[i1-2][0];
                   coordinatesdl[0][1]=a[i1-2][1];
                   coordinatesdl[1][0]=a[i2][0];
                   coordinatesdl[1][1]=a[i2][1];
               }
        }
        else
        {
            int temp=(i1+i2)/2;
            minleft(i1,temp);
            minleft(temp+1,i2);
        }
    }

    private static void minright(int i1, int i2)
    {
        if(i2-1==i1)
        {
            float xdif = a[i2][0]-a[i1][0];
               float ydif = a[i2][1]-a[i1][1];
               xdif = (float) Math.pow(xdif, 2);
               ydif = (float) Math.pow(ydif, 2);
               float dist = (float) Math.sqrt((xdif+ydif));
               if(mindistdr>dist)
               {
                   mindistdr=dist;
                   coordinatesdr[0][0]=a[i1][0];
                   coordinatesdr[0][1]=a[i1][1];
                   coordinatesdr[1][0]=a[i2][0];
                   coordinatesdr[1][1]=a[i2][1];
               }
        }
        else if(i2==i1)
        {
            float xdif = a[i2][0]-a[i1-1][0];
               float ydif = a[i2][1]-a[i1-1][1];
               xdif = (float) Math.pow(xdif, 2);
               ydif = (float) Math.pow(ydif, 2);
               float dist = (float) Math.sqrt((xdif+ydif));
               if(mindistdr>dist)
               {
                   mindistdr=dist;
                   coordinatesdr[0][0]=a[i1-1][0];
                   coordinatesdr[0][1]=a[i1-1][1];
                   coordinatesdr[1][0]=a[i2][0];
                   coordinatesdr[1][1]=a[i2][1];
               }
            xdif = a[i2][0]-a[i1-2][0];
               ydif = a[i2][1]-a[i1-2][1];
               xdif = (float) Math.pow(xdif, 2);
               ydif = (float) Math.pow(ydif, 2);
               dist = (float) Math.sqrt((xdif+ydif));
               if(mindistdr>dist)
               {
                   mindistdr=dist;
                   coordinatesdr[0][0]=a[i1-2][0];
                   coordinatesdr[0][1]=a[i1-2][1];
                   coordinatesdr[1][0]=a[i2][0];
                   coordinatesdr[1][1]=a[i2][1];
               }
        }
        else
        {
            int temp=(i1+i2)/2;
            minright(i1,temp);
            minright(temp+1,i2);
        }
    } 

    private static void minarraystrip(int i1, int i2)
    {
      
        if(i2-1==i1)
        {
            float xdif = arraystrip[i2][0]-arraystrip[i1][0];
               float ydif = arraystrip[i2][1]-arraystrip[i1][1];
               xdif = (float) Math.pow(xdif, 2);
               ydif = (float) Math.pow(ydif, 2);
               float dist = (float) Math.sqrt((xdif+ydif));
               if(mindistfinal>dist)
               {
                   mindistfinal=dist;
                   coordinatesfinal[0][0]=arraystrip[i1][0];
                   coordinatesfinal[0][1]=arraystrip[i1][1];
                   coordinatesfinal[1][0]=arraystrip[i2][0];
                   coordinatesfinal[1][1]=arraystrip[i2][1];
               }
        }
        else if(i2==i1)
        {
            float xdif = arraystrip[i2][0]-arraystrip[i1-1][0];
               float ydif = arraystrip[i2][1]-arraystrip[i1-1][1];
               xdif = (float) Math.pow(xdif, 2);
               ydif = (float) Math.pow(ydif, 2);
               float dist = (float) Math.sqrt((xdif+ydif));
               if(mindistfinal>dist)
               {
                   mindistfinal=dist;
                   coordinatesfinal[0][0]=arraystrip[i1-1][0];
                   coordinatesfinal[0][1]=arraystrip[i1-1][1];
                   coordinatesfinal[1][0]=arraystrip[i2][0];
                   coordinatesfinal[1][1]=arraystrip[i2][1];
               }
            xdif = arraystrip[i2][0]-arraystrip[i1-2][0];
               ydif = arraystrip[i2][1]-arraystrip[i1-2][1];
               xdif = (float) Math.pow(xdif, 2);
               ydif = (float) Math.pow(ydif, 2);
               dist = (float) Math.sqrt((xdif+ydif));
               if(mindistfinal>dist)
               {
                   mindistfinal=dist;
                   coordinatesfinal[0][0]=arraystrip[i1-2][0];
                   coordinatesfinal[0][1]=arraystrip[i1-2][1];
                   coordinatesfinal[1][0]=arraystrip[i2][0];
                   coordinatesfinal[1][1]=arraystrip[i2][1];
               }
        }
        else
        {
            int temp=(i1+i2)/2;
            minarraystrip(i1,temp);
            minarraystrip(temp+1,i2);
        }
    }
}