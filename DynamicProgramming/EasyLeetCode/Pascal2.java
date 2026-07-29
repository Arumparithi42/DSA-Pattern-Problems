public class Pascal2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for( int i = 0; i <= rowIndex; i++){
            row.add(1);
        }
        for(int i = 1; i < rowIndex; i++){ // since [1] and [1,1] size is 2 is already done
            for(int j = i; j > 0; j--){
                row.set(j, row.get(j) + row.get(j-1));
            }
        } 
        return row;   
    }
}