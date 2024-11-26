package bcit.NumberGame;

import java.util.ArrayList;
import java.util.Random;

public abstract class Numbers implements Actions {

    int[][] grid;
    ArrayList<Integer> numsPlaced;
    ArrayList<Integer> nums;

    public Numbers(){
        grid = new int[4][5];
        numsPlaced = new ArrayList<Integer>();
        nums = new ArrayList<Integer>();
        Random rand;
        rand = new Random();
        for(int i = 0; i < 20; i++){
            nums.add(rand.nextInt(1, 1000));
        }

        System.out.println(nums);

    }


    public int[][] getGrid(){
        return grid;
    }

    public ArrayList<Integer> getNumsPlaced(){
        return numsPlaced;
    }

    public void addNum(int number){
        numsPlaced.add(number);
    }

    public void editGrid(int number, int row, int col){
        grid[row][col] = number;
    }

    public ArrayList<Integer> getRandNumbers(){
        return nums;
    }

    public abstract Boolean ifAvaliableSpot(int col, int row);

    public void resetVariables() {
        numsPlaced.clear();
        nums = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            nums.add(rand.nextInt(1, 1000));
        }
        System.out.println(nums);
    }

    public void resetGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = 0;
            }
        }
    }


}
