package nyc.c4q.mustafizurmatin.simon;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final Handler handler = new Handler();

    //private TextView textview;
    private Button buttonYellow;
    private Button buttonRed;
    private Button buttonBlue;
    private Button buttonGreen;
    static String simonColor;
    Boolean gamePlay;
    //randomly generated
    String allColors[] = {"Red", "Blue", "Yellow", "Green"};
    // random color
    ArrayList<String> randomSimon = new ArrayList<>();
    // play color
    ArrayList<String> playerColors = new ArrayList<>();

    Boolean match = true;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startSimon();

        buttonYellow = (Button) findViewById(R.id.yellow);
        buttonYellow.setOnClickListener(this);
        buttonRed = (Button) findViewById(R.id.red);
        buttonRed.setOnClickListener(this);
        buttonBlue = (Button) findViewById(R.id.blue);
        buttonBlue.setOnClickListener(this);
        buttonGreen = (Button) findViewById(R.id.green);
        buttonGreen.setOnClickListener(this);

        buttonYellow.setText("Yellow");
        buttonRed.setText("Red");
        buttonBlue.setText("Blue");
        buttonGreen.setText("Green");


        String color = buttonYellow.getText().toString();
        Log.d("color", color);





            final Button button = (Button) findViewById(R.id.start);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            simonsTurn();
                        }
                    }, 1000);

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            switchBack();

                        }
                    }, 2000);
                }

            });
        }






    //add random color to simon's arraylist
    public void startSimon() {
        simonColor = (allColors[new Random().nextInt(allColors.length - 1)]);
        randomSimon.add(simonColor);


        Log.d("what color?", simonColor);
    }

    public void simonsTurn() {

        for (int i = 0; i < randomSimon.size(); i++) {
            simonColor = randomSimon.get(i);



            switch (simonColor) {
                case "Yellow":
                    buttonYellow.setBackgroundColor(buttonYellow.getContext().getResources().getColor(R.color.colorWhite));
                    Log.d("this was click ", randomSimon.toString());

                    break;
                case "Red":
                    buttonRed.setBackgroundColor(buttonRed.getContext().getResources().getColor(R.color.colorWhite));
                    Log.d("this was click ", randomSimon.toString());
                    break;
                case "Blue":
                    buttonBlue.setBackgroundColor(buttonBlue.getContext().getResources().getColor(R.color.colorWhite));
                    Log.d("this was click ", randomSimon.toString());
                    break;
                case "Green":
                    buttonGreen.setBackgroundColor(buttonGreen.getContext().getResources().getColor(R.color.colorWhite));
                    Log.d("this was click ", randomSimon.toString());
                    break;
            }
        }
    }

    public void switchBack() {

        switch (simonColor) {
            case "Yellow":
                buttonYellow.setBackgroundColor(buttonYellow.getContext().getResources().getColor(R.color.button));
                break;
            case "Red":
                buttonRed.setBackgroundColor(buttonRed.getContext().getResources().getColor(R.color.buttonTwo));
                break;
            case "Blue":
                buttonBlue.setBackgroundColor(buttonBlue.getContext().getResources().getColor(R.color.buttonThree));
                break;
            case "Green":
                buttonGreen.setBackgroundColor(buttonGreen.getContext().getResources().getColor(R.color.buttonFour));
                break;


        }

    }


    public void compare() {
        for (int i = 0; i < playerColors.size(); i++) {
            if (!playerColors.get(i).equals(randomSimon.get(i))) {
                match = false;
                System.out.println("Sorry Game Over ");
            } else {
                match = true;
            }
        }
    }

    String TAG = "";

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.yellow:
                Log.d(TAG, "onClick: button one was clicked ");
                buttonYellow.setBackgroundColor(buttonYellow.getContext().getResources().getColor(R.color.button));

                playerColors.add(buttonYellow.getText().toString());
                break;
            case R.id.red:
                Log.d(TAG, "onClick: button two was clicked ");
                buttonRed.setBackgroundColor(buttonRed.getContext().getResources().getColor(R.color.buttonTwo));

                playerColors.add(buttonRed.getText().toString());

                break;
            case R.id.blue:
                Log.d(TAG, "onClick: button three was clicked ");
                buttonBlue.setBackgroundColor(buttonBlue.getContext().getResources().getColor(R.color.buttonThree));
                playerColors.add(buttonBlue.getText().toString());
                break;
            case R.id.green:
                Log.d(TAG, "onClick: button four was clicked ");
                buttonGreen.setBackgroundColor(buttonGreen.getContext().getResources().getColor(R.color.buttonFour));
                playerColors.add(buttonGreen.getText().toString());
                break;
            default:
                break;


        }

        if (randomSimon.size() == playerColors.size()) {
            playerColors.clear(); // clearing the array becaue they have entered the array each time
            startSimon();
            simonsTurn();
        }
    }
}
