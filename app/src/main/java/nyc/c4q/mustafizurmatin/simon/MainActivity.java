package nyc.c4q.mustafizurmatin.simon;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //private TextView textview;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    //randomly generated
    int randomColor[] = {Color.RED, Color.BLUE,Color.YELLOW, Color.GREEN};
    // random color
    ArrayList<Integer> randomSimon = new ArrayList<>();
    // play color
    ArrayList<Integer> playerColors = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonOne = (Button) findViewById(R.id.one);
        buttonTwo = (Button) findViewById(R.id.two);
        buttonThree = (Button) findViewById(R.id.three);
        buttonFour = (Button) findViewById(R.id.four);
        buttonOne.setText("Yellow");
        buttonTwo.setText("Blue");
        buttonThree.setText("Red");
        buttonFour.setText("Green");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startSimon();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                switchBack();




            }
        }, 5000);




    }

    public void button(View view) {

    }

    //add random color to simon's arraylist
    public void startSimon() {
        int simonColor = (randomColor[new Random().nextInt(randomColor.length)]);

        for (int Color:randomColor){
            randomSimon.add(Color);


        }



    }

    public void simonsTurn() {
        for (Integer simonColor : randomSimon) {
            switch (simonColor) {
                case Color.YELLOW:
                    buttonOne.setBackgroundColor(buttonOne.getContext().getResources().getColor(R.color.colorWhite));
                    break;
                case Color.RED:
                    buttonTwo.setBackgroundColor(buttonTwo.getContext().getResources().getColor(R.color.colorWhite));
                    break;
                case Color.BLUE:
                    buttonThree.setBackgroundColor(buttonThree.getContext().getResources().getColor(R.color.colorWhite));
                    break;
                case Color.GREEN:
                    buttonFour.setBackgroundColor(buttonFour.getContext().getResources().getColor(R.color.colorWhite));
                    break;



            }



        }

    }
    public void switchBack(){
        for (Integer simonColor : randomSimon) {
            switch (simonColor) {
                case Color.YELLOW:
                    buttonOne.setBackgroundColor(buttonOne.getContext().getResources().getColor(R.color.button));
                    break;
                case Color.RED:
                    buttonTwo.setBackgroundColor(buttonTwo.getContext().getResources().getColor(R.color.buttonTwo));
                    break;
                case Color.BLUE:
                    buttonThree.setBackgroundColor(buttonThree.getContext().getResources().getColor(R.color.buttonThree));
                    break;
                case Color.GREEN:
                    buttonFour.setBackgroundColor(buttonFour.getContext().getResources().getColor(R.color.buttonFour));
                    break;


            }

        }


    }
    public void playersTurn(Integer Color){



    }

}
