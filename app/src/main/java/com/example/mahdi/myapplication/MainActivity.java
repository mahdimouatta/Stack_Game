package com.example.mahdi.myapplication;

import android.util.Log;

import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.emobadaragaminglib.Implementation.AndroidSound;
import com.example.mahdi.myapplication.assets.Ar;
import com.example.mahdi.myapplication.assets.BG;
import com.example.mahdi.myapplication.assets.Box;
import com.example.mahdi.myapplication.assets.Btn;
import com.example.mahdi.myapplication.assets.Empty_Box;
import com.example.mahdi.myapplication.assets.Eng;
import com.example.mahdi.myapplication.assets.Fr;
import com.example.mahdi.myapplication.assets.Success;

public class MainActivity extends AndroidGame {

    @Override
    public Screen getInitScreen() {

        Success.avatar = getGraphics().newImage(R.drawable.success,Graphics.ImageFormat.ARGB8888,getResources());
        BG.languebg = getGraphics().newImage(R.mipmap.languages,Graphics.ImageFormat.ARGB8888,getResources());

        // BackGrounds Ar

        BG.avatar = getGraphics().newImage(R.drawable.bgar1,Graphics.ImageFormat.ARGB8888,getResources());
        BG.avatar2 = getGraphics().newImage(R.mipmap.lvl1ar,Graphics.ImageFormat.ARGB8888,getResources());
        BG.avatar3 = getGraphics().newImage(R.mipmap.lvl2ar,Graphics.ImageFormat.ARGB8888,getResources());

        // BackGrounds Eng

        BG.avatar1eng = getGraphics().newImage(R.drawable.bgeng1,Graphics.ImageFormat.ARGB8888,getResources());
        BG.avatar2eng = getGraphics().newImage(R.mipmap.lvl1eng,Graphics.ImageFormat.ARGB8888,getResources());
        BG.avatar3eng = getGraphics().newImage(R.mipmap.lvl2eng,Graphics.ImageFormat.ARGB8888,getResources());

        // BackGrounds Fr

        BG.avatar1fr = getGraphics().newImage(R.drawable.bgfr1,Graphics.ImageFormat.ARGB8888,getResources());
        BG.avatar2fr = getGraphics().newImage(R.mipmap.lvl1fr,Graphics.ImageFormat.ARGB8888,getResources());
        BG.avatar3fr = getGraphics().newImage(R.mipmap.lvl2fr,Graphics.ImageFormat.ARGB8888,getResources());



        Box.avatar = getGraphics().newImage(R.mipmap.box,Graphics.ImageFormat.ARGB8888,getResources());
        Box.bot = getGraphics().newImage(R.mipmap.bot,Graphics.ImageFormat.ARGB8888,getResources());
        Box.mid = getGraphics().newImage(R.mipmap.mid,Graphics.ImageFormat.ARGB8888,getResources());
        Box.top = getGraphics().newImage(R.mipmap.top,Graphics.ImageFormat.ARGB8888,getResources());

        Empty_Box.avatar = getGraphics().newImage(R.mipmap.boxemp,Graphics.ImageFormat.ARGB8888,getResources());
        Empty_Box.bot = getGraphics().newImage(R.mipmap.botemp,Graphics.ImageFormat.ARGB8888,getResources());
        Empty_Box.mid = getGraphics().newImage(R.mipmap.midemp,Graphics.ImageFormat.ARGB8888,getResources());
        Empty_Box.top = getGraphics().newImage(R.mipmap.topemp,Graphics.ImageFormat.ARGB8888,getResources());


        Btn.image = getGraphics().newImage(R.drawable.btn,Graphics.ImageFormat.ARGB8888,getResources());
        Btn.repeat = getGraphics().newImage(R.mipmap.repeat,Graphics.ImageFormat.ARGB8888,getResources());



        Ar.langue = getGraphics().newImage(R.mipmap.dooriar,Graphics.ImageFormat.ARGB8888,getResources());
        Ar.languef = getGraphics().newImage(R.mipmap.doorfma,Graphics.ImageFormat.ARGB8888,getResources());
        Ar.lvls = getGraphics().newImage(R.mipmap.lvlsar,Graphics.ImageFormat.ARGB8888,getResources());
        Ar.lvl1 = getGraphics().newImage(R.mipmap.lvl1icon,Graphics.ImageFormat.ARGB8888,getResources());
        Ar.lvl2 = getGraphics().newImage(R.mipmap.lvl2icon,Graphics.ImageFormat.ARGB8888,getResources());
        Ar.retour = getGraphics().newImage(R.mipmap.retour,Graphics.ImageFormat.ARGB8888,getResources());
        Ar.helpsound = (AndroidSound)getAudio().createSound(R.raw.yasmine);
        Ar.aplaude = (AndroidSound)getAudio().createSound(R.raw.applaud);
        Ar.proche = (AndroidSound)getAudio().createSound(R.raw.prochear);
        Ar.tryangain1 = (AndroidSound)getAudio().createSound(R.raw.soundar2);
        Ar.tryangain2 = (AndroidSound)getAudio().createSound(R.raw.soundar3);
        Ar.bien1 = (AndroidSound)getAudio().createSound(R.raw.sonar);


        Fr.langue = getGraphics().newImage(R.mipmap.doorifr,Graphics.ImageFormat.ARGB8888,getResources());
        Fr.languef = getGraphics().newImage(R.mipmap.doorffr,Graphics.ImageFormat.ARGB8888,getResources());
        Fr.lvls = getGraphics().newImage(R.mipmap.lvlsfr,Graphics.ImageFormat.ARGB8888,getResources());

        Fr.lvl1 = getGraphics().newImage(R.mipmap.lvl1icon,Graphics.ImageFormat.ARGB8888,getResources());
        Fr.lvl2 = getGraphics().newImage(R.mipmap.lvl2icon,Graphics.ImageFormat.ARGB8888,getResources());
        Fr.retour = getGraphics().newImage(R.mipmap.retour,Graphics.ImageFormat.ARGB8888,getResources());
        Fr.helpsound = (AndroidSound)getAudio().createSound(R.raw.yasmine);
        Fr.aplaude = (AndroidSound)getAudio().createSound(R.raw.applaud);
        Fr.proche = (AndroidSound)getAudio().createSound(R.raw.prochear);
        Fr.tryangain1 = (AndroidSound)getAudio().createSound(R.raw.soundar2);
        Fr.tryangain2 = (AndroidSound)getAudio().createSound(R.raw.soundar3);
        Fr.bien1 = (AndroidSound)getAudio().createSound(R.raw.sonar);




        Eng.langue = getGraphics().newImage(R.mipmap.doorieng,Graphics.ImageFormat.ARGB8888,getResources());
        Eng.languef = getGraphics().newImage(R.mipmap.doorfeng,Graphics.ImageFormat.ARGB8888,getResources());
        Eng.lvl1 = getGraphics().newImage(R.mipmap.lvl1icon,Graphics.ImageFormat.ARGB8888,getResources());
        Eng.lvl2 = getGraphics().newImage(R.mipmap.lvl2icon,Graphics.ImageFormat.ARGB8888,getResources());
        Eng.lvls = getGraphics().newImage(R.mipmap.lvlseng,Graphics.ImageFormat.ARGB8888,getResources());

        Eng.retour = getGraphics().newImage(R.mipmap.retour,Graphics.ImageFormat.ARGB8888,getResources());
        Eng.helpsound = (AndroidSound)getAudio().createSound(R.raw.yasmine);
        Eng.aplaude = (AndroidSound)getAudio().createSound(R.raw.applaud);
        Eng.proche = (AndroidSound)getAudio().createSound(R.raw.prochear);
        Eng.tryangain1 = (AndroidSound)getAudio().createSound(R.raw.soundar2);
        Eng.tryangain2 = (AndroidSound)getAudio().createSound(R.raw.soundar3);
        Eng.bien1 = (AndroidSound)getAudio().createSound(R.raw.sonar);





        Box.voice =(AndroidSound)getAudio().createSound(R.raw.show_me);


        // help

        Btn.help = getGraphics().newImage(R.mipmap.help,Graphics.ImageFormat.ARGB8888,getResources());
        Btn.helpsound=(AndroidSound)getAudio().createSound(R.raw.yasmine);


        BG.welcomebg = getGraphics().newImage(R.mipmap.welcomebg,Graphics.ImageFormat.ARGB8888,getResources());


        Btn.play = getGraphics().newImage(R.mipmap.play,Graphics.ImageFormat.ARGB8888,getResources());
        Btn.playClick = getGraphics().newImage(R.mipmap.playclicked,Graphics.ImageFormat.ARGB8888,getResources());





        Log.i("track ","lvl1 lance");

        return new GameScreen(this);

    }




    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
