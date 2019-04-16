package com.example.mahdi.myapplication;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.ButtonUI;
import com.example.mahdi.myapplication.assets.BG;
import com.example.mahdi.myapplication.assets.Btn;

public class GameScreen extends Screen {


    private ButtonUI play;


    public GameScreen(Game game) {
        super(game);
        Graphics graphics = game.getGraphics();
        play = new ButtonUI(game,Btn.play,Btn.playClick, graphics.getWidth()/2-50,graphics.getHeight()*3/4-100,250,250);
        graphics.drawImage(BG.welcomebg,0,0,graphics.getWidth(),graphics.getHeight());


        addSprite(play);
    }

    @Override
    public void render(float deltaTime) {

        if (play.isClicked()) {


                game.setScreen(new com.example.mahdi.myapplication.Views.Languages(game));


//            System.out.println("clicked");
//                Screen s = new Lvl2(game);
//                new MainActivity().getInitScreen(s);

        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void backButton() {

    }

    @Override
    public void handleTouchDown(int x, int y, int pointer) {
        super.handleTouchDown(x, y, pointer);
        play.onTouchDown(x,y);
    }

    @Override
    public void handleTouchUp(int x, int y, int pointer) {
        super.handleTouchUp(x, y, pointer);
        play.onTouchUp(x,y);
    }



}
