# JMS Intro
Context: Two (or more ) applications want to communicate with each other ( ex: pass data)

If one of them is offline(say app2) while the other(app1) is sending data, how can we make sure that the data is not lost and app2 recieves that data when it comes online?

Messaging middleware servers help out in these kind of situations.

Messaging  servers decouple the senders and reciever apps. In fact, senders and reciever apps need not even be aware of each other!

Senders (also called as publishers in the messaging world) send the data to a designated(named) destination. 

Reciever apps (also known as Subscribers) subcribe to the named destination. Whenever data(also called as 'message') is published by the sender (Publisher),  reciever apps recieve the data when they are online.

Named destinations are also called as **'channels'**.

A **channel** can either be a **Queue** or a **Topic**.

A Queues is a point-to-point messaging channel. 
Publishers publish message to a Queue and Only one Subscriber consumes the published data.

A Topic is a one-to-many type of messaging channel. 
Publishers publish message to a Topic. The message is consumed by many Subscribers.

*It is worth noting that Subscriber consume the data exactly once.*
