package com.mygdx.tetrisoncrack;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public class TetrisScreen implements Screen {

    SpriteBatch batch = new SpriteBatch();
    Vector3 touchPoint = new Vector3();

    OrthographicCamera cam;
    Sprite game_sprite;
    Game game;

    public TetrisScreen(Game game) {

        this.game = game;

        cam = new OrthographicCamera();
        cam.setToOrtho(false, 480, 800);

        game_sprite = new Sprite(Ass.gameScreen);
        game_sprite.setPosition(0, 0);

    }

    // We have the buttons on the background so we make a clickable rectangle
    // May implement Stage, Actors and event listeners?
    boolean pushed(com.badlogic.gdx.math.Rectangle r){
        if (!Gdx.input.justTouched())
            return false;
        cam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

        return r.contains(touchPoint.x, touchPoint.y);
    }


    @Override
    public void render(float delta) {

        // We have the buttons on the background so we make a clickable rectangle
        // May implement Stage, Actors and event listeners?
        if (pushed(Ass.gamePauseButton)){
            game.setScreen(new PauseScreen(game));
        }

        batch.setProjectionMatrix(cam.combined);
        batch.begin();

        batch.draw(game_sprite, 0, 0);


        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

}

