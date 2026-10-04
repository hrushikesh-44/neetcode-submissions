class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;

        for(int weight: weights){
            start = Math.max(weight, start);
            end += weight;
        }

        while(start <= end){
            int mid = (start + end)/ 2;
            if(canShip(weights, days, mid)){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean canShip(int[] weights, int days, int cap){
        int ships = 1;
        int currCap = cap;

        for(int weight: weights){
            if(currCap - weight < 0){
                ships++;
                if(ships > days){
                    return false;
                }
                currCap = cap;
            }
            currCap -= weight;
        }
        return true;
    }
}