package com.example.mahdi.myapplication.Views.Eng;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.ButtonUI;
import com.example.mahdi.myapplication.Views.Languages;
import com.example.mahdi.myapplication.assets.Ar;
import com.example.mahdi.myapplication.assets.Eng;

public class Levels extends Screen {

    private ButtonUI lvl1;
    private ButtonUI lvl2;
    private ButtonUI retour;


    public Levels(Game game) {
        super(game);
        Graphics graphics = game.getGraphics();

        graphics.drawImage(Eng.lvls,0,0,graphics.getWidth(),graphics.getHeight());
        lvl1 = new ButtonUI(game, Eng.lvl1,Eng.lvl1, graphics.getWidth()/8,graphics.getHeight()*2/5, graphics.getHeight()/4,graphics.getWidth()/4);
        lvl2 = new ButtonUI(game, Eng.lvl2,Eng.lvl2, graphics.getWidth()*5/8,graphics.getHeight()*2/5, graphics.getHeight()/4,graphics.getWidth()/4);
        retour = new ButtonUI(game, Ar.retour,Ar.retour, graphics.getWidth()*7/8,50, 100,100);



        addSprite(lvl1);
        addSprite(lvl2);
        addSprite(retour);
    }



    @Override
    public void render(float deltaTime) {
        if(lvl1.isClicked()){

//            System.out.println("clicked");
//                Screen s = new Lvl2(game);
//                new MainActivity().getInitScreen(s);
            game.setScreen(new Lvl2(game));

        }
        if(lvl2.isClicked()){

//            System.out.println("clicked");
//                Screen s = new Lvl2(game);
//                new MainActivity().getInitScreen(s);
            game.setScreen(new lvl3(game));

        }
//        if(lvl3.isClicked()){
//
////            System.out.println("clicked");
////                Screen s = new Lvl2(game);
////                new MainActivity().getInitScreen(s);
//            game.setScreen(new Lvl3(game));
//
//        }


        if(retour.isClicked()){

//            System.out.println("clicked");
//                Screen s = new Lvl2(game);
//                new MainActivity().getInitScreen(s);
            game.setScreen(new Languages(game));

        }


    }


    @Override
    public void handleTouchDown(int x, int y, int pointer) {
        super.handleTouchDown(x, y, pointer);
        lvl1.onTouchDown(x,y);
        lvl2.onTouchDown(x,y);
        retour.onTouchDown(x,y);

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
}
