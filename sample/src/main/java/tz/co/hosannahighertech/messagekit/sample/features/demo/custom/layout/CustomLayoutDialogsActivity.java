package tz.co.hosannahighertech.messagekit.sample.features.demo.custom.layout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import tz.co.hosannahighertech.messagekit.dialogs.DialogsList;
import tz.co.hosannahighertech.messagekit.dialogs.DialogsListAdapter;
import tz.co.hosannahighertech.messagekit.sample.R;
import tz.co.hosannahighertech.messagekit.sample.common.data.fixtures.DialogsFixtures;
import tz.co.hosannahighertech.messagekit.sample.common.data.model.Dialog;
import tz.co.hosannahighertech.messagekit.sample.features.demo.DemoDialogsActivity;

public class CustomLayoutDialogsActivity extends DemoDialogsActivity {

    public static void open(Context context) {
        context.startActivity(new Intent(context, CustomLayoutDialogsActivity.class));
    }

    private DialogsList dialogsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout_dialogs);

        dialogsList = (DialogsList) findViewById(R.id.dialogsList);
        initAdapter();
    }

    @Override
    public void onDialogClick(Dialog dialog) {
        CustomLayoutMessagesActivity.open(this);
    }

    private void initAdapter() {
        super.dialogsAdapter = new DialogsListAdapter<>(R.layout.item_custom_dialog, super.imageLoader);
        super.dialogsAdapter.setItems(DialogsFixtures.getDialogs());

        super.dialogsAdapter.setOnDialogClickListener(this);
        super.dialogsAdapter.setOnDialogLongClickListener(this);

        dialogsList.setAdapter(super.dialogsAdapter);
    }
}
