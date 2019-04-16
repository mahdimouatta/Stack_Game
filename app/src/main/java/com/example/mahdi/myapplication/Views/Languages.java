package com.example.mahdi.myapplication.Views;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.ButtonUI;
import com.example.mahdi.myapplication.GameScreen;
import com.example.mahdi.myapplication.Views.Ar.Levels;
import com.example.mahdi.myapplication.assets.Ar;
import com.example.mahdi.myapplication.assets.BG;
import com.example.mahdi.myapplication.assets.Eng;
import com.example.mahdi.myapplication.assets.Fr;

public class Languages extends Screen {



    private ButtonUI retour;
    private ButtonUI ar;
    private ButtonUI fr;
    private ButtonUI eng;





    public Languages(Game game) {
        super(game);
        Graphics graphics = game.getGraphics();

        graphics.drawImage(BG.languebg,0,0,graphics.getWidth(),graphics.getHeight());

        retour = new ButtonUI(game, Ar.retour,Ar.retour, graphics.getWidth()*7/8,50, 100,100);

        ar = new ButtonUI(game, Ar.langue,Ar.languef, graphics.getWidth()/12,graphics.getHeight()/4, graphics.getHeight()/2,graphics.getWidth()/5);
        fr = new ButtonUI(game, Fr.langue,Fr.languef, graphics.getWidth()*5/13  ,graphics.getHeight()/4, graphics.getHeight()/2,graphics.getWidth()/5);
        eng = new ButtonUI(game,Eng.langue,Eng.languef, graphics.getWidth()*9/13 ,graphics.getHeight()/4, graphics.getHeight()/2,graphics.getWidth()/5);


        addSprite(ar);
        addSprite(fr);
        addSprite(eng);
        addSprite(retour);

    }

    public void handleTouchDown(int x, int y, int pointer) {
        super.handleTouchDown(x, y, pointer);
        ar.onTouchDown(x,y);
        fr.onTouchDown(x,y);
        eng.onTouchDown(x,y);
        retour.onTouchDown(x,y);

    }

    @Override
    public void handleTouchUp(int x, int y, int pointer) {
        super.handleTouchUp(x, y, pointer);
        ar.onTouchUp(x,y);
        fr.onTouchUp(x,y);
        eng.onTouchUp(x,y);
        retour.onTouchUp(x,y);
    }

    @Override
    public void render(float deltaTime) {
        if (ar.isClicked()) {

//            System.out.println("clicked");
//                Screen s = new Lvl2(game);
//                new MainActivity().getInitScreen(s);
            game.setScreen(new Levels(game));

        }
        if (fr.isClicked()) {

//            System.out.println("clicked");
//                Screen s = new Lvl2(game);
//                new MainActivity().getInitScreen(s);
            game.setScreen(new com.example.mahdi.myapplication.Views.Fr.Levels(game));

        }
        if (eng.isClicked()) {

//            System.out.println("clicked");
//                Screen s = new Lvl2(game);
//                new MainActivity().getInitScreen(s);
            game.setScreen(new com.example.mahdi.myapplication.Views.Eng.Levels(game));

        }
        if (retour.isClicked()){
            game.setScreen(new GameScreen(game));
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
        game.setScreen(new com.example.mahdi.myapplication.GameScreen(game));
    }




}
