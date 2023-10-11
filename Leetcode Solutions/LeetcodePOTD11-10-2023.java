class Solution {
    private int binsearch1(ArrayList<Integer> list, int k) {
        int low = 0;
        int high = list.size();
        int res = high+1;

        while (low < high) {
            int mid = low + (high-low) / 2;
            if (list.get(mid) <= k) {
                low = mid + 1;
            } else {  
                high = mid ;
            }
        }

        return low;
    }
    private int binsearch2(ArrayList<Integer> list, int k) {
        int low = 0;
        int high = list.size();
        int res = high+1;

        while (low < high) {
            int mid = low + (high-low) / 2;
            if (list.get(mid) < k) {
                low = mid + 1;
            } else {  
                high = mid ;
            }
        }

        return low;
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int[] row : flowers){
            list1.add(row[0]);
            list2.add(row[1]);
        }
        Collections.sort(list1);
        Collections.sort(list2);
        int n = people.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            // flowers will blooom in start of the day and end in end of the day 
            res[i] = binsearch1(list1,people[i])-binsearch2(list2,people[i]);
        }
        return res;
    }
}
