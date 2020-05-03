package com.mygdx.game;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;


public class Planeta {

    public Matrix4 matriz;
    public Vector3 posicion;
    public float escala;
    public Vector3 rotacion;
    public float anguloRotacion;
    private int velocidadeRotacion;

    public Planeta(Vector3 pos, float escala, Vector3 rotacion, int velocidadeRotacion){

        matriz = new Matrix4();
        posicion = pos;
        this.escala=escala;
        this.rotacion=rotacion;
        anguloRotacion=0;
        this.velocidadeRotacion=velocidadeRotacion;
    }

    public void update(float delta){
        anguloRotacion+=delta*velocidadeRotacion;
        matriz.idt();
        matriz.translate(posicion);
        matriz.scl(escala);
        matriz.rotate(rotacion, anguloRotacion);

    }

}
