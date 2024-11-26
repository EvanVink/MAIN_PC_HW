package bcit.NumberGame;

import java.util.ArrayList;

public class NumberGame extends Numbers {


    @Override
    public int insertNumber(int number, int col, int row) {
        editGrid(number, col, row);



        return number;
    }

    @Override
    public boolean checkGame(int index, int row, int col) {

        //need to check all possible spots
        //loop through the array until the old number is higher than the new number
        //and check if the spot is available
        boolean passed = false;
        ArrayList<Boolean> spots;
        spots = new ArrayList<>();


        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 5; j++){
                int currentNumber = getGrid()[i][j];

                int nextNumber = getRandNumbers().get(index + 1);

                if(nextNumber < getGrid()[i][j]){
                    passed = true;
                }


                if(ifAvaliableSpot(i, j) && !passed){





                    if(currentNumber == 0){
//                        System.out.println("valid spot: " + i + ", " + j + "\n");
                        spots.add(true);
                    }


                }



                if(passed){
//                    System.out.println("invalid spot: " + i + ", " + j + "\n");
                    spots.add(false);
                }





            }
        }

        if(spots.stream().noneMatch(truth -> truth)){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void resetGame() {
        resetGrid();
        resetVariables();
    }

    @Override
    public Boolean ifAvaliableSpot(int row, int col){
        if(getGrid()[row][col] == 0){
            return true;
        } else {
            return false;
        }
    }


}
