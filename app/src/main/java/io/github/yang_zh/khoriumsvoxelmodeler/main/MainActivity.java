package io.github.yang_zh.khoriumsvoxelmodeler.main;

import android.os.Bundle;

import io.github.yang_zh.khoriumsvoxelmodeler.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private VoxelEditorView mGLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mGLView = new VoxelEditorView(this);
        setContentView(mGLView);
    }
}
