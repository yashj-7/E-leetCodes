class Solution {
    public int mostWordsFound(String[] sentences) {
        int count = 0;
        for(int i=0;i<sentences.length;i++){
            String[] splitted = sentences[i].split(" ");
            count = Math.max(count,splitted.length);
        }
        return count;
    }
}