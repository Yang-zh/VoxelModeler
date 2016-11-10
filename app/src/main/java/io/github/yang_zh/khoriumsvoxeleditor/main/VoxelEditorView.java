package io.github.yang_zh.khoriumsvoxeleditor.main;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.view.MotionEvent;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import io.github.yang_zh.khoriumsvoxeleditor.base.BaseGLSurfaceView;
import io.github.yang_zh.khoriumsvoxeleditor.model.Square;
import io.github.yang_zh.khoriumsvoxeleditor.model.Triangle;

/**
 * VoxelEditView
 * Created by Khorium on 2016/11/4.
 */

public class VoxelEditorView extends BaseGLSurfaceView {

    private final VoxelEditorRenderer mVoxelEditorRenderer;

    public VoxelEditorView(Context context) {
        super(context);

        setEGLContextClientVersion(2);

        mVoxelEditorRenderer = new VoxelEditorRenderer();

        //Turn on error-checking and logging
        setDebugFlags(DEBUG_CHECK_GL_ERROR | DEBUG_LOG_GL_CALLS);

        setRenderer(mVoxelEditorRenderer);

        // Render the view only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
    private float mPreviousX;
    private float mPreviousY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dx = x - mPreviousX;
                float dy = y - mPreviousY;

                if (y > getHeight() / 2) {
                    dx = dx * -1;
                }
                if (x < getWidth() / 2) {
                    dy = dy * -1;
                }

                mVoxelEditorRenderer.setAngle(
                        mVoxelEditorRenderer.getAngle() -
                                ((dx + dy) * TOUCH_SCALE_FACTOR));
                requestRender();
        }

        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
}
