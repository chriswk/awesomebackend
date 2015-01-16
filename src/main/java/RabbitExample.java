RabbitQueue amqp = new RabbitQueue("queueName");
Observable.timer(0, 1, TimeUnit.SECONDS)
.map(tick -> amp.next())
.subscribe(...)
