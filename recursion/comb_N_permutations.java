
public class comb_N_permutations {
    
    public static void main(String[] args){
        int[] a = {2,3,5,7};
        int tar = 10;
                //int count = coinChangeInfinitePermutation(a, tar, "", 0);
           //int count = coinChangeInfiniteCombinations(a, tar, "", 0);

         //int count = coinChangeSingleCombinations(a, tar, "", 0);
       
     //int count = coinChangeSinglePermutations(a, tar, "", 0);
       // System.out.println(count);
         //int c = coinChangeSingleSubsequence_Comb(a, tar, "", 0);

           //int c = coinChangeInfiniteSubsequence_Comb(a, tar, "", 0);
                 //int c = coinChangeInfiniteSubsequence_Permutation(a, tar, "", 0);
    //int c = coinChangeSingleSubsequence_Permutation(a, tar, "", 0);
       //System.out.println(c);
        
    }

    public static int coinChangeInfinitePermutation(int[]a, int tar, String ans, int idx){
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i = idx; i < a.length; i++){
            if(tar - a[i] >= 0){
                count += coinChangeInfinitePermutation(a, tar-a[i], ans + a[i], idx);
            }
        }
        return count;
    }

    public static int coinChangeInfiniteCombinations(int[]a, int tar, String ans, int idx){
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i = idx; i < a.length; i++){
            if(tar - a[i] >= 0){
                count += coinChangeInfiniteCombinations(a, tar-a[i], ans + a[i], i);
            }
        }
        return count;
    }


    public static int coinChangeSingleCombinations(int[]a, int tar, String ans, int idx){
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i = idx; i < a.length; i++){
            if(tar - a[i] >= 0){
                count += coinChangeSingleCombinations(a, tar-a[i], ans + a[i], i+1);
            }
        }
        return count;
    }


    public static int coinChangeSinglePermutations(int[]a, int tar, String ans, int idx){
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i = idx; i < a.length; i++){
            if(tar - a[i] >= 0 && a[i] > 0){

                int temp = a[i];
                a[i] = -a[i];   //visited
                count += coinChangeSinglePermutations(a, tar-temp, ans + temp, idx);
                a[i] = -a[i];   //unvisited
            }
        }
        return count;
    }


////////******** Subsequence ->  Single Combination           */
    public static int coinChangeSingleSubsequence_Comb(int[]a, int tar, String ans, int idx){

        if(tar == 0 || idx == a.length){

            if(tar == 0){

                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        


        int count = 0;
        if(tar - a[idx] >= 0){
            count += coinChangeSingleSubsequence_Comb(a, tar-a[idx], ans+a[idx], idx+1);
        }

        count += coinChangeSingleSubsequence_Comb(a, tar, ans, idx+1);

        return count;
    }

    ////////******** Subsequence ->  Infinite Combination           */
    public static int coinChangeInfiniteSubsequence_Comb(int[]a, int tar, String ans, int idx){

        if(tar == 0 || idx == a.length){

            if(tar == 0){

                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        


        int count = 0;
        if(tar - a[idx] >= 0){
            count += coinChangeInfiniteSubsequence_Comb(a, tar-a[idx], ans+a[idx], idx);
        }

        count += coinChangeInfiniteSubsequence_Comb(a, tar, ans, idx+1);

        return count;
    }


     ////////******** Subsequence ->  Infinite Permutation           */
     public static int coinChangeInfiniteSubsequence_Permutation(int[]a, int tar, String ans, int idx){

        if(tar == 0 || idx == a.length){

            if(tar == 0){

                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        


        int count = 0;
        if(tar - a[idx] >= 0){
            count += coinChangeInfiniteSubsequence_Permutation(a, tar-a[idx], ans+a[idx], 0);
        }

        count += coinChangeInfiniteSubsequence_Permutation(a, tar, ans, idx+1);

        return count;
    }

   
    ///////******** Subsequence ->  Single Permutation           */
    public static int coinChangeSingleSubsequence_Permutation(int[]a, int tar, String ans, int idx){

        if(tar == 0 || idx == a.length){

            if(tar == 0){

                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        

        int count = 0;
        if(tar - a[idx] >= 0  && a[idx] >0){
            int temp = a[idx];

            a[idx] = -a[idx];
            count += coinChangeSingleSubsequence_Permutation(a, tar-temp, ans+temp, 0);
            a[idx] = - a[idx];
        }

        count += coinChangeSingleSubsequence_Permutation(a, tar, ans, idx+1);

        return count;
    }



}