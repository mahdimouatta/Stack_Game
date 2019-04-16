package com.example.mahdi.myapplication.Views.Eng;

import android.util.Log;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.ButtonUI;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.mahdi.myapplication.Sprites.BoxDyn;
import com.example.mahdi.myapplication.Sprites.BoxEmpl;
import com.example.mahdi.myapplication.assets.Ar;
import com.example.mahdi.myapplication.assets.BG;
import com.example.mahdi.myapplication.assets.Box;
import com.example.mahdi.myapplication.assets.Btn;
import com.example.mahdi.myapplication.assets.Empty_Box;
import com.example.mahdi.myapplication.assets.Eng;
import com.example.mahdi.myapplication.assets.Success;

public class lvl3 extends Screen {

    private ButtonUI buttonUI;
    private Sprite bg;
    private Sprite success;
    private int nbrEssaies=1;
    int x;
    private int help_t =0;

    private BoxEmpl boxEmpl1;
    private BoxEmpl boxEmpl2;
    private BoxEmpl boxEmpl3;


    private BoxDyn boxDyn1;
    private BoxDyn boxDyn2;
    private BoxDyn boxDyn3;

    private ButtonUI retour;
    private ButtonUI help;
    private ButtonUI repeat;
    int sound = 0;




    public lvl3(Game game) {
        super(game);
        Graphics graphics = game.getGraphics();

        retour = new ButtonUI(game, Ar.retour,Ar.retour, graphics.getWidth()/2 +100,graphics.getHeight()/2, 100,100);

        buttonUI = new ButtonUI(game,Btn.image,Btn.image,graphics.getWidth() - 200,graphics.getHeight() - 180, 150 ,150);
        help = new ButtonUI(game,Btn.help,Btn.help,graphics.getWidth()/2-200,graphics.getHeight()/2, 100 ,100);
        repeat = new ButtonUI(game,Btn.repeat,Btn.repeat,graphics.getWidth()/2 - 50,graphics.getHeight()/2, 100 ,100);


        success = new Sprite(game,Success.avatar,graphics.getWidth()/2-250,graphics.getHeight()/2-250,500,500);
        bg = new Sprite(game, BG.avatar3eng,0,0,graphics.getHeight(),graphics.getWidth());


        boxEmpl1 = new BoxEmpl(game,Empty_Box.bot,50,graphics.getHeight() - 270  ,200,200);
        boxEmpl2 = new BoxEmpl(game,Empty_Box.mid,50,graphics.getHeight() - 450,200,200);
        boxEmpl3 = new BoxEmpl(game,Empty_Box.top,50,graphics.getHeight() - 630,200,200);

        boxDyn1 = new BoxDyn(game,Box.bot,graphics.getWidth()-200,graphics.getHeight()-270,190,190);
        boxDyn2 = new BoxDyn(game,Box.mid,graphics.getWidth()-200,graphics.getHeight()-270,190,190);
        boxDyn3 = new BoxDyn(game,Box.top,graphics.getWidth()-200,graphics.getHeight()-270,190,190);



        addSprite(boxDyn1);
        addSprite(help);

        addSprite(boxEmpl1);
        addSprite(retour);
        addSprite(repeat);






        Log.d("track", "Constructor Called");




    }

    @Override
    public void handleDragging(int x, int y, int pointer) {
        super.handleDragging(x, y, pointer);
    }


    @Override
    public void render(float deltaTime) {
        Graphics graphics = game.getGraphics();
        graphics.drawImage(BG.avatar3eng,0,0,graphics.getWidth(),graphics.getHeight());
        //addSprite(retour);
        Sprite draggable= boxDyn1;


        if ( nbrEssaies ==1) { // placement du 1er box
            if ( boxDyn1.isDragged()) {

                if (well_placed()==1) {
                    Eng.bien1.play(1);
                    boxDyn1.setPosition(graphics.getWidth()*2,graphics.getHeight()*2);
                    boxDyn1.setDragged(false);

                    Log.d("wp1", "wp");
                    //Box.voice.play(1);
                    boxEmpl1 = new BoxEmpl(game,Box.bot,50,graphics.getHeight() - 270  ,200,200);


                    addSprite(boxEmpl1);
                    addSprite(boxDyn2);
                    addSprite(boxEmpl2);
                    nbrEssaies = 2;

                }
            }else {
                boxDyn1.setY(graphics.getHeight() - 270);
                if(sound != 1) {
//                    Ar.tryangain1.play(1);
                    sound = 1;
                }
            }

//            boxDyn1.setPosition(graphics.getWidth() - 100, graphics.getHeight() - 100);


        }else if ( nbrEssaies ==2){ // placement du 2e box
            if (boxDyn2.isDragged()){
                if (well_placed()== 2) {
                    Eng.bien1.play(1);

                    boxDyn2.setPosition(graphics.getWidth()*2,graphics.getHeight()*2);
                    boxDyn2.setDragged(false);
                    Log.d("wp2", "wp");
                    //Box.voice.play(1);
                    boxEmpl2 = new BoxEmpl(game,Box.mid,50,graphics.getHeight() - 450,200,200);

                    addSprite(boxEmpl2);
                    addSprite(boxDyn3);
                    addSprite(boxEmpl3);

                    nbrEssaies = 3;
                }
            }else boxDyn2.setY(graphics.getHeight() - 270);
//            boxDyn2.setPosition(graphics.getWidth() - 100, graphics.getHeight() - 100);

        }else if ( nbrEssaies ==3){ //placement du 3e box
            if (boxDyn3.isDragged()) {
                if (well_placed() == 3) {
                    Eng.bien1.play(1);
                    boxDyn3.setPosition(graphics.getWidth()*2,graphics.getHeight()*2);
                    boxDyn3.setDragged(false);

                    Log.d("wp3", "wp");
                    //Box.voice.play(1);
                    boxEmpl3 = new BoxEmpl(game,Box.top,50,graphics.getHeight() - 630,200,200);



                    addSprite(boxEmpl3);
                    nbrEssaies = 4;
                }
            }else boxDyn3.setY(graphics.getHeight() - 270);
//            boxDyn3.setPosition(graphics.getWidth() - 100, graphics.getHeight() - 100);
        }


        if (nbrEssaies == 4){
            boxDyn3.setStatic(true);


//            addSprite(buttonUI);
////            game.setScreen(new Lvl2(game));
//            addSprite(success);



        }


//        if(buttonUI.isClicked()){
//
//            System.out.println("clicked");
////                Screen s = new Lvl2(game);
////                new MainActivity().getInitScreen(s);
//            game.setScreen(new Levels(game));
//
//        }

        if(retour.isClicked()){

            //            System.out.println("clicked");
            //                Screen s = new Lvl2(game);
            //                new MainActivity().getInitScreen(s);
            if(help_t!=1) {
                game.setScreen(new Levels(game));
                help_t=1;
            }
        }
        if(help.isClicked()){

            //            System.out.println("clicked");
            //                Screen s = new Lvl2(game);
            //                new MainActivity().getInitScreen(s);
            Ar.helpsound.play(1);

        }
        if (repeat.isClicked()){
            game.setScreen(new lvl3(game));
        }



    }

    @Override
    public void handleTouchDown(int x, int y, int pointer) {
        super.handleTouchDown(x, y, pointer);
        buttonUI.onTouchDown(x,y);
        retour.onTouchDown(x,y);
        repeat.onTouchDown(x,y);
        help.onTouchDown(x,y);
    }

    @Override
    public void handleTouchUp(int x, int y, int pointer) {
        super.handleTouchUp(x, y, pointer);
        buttonUI.onTouchUp(x,y);
        retour.onTouchUp(x,y);
        repeat.onTouchUp(x,y);
        help.onTouchUp(x,y);




    }

    @Override
    public void pause() {
        Log.d("track", "pause Called");
    }

    @Override
    public void resume() {
        Log.d("track", "resume Called");

    }

    @Override
    public void backButton() {
        game.setScreen(new Levels(game));

    }
    @Override
    public void dispose() {
        super.dispose();

    }

    int well_placed(){
        if(boxEmpl1.contain(boxDyn1.getX(),boxDyn1.getY())) return 1;
        else if(boxEmpl2.contain(boxDyn2.getX(),boxDyn2.getY())) return 2;
        else if(boxEmpl3.contain(boxDyn3.getX(),boxDyn3.getY())) return 3;
        return 0;
    }

}
