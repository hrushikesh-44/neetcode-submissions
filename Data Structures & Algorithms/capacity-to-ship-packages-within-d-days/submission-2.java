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
            int capacity = weightCap(weights, mid);
            if(capacity <= days){
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

    int weightCap(int[] weights, int mid){
        int days = 1;
        int currWeight = 0;

        for(int weight: weights){
            if(currWeight + weight > mid){
                days++;
                currWeight = 0;
            }
            currWeight += weight;
        }
        return days;
    }
}