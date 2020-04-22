package com.example.appone;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGLSurfaceView extends GLSurfaceView {


    private MyGLRenderer renderer = null;

    public MyGLSurfaceView(Context context) {
        super(context);

        setEGLContextClientVersion(3);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        renderer = new MyGLRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(renderer);
    }
}
