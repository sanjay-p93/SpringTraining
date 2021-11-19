Spring JMS POC - Publisher/Subscriber (Pub/Sub) Messaging Domain


Consists of 2 Application a publisher to publish messages to a topic and a Subscriber with multiple listener to read from the same topic implemented  using JmsTemplate and Apache ActiveMQ broker

The application SpringJmsPublisher has a REST Service Endpoint to publish string messages to the topic which will be in the ActiveMQ broker and SpringJmsSubscriber consumes the msg from the topic using JmsListener, multiple listeners are added to demonstrate that every listener subscribed gets the message.


