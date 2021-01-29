import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class a1_real_Test {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void pdf1(){
        int[] positions = {1,2,3,1};
        int expectedOutput = 3;
        int out = a1_real.silence(positions);
        if(expectedOutput != out){
            fail("Expected output: " + expectedOutput + " instead, got " + out) ;
        }
    }

    @Test
    void pdf2(){
        int[] positions = {1,2,3};
        int expectedOutput = 3;
        int out = a1_real.silence(positions);
        if(expectedOutput != out){
            fail("Expected output: " + expectedOutput + " instead, got " + out) ;
        }
    }

    @Test
    void silence(){
        int successfulIters = 0;
        int size = 2147486;
        for(int i = 1; i < size; i*=2) {
            boolean even = false;
            for(int j = 1; j < size; j*=2) {
                if(!even && j % 2 == 0){
                    j++;
                }
                int[] positions = generatePositions(size, j, 24601);
                int out = a1_real.silence(positions);
                successfulIters++;
                if (j != out) {
                    fail("Expected output: " + j + " instead, got " + out + " ; params of generator are: size: " + size +" gap: " + j + " Successfully ran " + successfulIters + " times");
                }
                even = !even;
            }
        }
    }

    @Test
    void silence2(){
        int[] positions = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,2};
        int expectedOut = 1;
        int out = a1_real.silence(positions);
        if (expectedOut != out) {
            fail("Expected output: " + expectedOut + " instead, got " + out);
        }
    }

    @Test
    void silence3(){
        int[] positions = {1,2,1,2,1,2,1,2};
        int expectedOut = 2;
        int out = a1_real.silence(positions);
        if (expectedOut != out) {
            fail("Expected output: " + expectedOut + " instead, got " + out);
        }
    }


    private static int[] generatePositions(int size, int gap, int seed){
        int[] out;

        //The case where the same number *never* appears
        if(gap >= size - 1){
            out =  new int[size];
            for(int i = 0; i < out.length; i++){
                out[i] = i;
            }
            return out;
        }


        //The case where there is a same number that appears
        Random rand = new Random(seed);
        out = new int[size];
        int chosenOne = rand.nextInt(size - gap - 1);
        for(int i = out.length - 1; i >= 0; i--){
            if(i == chosenOne){
                out[i] = chosenOne;
            }else if(i == chosenOne + gap){
                out[i] = chosenOne;
            }else{
                out[i] = i;
            }
        }
        return out;
    }
}