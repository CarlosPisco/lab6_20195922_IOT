package com.example.lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab6.databinding.ActivityMainBinding;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity {



    private ActivityMainBinding binding;

    TextView tv_p1, tv_p2;
    ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24, iv_31, iv_32, iv_33, iv_34;

    //El card Array de todas las imagenes con sus respectivos pares
    Integer[] cardArray = {101,102,103,104,105,106,201,202,203,204,205,206};

    int image101, image102, image103, image104, image105, image106,
            image201, image202, image203, image204, image205, image206;

    int first_Card,second_Card;
    int clickedFirst, clickedSecond;
    int cardNumber=1;

    //int turn = 1;
    int playerPoints = 0;//, cpuPoints = 0;

    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = FirebaseFirestore.getInstance();


        tv_p1 = (TextView) findViewById(R.id.tv_p1);
        tv_p2 = (TextView) findViewById(R.id.tv_p2);

        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);
        iv_14 = (ImageView) findViewById(R.id.iv_14);
        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);
        iv_24 = (ImageView) findViewById(R.id.iv_24);
        iv_31 = (ImageView) findViewById(R.id.iv_31);
        iv_32 = (ImageView) findViewById(R.id.iv_32);
        iv_33 = (ImageView) findViewById(R.id.iv_33);
        iv_34 = (ImageView) findViewById(R.id.iv_34);




        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_14.setTag("3");
        iv_21.setTag("4");
        iv_22.setTag("5");
        iv_23.setTag("6");
        iv_24.setTag("7");
        iv_31.setTag("8");
        iv_32.setTag("9");
        iv_33.setTag("10");
        iv_34.setTag("11");




        frontOfCardResources();

        Collections.shuffle(Arrays.asList(cardArray));




        tv_p2.setTextColor(Color.GRAY);

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_11, theCard);
                Log.d("msg-test", (String) iv_11.getTag() + "card: "+ theCard);
                Log.d("msg-test", String.valueOf(cardArray[theCard]));
            }
        });
        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_12, theCard);
                Log.d("msg-test", (String) iv_11.getTag() + "card: "+ theCard);
            }
        });
        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_13, theCard);
                Log.d("msg-test", (String) iv_11.getTag() + "card: "+ theCard);
            }
        });
        iv_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_14, theCard);
                Log.d("msg-test", (String) iv_11.getTag() + "card: "+ theCard);
            }
        });
        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_21, theCard);
                Log.d("msg-test", (String) iv_11.getTag() + "card: "+ theCard);
            }
        });
        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_22, theCard);
                Log.d("msg-test", (String) iv_11.getTag() + "card: "+ theCard);
            }
        });
        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_23, theCard);
                Log.d("msg-test", (String) iv_11.getTag() + "card: "+ theCard);
            }
        });
        iv_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_24, theCard);
                Log.d("msg-test", (String) iv_11.getTag() + "card: "+ theCard);
            }
        });
        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_31, theCard);
                Log.d("msg-test", (String) iv_11.getTag() + "card: "+ theCard);
            }
        });
        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_32, theCard);
                Log.d("msg-test", (String) iv_11.getTag() + "card: "+ theCard);
            }
        });
        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_33, theCard);
                Log.d("msg-test", (String) iv_11.getTag() + "card: "+ theCard);
            }
        });
        iv_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int theCard = Integer.parseInt((String) v.getTag());
                doStuff(iv_34, theCard);
                Log.d("msg-test", (String) iv_11.getTag() + "card: "+ theCard);
                //El doStuff pasa el id de la img seleccionada
                //y el tag asociado a cada una (0 - 11)
            }
        });

        //verifInicio();


    }

    /**Hubo error con los callbacks, no se pudo sincronizar los requests y la logica usada con estos*/
    /*
    @Override
    protected void onStart() {
        super.onStart();

        JuegoDatos juegoDatos = new JuegoDatos();

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        DatabaseReference posicion = databaseReference.child("Posicion");
        DatabaseReference arrayPosicion = posicion.child("ArrayPosicion");

        arrayPosicion.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){

                    String currentArrayPosicion = snapshot.getValue(String.class);
                    String[] cardArrayPosition = currentArrayPosicion.split(",");

                    juegoDatos.setArrayPosicion(cardArrayPosition);

                    Log.d("msg-test", Arrays.toString(juegoDatos.getArrayPosicion()));
                    //Poner las imagenes en orden pero invisibles si fueron encontradas con su par
                    //o volteadas si tdv no fueron encontradas

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("msg-test","Inicio error front");
            }
        });



        DatabaseReference hideRef = databaseReference.child("Hide");
        DatabaseReference arrayHideRef = hideRef.child("ArrayFront");


        arrayHideRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String currentArrayFront = snapshot.getValue(String.class);
                    String [] cardArrayFront = currentArrayFront.split(",");
                    //De los cards de la bd
                    for (String card : cardArrayFront) {
                        //cardArray[Integer.parseInt(card)]
                        Log.d("msg-test","probando");
                        //cardArray[Integer.parseInt(card)]

                        //verifico el index para poder encontrar su posicion en cardArray, y asi poder
                        //identificar las imagenes
                        int indice = Arrays.asList(juegoDatos.getArrayPosicion()).indexOf(Integer.valueOf(card));
                        Log.d("msg-test", Arrays.toString(juegoDatos.getArrayPosicion()));
                        if(indice==0){
                            iv_11.setImageResource(R.drawable.hide);
                        } else if (indice==1) {
                            iv_12.setImageResource(R.drawable.hide);
                        }
                        else if (indice==2) {
                            iv_13.setImageResource(R.drawable.hide);
                        }
                        else if (indice==3) {
                            iv_14.setImageResource(R.drawable.hide);
                        }
                        else if (indice==4) {
                            iv_21.setImageResource(R.drawable.hide);
                        }
                        else if (indice==5) {
                            iv_22.setImageResource(R.drawable.hide);
                        }else if (indice==6) {
                            iv_23.setImageResource(R.drawable.hide);
                        }
                        else if (indice==7) {
                            iv_24.setImageResource(R.drawable.hide);
                        }
                        else if (indice==8) {
                            iv_31.setImageResource(R.drawable.hide);
                        }
                        else if (indice==9) {
                            iv_32.setImageResource(R.drawable.hide);
                        }
                        else if (indice==10) {
                            iv_33.setImageResource(R.drawable.hide);
                        }
                        else if (indice==11) {
                            iv_34.setImageResource(R.drawable.hide);
                        }

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("msg-test","Inicio error front");
            }
        });

        DatabaseReference foundRef = databaseReference.child("Found");
        DatabaseReference arrayFoundRef = foundRef.child("ArrayFound");

        arrayFoundRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String currentArrayFound = snapshot.getValue(String.class);
                    String[] cardArrayFound = currentArrayFound.split(",");
                    juegoDatos.setArrayFound(cardArrayFound);


                    if(juegoDatos.getArrayFound().length==0){
                        Collections.shuffle(Arrays.asList(cardArray));
                    }else{

                        for (int i = 0; i < juegoDatos.getArrayPosicion().length; i++) {
                            try {
                                cardArray[i] = Integer.parseInt(juegoDatos.getArrayPosicion()[i]);
                            } catch (NumberFormatException e) {

                                cardArray[i] = 0;
                            }
                        }
                    }


                    for (String card : cardArrayFound) {

                        try{
                            int indice = Arrays.asList(juegoDatos.getArrayPosicion()).indexOf(Integer.valueOf(card));

                            if(indice==0){
                                iv_11.setVisibility(View.INVISIBLE);
                            } else if (indice==1) {
                                iv_12.setVisibility(View.INVISIBLE);
                            }
                            else if (indice==2) {
                                iv_13.setVisibility(View.INVISIBLE);
                            }
                            else if (indice==3) {
                                iv_14.setVisibility(View.INVISIBLE);
                            }
                            else if (indice==4) {
                                iv_21.setVisibility(View.INVISIBLE);
                            }
                            else if (indice==5) {
                                iv_22.setVisibility(View.INVISIBLE);
                            }else if (indice==6) {
                                iv_23.setVisibility(View.INVISIBLE);
                            }
                            else if (indice==7) {
                                iv_24.setVisibility(View.INVISIBLE);
                            }
                            else if (indice==8) {
                                iv_31.setVisibility(View.INVISIBLE);
                            }
                            else if (indice==9) {
                                iv_32.setVisibility(View.INVISIBLE);
                            }
                            else if (indice==10) {
                                iv_33.setVisibility(View.INVISIBLE);
                            }
                            else if (indice==11) {
                                iv_34.setVisibility(View.INVISIBLE);
                            }
                        }catch (NumberFormatException e){
                            Log.d("msg-test","Hubo error de parseo NumberFormatException");
                        }




                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("msg-test","Inicio error found");
            }
        });


    }*/

    @Override
    protected void onStop() {
        super.onStop();


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference posicion = databaseReference.child("Posicion");
        DatabaseReference arrayPosicion = posicion.child("ArrayPosicion");

        arrayPosicion.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String cardArrayString = TextUtils.join(",", cardArray);
                    arrayPosicion.setValue(cardArrayString);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("msg-test","Inicio error front");
            }
        });

    }



    private void frontOfCardResources(){

        image101 = R.drawable.abra;
        image102 = R.drawable.aerodactyl;
        image103 = R.drawable.alakazam;
        image104 = R.drawable.arbok;
        image105 = R.drawable.arcanine;
        image106 = R.drawable.articuno;
        image201 = R.drawable.abra;
        image202 = R.drawable.aerodactyl;
        image203 = R.drawable.alakazam;
        image204 = R.drawable.arbok;
        image205 = R.drawable.arcanine;
        image206 = R.drawable.articuno;

    }

    private void doStuff(ImageView iv, int card){

        //Al voltear debe mostrar su respectiva imagen

        //Como el tag asociado a cada img (0 -11)
        //Tbm da la posicion en el card_Array
        //por eso al voltearse muestran los respectivas imagenes
        if(cardArray[card] == 101){
            iv.setImageResource(image101);
        } else if (cardArray[card] == 102) {
            iv.setImageResource(image102);
        } else if (cardArray[card] == 103) {
            iv.setImageResource(image103);
        } else if (cardArray[card] == 104) {
            iv.setImageResource(image104);
        } else if (cardArray[card] == 105) {
            iv.setImageResource(image105);
        } else if (cardArray[card] == 106) {
            iv.setImageResource(image106);
        } else if (cardArray[card] == 201) {
            iv.setImageResource(image201);
        } else if (cardArray[card] == 202) {
            iv.setImageResource(image202);
        } else if (cardArray[card] == 203) {
            iv.setImageResource(image203);
        } else if (cardArray[card] == 204) {
            iv.setImageResource(image204);
        } else if (cardArray[card] == 205) {
            iv.setImageResource(image205);
        }else if (cardArray[card] == 206) {
            iv.setImageResource(image206);
        }


        if(cardNumber == 1){
            first_Card = cardArray[card];
            if(first_Card>200){
                first_Card = first_Card - 100;
            }
            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        } else if (cardNumber==2) {
            second_Card = cardArray[card];
            if(second_Card>200){
                second_Card = second_Card - 100;
            }
            cardNumber = 1;
            clickedSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_14.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_24.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_34.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            },1000);




        }

    }

    private void calculate (){
        //Verificar si las cartas seleccionadas son iguales



        if(first_Card == second_Card){

            Log.d("msg-test", Arrays.toString(cardArray));

            playerPoints++;
            tv_p1.setText("P1 : "+playerPoints);
            //Y verifica las que son ambos pares
            //first y second para ponerlas invisible

            Log.d("msg-test", String.valueOf(first_Card) + String.valueOf(second_Card));

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
            DatabaseReference hideRef = databaseReference.child("Hide");
            DatabaseReference arrayHideRef = hideRef.child("ArrayFront");

            arrayHideRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        String currentArrayFront = snapshot.getValue(String.class);
                        String pairToRemove = String.valueOf(first_Card);
                        String pairToRemove2 = String.valueOf(first_Card+100);

                        String[] cardArray = currentArrayFront.split(",");
                        List<String> newArrayFront = new ArrayList<>();

                        for (String card : cardArray) {
                            if (!card.equals(pairToRemove) && !card.equals(pairToRemove2)) {
                                newArrayFront.add(card);
                            }
                        }

                        String newStringArrayFront = TextUtils.join(",", newArrayFront);

                        arrayHideRef.setValue(newStringArrayFront);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.d("msg-test", "Algo paso");
                }
            });

            DatabaseReference foundRef = databaseReference.child("Found");
            DatabaseReference arrayFound = foundRef.child("ArrayFound");

            arrayFound.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if(snapshot.exists()){
                        String currentArrayFound = snapshot.getValue(String.class);
                        String pairToAdd = String.valueOf(first_Card);
                        String pairToAdd2 = String.valueOf(first_Card+100);

                        List<String> currentFoundList = new ArrayList<>(Arrays.asList(currentArrayFound.split(",")));



                        currentFoundList.add(pairToAdd);
                        currentFoundList.add(pairToAdd2);


                        String newStringArrayFront = TextUtils.join(",", currentFoundList);

                        arrayFound.setValue(newStringArrayFront);

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Log.d("msg-test", "Algo paso");
                }
            });


            if(clickedFirst == 0){
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            }else if (clickedFirst == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            }else if (clickedFirst == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            }else if (clickedFirst == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            }else if (clickedFirst == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            }else if (clickedFirst == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            }else if (clickedFirst == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            }else if (clickedFirst == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            }else if (clickedFirst == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            }else if (clickedFirst == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            }else if (clickedFirst == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            }

            if(clickedSecond == 0){
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            }else if (clickedSecond == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            }else if (clickedSecond == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            }else if (clickedSecond == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            }else if (clickedSecond == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            }else if (clickedSecond == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            }else if (clickedSecond == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            }else if (clickedSecond == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            }else if (clickedSecond == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            }else if (clickedSecond == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            }else if (clickedSecond == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            }

            /*if(turn==1){
                playerPoints++;
                tv_p1.setText("P1: "+playerPoints);
            } else if (turn==2) {
                cpuPoints++;
                tv_p2.setText("P2: "+cpuPoints);

            }*/

        }else{ //si no son iguales se mantiene oculto
            iv_11.setImageResource(R.drawable.hide);
            iv_12.setImageResource(R.drawable.hide);
            iv_13.setImageResource(R.drawable.hide);
            iv_14.setImageResource(R.drawable.hide);
            iv_21.setImageResource(R.drawable.hide);
            iv_22.setImageResource(R.drawable.hide);
            iv_23.setImageResource(R.drawable.hide);
            iv_24.setImageResource(R.drawable.hide);
            iv_31.setImageResource(R.drawable.hide);
            iv_32.setImageResource(R.drawable.hide);
            iv_33.setImageResource(R.drawable.hide);
            iv_34.setImageResource(R.drawable.hide);

            /*if(turn ==1){
                turn = 2;
                tv_p1.setTextColor(Color.GRAY);
                tv_p2.setTextColor(Color.BLACK);
            } else if (turn==2) {
                turn = 1;
                tv_p2.setTextColor(Color.GRAY);
                tv_p1.setTextColor(Color.BLACK);
            }*/

        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_14.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_24.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_34.setEnabled(true);

        checkEnd();

    }

    private void checkEnd(){
        //Si todas son invisibles entonces se acabo el juego
        if(iv_11.getVisibility()==View.INVISIBLE &&
                iv_12.getVisibility()==View.INVISIBLE &&
                iv_13.getVisibility()==View.INVISIBLE &&
                iv_14.getVisibility()==View.INVISIBLE &&
                iv_21.getVisibility()==View.INVISIBLE &&
                iv_22.getVisibility()==View.INVISIBLE &&
                iv_23.getVisibility()==View.INVISIBLE &&
                iv_24.getVisibility()==View.INVISIBLE &&
                iv_31.getVisibility()==View.INVISIBLE &&
                iv_32.getVisibility()==View.INVISIBLE &&
                iv_33.getVisibility()==View.INVISIBLE &&
                iv_34.getVisibility()==View.INVISIBLE ){


            //Dialog Final
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder.setMessage("Game Over\n "+
                    "P1: "+playerPoints).setCancelable(false)
                    .setPositiveButton("Nuevo Juego", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                            DatabaseReference hideRef = databaseReference.child("Hide");
                            DatabaseReference arrayHideRef = hideRef.child("ArrayFront");

                            arrayHideRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if(snapshot.exists()){

                                        arrayHideRef.setValue("101,102,103,104,105,106,201,202,203,204,205,206");
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Log.d("msg-test", "Algo paso");
                                }
                            });

                            DatabaseReference foundRef = databaseReference.child("Found");
                            DatabaseReference arrayFoundRef = foundRef.child("ArrayFound");

                            arrayFoundRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if(snapshot.exists()){
                                        arrayFoundRef.setValue("");
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    Log.d("msg-test", "Algo paso");
                                }
                            });



                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                            startActivity(intent);
                            finish();
                        }
                    }).setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }


}