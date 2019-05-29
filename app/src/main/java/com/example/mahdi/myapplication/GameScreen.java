package com.example.mahdi.myapplication;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

import com.e_mobadara.audiomanaging.AudioSettingsActivity;
import com.e_mobadara.audiomanaging.MainAudioModuleActivity;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Components.ButtonUI;
import com.example.mahdi.myapplication.assets.BG;
import com.example.mahdi.myapplication.assets.Btn;

public class GameScreen extends Screen {


    int s = 0;
    private ButtonUI play;
    private ButtonUI audioConf;
    AudioManager audioManager = (AudioManager) ((Context) game).getSystemService(Context.AUDIO_SERVICE);


    public GameScreen(Game game) {
        super(game);

        Graphics graphics = game.getGraphics();
        play = new ButtonUI(game,Btn.play,Btn.playClick, graphics.getWidth()/2-50,graphics.getHeight()*3/4-100,250,250);
        graphics.drawImage(BG.welcomebg,0,0,graphics.getWidth(),graphics.getHeight());

        audioConf = new ButtonUI(game,Btn.audioConf,Btn.audioConf, graphics.getWidth()-200,0,150,150);


        addSprite(play);
        addSprite(audioConf);

    }

    @Override
    public void render(float deltaTime) {

        if (play.isClicked()) {
//            if(s==0) {
//                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
//                s=1;
//            }

//                Loading loading = new Loading();
//                loading.OpensettingsActivity(ne);
                game.setScreen(new com.example.mahdi.myapplication.Views.Languages(game));
//

//            System.out.println("clicked");
//                Screen s = new Lvl2(game);
//                new MainAppActivity().getInitScreen(s);

        }
        if(audioConf.isClicked()){

            Intent i = new Intent((Context) game, AudioSettingsActivity.class);
            ((Context) game).startActivity(i);
//            audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);

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
        audioConf.onTouchDown(x,y);

    }

    @Override
    public void handleTouchUp(int x, int y, int pointer) {
        super.handleTouchUp(x, y, pointer);
        play.onTouchUp(x,y);
        audioConf.onTouchUp(x, y);
        s=0;
    }



}
