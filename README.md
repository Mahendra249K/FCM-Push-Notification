# FCM-Push-Notification

* FCM clients require devices running Android 4.4 or higher that also have the Google Play Store app installed, or an emulator running Android 4.4 with Google APIs. Note that you are not limited to deploying your Android apps through Google Play Store.

* FCM is completely free to use, including the use of topics.

* When you use topics, you separate the sending of messages about a topic, from the fact that an install of your app subscribes to that topic. This means you can add subscribers to the topic later, without having to write additional code or even data (as the list of tokens that are subscribed to a topic is handled by FCM itself).

* On the other hand: topics are public. Once somebody knows the topic ID, they can subscribe to that topic, and receive any messages you send to that topic.

* The alternative to using topics is sending messages directly to FCM Instance ID tokens. In that case you'll keep a list of tokens somewhere yourself, and determine what token(s) to deliver the message to. In this case, you fully control who receives the message, but will have to maintain your own list of tokens, and the mapping of what token receives what messages.

* Note that sending messages (no matter whether to topics or to tokens) can be done from any trusted environment, like your development machine, a server you control, or Cloud Functions. And sending messages (no matter whether to topics or to tokens) can't be (securely) done from the client-side code.

# Screen-Shots
![1](https://user-images.githubusercontent.com/65441774/209339808-5f9e7670-a033-4b52-8e2a-76535be7e41d.jpg)
![2](https://user-images.githubusercontent.com/65441774/209339812-ed7770be-39a8-444f-902a-3ade17bcc585.jpg)
![3](https://user-images.githubusercontent.com/65441774/209339814-1acefbcb-c59b-42e9-8818-4d89a1d59e5f.jpg)
