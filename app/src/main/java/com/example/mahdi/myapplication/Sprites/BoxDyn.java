package com.example.mahdi.myapplication.Sprites;

import com.example.emobadaragaminglib.Base.Game;
import com.example.emobadaragaminglib.Base.Graphics;
import com.example.emobadaragaminglib.Base.Image;
import com.example.emobadaragaminglib.Components.Sprite;
import com.example.mahdi.myapplication.R;
import com.example.mahdi.myapplication.assets.Box;

public class BoxDyn extends Sprite {
    Box box;
    // c'est le box qui doit etre déplacé


    public BoxDyn(Game game, Image image, int x, int y, int height, int width) {

        super(game, image, x, y, height, width);

        setStatic(false);
    }


}
