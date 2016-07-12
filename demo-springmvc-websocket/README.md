# demo-springmvc-websocket
WebSocket它实现了浏览器与服务器全双工通信(full-duplex)，浏览器和服务器只需要做一个握手的动作，然后，浏览器和服务器之间就形成了一条快速通道。两者之间就直接可以数据互相传送。在此WebSocket 协议中，为我们实现即时服务带来了两大好处：
* Header
互相沟通的Header是很小的-大概只有 2 Bytes
* Server Push
服务器的推送，服务器不再被动的接收到浏览器的request之后才返回数据，而是在有新数据时就主动推送给浏览器
* 功能尚未完成，移植到spring-boot-websocket中去
