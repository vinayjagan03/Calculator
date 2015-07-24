package vinay.com.calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {


    String first = "";
    String last = "";
    int operator = 0;
    boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText textField = (EditText) findViewById(R.id.textField);
        textField.setText("0.0");
        ArrayList<Button> numbers = new ArrayList<Button>();
        numbers.add((Button) findViewById(R.id.button1));
        numbers.add((Button) findViewById(R.id.button2));
        numbers.add((Button) findViewById(R.id.button3));
        numbers.add((Button) findViewById(R.id.button4));
        numbers.add((Button) findViewById(R.id.button5));
        numbers.add((Button) findViewById(R.id.button6));
        numbers.add((Button) findViewById(R.id.button7));
        numbers.add((Button) findViewById(R.id.button8));
        numbers.add((Button) findViewById(R.id.button9));
        numbers.add((Button) findViewById(R.id.button0));
        for (int i = 0; i < numbers.size(); i++) {
            final Button b = numbers.get(i);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (operator == 0) {
                        Log.d("Activity", "First Button: " + b.getText());
                        first += b.getText().toString();
                    } else {
                        Log.d("Activity", "last Button: " + b.getText());
                        last += b.getText().toString();

                    }
                }
            });
        }

        operatorEvents();

        findViewById(R.id.buttonEqu).setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                double value = 0;
                                                                EditText textField = (EditText) findViewById(R.id.textField);
                                                                if (operator == 1) {
                                                                    value = Double.parseDouble(first) + Double.parseDouble(last);
                                                                }
                                                                if (operator == 2) {
                                                                    value = Double.parseDouble(first) - Double.parseDouble(last);
                                                                }
                                                                if (operator == 3) {
                                                                    value = Double.parseDouble(first) * Double.parseDouble(last);
                                                                }
                                                                if (operator == 4) {
                                                                    value = Double.parseDouble(first) / Double.parseDouble(last);
                                                                }
                                                                textField.setText(Double.toString(value));
                                                            }
                                                        }

        );
        findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textField = (EditText) findViewById(R.id.textField);
                operator = 0;
                first = "";
                last = "";
                textField.setText("0.0");
            }
        });
    }

    private void disableOnClick(ArrayList<Button> buttons) {
        for (int i = 0; i < buttons.size(); i++) {
            Button b = buttons.get(i);
            b.setOnClickListener(null);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void operatorEvents() {
        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = 1;
            }
        });
        findViewById(R.id.buttonSub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = 2;
            }
        });
        findViewById(R.id.buttonMul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = 3;
            }
        });
        findViewById(R.id.buttonDiv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = 4;
            }
        });
    }
}
