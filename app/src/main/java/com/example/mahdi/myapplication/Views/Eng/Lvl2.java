package com.example.mahdi.myapplication.Views.Eng;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.ButtonUI;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.mahdi.myapplication.MainAppActivity;
import com.example.mahdi.myapplication.Sprites.BoxDyn;
import com.example.mahdi.myapplication.Sprites.BoxEmpl;
import com.example.mahdi.myapplication.assets.Ar;
import com.example.mahdi.myapplication.assets.BG;
import com.example.mahdi.myapplication.assets.Box;
import com.example.mahdi.myapplication.assets.Btn;
import com.example.mahdi.myapplication.assets.Empty_Box;
import com.example.mahdi.myapplication.assets.Eng;
import com.example.mahdi.myapplication.assets.Success;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.mahdi.myapplication.MainAppActivity.saveState;

public class Lvl2 extends Screen {

    private ButtonUI buttonUI;
    private Sprite bg;
    private Sprite success;
    private Sprite hand;
    private int nbrEssaies=1;
    int x;
    private int help_t =0;

    private BoxEmpl boxEmpl1;
    private BoxEmpl boxEmpl2;
    private BoxEmpl boxEmpl3;
    private BoxDyn accBox;



    private BoxDyn boxDyn1;
    private BoxDyn boxDyn2;
    private BoxDyn boxDyn3;

    private ButtonUI retour;
    private ButtonUI help;
    private ButtonUI repeat;
    private int sound = 0;
    private Timer timer;

    private String lvl = "1";
    private int succ=0;
    private int fail=0;

    private ButtonUI reduireV;
    private ButtonUI ajouterV;
    int s = 0; // controller le volume


    private AudioManager audioManager;




    public Lvl2(Game game) {
        super(game);
        Graphics graphics = game.getGraphics();

        audioManager = (AudioManager) ((Context) game).getSystemService(Context.AUDIO_SERVICE);


        retour = new ButtonUI(game, Ar.retour,Ar.retour, graphics.getWidth()/2 +100,graphics.getHeight()/2, 100,100);
        hand = new ButtonUI(game, Btn.hand,Btn.hand, graphics.getWidth()-170,graphics.getHeight()-300, 100,100);

        buttonUI = new ButtonUI(game,Btn.image,Btn.image,graphics.getWidth() - 200,graphics.getHeight() - 180, 150 ,150);
        help = new ButtonUI(game,Btn.help,Btn.help,graphics.getWidth()/2-200,graphics.getHeight()/2, 100 ,100);
        repeat = new ButtonUI(game,Btn.repeat,Btn.repeat,graphics.getWidth()/2 - 50,graphics.getHeight()/2, 100 ,100);


        success = new Sprite(game,Success.avatar,graphics.getWidth()/2-250,graphics.getHeight()/2-250,500,500);
        bg = new Sprite(game, BG.avatar,0,0,graphics.getHeight(),graphics.getWidth());


        boxEmpl1 = new BoxEmpl(game,Empty_Box.avatar,50,graphics.getHeight() - 200  ,200,200);
        boxEmpl2 = new BoxEmpl(game,Empty_Box.avatar,50,graphics.getHeight() - 380,200,200);
        boxEmpl3 = new BoxEmpl(game,Empty_Box.avatar,50,graphics.getHeight() - 560,200,200);

        boxDyn1 = new BoxDyn(game,Box.avatar,graphics.getWidth()-200,graphics.getHeight()-200,190,190);
        boxDyn2 = new BoxDyn(game,Box.avatar,graphics.getWidth()-200,graphics.getHeight()-200,190,190);
        boxDyn3 = new BoxDyn(game,Box.avatar,graphics.getWidth()-200,graphics.getHeight()-200,190,190);
        accBox = boxDyn1;
        timer = new Timer();

        reduireV = new ButtonUI(game,Btn.audioMinus,Btn.audioMinus, 110,0, 80,80);
        ajouterV = new ButtonUI(game, Btn.audioPlus,Btn.audioPlus, 20,0, 80,80);


        addSprite(reduireV);
        addSprite(ajouterV);

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
        graphics.drawImage(BG.avatar2eng,0,0,graphics.getWidth(),graphics.getHeight());
        //addSprite(retour);
        Sprite draggable= boxDyn1;


        if ( nbrEssaies ==1) { // placement du 1er box
            if ( boxDyn1.isDragged()) {
                accBox = boxDyn1;


                if (well_placed()==1) {
                    succ++;
                    MainAppActivity.datefin = new Date();

                    MainAppActivity.times[0] = MainAppActivity.getDiffDates(MainAppActivity.dateDebut,MainAppActivity.datefin);

                    MainAppActivity.dateDebut = new Date();
                    if ( Eng.tryangain1.isPlaying()) Eng.tryangain1.pause();

                    Eng.bien1.start();
                    boxDyn1.setPosition(graphics.getWidth()*2,graphics.getHeight()*2);
                    boxDyn1.setDragged(false);

                    Log.d("wp1", "wp");
                    //Box.voice.start();
                    boxEmpl1 = new BoxEmpl(game,Box.avatar,50,graphics.getHeight() - 200  ,200,200);


                    addSprite(boxEmpl1);
                    addSprite(boxDyn2);
                    addSprite(boxEmpl2);
                    nbrEssaies = 2;
                    sound = 1;


                }else {
                    if (sound != 1) {
                        fail++;
                        Eng.tryangain1.start();
                        sound = 1;
                    }
                }
            }else {
                boxDyn1.setY(graphics.getHeight() - 200);
                sound = 0;
//                if(sound != 1) {
//                    Eng.tryangain1.start();
//                    sound = 1;
//                }
            }

//            boxDyn1.setPosition(graphics.getWidth() - 100, graphics.getHeight() - 100);


        }else if ( nbrEssaies ==2){ // placement du 2e box
            accBox = boxDyn2;
            if (boxDyn2.isDragged()){
                succ++;
                    MainAppActivity.datefin = new Date();

                    MainAppActivity.times[1] = MainAppActivity.getDiffDates(MainAppActivity.dateDebut,MainAppActivity.datefin);

                    MainAppActivity.dateDebut = new Date();
                if (well_placed()== 2) {
                    if ( Eng.tryangain2.isPlaying()) Eng.tryangain2.pause();
                    Eng.bien2.start();

                    boxDyn2.setPosition(graphics.getWidth()*2,graphics.getHeight()*2);
                    boxDyn2.setDragged(false);
                    Log.d("wp2", "wp");
                    //Box.voice.start();
                    boxEmpl2 = new BoxEmpl(game,Box.avatar,50,graphics.getHeight() - 380,200,200);

                    addSprite(boxEmpl2);
                    addSprite(boxDyn3);
                    addSprite(boxEmpl3);

                    nbrEssaies = 3;
                    sound = 1;


                }else {
                    if (sound != 1) {
                        fail++;
                        Eng.tryangain2.start();
                        sound = 1;
                    }
                }
            }else {
                boxDyn2.setY(graphics.getHeight() - 200);
                sound = 0;

            }
//            boxDyn2.setPosition(graphics.getWidth() - 100, graphics.getHeight() - 100);

        }else if ( nbrEssaies ==3){ //placement du 3e box
            accBox = boxDyn3;
            if (boxDyn3.isDragged()) {
                succ++;
                    MainAppActivity.datefin = new Date();

                    MainAppActivity.times[2] = MainAppActivity.getDiffDates(MainAppActivity.dateDebut,MainAppActivity.datefin);

                    MainAppActivity.dateDebut = new Date();
                if (well_placed() == 3) {
                    if ( Eng.proche.isPlaying()) Eng.proche.pause();
                    Eng.aplaude.start();

                    boxDyn3.setPosition(graphics.getWidth()*2,graphics.getHeight()*2);
                    boxDyn3.setDragged(false);

                    Log.d("wp3", "wp");
                    //Box.voice.start();
                    boxEmpl3 = new BoxEmpl(game,Box.avatar,50,graphics.getHeight() - 560,200,200);



                    addSprite(boxEmpl3);
                    nbrEssaies = 4;
                    sound = 1;


                }else {
                    if (sound != 1) {
                        fail++;
                        Eng.proche.start();
                        sound = 1;
                    }
                }
            }else {
                boxDyn3.setY(graphics.getHeight() - 200);
                sound = 0;

            }
//            boxDyn3.setPosition(graphics.getWidth() - 100, graphics.getHeight() - 100);
        }


        if (nbrEssaies == 4){
            boxDyn3.setStatic(true);

//            addSprite(success);
//            addSprite(buttonUI);
//            game.setScreen(new Lvl2(game));


        }

        if(retour.isClicked()){

            //            System.out.println("clicked");
            //                Screen s = new Lvl2(game);
            //                new MainAppActivity().getInitScreen(s);
            if(help_t!=1) {
                saveState((Context)game ,lvl,succ,fail,MainAppActivity.dateFormat.format(new Date()));
                game.setScreen(new Levels(game));
                help_t=1;
            }

        }
        if(help.isClicked()){

            //            System.out.println("clicked");
            //                Screen s = new Lvl2(game);
            //                new MainAppActivity().getInitScreen(s);
            if(help_t!=1) {
                hand.setX(accBox.getX()+30);
                Eng.helpsound.start();
                addSprite(hand);
                help_t = 1;

                    timer.schedule(new RemindTask(),  2*1000);
            }

        }
        if (repeat.isClicked()){
            game.setScreen(new Lvl2(game));
        }


        if (ajouterV.isClicked()) {
            if(s==0) {
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
                s=1;
            }
        }

        if (reduireV.isClicked()) {
            if(s==0) {
                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
                s=1;
            }
        }


    }

    @Override
    public void handleTouchDown(int x, int y, int pointer) {
        super.handleTouchDown(x, y, pointer);
        buttonUI.onTouchDown(x,y);
        retour.onTouchDown(x,y);
        repeat.onTouchDown(x,y);
        help.onTouchDown(x,y);
        ajouterV.onTouchDown(x,y);
        reduireV.onTouchDown(x,y);
    }

    @Override
    public void handleTouchUp(int x, int y, int pointer) {
        super.handleTouchUp(x, y, pointer);
        buttonUI.onTouchUp(x,y);
        retour.onTouchUp(x,y);
        repeat.onTouchUp(x,y);
        help.onTouchUp(x,y);
        ajouterV.onTouchUp(x,y);
        reduireV.onTouchUp(x,y);
        s=0;

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
        saveState((Context)game ,lvl,succ,fail,MainAppActivity.dateFormat.format(new Date()));
        game.setScreen(new Levels(game));

    }
    @Override
    public void dispose() {
        saveState((Context)game ,lvl,succ,fail,MainAppActivity.dateFormat.format(new Date()));
        super.dispose();

    }

    int well_placed(){
        if(boxEmpl1.contain(boxDyn1.getX(),boxDyn1.getY())) return 1;
        else if(boxEmpl2.contain(boxDyn2.getX(),boxDyn2.getY())) return 2;
        else if(boxEmpl3.contain(boxDyn3.getX(),boxDyn3.getY())) return 3;
        return 0;
    }

    private class RemindTask extends TimerTask {
        public void run() {
            if (hand.getX()>80){

                hand.setX(hand.getX() - 10);
                timer.schedule(new RemindTask(),30);

            }else {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        hand.setX(-500);
                        help_t = 0;
                    }
                }, 5000);
            }
        }
    }
}
