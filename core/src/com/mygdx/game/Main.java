package com.mygdx.game;

import com.badlogic.gdx.Game;

public class Main extends Game {
    private SistemaSolar pantallaxogo;

    @Override
    public void create() {

        // TODO Auto-generated method stub
        pantallaxogo = new SistemaSolar();

        setScreen(pantallaxogo);

    }

    @Override
    public void dispose(){
        super.dispose();
        pantallaxogo.dispose();
    }
}
