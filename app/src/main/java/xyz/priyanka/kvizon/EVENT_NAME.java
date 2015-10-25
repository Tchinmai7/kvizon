package xyz.priyanka.kvizon;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class EVENT_NAME extends Activity {
 int counter=0,checker;
   int[] ans;
    int[] getanswers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String[] str=new String[20];
        // these questions are stored for c you have to remove this since some operators are considered as illegal in xml i have stored these haere
        //such questions can be stored in an string array in xml itself dont confuse with this part
        str[0]="void main()\n" +
                "{\n" +
                "int a = 2 + 4 + 3 * 5 / 3 - 5;\n" +
                "printf(\"%d\", a);\n" +
                "}";
        str[1]="void main()\n" +
                "{\n" +
                "int a = 5 * 3 + 2 - 4;\n" +
                "printf(\"%d\", a);\n" +
                "}";
        str[2]="int main()\n" +
                " {\n" +
                " int x = 0, y = 2;\n" +
                " if (!x && y)\n" +
                " printf(\"true\\n\");\n" +
                " else\n" +
                " printf(\"false\\n\");\n" +
                " }";
        str[3]="int main()\n" +
                " {\n" +
                " int x = 2, y = 2;\n" +
                " int z = x ^ y & 1;\n" +
                "  printf(\"%d\\n\", z);\n" +
                "  }";
        str[4]="void main()\n" +
                "{\n" +
                "double b = 3 % 0 * 1 - 4 / 2;\n" +
                "printf(\"%lf\", b);\n" +
                "}";
        str[5]="void main()\n" +
                "{\n" +
                "double b = 3 && 5 & 4 % 3;\n" +
                "printf(\"%lf\", b);\n" +
                "}";
        str[6]="void main()\n" +
                "{\n" +
                "double b = 5 & 3 && 4 || 5 | 6;\n" +
                "printf(\"%lf" +
                "\", b);\n" +
                "}";
        str[7]="void main()\n" +
                "{\n" +
                "int k = 0;\n" +
                "double b = k++ + ++k + k--;\n" +
                "printf(\"%d\", k);\n" +
                "}\n";
        str[8]=" void main()\n" +
                " {\n" +
                " int b = 5 & 4 & 6;\n" +
                " printf(\"%d\", b);\n" +
                " }";
        str[9]="void main()\n" +
                " {\n" +
                " int b = 5 & 4 | 6;\n" +
                " printf(\"%d\", b);\n" +
                " }\n";
        str[10]="void main()\n" +
                "{\n" +
                "int b = 5 + 7 * 4 - 9 * (3, 2);\n" +
                " printf(\"%d\", b);\n" +
                " }";
        str[11]="void main()\n" +
                "{\n" +
                "int h = 8;\n" +
                "int b = (h++, h++);\n" +
                "printf(\"%d%d\\n\", b, h);\n" +
                "}";
        str[12]="void main()\n" +
                "{\n" +
                "int h = 8;\n" +
                "int b = 4 * 6 + 3 * 4 < 3 ? 4 : 3;\n" +
                "printf(\"%d\\n\", b);\n" +
                "}";
        str[13]="void main()\n" +
                "{\n" +
                "int a = 2 + 3 - 4 + 8 -  5 % 4;\n" +
                "printf(\"%d\\n\", a);\n" +
                "}";
        str[14]="void main()\n" +
                "{\n" +
                "char a = 'A';\n" +
                "char b = 'B';\n" +
                "int c = a + b % 3 - 3 * 2;\n" +
                "printf(\"%d\\n\", c);\n" +
                "}";
        str[15]="Which of the following operators has an associativity from Right to Left?";
        str[16]="Which of the following option is the correct representation of the following code? e = a * b + c / d * f;";
        str[17]="Which of the following operator has the highest precedence in the following?";
        str[18]="Associativity of an operator can be:";
        str[19]=" Which of the following operators has the lowest precedence?";
        //end of questions

        //DECLARATION OF STRING VARIABLES FOR OPTIONS AND GETTING THE VALUES FROM A XML FILE
        final String[] optiona= getResources().getStringArray(R.array.optiona);
        final String[] optionb= getResources().getStringArray(R.array.optionb);
        final String[] optionc= getResources().getStringArray(R.array.optionc);
        final String[] optiond= getResources().getStringArray(R.array.optiond);
        final String lock="Your Option is ";
        ans= getResources().getIntArray(R.array.answers);
        //END OF RETRIVING VALUES FROM XML FILES
        getanswers=new int[20];
        setContentView(R.layout.activity_event__name);
        //DECLARATION OF BUTTONS AND TEXTVIEW
        final Button a=(Button)findViewById(R.id.next);
   //     final Button b=(Button)findViewById(R.id.finish);
        final Button c=(Button)findViewById(R.id.prev);
        final TextView tv1=(TextView)findViewById(R.id.t1);
        final TextView tv2=(TextView)findViewById(R.id.t2);
        final TextView tv3=(TextView)findViewById(R.id.t3);
        final TextView tv4=(TextView)findViewById(R.id.t4);
        final TextView tv5=(TextView)findViewById(R.id.t5);
        final TextView tv6=(TextView)findViewById(R.id.t6);
//SETTING UP THE INITIAL VALUES FOR TEXTVIEW i.e THE FIRST QUESTION
            tv1.setText(str[0]);
            tv2.setText(optiona[0]);
        tv3.setText(optionb[0]);
        tv4.setText(optionc[0]);
        tv5.setText(optiond[0]);
        //IMPLEMENTING EVENTLISTENER FOR NEXT BUTTON
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                c.setClickable(true);
                if(counter==20)
                {
                    a.setClickable(false);
                    String str=checkanswers();
                    Intent intent=new Intent(EVENT_NAME.this,MainActivity.class);
                    intent.putExtra("score",str);
                    startActivity(intent);
                }
                else
                {
                   if(getanswers[counter]==0){
                    tv1.setText(str[counter]);
                    tv2.setText(optiona[counter]);
                    tv3.setText(optionb[counter]);
                    tv4.setText(optionc[counter]);
                    tv5.setText(optiond[counter]);
                    tv2.setBackgroundColor(Color.WHITE);
                    tv3.setBackgroundColor(Color.WHITE);
                    tv4.setBackgroundColor(Color.WHITE);
                    tv5.setBackgroundColor(Color.WHITE);
                    tv6.setText("");}
                    else
                   {
                       if(getanswers[counter]==1)
                       {
                           tv2.setBackgroundColor(Color.YELLOW);
                           tv3.setBackgroundColor(Color.WHITE);
                           tv4.setBackgroundColor(Color.WHITE);
                           tv5.setBackgroundColor(Color.WHITE);
                       }
                       if(getanswers[counter]==2){
                           tv3.setBackgroundColor(Color.YELLOW);
                           tv2.setBackgroundColor(Color.WHITE);
                           tv4.setBackgroundColor(Color.WHITE);
                           tv5.setBackgroundColor(Color.WHITE);}
                       if(getanswers[counter]==3){
                           tv4.setBackgroundColor(Color.YELLOW);
                           tv2.setBackgroundColor(Color.WHITE);
                           tv3.setBackgroundColor(Color.WHITE);
                           tv5.setBackgroundColor(Color.WHITE);}
                       if(getanswers[counter]==4){
                           tv5.setBackgroundColor(Color.YELLOW);
                           tv2.setBackgroundColor(Color.WHITE);
                           tv3.setBackgroundColor(Color.WHITE);
                           tv4.setBackgroundColor(Color.WHITE);
                       }
                   }
                }
            }
        });
        //IMPLEMENTING EVENT LISTENER FOR PREVIOUS BUTTON
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                a.setClickable(true);
                if(counter==0)
                {
                    c.setClickable(false);
                }
                if(counter==-1)
                {
                    counter=0;
                }
              else
                {
                    if(getanswers[counter]==0)
                    {
                    tv1.setText(str[counter]);
                    tv2.setText(optiona[counter]);
                    tv3.setText(optionb[counter]);
                    tv4.setText(optionc[counter]);
                    tv5.setText(optiond[counter]);
                    tv2.setBackgroundColor(Color.WHITE);
                    tv3.setBackgroundColor(Color.WHITE);
                    tv4.setBackgroundColor(Color.WHITE);
                    tv5.setBackgroundColor(Color.WHITE);
                    tv6.setText("");
                }
                else
                    {
                        tv1.setText(str[counter]);
                        tv2.setText(optiona[counter]);
                        tv3.setText(optionb[counter]);
                        tv4.setText(optionc[counter]);
                        tv5.setText(optiond[counter]);
                       if(getanswers[counter]==1)
                       {
                           tv2.setBackgroundColor(Color.YELLOW);
                           tv3.setBackgroundColor(Color.WHITE);
                           tv4.setBackgroundColor(Color.WHITE);
                           tv5.setBackgroundColor(Color.WHITE);
                       }
                        if(getanswers[counter]==2){
                        tv3.setBackgroundColor(Color.YELLOW);
                            tv2.setBackgroundColor(Color.WHITE);
                            tv4.setBackgroundColor(Color.WHITE);
                            tv5.setBackgroundColor(Color.WHITE);}
                        if(getanswers[counter]==3){
                        tv4.setBackgroundColor(Color.YELLOW);
                            tv2.setBackgroundColor(Color.WHITE);
                            tv3.setBackgroundColor(Color.WHITE);
                            tv5.setBackgroundColor(Color.WHITE);}
                        if(getanswers[counter]==4){
                        tv5.setBackgroundColor(Color.YELLOW);
                            tv2.setBackgroundColor(Color.WHITE);
                            tv3.setBackgroundColor(Color.WHITE);
                            tv4.setBackgroundColor(Color.WHITE);
                            }

                    }

                }

            }
        });
        //IMPLEMENTING EVENT LISTENER FOR FIRST TEXTVIEW
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locker=lock+"a";
                tv2.setBackgroundColor(Color.YELLOW);
                tv3.setBackgroundColor(Color.WHITE);
                tv4.setBackgroundColor(Color.WHITE);
                tv5.setBackgroundColor(Color.WHITE);
                getanswers[counter]=1;
                tv6.setText(locker);
            }
        });
        //IMPLEMENTING EVENT LISTENER FOR SECOND TEXTVIEW
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locker=lock+"b";
                tv3.setBackgroundColor(Color.YELLOW);
                tv2.setBackgroundColor(Color.WHITE);
                tv4.setBackgroundColor(Color.WHITE);
                tv5.setBackgroundColor(Color.WHITE);
                getanswers[counter]=2;
                tv6.setText(locker);
            }
        });
        //IMPLEMENTING EVENT LISTENER FOR THIRD TEXTVIEW
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locker=lock+"c";
                tv4.setBackgroundColor(Color.YELLOW);
                tv3.setBackgroundColor(Color.WHITE);
                tv2.setBackgroundColor(Color.WHITE);
                tv5.setBackgroundColor(Color.WHITE);
                getanswers[counter]=3;
                tv6.setText(locker);
            }
        });
        //IMPLEMENTING EVENT LISTENER FOR FOURTH TEXTVIEW
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String locker=lock+"d";
                tv5.setBackgroundColor(Color.YELLOW);
                tv3.setBackgroundColor(Color.WHITE);
                tv4.setBackgroundColor(Color.WHITE);
                tv2.setBackgroundColor(Color.WHITE);
                getanswers[counter]=4;
                tv6.setText(locker);
            }
        });
        ////IMPLEMENTING EVENT LISTENER FOR FINISH BUTTON
    /*    b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str="Your Score is";
                tv6.setText(str);
            }
        });*/
    }

public String checkanswers()
{
    String str="";
    int i;
    checker=0;
    for(i=0;i<20;i++)
    {
        if(ans[i]==getanswers[i])
        {
            checker++;
        }
    }
    str=str+Integer.toString(checker);
    return str;

}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    //   getMenuInflater().inflate(R.menu.event__name, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}
