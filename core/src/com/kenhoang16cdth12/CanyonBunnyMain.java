package com.kenhoang16cdth12;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.math.Interpolation;
import com.kenhoang16cdth12.game.Assets;
import com.kenhoang16cdth12.screens.DirectedGame;
import com.kenhoang16cdth12.screens.MenuScreen;
import com.kenhoang16cdth12.screens.transitions.ScreenTransition;
import com.kenhoang16cdth12.screens.transitions.ScreenTransitionSlice;
import com.kenhoang16cdth12.util.AudioManager;
import com.kenhoang16cdth12.util.GamePreferences;

public class CanyonBunnyMain extends DirectedGame {

    private static final String TAG = CanyonBunnyMain.class.getName();

    @Override
    public void create() {
        // Set Libgdx log level to DEBUG
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        // Load assets
        Assets.instance.init(new AssetManager());
        // Load preferences for audio settings and start playing music
        GamePreferences.instance.load();
        AudioManager.instance.play(Assets.instance.music.song01);
        // Start game at menu screen
        ScreenTransition transition = ScreenTransitionSlice.init(2,
                ScreenTransitionSlice.UP_DOWN, 10, Interpolation.pow5Out);
        setScreen(new MenuScreen(this), transition);

    }
}
