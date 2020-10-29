package tz.co.hosannahighertech.messagekit.interfaces;

import tz.co.hosannahighertech.messagekit.messages.MessagesListAdapter;
import tz.co.hosannahighertech.messagekit.commons.models.IMessage;

public abstract class OnMessageGestureListener {

    protected boolean restoreSwiped;

    /**
     * Listen Gestures from the message list
     * @param restoreSwiped boolean. Whether we should restore once swipe is done
     *                      If false, the item will be deleted from the adapter
     */
    public OnMessageGestureListener(boolean restoreSwiped) {
        this.restoreSwiped = restoreSwiped;
    }

    /**
     * Tell whether we should restore swiped item or delete it
     * @return Whether the Swiped ViewHolder should be restored
     */
    public boolean isRestoreSwiped() {
        return restoreSwiped;
    }

    /**
     * Get Gesture Events for Swipe Left
     *
     * @param message {@link IMessage} of the swiped item. Use {@link MessagesListAdapter#getMessageByIndex} to get the message
     */
    abstract public void onSwipeLeft(IMessage message);

    /**
     * Get Gesture Events for Swipe Right
     *
     * @param message {@link IMessage} of the swiped item. Use {@link MessagesListAdapter#getMessageByIndex} to get the message
     */
    abstract public void onSwipeRight(IMessage message);
}
