package com.example.tic_tac_toe.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.tic_tac_toe.MainActivity;
import com.example.tic_tac_toe.R;

public class GameFragment extends Fragment {

    private GameViewModel galleryViewModel;

    int playerTurn;
    Button btn00;
    Button btn01;
    Button btn02;
    Button btn10;
    Button btn11;
    Button btn12;
    Button btn20;
    Button btn21;
    Button btn22;
    TextView gameMasterText;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Reset();

        galleryViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        View root = inflater.inflate(R.layout.fragment_game, container, false);
//        final TextView textView = root.findViewById(R.id.text_gallery);
//        galleryViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });


        playerTurn = 0;
        btn00 = (Button) root.findViewById(R.id.btn00);
        btn01 = (Button) root.findViewById(R.id.btn01);
        btn02 = (Button) root.findViewById(R.id.btn02);
        btn10 = (Button) root.findViewById(R.id.btn10);
        btn11 = (Button) root.findViewById(R.id.btn11);
        btn12 = (Button) root.findViewById(R.id.btn12);
        btn20 = (Button) root.findViewById(R.id.btn20);
        btn21 = (Button) root.findViewById(R.id.btn21);
        btn22 = (Button) root.findViewById(R.id.btn22);
        gameMasterText = (TextView) root.findViewById(R.id.GameMaster);


        OnClickListener buttonListener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Button currentBtn;

                switch (v.getId()){
                    case R.id.btn00:
                        currentBtn = btn00;
                        ButtonClick(currentBtn);
                        break;

                    case R.id.btn01:
                        currentBtn = btn01;
                        ButtonClick(currentBtn);
                        break;

                    case R.id.btn02:
                        currentBtn = btn02;
                        ButtonClick(currentBtn);
                        break;

                    case R.id.btn10:
                        currentBtn = btn10;
                        ButtonClick(currentBtn);
                        break;

                    case R.id.btn11:
                        currentBtn = btn11;
                        ButtonClick(currentBtn);
                        break;

                    case R.id.btn12:
                        currentBtn = btn12;
                        ButtonClick(currentBtn);
                        break;

                    case R.id.btn20:
                        currentBtn = btn20;
                        ButtonClick(currentBtn);
                        break;

                    case R.id.btn21:
                        currentBtn = btn21;
                        ButtonClick(currentBtn);
                        break;

                    case R.id.btn22:
                        currentBtn = btn22;
                        ButtonClick(currentBtn);
                        break;
                }
            }
        };

        btn00.setOnClickListener(buttonListener);
        btn01.setOnClickListener(buttonListener);
        btn02.setOnClickListener(buttonListener);
        btn10.setOnClickListener(buttonListener);
        btn11.setOnClickListener(buttonListener);
        btn12.setOnClickListener(buttonListener);
        btn20.setOnClickListener(buttonListener);
        btn21.setOnClickListener(buttonListener);
        btn22.setOnClickListener(buttonListener);

        return root;
    }

    public void NextPlayer(){
        if(playerTurn == 0){
            playerTurn = 1;
            gameMasterText.setText("Player 2, your turn");
        }
        else if (playerTurn == 1){
            playerTurn = 0;
            gameMasterText.setText("Player 1, your turn");
        }

        if(CheckWin() != -1)
            Win(CheckWin());
    }

    public void Win(int player){
        if(player == 0)
            gameMasterText.setText("Congratulation player 1, you win!");
        else if(player == 1)
            gameMasterText.setText("Congratulation player 2, you win!");

        playerTurn = -1;
    }

    public void ButtonClick(Button btn){
        if(btn.getText().equals("X") || btn.getText().equals("O")) {
            gameMasterText.setText("This case is already occupy!!!!");
        } else if (playerTurn == 0){
            btn.setText("X");
            NextPlayer();
        } else if (playerTurn == 1){
            btn.setText("O");
            NextPlayer();
        }
    }

    public int CheckWin(){
        int output = -1;

        String win1 = (String)btn00.getText() + btn01.getText() + btn02.getText();
        String win2 = (String)btn10.getText() + btn11.getText() + btn12.getText();
        String win3 = (String)btn20.getText() + btn21.getText() + btn22.getText();
        String win4 = (String)btn00.getText() + btn10.getText() + btn20.getText();
        String win5 = (String)btn01.getText() + btn11.getText() + btn22.getText();
        String win6 = (String)btn20.getText() + btn21.getText() + btn22.getText();
        String win7 = (String)btn00.getText() + btn11.getText() + btn22.getText();
        String win8 = (String)btn02.getText() + btn11.getText() + btn20.getText();

        String[] winPossibility = new String[8];
        winPossibility[0] = win1;
        winPossibility[1] = win2;
        winPossibility[2] = win3;
        winPossibility[3] = win4;
        winPossibility[4] = win5;
        winPossibility[5] = win6;
        winPossibility[6] = win7;
        winPossibility[7] = win8;

        for (String s : winPossibility) {
            if(s.equals("XXX"))
                output = 0;
            else if (s.equals("OOO"))
                output = 1;
        }

        return output;
    }
}