Spring JMS POC - Point-to-Point (PTP) Messaging Domain


2 Applications : a producer to publish messages to a queue and a Receiver listen to read from the queue implemented  using JmsTemplate and Apache ActiveMQ broker

The application SpringJmsProducer has a REST Service Endpoint to send string messages to a queue which will be in the ActiveMQ broker and SpringJmsReceiver reads from the queue using JmsListener


