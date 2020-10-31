# MessageKit for Android

MessageKit is a library designed to simplify the development of UI for such a trivial task as chat. It has flexible possibilities for styling, customizing and data management

<p align="center">
<img src="images/HEADER.jpg">
</p>

### Features

* Ready-to-use already styled solution for quick implementation;
* Default and custom media messages;
* Fully customizable layouts - setting styles out of the box (use your own colors, text appearances, drawables, selectors and sizes) or even create your own custom markup or/and holders for unique behaviour;
* List of dialogs, including tete-a-tete and group chats, markers for unread messages and last user message view;
* List of messages (incoming and outcoming) with history pagination and already calculated dates headers;
* Different avatars with no specific realization of image loading - you can use any library you want;
* Selection mode for interacting with messages;
* Get Swipe Left/Right Gestures to implement features like Swipe to reply or delete
* Links highlighting
* Easy dates formatting;
* Your own models for dialogs and messages - there is no converting needed;
* Ready to use message input view;
* Custom animations (according to RecyclerView usage).

## Sample Application

For Demonstration of how to use different features of MessageKit capabilities, is included the sample application as a module. A demo application will be uploaded to Playstore and linked here

### How to use

To implement all of the features above you can use the following components:

* [DialogsList](docs/dialogs.md);
* [MessagesList](docs/message_list.md);
* [MessageInput](docs/message_input.md)

### Requirements 

Library requires minimum of Android SDK 19 to work. It will probably not work with lower versions.


### Download

Download via Gradle:
```gradle
implementation 'tz.co.hosannahighertech:messagekit:1.0.0apha4'
```

### AndroidX

Library Supports Androidx aout of the box.

### Proguard
If you are using ProGuard you might need to add rules:
```
-keep class * extends messagekit.messages.MessageHolders$OutcomingTextMessageViewHolder {
     public <init>(android.view.View, java.lang.Object);
     public <init>(android.view.View);
 }
-keep class * extends messagekit.messages.MessageHolders$IncomingTextMessageViewHolder {
     public <init>(android.view.View, java.lang.Object);
     public <init>(android.view.View);
 }
-keep class * extends messagekit.messages.MessageHolders$IncomingImageMessageViewHolder {
     public <init>(android.view.View, java.lang.Object);
     public <init>(android.view.View);
 }
-keep class * extends messagekit.messages.MessageHolders$OutcomingImageMessageViewHolder {
     public <init>(android.view.View, java.lang.Object);
     public <init>(android.view.View);
 }
```

### Changelog
[See the changelog](docs/CHANGELOG.md) to be aware of latest improvements and fixes.

### Are You Using MessageKit Android?

We Would like to make a list of Companies and Applications using MessageKit Android. Please let us know through support@hosannahighertech.co.tz. Interested in Working with us? Contact us through the same eMail.

### Gratitude

MessageKit started as a fork of ChatKit library by [St Falcon](https://github.com/stfalcon-studio).  Without their sacrifice and a good heart toward open source we would probably have no MessageKit Android.
Thank you!

### License

```
Original Code, Copyright (C) 2017 stfalcon.com
New Code Copyright (C) 2020, Hosanna Higher Technologies Co. Ltd

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

https://github.com/stfalcon-studio/MessageKit/blob/master/LICENSE

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
