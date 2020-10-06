package tz.co.hosannahighertech.messagekit.sample.features.demo.custom.media.holders;

import android.view.View;
import android.widget.TextView;

import tz.co.hosannahighertech.messagekit.messages.MessageHolders;
import tz.co.hosannahighertech.messagekit.sample.R;
import tz.co.hosannahighertech.messagekit.sample.common.data.model.Message;
import tz.co.hosannahighertech.messagekit.sample.utils.FormatUtils;
import tz.co.hosannahighertech.messagekit.utils.DateFormatter;

/*
 * Created by troy379 on 05.04.17.
 */
public class IncomingVoiceMessageViewHolder
        extends MessageHolders.IncomingTextMessageViewHolder<Message> {

    private final TextView tvDuration;
    private final TextView tvTime;

    public IncomingVoiceMessageViewHolder(View itemView, Object payload) {
        super(itemView, payload);
        tvDuration = (TextView) itemView.findViewById(R.id.duration);
        tvTime = (TextView) itemView.findViewById(R.id.time);
    }

    @Override
    public void onBind(Message message) {
        super.onBind(message);
        tvDuration.setText(
                FormatUtils.getDurationString(
                        message.getVoice().getDuration()));
        tvTime.setText(DateFormatter.format(message.getCreatedAt(), DateFormatter.Template.TIME));
    }
}
