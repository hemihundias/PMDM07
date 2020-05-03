package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Vector3;

public class SistemaSolar implements Screen {

    private PerspectiveCamera camara3d;
    private ModelBatch modelBatch;
    private ModelInstance instanceMarte,instanceVenus,instanceMercurio,instanceSol,instanceTierra;
    private Planeta sol,mercurio,venus,tierra,marte;
    private Environment environment;
    private CameraInputController camController;

    public SistemaSolar(){

        camara3d = new PerspectiveCamera();
        camController = new CameraInputController(camara3d);
        Gdx.input.setInputProcessor(camController);

        modelBatch = new ModelBatch();
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(1f, 1f, 1f, 1f, 0f, 0f));

        sol = new Planeta(new Vector3(199f, -17, 0),20f,new Vector3(0,1,0),20);
        mercurio = new Planeta(new Vector3(199f, 0, 0),1f,new Vector3(0,1,0),120);
        venus = new Planeta(new Vector3(199f, 0, 0),1.5f,new Vector3(0,1,0),50);
        tierra = new Planeta(new Vector3(199f, 0, 0),2f,new Vector3(0,1,0),40);
        marte = new Planeta(new Vector3(199f, 0, 0),1.8f,new Vector3(0,1,0),30);

        AssetManager assets = new AssetManager();

        assets.load("Tierra.obj", Model.class);
        assets.load("Sol.obj", Model.class);
        assets.load("Marte.obj", Model.class);
        assets.load("Mercurio.obj", Model.class);
        assets.load("Venus.obj", Model.class);

        assets.finishLoading();

        Model modelTierra = assets.get("Tierra.obj", Model.class);
        Model modelSol = assets.get("Sol.obj", Model.class);
        Model modelMarte = assets.get("Marte.obj", Model.class);
        Model modelVenus = assets.get("Venus.obj", Model.class);
        Model modelMercurio = assets.get("Mercurio.obj", Model.class);

        instanceTierra = new ModelInstance(modelTierra);
        instanceMarte = new ModelInstance(modelMarte);
        instanceVenus = new ModelInstance(modelVenus);
        instanceMercurio = new ModelInstance(modelMercurio);
        instanceSol = new ModelInstance(modelSol);



    }



    @Override

    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        camController.update();
        camara3d.lookAt(sol.posicion);
        camara3d.update();
        modelBatch.begin(camara3d);

        tierra.update(delta);
        instanceTierra.transform.set(tierra.matriz);
        Vector3 positionTierra = instanceTierra.transform.getTranslation(new Vector3());
        positionTierra.sub(0f,0f,0f).scl(-1);
        instanceTierra.transform.translate(positionTierra);
        instanceTierra.transform.rotate(0f,1f,0f,30f);
        instanceTierra.transform.translate(positionTierra.scl(-1));
        modelBatch.render(instanceTierra,environment);

        marte.update(delta);
        instanceMarte.transform.set(marte.matriz);
        Vector3 positionMarte = instanceMarte.transform.getTranslation(new Vector3());
        positionMarte.sub(0f,0f,0f).scl(-1);
        instanceMarte.transform.translate(positionMarte);
        instanceMarte.transform.rotate(0f,1f,0f,40f);
        instanceMarte.transform.translate(positionMarte.scl(-1));
        modelBatch.render(instanceMarte,environment);

        mercurio.update(delta);
        instanceMercurio.transform.set(mercurio.matriz);
        Vector3 positionMercurio = instanceMercurio.transform.getTranslation(new Vector3());
        positionMercurio.sub(0f,0f,0f).scl(-1);
        instanceMercurio.transform.translate(positionMercurio);
        instanceMercurio.transform.rotate(0f,1f,0f,20f);
        instanceMercurio.transform.translate(positionMercurio.scl(-1));
        modelBatch.render(instanceMercurio,environment);

        venus.update(delta);
        instanceVenus.transform.set(venus.matriz);
        Vector3 positionVenus = instanceVenus.transform.getTranslation(new Vector3());
        positionVenus.sub(0f,0f,0f).scl(-1);
        instanceVenus.transform.translate(positionVenus);
        instanceVenus.transform.rotate(0f,1f,0f,25f);
        instanceVenus.transform.translate(positionVenus.scl(-1));
        modelBatch.render(instanceVenus,environment);

        sol.update(delta);
        instanceSol.transform.set(sol.matriz);
        modelBatch.render(instanceSol,environment);

        modelBatch.end();
    }

    @Override

    public void resize(int width, int height) {
        camara3d.fieldOfView=67;
        camara3d.viewportWidth=width;
        camara3d.viewportHeight=height;
        Gdx.input.setInputProcessor(camController);
        camara3d.position.set(0f,0f,450f);
        camara3d.lookAt(0,0,0);
        camara3d.near=1;
        camara3d.far=500f;
        camara3d.update();
    }



    @Override

    public void show() {

        // TODO Auto-generated method stub

    }


    @Override

    public void hide() {

        // TODO Auto-generated method stub



    }


    @Override

    public void pause() {

        // TODO Auto-generated method stub



    }


    @Override

    public void resume() {

        // TODO Auto-generated method stub



    }


    @Override

    public void dispose() {
        modelBatch.dispose();
    }


}
