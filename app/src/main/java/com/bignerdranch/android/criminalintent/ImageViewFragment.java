package com.bignerdranch.android.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by ianri on 11/9/2017.
 */

public class ImageViewFragment extends DialogFragment {

    private ImageView mImageView;
    private File mPhotoFile;

    public static ImageViewFragment newInstance(File photoFile) {
        ImageViewFragment ivf = new ImageViewFragment();
        ivf.mPhotoFile = photoFile;

        return ivf;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.image_view_dialog, null);

        builder.setView(v);
        mImageView = (ImageView) v.findViewById(R.id.image_detail);
        updatePhotoView();
        return builder.create();
    }


    private void updatePhotoView() {

        if (mPhotoFile == null || !mPhotoFile.exists()) {
            mImageView.setImageDrawable(null);
        }
        else{
            Bitmap bitmap = PictureUtils.getScaledBitmap(mPhotoFile.getPath(), getActivity());
            mImageView.setImageBitmap(bitmap);

            Point size = new Point();
            getActivity().getWindowManager().getDefaultDisplay().getSize(size);

            ViewGroup.LayoutParams params = mImageView.getLayoutParams();

            double h = bitmap.getHeight();
            double w = bitmap.getWidth();

            double imgRatio = h / w;


            double height = (h / w) * (double) params.width;

            params.height = Math.round(Math.round(height));

            mImageView.setLayoutParams(params);
        }

    }
}
