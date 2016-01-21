/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxmindac;

/**
 *
 * @author Vishal
 */
public class MaxMinDAC {

    public static Integer[] a = {100,23,3,-1,60,11,9,66,110,-9};//static declaration of the array
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        System.out.println("the numbers in the array are");
        for(int i = 0 ; i<10; i ++)
        {
            System.out.println((i+1)+"th element is "+a[i]);
        }
        int[] finalresult = minmax(0,9);
        System.out.println("the minimum and the maximum element are "+finalresult[0]+" and "+finalresult[1]);
    }
    //zero index is for the minimum element andd 1 is for the maximum element
    public static int[] minmax(int i,int j)
    {
        int temp[]=new int[2];
        if(i==j)
        {
            temp[0]=a[i];
            temp[1]=a[j];
            return(temp);
        }
        else if (j-i==1)
        {
            if(a[i]<a[j])
            {
                
            temp[0]=a[i];
            temp[1]=a[j];
            }
            else
            {
            temp[0]=a[j];
            temp[1]=a[i];
            }
            return(temp);
        }
        else
        {
            int mid = (i + j) /2;
            int[] branchleftresult = minmax(i,mid);
            int[] branchrightresult = minmax(mid+1,j);
            //compare minimum of left and right branch
            if(branchleftresult[0]<branchrightresult[0])
            {
                temp[0]=branchleftresult[0];
            }
            else
            {
                temp[0]=branchrightresult[0];
            }
            //compare maximum of left and right branch
            if(branchleftresult[1]>branchrightresult[1])
            {
                temp[1]=branchleftresult[1];
            }
            else
            {
                temp[1]=branchrightresult[1];
            }
            
           return(temp);
        }
    }
    
}
