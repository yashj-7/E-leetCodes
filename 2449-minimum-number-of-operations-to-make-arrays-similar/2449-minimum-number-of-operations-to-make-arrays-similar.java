//the basic intuition behind the question is first an observation
//observation 1:- the parity of a number in nums will never change while adding or subtracting 2 , so that means to make an even number of target we have to select an even number from the nums, similarily is the case with the odd numbers of target.
//Observation 2:- increasing in one number means taking two from another number of array and adding in that number, that is the operations are consistent.
//Observation 3:- odd number from target and nums and even numbers from target and nums can be treated seperately. 
//Use sorting

class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        ArrayList<Integer> numOdd = new ArrayList<Integer>();
        ArrayList<Integer> numEven = new ArrayList<Integer>();
        ArrayList<Integer> targetOdd = new ArrayList<>();
        ArrayList<Integer> targetEven = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                numEven.add(nums[i]);
            }else{
                numOdd.add(nums[i]);
            }
        }
        for(int i=0;i<target.length;i++){
            if(target[i]%2==0){
                targetEven.add(target[i]);
            }else{
                targetOdd.add(target[i]);
            }
        }
        Collections.sort(targetEven);
        Collections.sort(targetOdd);
        Collections.sort(numEven);
        Collections.sort(numOdd);
        long ans = 0;
        for(int i=0;i<targetEven.size();i++){
            ans += Math.abs(targetEven.get(i)-numEven.get(i))/2;
        }
        //ans/=2;
        long ans1 = 0;
        for(int i=0;i<targetOdd.size();i++){
            ans1+=Math.abs(targetOdd.get(i)-numOdd.get(i))/2;
        }
        //ans1=ans1/2;
        return (ans+ans1)/2;
    }
}