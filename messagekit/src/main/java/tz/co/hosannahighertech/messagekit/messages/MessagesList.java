/*******************************************************************************
 * Copyright 2016 stfalcon.com
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package tz.co.hosannahighertech.messagekit.messages;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import tz.co.hosannahighertech.messagekit.commons.models.IMessage;
import tz.co.hosannahighertech.messagekit.interfaces.OnMessageGestureListener;

/**
 * Component for displaying list of messages
 */
public class MessagesList extends RecyclerView {
    private MessagesListStyle messagesListStyle;

    public MessagesList(Context context) {
        super(context);
    }

    public MessagesList(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        parseStyle(context, attrs);
    }

    public MessagesList(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        parseStyle(context, attrs);
    }

    /**
     * Don't use this method for setting your adapter, otherwise exception will by thrown.
     * Call {@link #setAdapter(MessagesListAdapter)} instead.
     */
    @Override
    public void setAdapter(Adapter adapter) {
        throw new IllegalArgumentException("You can't set adapter to MessagesList. Use #setAdapter(MessagesListAdapter) instead.");
    }

    /**
     * Sets adapter for MessagesList
     *
     * @param adapter   Adapter. Must extend MessagesListAdapter
     * @param <MESSAGE> Message model class
     */
    public <MESSAGE extends IMessage>
    void setAdapter(MessagesListAdapter<MESSAGE> adapter) {
        setAdapter(adapter, true);
    }

    /**
     * Sets adapter for MessagesList and listen for gestures
     *
     * @param adapter   Adapter. Must extend MessagesListAdapter
     * @param <MESSAGE> Message model class
     * @param listener  OnMessageGestureListener. Listens for Message list gestures,
     *                  currently only swipe left/right is implemented
     */
    public <MESSAGE extends IMessage>
    void setAdapter(MessagesListAdapter<MESSAGE> adapter, OnMessageGestureListener listener) {
        setAdapter(adapter, true);

        final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                MESSAGE message = adapter.getMessageByIndex(viewHolder.getAdapterPosition());
                if (direction == ItemTouchHelper.LEFT) {
                    listener.onSwipeLeft(message);
                } else if (direction == ItemTouchHelper.RIGHT) {
                    listener.onSwipeRight(message);
                }

                if (listener.isRestoreSwiped()) {
                    adapter.notifyDataSetChanged();
                } else {
                    adapter.delete(message);
                }
            }
        });
        itemTouchHelper.attachToRecyclerView(this);
    }

    /**
     * Sets adapter for MessagesList
     *
     * @param adapter       Adapter. Must extend MessagesListAdapter
     * @param reverseLayout weather to use reverse layout for layout manager.
     * @param <MESSAGE>     Message model class
     */
    public <MESSAGE extends IMessage>
    void setAdapter(MessagesListAdapter<MESSAGE> adapter, boolean reverseLayout) {
        SimpleItemAnimator itemAnimator = new DefaultItemAnimator();
        itemAnimator.setSupportsChangeAnimations(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, reverseLayout);

        setItemAnimator(itemAnimator);
        setLayoutManager(layoutManager);
        adapter.setLayoutManager(layoutManager);
        adapter.setStyle(messagesListStyle);

        addOnScrollListener(new RecyclerScrollMoreListener(layoutManager, adapter));
        super.setAdapter(adapter);
    }

    @SuppressWarnings("ResourceType")
    private void parseStyle(Context context, AttributeSet attrs) {
        messagesListStyle = MessagesListStyle.parse(context, attrs);
    }
}
