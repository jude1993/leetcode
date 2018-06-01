public class One_bit_and_two_bitCharacters_717 {
    public boolean isOneBitCharacter(int[] bits) {
        for(int i=0; i<bits.length; i++){
            if(bits[i] == 1){
                if(i == bits.length-2 && bits[i] == 1){
                    return false;
                }
                if(bits[i] == 1){
                    i++;
                }else{
                    continue;
                }
            }
        }
        return true;
    }
}
