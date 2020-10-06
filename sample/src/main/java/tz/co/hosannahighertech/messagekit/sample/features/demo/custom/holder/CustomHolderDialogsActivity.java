package tz.co.hosannahighertech.messagekit.sample.features.demo.custom.holder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import tz.co.hosannahighertech.messagekit.dialogs.DialogsList;
import tz.co.hosannahighertech.messagekit.dialogs.DialogsListAdapter;
import tz.co.hosannahighertech.messagekit.sample.R;
import tz.co.hosannahighertech.messagekit.sample.common.data.fixtures.DialogsFixtures;
import tz.co.hosannahighertech.messagekit.sample.common.data.model.Dialog;
import tz.co.hosannahighertech.messagekit.sample.features.demo.DemoDialogsActivity;
import tz.co.hosannahighertech.messagekit.sample.features.demo.custom.holder.holders.dialogs.CustomDialogViewHolder;

public class CustomHolderDialogsActivity extends DemoDialogsActivity {

    public static void open(Context context) {
        context.startActivity(new Intent(context, CustomHolderDialogsActivity.class));
    }

    private DialogsList dialogsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_holder_dialogs);

        dialogsList = (DialogsList) findViewById(R.id.dialogsList);
        initAdapter();
    }

    @Override
    public void onDialogClick(Dialog dialog) {
        CustomHolderMessagesActivity.open(this);
    }

    private void initAdapter() {
        super.dialogsAdapter = new DialogsListAdapter<>(
                R.layout.item_custom_dialog_view_holder,
                CustomDialogViewHolder.class,
                super.imageLoader);

        super.dialogsAdapter.setItems(DialogsFixtures.getDialogs());

        super.dialogsAdapter.setOnDialogClickListener(this);
        super.dialogsAdapter.setOnDialogLongClickListener(this);

        dialogsList.setAdapter(super.dialogsAdapter);
    }
}
