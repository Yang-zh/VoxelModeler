package io.github.yang_zh.khoriumsvoxelmodeler.main;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import io.github.yang_zh.khoriumsvoxelmodeler.base.BaseGLSurfaceView;

/**
 * VoxelEditView
 * Created by Khorium on 2016/11/4.
 */

public class VoxelEditorView extends BaseGLSurfaceView{

    private final VoxelEditorRender mVoxelEditorRenderer;

    public VoxelEditorView(Context context) {
        super(context);

        setEGLContextClientVersion(2);

        mVoxelEditorRenderer = new VoxelEditorRender();

        setRenderer(mVoxelEditorRenderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    class VoxelEditorRender implements Renderer {

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        }

        @Override
        public void onDrawFrame(GL10 gl) {
            GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            GLES20.glViewport(0, 0, width, height);
        }
    }
}