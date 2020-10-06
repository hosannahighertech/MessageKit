package tz.co.hosannahighertech.messagekit.sample.features.demo;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import tz.co.hosannahighertech.messagekit.commons.ImageLoader;
import tz.co.hosannahighertech.messagekit.dialogs.DialogsListAdapter;
import tz.co.hosannahighertech.messagekit.sample.common.data.model.Dialog;
import tz.co.hosannahighertech.messagekit.sample.utils.AppUtils;

/*
 * Created by troy379 on 05.04.17.
 */
public abstract class DemoDialogsActivity extends AppCompatActivity
        implements DialogsListAdapter.OnDialogClickListener<Dialog>,
        DialogsListAdapter.OnDialogLongClickListener<Dialog> {

    protected ImageLoader imageLoader;
    protected DialogsListAdapter<Dialog> dialogsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageLoader = (imageView, url, payload) -> Picasso.get().load(url).into(imageView);
    }

    @Override
    public void onDialogLongClick(Dialog dialog) {
        AppUtils.showToast(
                this,
                dialog.getDialogName(),
                false);
    }
}
