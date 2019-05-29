package com.example.mahdi.myapplication;

import android.arch.core.util.Function;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;

import com.e_mobadara.audiomanaging.moblibAudioFileManager;
import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Screen;
import com.example.emobadaragaminglib.Implementation.AndroidGame;
import com.example.emobadaragaminglib.Implementation.AndroidSound;
import com.example.ensias_auth_library.FoxyAuth;
import com.example.ensias_auth_library.models.GameStat;
import com.example.mahdi.myapplication.assets.Ar;
import com.example.mahdi.myapplication.assets.BG;
import com.example.mahdi.myapplication.assets.Box;
import com.example.mahdi.myapplication.assets.Btn;
import com.example.mahdi.myapplication.assets.Empty_Box;
import com.example.mahdi.myapplication.assets.Eng;
import com.example.mahdi.myapplication.assets.Fr;
import com.example.mahdi.myapplication.assets.Success;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainAppActivity extends AndroidGame {




    public static int waiting = 3000;
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static Date date =new Date();
    private static String created_at = dateFormat.format(date);
    public static Date dateDebut;
    public static Date datefin;

    public static String times[] = new String[3];


    public static void viderTimes(){
        for (int i =0;i<3;i++)
            times[i]="0";
    }

    public static String getDiffDates(Date d,Date end){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        String diff = decimalFormat.format(end.getSeconds() - d.getSeconds());
        return diff;
    }

    public static String getMinTime(String[] ts){
        String min = "60000";
        for(String a : ts){
            if (!TextUtils.isEmpty(a) && TextUtils.isDigitsOnly(a)){
                if (Integer.parseInt(min)>Integer.parseInt(a)) {
                    min = a;
                }
            }
        }
        return min;
    }

    public static String getAvgTime(String[] ts){
        int avg = 0;
        int i =0;
        for(String a : ts) {
            if (!TextUtils.isEmpty(a) && TextUtils.isDigitsOnly(a)) {
                i++;
                avg += Integer.parseInt(a);

            }
        }
        avg/=i;
        return avg+"";
    }

    public static void saveState(Context context,String lvl, int succ, int fail, String updated_at){
        GameStat gameStat = new GameStat();

        String application_id = "2019_3_2_3";
        gameStat.setApp_id(application_id);

        String exercice_id = "T_5_1";
        gameStat.setExercise_id(exercice_id);


        gameStat.setCreated_at(created_at);

        gameStat.setUpdated_at(updated_at);

        gameStat.setMin_time_succeed_sec(getMinTime(times));

        gameStat.setAvg_time_succeed_sec(getAvgTime(times));


        gameStat.setLevel_id(lvl);

        gameStat.setSuccessful_attempts(String.valueOf(succ));

        gameStat.setFailed_attempts(String.valueOf(fail));
        FoxyAuth.storeGameStat(context,gameStat);

        viderTimes();

    }

    public static void help(final TimerTask task){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.run();
            }
        },waiting);

    }
    @Override
    public Screen getInitScreen() {

//        date = new Date();


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
        Btn.hand = getGraphics().newImage(R.mipmap.hand,Graphics.ImageFormat.ARGB8888,getResources());



        Ar.langue = getGraphics().newImage(R.mipmap.dooriar,Graphics.ImageFormat.ARGB8888,getResources());
        Ar.languef = getGraphics().newImage(R.mipmap.doorfma,Graphics.ImageFormat.ARGB8888,getResources());
        Ar.lvls = getGraphics().newImage(R.mipmap.lvlsar,Graphics.ImageFormat.ARGB8888,getResources());
        Ar.lvl1 = getGraphics().newImage(R.mipmap.lvl1icon,Graphics.ImageFormat.ARGB8888,getResources());
        Ar.lvl2 = getGraphics().newImage(R.mipmap.lvl2icon,Graphics.ImageFormat.ARGB8888,getResources());
        Ar.retour = getGraphics().newImage(R.mipmap.retour,Graphics.ImageFormat.ARGB8888,getResources());

        Ar.helpsound = MediaPlayer.create(this,R.raw.yasmine);
        Ar.aplaude = moblibAudioFileManager.getRandomAudioFile(this,"excellent","AR");
        if(Ar.aplaude==null) Ar.aplaude = MediaPlayer.create(this,R.raw.applaud);
        Ar.proche = moblibAudioFileManager.getRandomAudioFile(this,"encouragement","AR");
        if(Ar.proche==null) Ar.proche = MediaPlayer.create(this,R.raw.prochear);
        Ar.tryangain1 = moblibAudioFileManager.getRandomAudioFile(this,"encouragement","AR");
        if(Ar.tryangain1==null) Ar.tryangain1 = MediaPlayer.create(this,R.raw.soundar2);
        Ar.tryangain2 = moblibAudioFileManager.getRandomAudioFile(this,"encouragement","AR");
        if(Ar.tryangain2==null) Ar.tryangain2 = MediaPlayer.create(this,R.raw.essayear);
        Ar.bien1 = moblibAudioFileManager.getRandomAudioFile(this,"good","AR");
        if(Ar.bien1==null) Ar.bien1 = MediaPlayer.create(this,R.raw.sonar);
        Ar.bien2 = moblibAudioFileManager.getRandomAudioFile(this,"good","AR");
        if(Ar.bien2==null) Ar.bien2 = MediaPlayer.create(this,R.raw.sonar2);
        Ar.bien3 = moblibAudioFileManager.getRandomAudioFile(this,"good","AR");
        if(Ar.bien3==null) Ar.bien3 = MediaPlayer.create(this,R.raw.son3ar);



        Fr.langue = getGraphics().newImage(R.mipmap.doorifr,Graphics.ImageFormat.ARGB8888,getResources());
        Fr.languef = getGraphics().newImage(R.mipmap.doorffr,Graphics.ImageFormat.ARGB8888,getResources());
        Fr.lvls = getGraphics().newImage(R.mipmap.lvlsfr,Graphics.ImageFormat.ARGB8888,getResources());

        Fr.lvl1 = getGraphics().newImage(R.mipmap.lvl1icon,Graphics.ImageFormat.ARGB8888,getResources());
        Fr.lvl2 = getGraphics().newImage(R.mipmap.lvl2icon,Graphics.ImageFormat.ARGB8888,getResources());
        Fr.retour = getGraphics().newImage(R.mipmap.retour,Graphics.ImageFormat.ARGB8888,getResources());
        Fr.helpsound = MediaPlayer.create(this,R.raw.helpf);
        Fr.aplaude = moblibAudioFileManager.getRandomAudioFile(this,"excellent","FR");
        if(Fr.aplaude==null) Fr.aplaude = MediaPlayer.create(this,R.raw.applaud);
        Fr.proche = moblibAudioFileManager.getRandomAudioFile(this,"encouragement","FR");
        if(Fr.proche==null) Fr.proche = MediaPlayer.create(this,R.raw.proche);
        Fr.tryangain1 = moblibAudioFileManager.getRandomAudioFile(this,"encouragement","FR");
        if(Fr.tryangain1==null) Fr.tryangain1 = MediaPlayer.create(this,R.raw.essayerencore);
        Fr.tryangain2 = moblibAudioFileManager.getRandomAudioFile(this,"encouragement","FR");
        if(Fr.tryangain2==null) Fr.tryangain2 = MediaPlayer.create(this,R.raw.proche);
        Fr.bien1 = moblibAudioFileManager.getRandomAudioFile(this,"good","FR");
        if(Fr.bien1==null) Fr.bien1 = MediaPlayer.create(this,R.raw.son1fr);
        Fr.bien2 = moblibAudioFileManager.getRandomAudioFile(this,"good","FR");
        if(Fr.bien2==null) Fr.bien2 = MediaPlayer.create(this,R.raw.son2fr);
        Fr.bien3 = moblibAudioFileManager.getRandomAudioFile(this,"good","FR");
        if(Fr.bien3==null) Fr.bien3 = MediaPlayer.create(this,R.raw.son3fr);




        Eng.langue = getGraphics().newImage(R.mipmap.doorieng,Graphics.ImageFormat.ARGB8888,getResources());
        Eng.languef = getGraphics().newImage(R.mipmap.doorfeng,Graphics.ImageFormat.ARGB8888,getResources());
        Eng.lvl1 = getGraphics().newImage(R.mipmap.lvl1icon,Graphics.ImageFormat.ARGB8888,getResources());
        Eng.lvl2 = getGraphics().newImage(R.mipmap.lvl2icon,Graphics.ImageFormat.ARGB8888,getResources());
        Eng.lvls = getGraphics().newImage(R.mipmap.lvlseng,Graphics.ImageFormat.ARGB8888,getResources());

        Eng.retour = getGraphics().newImage(R.mipmap.retour,Graphics.ImageFormat.ARGB8888,getResources());
        Eng.helpsound = MediaPlayer.create(this,R.raw.helpan);
        Eng.aplaude = moblibAudioFileManager.getRandomAudioFile(this,"excellent","AN");
        Eng.aplaude = MediaPlayer.create(this,R.raw.applaud);
        Eng.proche = moblibAudioFileManager.getRandomAudioFile(this,"encouragement","AN");
        Eng.proche = MediaPlayer.create(this,R.raw.urclose);
        Eng.tryangain1 = moblibAudioFileManager.getRandomAudioFile(this,"encouragement","AN");
        Eng.tryangain1 = MediaPlayer.create(this,R.raw.tryagain);
        Eng.tryangain2 = moblibAudioFileManager.getRandomAudioFile(this,"encouragement","AN");
        Eng.tryangain2 = MediaPlayer.create(this,R.raw.urclose);
        Eng.bien1 = moblibAudioFileManager.getRandomAudioFile(this,"good","AN");
        Eng.bien1 = MediaPlayer.create(this,R.raw.son1ang);
        Eng.bien2 = moblibAudioFileManager.getRandomAudioFile(this,"good","AN");
        Eng.bien2 = MediaPlayer.create(this,R.raw.son2ang);
        Eng.bien3 = moblibAudioFileManager.getRandomAudioFile(this,"good","AN");
        Eng.bien3 = MediaPlayer.create(this,R.raw.son3ang);







        // help

        Btn.help = getGraphics().newImage(R.mipmap.help,Graphics.ImageFormat.ARGB8888,getResources());
        Btn.helpsound = MediaPlayer.create(this,R.raw.yasmine);


        BG.welcomebg = getGraphics().newImage(R.mipmap.welcomebg,Graphics.ImageFormat.ARGB8888,getResources());


        Btn.play = getGraphics().newImage(R.mipmap.play,Graphics.ImageFormat.ARGB8888,getResources());
        Btn.audioConf = getGraphics().newImage(R.mipmap.audioconf,Graphics.ImageFormat.ARGB8888,getResources());
        Btn.audioPlus = getGraphics().newImage(R.mipmap.audioplus,Graphics.ImageFormat.ARGB8888,getResources());
        Btn.audioMinus = getGraphics().newImage(R.mipmap.audiominus,Graphics.ImageFormat.ARGB8888,getResources());
        Btn.playClick = getGraphics().newImage(R.mipmap.playclicked,Graphics.ImageFormat.ARGB8888,getResources());






        Log.i("track ","lvl1 lance");

        return new GameScreen(this);

    }



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
