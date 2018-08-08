package com.onurakcay.myapplication;

import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.nio.DoubleBuffer;


public class MainActivity extends AppCompatActivity  {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    //variables that i'm going to use:
    private TextView textview;
    private double valueOne=0,valueTwo=0;
    private Button btnDelete,btnDivide,btnMultiply,btnBack,btn7,btn8,btn9,
            btnSub,btn4,btn5,btn6,btnPlus,btn1,btn2,btn3,btnPrime,btn0,btnDot,btnFactorial,btnEqual;
    private int act=-1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //converted them into variables that i can use during the coding part
        textview=(TextView)findViewById(R.id.textView);
        btnDelete=(Button)findViewById(R.id.buttonDelete);
        btnDivide=(Button)findViewById(R.id.buttonDivide);
        btnMultiply=(Button)findViewById(R.id.buttonMultiply);
        btnBack=(Button)findViewById(R.id.buttonBack);
        btn7=(Button)findViewById(R.id.button7);
        btn8=(Button)findViewById(R.id.button8);
        btn9=(Button)findViewById(R.id.button9);
        btnSub=(Button)findViewById(R.id.buttonSub);
        btn4=(Button)findViewById(R.id.button4);
        btn5=(Button)findViewById(R.id.button5);
        btn6=(Button)findViewById(R.id.button6);
        btnPlus=(Button)findViewById(R.id.buttonPlus);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btnPrime=(Button)findViewById(R.id.buttonPrime);
        btn0=(Button)findViewById(R.id.button0);
        btnDot=(Button)findViewById(R.id.buttonDot);
        btnFactorial=(Button)findViewById(R.id.buttonFactorial);
        btnEqual=(Button)findViewById(R.id.buttonEquals);

        btnPlus.setEnabled(false);
        btnSub.setEnabled(false);
        btnMultiply.setEnabled(false);
        btnDivide.setEnabled(false);
        btnFactorial.setEnabled(false);
        btnPrime.setEnabled(false);
        //Delete button sets the text null
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText("");
                valueOne=0;
                valueTwo=0;
                act=-1;

                btnPlus.setEnabled(false);
                btnSub.setEnabled(false);
                btnMultiply.setEnabled(false);
                btnDivide.setEnabled(false);
                btnFactorial.setEnabled(false);
                btnPrime.setEnabled(false);
                btnEqual.setEnabled(true);
            }
        });

        //if the divide operation clicked then o_divide becomes true and text is null for new values
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valueOne=Double.parseDouble(textview.getText()+"");
                if(valueOne!=0)
                {


                     act=3;
                    textview.append(" / ");
                    btnPlus.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMultiply.setEnabled(false);
                    btnDivide.setEnabled(false);
                    btnFactorial.setEnabled(false);
                    btnPrime.setEnabled(false);
                    btnEqual.setEnabled(true);

                }
                else
                {
                    textview.setText("");
                    Toast.makeText(getApplicationContext(), "Enter an input", Toast.LENGTH_LONG).show();
                }
            }
        });

        //similar with divide
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valueOne = Double.parseDouble(textview.getText() + "");
                if(valueOne!=0) {

                    act = 2;
                    textview.append(" x ");
                    btnPlus.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMultiply.setEnabled(false);
                    btnDivide.setEnabled(false);
                    btnFactorial.setEnabled(false);
                    btnPrime.setEnabled(false);
                    btnEqual.setEnabled(true);
                }
                 else
                {
                    textview.setText("");
                    Toast.makeText(getApplicationContext(), "Enter an input", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Back button deletes only the last entry
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(valueOne!=0&&textview.length()!=0) {
                    String a =textview.getText().subSequence(0, textview.getText().length() - 1).toString();
                    if(a.contains("+")||a.contains("-")||a.contains("*")||a.contains("/")) {
                        textview.setText(a);
                    }
                    else
                    {
                        textview.setText(a);
                        btnPlus.setEnabled(true);
                        btnSub.setEnabled(true);
                        btnMultiply.setEnabled(true);
                        btnDivide.setEnabled(true);
                        btnFactorial.setEnabled(true);
                        btnPrime.setEnabled(true);
                        btnEqual.setEnabled(false);

                }
                }
                 else
                {
                    textview.setText("");
                    Toast.makeText(getApplicationContext(), "Enter an input", Toast.LENGTH_LONG).show();
                    btnPlus.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMultiply.setEnabled(false);
                    btnDivide.setEnabled(false);
                    btnFactorial.setEnabled(false);
                    btnPrime.setEnabled(false);
                    btnEqual.setEnabled(false);
                    act=-1;

                }
            }
        });

        //similar with divide
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valueOne = Double.parseDouble(textview.getText() + "");
                if(valueOne!=0) {

                    act = 1;
                    textview.append(" - ");
                    btnPlus.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMultiply.setEnabled(false);
                    btnDivide.setEnabled(false);
                    btnFactorial.setEnabled(false);
                    btnPrime.setEnabled(false);
                    btnEqual.setEnabled(true);
                }
                 else
                {
                    textview.setText("");
                    Toast.makeText(getApplicationContext(), "Enter an input", Toast.LENGTH_LONG).show();
                }
            }
        });

        //similar with divide
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(ans!=0){
                textview.setText(ans+"");}*/
                valueOne = Double.parseDouble(textview.getText() + "");
                if(valueOne!=0||act!=-1) {

                    act = 0;
                    textview.append("+");
                    btnPlus.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMultiply.setEnabled(false);
                    btnDivide.setEnabled(false);
                    btnFactorial.setEnabled(false);
                    btnPrime.setEnabled(false);
                    btnEqual.setEnabled(true);
                }

                 else
                {
                    textview.setText("");
                    Toast.makeText(getApplicationContext(), "Enter an input", Toast.LENGTH_LONG).show();
                }

            }
        });

        //for creating double values
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText()+".");
            }
        });

        //completing the operation
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (act==-1&&textview.length()==0)
                {

                    textview.setText("");
                    Toast.makeText(getApplicationContext(), "Enter an input", Toast.LENGTH_LONG).show();
                }
                else
                {
                    /*btnPlus.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMultiply.setEnabled(false);
                    btnDivide.setEnabled(false);
                    btnFactorial.setEnabled(false);
                    //btnPrime.setEnabled(false);
                    //btnEqual.setEnabled(false);*/

                    if (act == 0) {

                        String plus[] = textview.getText().toString().split("\\+");

                        if(plus.length>1){



                        valueTwo = Double.parseDouble(plus[1]+"");
                        String numberAsString = String.format("%.1f", Double.parseDouble(Calculator(valueOne,valueTwo,act)+""));
                        String number = numberAsString;
                        String [] num = number.split(",");

                            if (Integer.parseInt(num[1]) == 0) {
                                textview.append("=" + num[0] + "");

                            } else {
                                textview.append("=" + numberAsString + "");

                            }
                            btnPlus.setEnabled(false);
                            btnSub.setEnabled(false);
                            btnMultiply.setEnabled(false);
                            btnDivide.setEnabled(false);
                            btnFactorial.setEnabled(false);
                            btnEqual.setEnabled(false);
                            btnPrime.setEnabled(false);
                        }
                        else
                        {

                           Toast.makeText(getApplicationContext(), "You can't do that again.", Toast.LENGTH_LONG).show();
                        }
                        /*if (Double.parseDouble(separated[1]) == 0) {
                            textview.setText(separated[0] + "");
                        }

                        else
                        {
                            String numberAsString = String.format("%.2f", Double.parseDouble(plus[1]));
                            textview.append("="+numberAsString);
                        }
                        */

                    }
                    if (act == 1) {

                        String currentString = textview.getText().toString();
                        String[] multiply = currentString.split("-");
                        valueTwo = Double.parseDouble(multiply[1]+"");
                        String numberAsString = String.format("%.2f", Double.parseDouble(Calculator(valueOne,valueTwo,act)+""));
                        String number = numberAsString;
                        String [] num = number.split(",");
                        if (Integer.parseInt(num[1]) == 0) {
                            textview.append("=" + num[0] + "");

                        } else {

                            textview.append("=" + numberAsString + "");

                        }

                        btnPrime.setEnabled(false);
                        btnPlus.setEnabled(false);
                        btnSub.setEnabled(false);
                        btnMultiply.setEnabled(false);
                        btnDivide.setEnabled(false);
                        btnFactorial.setEnabled(false);
                        btnEqual.setEnabled(false);


                    }
                    if (act == 2) {

                        String currentString = textview.getText().toString();
                        String[] multiply = currentString.split("x");
                        valueTwo = Double.parseDouble(multiply[1]+"");
                        String numberAsString = String.format("%.2f", Double.parseDouble(Calculator(valueOne,valueTwo,act)+""));
                        String number = numberAsString;
                        String [] num = number.split(",");
                        if (Integer.parseInt(num[1]) == 0) {
                            textview.append("=" + num[0] + "");

                        } else {
                            textview.append("=" + numberAsString + "");

                        }

                        btnPrime.setEnabled(false);
                        btnPlus.setEnabled(false);
                        btnSub.setEnabled(false);
                        btnMultiply.setEnabled(false);
                        btnDivide.setEnabled(false);
                        btnFactorial.setEnabled(false);
                        btnEqual.setEnabled(false);
                        /*if (Double.parseDouble(separated[1]) == 0) {
                            textview.setText(separated[0] + "");
                        }

                        else
                        {
                            String numberAsString = String.format("%.2f", Double.parseDouble(plus[1]));
                            textview.append("="+numberAsString);
                        }
                        */

                    }


                    if (act == 3) {
                        String currentString = textview.getText().toString();
                        String[] divide = currentString.split("/");
                        valueTwo = Double.parseDouble(divide[1]+"");
                            if (valueTwo != 0) {


                                String numberAsString = String.format("%.2f", Double.parseDouble(Calculator(valueOne,valueTwo,act)+""));
                                String number = numberAsString;
                                String [] num = number.split(",");
                                if (Integer.parseInt(num[1]) == 0) {
                                    textview.append("=" + num[0] + "");

                                } else {

                                    textview.append("=" + numberAsString + "");

                                }



                            }
                            else {
                                Toast.makeText(getApplicationContext(), "Can not divide zero", Toast.LENGTH_LONG).show();

                                textview.setText("");
                                act=-1;

                            }

                        btnPrime.setEnabled(false);
                        btnPlus.setEnabled(false);
                        btnSub.setEnabled(false);
                        btnMultiply.setEnabled(false);
                        btnDivide.setEnabled(false);
                        btnFactorial.setEnabled(false);
                        btnEqual.setEnabled(false);
                        }





                }

            }
        });

        //Number buttons for creating a value:
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText()+"1");
                if(valueOne==0)
                {
                    btnPlus.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMultiply.setEnabled(true);
                    btnDivide.setEnabled(true);
                    btnFactorial.setEnabled(true);
                    btnPrime.setEnabled(true);
                }

                    /*btnPlus.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMultiply.setEnabled(true);
                    btnDivide.setEnabled(true);
                    btnFactorial.setEnabled(true);
                    btnPrime.setEnabled(true);*/




            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText()+"2");
                if(valueOne==0)
                {
                    btnPlus.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMultiply.setEnabled(true);
                    btnDivide.setEnabled(true);
                    btnFactorial.setEnabled(true);
                    btnPrime.setEnabled(true);
                }


            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText()+"3");
                if(valueOne==0)
                {
                    btnPlus.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMultiply.setEnabled(true);
                    btnDivide.setEnabled(true);
                    btnFactorial.setEnabled(true);
                    btnPrime.setEnabled(true);
                }


                }



        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText()+"4");
                if(valueOne==0)
                {
                    btnPlus.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMultiply.setEnabled(true);
                    btnDivide.setEnabled(true);
                    btnFactorial.setEnabled(true);
                    btnPrime.setEnabled(true);
                }



            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText()+"5");
                if(valueOne==0)
                {
                    btnPlus.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMultiply.setEnabled(true);
                    btnDivide.setEnabled(true);
                    btnFactorial.setEnabled(true);
                    btnPrime.setEnabled(true);
                }



            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "6");
                if(valueOne==0)
                {
                    btnPlus.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMultiply.setEnabled(true);
                    btnDivide.setEnabled(true);
                    btnFactorial.setEnabled(true);
                    btnPrime.setEnabled(true);
                }


            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText()+"7");
                if(valueOne==0)
                {
                    btnPlus.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMultiply.setEnabled(true);
                    btnDivide.setEnabled(true);
                    btnFactorial.setEnabled(true);
                    btnPrime.setEnabled(true);
                }


                }

        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText()+"8");
                if(valueOne==0)
                {
                    btnPlus.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMultiply.setEnabled(true);
                    btnDivide.setEnabled(true);
                    btnFactorial.setEnabled(true);
                    btnPrime.setEnabled(true);
                }


                }

        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "9");
                if(valueOne==0)
                {
                    btnPlus.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMultiply.setEnabled(true);
                    btnDivide.setEnabled(true);
                    btnFactorial.setEnabled(true);
                    btnPrime.setEnabled(true);
                }

            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText()+"0");

                if(valueOne==0)
                {
                    btnPlus.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMultiply.setEnabled(true);
                    btnDivide.setEnabled(true);
                    btnFactorial.setEnabled(true);
                    btnPrime.setEnabled(true);
                }

                }

        });

        //after the value is given prime button determines if the given value is prime or not or is it valid
        btnPrime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               //valueOne=ans;
                 valueOne = Double.parseDouble(textview.getText() + "");
                if(valueOne!=0)
                {
                    /*String number = valueOne+"";
                    String [] num = number.split(",");
                    if (Integer.parseInt(num[1]) == 0) {
                        textview.setText(num[0]+"");

                    }
                    else
                    {
                        textview.setText(valueOne+"");
                    }

                    btnPlus.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMultiply.setEnabled(true);
                    btnDivide.setEnabled(true);
                    btnFactorial.setEnabled(true);

                    act=-1;
*/

                boolean prime = false;
                if (valueOne % 1 == 0 && valueOne > 1) {
                    for (int i = 2; i <= valueOne / 2; i++) {
                        if (valueOne % i == 0) {
                            prime = false;
                            break;
                        } else {
                            prime = true;
                        }
                    }
                    if (!prime) {
                        Toast.makeText(getApplicationContext(), "Not prime", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Prime", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Value", Toast.LENGTH_LONG).show();
                }

            }
            else
                {
                    Toast.makeText(getApplicationContext(), "Enter an input", Toast.LENGTH_LONG).show();
                }

            }

        });

        //after the value is given factorial button calculates the factorial of given value if it is valid
        btnFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                valueOne = Double.parseDouble(textview.getText() + "");
                if(valueOne!=0)
                {

                int result = 1;
                if (valueOne % 1 == 0 && valueOne > 0) {
                    for (int i = 1; i <= valueOne; i++) {
                        result = result * i;
                    }
                    valueOne=result;
                    //Toast.makeText(getApplicationContext(), val + "", Toast.LENGTH_LONG).show();

                    textview.setText(valueOne+"");
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Value", Toast.LENGTH_LONG).show();
                }
            }
            else
                {
                    Toast.makeText(getApplicationContext(), "Enter an input", Toast.LENGTH_LONG).show();
                }
            }
        });




    }






    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native double Calculator(double a,double b,int c);


}


